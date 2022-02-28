package com.masmovil.domain.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@Data
@Builder
public class ContactoDto implements Serializable {

    private Long idContacto;
    private Integer idCuenta;
    private String tipoDocumento;
    private String documento;
    private String nombre;
    private String apellidos;
    private String telefono;
    private String email;
    private String tipo;
    private boolean apoderado;
}
