package com.masmovil.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OfferDto implements Serializable {

    private Long offerId;

    @NotNull
    private Integer originOfferId;

    private Long accountId;

    @Email
    @Max(50)
    private String ownerId;

    private Long version;

    private Date entryDate;

    private Date stateDate;

    @NotNull
    @Size(max = 20)
    private String state;

    @Size(max = 10000)
    private String content;

}
