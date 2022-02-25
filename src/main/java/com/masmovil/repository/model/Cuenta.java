package com.masmovil.repository.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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
    Long idCuenta;

    // Preguntar si el tamaño lo validamos aquí
    String cif;

    String nombre;

    @Column(name = "ID_PROPIETARIO")
    String idPropietario;

    @Column(name = "FEC_INICIO_PROPIEDAD")
    Date fecInicioPropiedad;

    @Column(name = "FEC_FIN_PROPIEDAD")
    Date fecFinPropiedad;
}
