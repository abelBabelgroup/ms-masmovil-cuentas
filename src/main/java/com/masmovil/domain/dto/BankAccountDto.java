package com.masmovil.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BankAccountDto implements Serializable {

    private Long bankAccountId;
    private Long accountId;
    private Long accountNumber;
}
