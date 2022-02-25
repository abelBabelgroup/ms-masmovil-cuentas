package com.masmovil.domain.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
public class CuentaDto implements Serializable {

    private Long idCuenta;
    private String cif;
    private String nombre;
    private String idPropietario;
    private Date fecInicioPropiedad;
    private Date fecFinPropiedad;
}
