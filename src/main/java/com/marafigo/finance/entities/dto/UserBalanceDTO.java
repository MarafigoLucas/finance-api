package com.marafigo.finance.entities.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class UserBalanceDTO implements Serializable {
    private Double totalIncome;
    private Double totalExpense;
    private Double balance;
}
