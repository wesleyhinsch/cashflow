package com.api.cashflow.models;

import com.api.cashflow.enums.EnumOperation;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "TB_RECORD_CONTROL")
public class CashFlowModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private Integer value;

    @Column(nullable = false)
    private EnumOperation operation;

    @Column(nullable = false)
    private LocalDate registrationDate;

}
