package com.masmovil.domain.dto;

import com.masmovil.repository.model.Cuenta;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class SedeDto implements Serializable {

    private Long idSede;
    private Cuenta idCuenta;
    private boolean principal;
    private String provincia;
    private String municipio;
    private String codPostal;
    private String tipoVia;
    private String calle;
    private String numero;
    private String bloque;
    private String portal;
    private String planta;
    private String letra;
}
