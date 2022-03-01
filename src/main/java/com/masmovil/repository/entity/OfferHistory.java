package com.masmovil.repository.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@Table(name = "oferta_historico")
public class OfferHistory implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_HISTORICO")
    private Long historyId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_OFERTA")
    private Offer offerId;

    private String state;

    @Column(name = "FEC_ESTADO")
    private Date stateDate;

    @Column(name = "USUARIO_ESTADO")
    private String userState;
}
