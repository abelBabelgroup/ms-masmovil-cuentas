package com.masmovil.repository.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@Table(name = "cuentas")
public class Cuenta implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CUENTA")
    private Long idCuenta;

    @Max(9)
    private String cif;

    @Max(250)
    private String nombre;

    @Column(name = "ID_PROPIETARIO")
    @Email
    @Max(50)
    private String idPropietario;

    @Column(name = "FEC_INICIO_PROPIEDAD")
    @Temporal(TemporalType.DATE)
    private Date fecInicioPropiedad;

    @Column(name = "FEC_FIN_PROPIEDAD")
    @Temporal(TemporalType.DATE)
    private Date fecFinPropiedad;

}
