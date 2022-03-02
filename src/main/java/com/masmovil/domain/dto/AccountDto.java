package com.masmovil.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
public class AccountDto implements Serializable {

    private Long accountId;

    @Size(max = 9)
    private String cif;

    @Size(max = 250)
    private String name;

    @Email
    @Size(max = 50)
    private String ownerId;

    private Date startDateOwnership;

    private Date endDateOwnership;

    private List<ContactDto> contacts;

    private List<AddressDto> addresses;

    public AccountDto() {
        this.contacts = new ArrayList<>();
        this.addresses = new ArrayList<>();
    }
}
