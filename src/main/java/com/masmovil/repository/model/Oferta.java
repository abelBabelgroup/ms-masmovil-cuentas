package com.masmovil.repository.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

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

    @Column(name = "VERSION")
    private String version;

    @Column(name = "FEC_ALTA")
    private String fechaAlta;

    @Column(name = "FEC_ESTADO")
    private String fechaEstado;

    @Column(name = "ESTADO")
    private String estado;

    @Column(name = "CONTENIDO")
    private String contenido;

}
