package com.masmovil.repository.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@NoArgsConstructor
@Table(name = "oferta")
public class Oferta implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_OFERTA")
    private Long idOferta;

    @Column(name = "ID_OFERTA_ORIGEN")
    private Integer IdOfertaOrigen;

    @Column(name = "ID_CUENTA")
    private String idCuenta;

    @Column(name = "ID_PROPIETARIO")
    private String idPropietario;

    private Integer version;

    // preguntar si se usará el Date de java.util o el OffsetDateTime de java.time
    @Column(name = "FEC_ALTA")
    private Date fechaAlta;

    // preguntar si se usará el Date de java.util o el OffsetDateTime de java.time
    @Column(name = "FEC_ESTADO")
    private Date fechaEstado;

    private String estado;

    private String contenido;

}
