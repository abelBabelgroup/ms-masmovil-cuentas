package com.masmovil.repository.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

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
    @NotNull
    private Integer IdOfertaOrigen;

    @Column(name = "ID_CUENTA")
    private String idCuenta;

    @Column(name = "ID_PROPIETARIO")
    @Email
    private String idPropietario;

    private Integer version;

    // preguntar si se usará el Date de java.util o el OffsetDateTime de java.time
    @Column(name = "FEC_ALTA")
    @Temporal(TemporalType.DATE)
    private Date fechaAlta;

    // preguntar si se usará el Date de java.util o el OffsetDateTime de java.time
    @Column(name = "FEC_ESTADO")
    @Temporal(TemporalType.DATE)
    private Date fechaEstado;

    @Column(name = "ESTADO")
    @NotNull
    private String estado;

    private String contenido;

}
