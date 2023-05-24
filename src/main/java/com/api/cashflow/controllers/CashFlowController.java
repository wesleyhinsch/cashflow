package com.api.cashflow.controllers;

import com.api.cashflow.dtos.CashFlowDto;
import com.api.cashflow.models.CashFlowModel;
import com.api.cashflow.services.CashFLowService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;

import static java.time.LocalDate.now;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/cashflow")
public class CashFlowController {

    @Autowired
    CashFLowService cashFLowService;

    @PostMapping
    public ResponseEntity<Object> registerOperation(@RequestBody @Valid CashFlowDto cashFlowDto){
        var cashFlowModel = new CashFlowModel();
        BeanUtils.copyProperties(cashFlowDto, cashFlowModel);
        cashFlowModel.setRegistrationDate(now());
        return ResponseEntity.status(HttpStatus.CREATED).body(cashFLowService.save(cashFlowModel));
    }

    @GetMapping
    public ResponseEntity<Page<CashFlowModel>> getAllOperations(@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable){
        return ResponseEntity.status(HttpStatus.OK).body(cashFLowService.findAll(pageable));
    }


    @GetMapping("/consolidate")
    public ResponseEntity<Integer> getConsolidateOperationOfDay(){
        return ResponseEntity.status(HttpStatus.OK).body(cashFLowService.getConsolidateOperationOfDay(now()));
    }
}
