package com.masmovil.domain.dto;

import com.masmovil.repository.model.Offer;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
public class OfferHistoryDto implements Serializable {

    private Long historyId;

    private Offer offerId;

    @NotNull
    @Size(max = 20)
    private String state;

    private Date stateDate;

    @Email
    @Size(max = 50)
    private String userState;
}
