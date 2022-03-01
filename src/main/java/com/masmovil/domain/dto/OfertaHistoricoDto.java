package com.masmovil.domain.dto;

import com.masmovil.repository.entity.offer;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
public class OfertaHistoricoDto implements Serializable {

    private Long idHistorico;
    private offer idOferta;
    private String estado;
    private Date fecEstado;
    private String usuarioEstado;
}
