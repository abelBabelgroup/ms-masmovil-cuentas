package com.masmovil.domain.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@NoArgsConstructor
@Data
@Builder
public class OfertaDto implements Serializable {

    private Long idOferta;
    private Integer IdOfertaOrigen;
    private String idCuenta;
    private String idPropietario;
    private Integer version;
    // preguntar si se usará el Date de java.util o el OffsetDateTime de java.time
    private Date fechaAlta;
    // preguntar si se usará el Date de java.util o el OffsetDateTime de java.time
    private Date fechaEstado;
    private String estado;
    private String contenido;
}
