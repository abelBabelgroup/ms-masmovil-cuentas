package com.masmovil.domain.dto;

import com.masmovil.domain.OfferState;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OfferDto implements Serializable {

    private Long offerId;

    private Long originOfferId;

    private Long accountId;

    @Email
    @Max(50)
    private String ownerId;

    private Long version;

    private LocalDate entryDate;

    private LocalDate stateDate;

    @NotNull
    @Size(max = 20)
    private OfferState state;

    @Size(max = 10000)
    private String content;

}
