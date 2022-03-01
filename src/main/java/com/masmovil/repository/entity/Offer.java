package com.masmovil.repository.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Data
@NoArgsConstructor
@Table(name = "oferta")
public class Offer implements Serializable {

    @Id
    @Column(name = "ID_OFERTA")
    private Long offerId;

    @Column(name = "ID_OFERTA_ORIGEN")
    private Integer originOfferId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_CUENTA")
    private Account accountId;

    @Column(name = "ID_PROPIETARIO")
    private String ownerId;

    @Column(name = "VERSION")
    private String version;

    @Column(name = "FEC_ALTA")
    private String createDate;

    @Column(name = "FEC_ESTADO")
    private String statusDate;

    @Column(name = "ESTADO")
    private String status;

    @Column(name = "CONTENIDO")
    private String content;
}
