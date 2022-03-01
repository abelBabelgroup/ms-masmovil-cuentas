package com.masmovil.domain.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
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
}
