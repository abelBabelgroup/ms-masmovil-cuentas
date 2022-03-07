package com.masmovil.domain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountDto implements Serializable {

    private Long accountId;

    @Size(max = 9)
    private String cif;

    @Size(max = 250)
    private String name;

    @Size(max = 500)
    private String webSite;

    @Email
    @Size(max = 50)
    private String ownerId;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date startDateOwnership;

    private Date endDateOwnership;

    private String brands;

    @Size(max = 20)
    private String channel;

    private List<ContactDto> contacts;

    private List<AddressDto> addresses;

}
