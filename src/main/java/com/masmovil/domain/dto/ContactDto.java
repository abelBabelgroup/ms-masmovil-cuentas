package com.masmovil.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ContactDto implements Serializable {

    private Long contactId;

    private Long accountId;

    @NotNull
    @Size(max = 10)
    private String documentType;

    @Size(max = 20)
    private String document;

    @NotNull
    @Size(max = 100)
    private String name;

    @NotNull
    @Size(max = 100)
    private String surname;

    @Size(max = 100)
    private String phoneNumber;

    @NotNull
    @Size(max = 20)
    @Email
    private String email;

    @NotNull
    private String type;

    @NotNull
    private boolean manager;
}
