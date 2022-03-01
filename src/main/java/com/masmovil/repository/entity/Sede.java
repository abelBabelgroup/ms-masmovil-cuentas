package com.masmovil.repository.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@Table(name = "sedes")
public class Sede implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_SEDE")
    private Long idSede;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_CUENTA")
    private Cuenta accountId;

    private boolean principal;

    private String provincia;

    private String municipio;

    @Column(name = "COD_POSTAL")
    private String codPostal;

    @Column(name = "TIPO_VIA")
    private String tipoVia;

    private String calle;

    private String numero;

    private String bloque;

    private String portal;

    private String planta;

    private String letra;

}
