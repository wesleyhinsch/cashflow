package com.api.cashflow.repositories;

import com.api.cashflow.models.CashFlowModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Repository
public interface CashFlowRepository extends JpaRepository<CashFlowModel, UUID> {

    List<CashFlowModel> findAllByRegistrationDate(LocalDate dateTime);

}
