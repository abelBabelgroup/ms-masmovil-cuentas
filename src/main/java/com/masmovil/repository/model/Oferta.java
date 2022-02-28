package com.masmovil.repository.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

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
    @Max(50)
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
    @Size(max = 20)
    private String estado;

    @Size(max = 10000)
    private String contenido;

}
