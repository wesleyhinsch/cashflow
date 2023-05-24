package com.api.cashflow.dtos;

import com.api.cashflow.enums.EnumOperation;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class CashFlowDto {

    @NotNull
    private Integer value;

    @NotNull
    private EnumOperation operation;

}
