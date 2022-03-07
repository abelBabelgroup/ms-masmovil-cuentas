package com.masmovil.domain.dto;

import com.masmovil.domain.OfferState;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OfferHistoryDto implements Serializable {

    private Long historyId;

    private Long offerId;

    @NotNull
    @Size(max = 20)
    private OfferState state;

    private LocalDate stateDate;

    @Email
    @Size(max = 50)
    private String userState;
}
