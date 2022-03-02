package com.masmovil.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressDto implements Serializable {

    private Long addressId;

    private AccountDto accountId;

    private boolean principal;

    private String provincia;

    private String municipio;

    private String postalCode;

    private String streetType;

    private String street;

    private String number;

    private String block;

    private String portal;

    private String floor;

    private String letter;
}
