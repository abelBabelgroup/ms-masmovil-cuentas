package com.masmovil.repository.entity;

import com.masmovil.domain.OfferState;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "oferta")
public class Offer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_oferta")
    private Long offerId;

    @Column(name = "id_oferta_origen")
    private Long originOfferId;

    @Column(name = "id_cuenta")
    private Long accountId;

    @Column(name = "id_propietario")
    private String ownerId;

    private Long version;

    @Column(name = "fec_alta")
    private LocalDate entryDate;

    @Column(name = "fec_estado")
    private LocalDate stateDate;

    @Column(name = "estado")
    @Enumerated(EnumType.STRING)
    private OfferState state;

    @Column(name = "contenido")
    private String content;

    public static Offer from(Long accountId, LocalDate entryDate, LocalDate stateDate, OfferState state) {
        Offer offer = new Offer();
        offer.setAccountId(accountId);
        offer.setEntryDate(entryDate);
        offer.setStateDate(stateDate);
        offer.setState(state);
        return offer;
    }
}
