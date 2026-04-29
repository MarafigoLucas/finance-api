package com.marafigo.finance.dto;


import java.io.Serializable;
import java.math.BigDecimal;

public record UserBalanceDTO(
        BigDecimal totalIncome,
        BigDecimal totalExpense,
        BigDecimal balance
) implements Serializable {}