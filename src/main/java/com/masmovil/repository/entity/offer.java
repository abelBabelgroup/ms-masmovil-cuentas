package com.masmovil.repository.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@NoArgsConstructor
@Table(name = "oferta")
public class offer implements Serializable {

    @Id
    @Column(name = "ID_OFERTA")
    private Long offerId;

    @Column(name = "ID_OFERTA_ORIGEN")
    private Integer originOfferId;

    @Column(name = "ID_CUENTA")
    private String accountId;

    @Column(name = "ID_PROPIETARIO")
    private String ownerId;

    @Column(name = "VERSION")
    private Integer version;

    @Column(name = "FEC_ALTA")
    private Date creationDate;

    @Column(name = "FEC_ESTADO")
    private Date statusDate;

    @Column(name = "ESTADO")
    private String status;

    @Column(name = "CONTENIDO")
    private String content;

}
