package com.api.cashflow.services;

import com.api.cashflow.enums.EnumOperation;
import com.api.cashflow.models.CashFlowModel;
import com.api.cashflow.repositories.CashFlowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;

@Service
public class CashFLowService {

    @Autowired
    CashFlowRepository cashFlowRepository;

    @Transactional
    public CashFlowModel save(CashFlowModel cashFlowModel) {
        return cashFlowRepository.save(cashFlowModel);
    }

    public Page<CashFlowModel> findAll(Pageable pageable) {
        return cashFlowRepository.findAll(pageable);
    }

    public Integer getConsolidateOperationOfDay(LocalDate localDate) {
        var operationList = cashFlowRepository.findAllByRegistrationDate(localDate);
        Integer credit = operationList.stream().filter(x -> x.getOperation().equals(EnumOperation.CREDIT)).mapToInt(CashFlowModel::getValue).sum();
        Integer debit =  operationList.stream().filter(x -> x.getOperation().equals(EnumOperation.DEBIT)).mapToInt(CashFlowModel::getValue).sum();
        return  credit - debit;
    }

}
