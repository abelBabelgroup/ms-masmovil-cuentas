package com.masmovil.repository.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@Table(name = "oferta")
public class Offer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_OFERTA")
    private Long offerId;

    @Column(name = "ID_OFERTA_ORIGEN")
    private Integer originOfferId;

    @Column(name = "ID_CUENTA")
    private Long accountId;

    @Column(name = "ID_PROPIETARIO")
    private String ownerId;

    @Column(name = "VERSION")
    private Long version;

    @Column(name = "FEC_ALTA")
    private Date entryDate;

    @Column(name = "FEC_ESTADO")
    private Date stateDate;

    @Column(name = "ESTADO")
    private String state;

    @Column(name = "CONTENIDO")
    private String content;

    public Offer(Long accountId, Date entryDate, Date stateDate, String state) {
        this.accountId = accountId;
        this.entryDate = entryDate;
        this.stateDate = stateDate;
        this.state = state;
    }
}
