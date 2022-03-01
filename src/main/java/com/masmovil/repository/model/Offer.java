package com.masmovil.repository.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

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

    @Column(name = "ID_CUENTA")
    private String accountId;

    @Column(name = "ID_PROPIETARIO")
    private String ownerId;

    private Integer version;

    @Column(name = "FEC_ALTA")
    private Date entryDate;

    @Column(name = "FEC_ESTADO")
    private Date stateDate;

    @Column(name = "ESTADO")
    private String state;

    private String content;

}
