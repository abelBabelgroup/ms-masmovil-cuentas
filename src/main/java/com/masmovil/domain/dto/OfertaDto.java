package com.masmovil.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class OfertaDto implements Serializable {

    private Long offerId;
    @NotNull
    private Integer originOfferId;
    private String accountId;
    @Email
    @Size(max = 50)
    private String ownerId;
    private Integer version;
    private Date creationDate;
    private Date statusDate;
    @NotNull
    @Size(max = 20)
    private String status;
    @Size(max = 10000)
    private String content;
}
