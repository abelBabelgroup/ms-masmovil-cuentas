package com.masmovil.domain.dto;

import com.masmovil.repository.model.Oferta;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
public class OfertaHistoricoDto implements Serializable {

    private Long idHistorico;
    private Oferta idOferta;
    private String estado;
    private Date fecEstado;
    private String usuarioEstado;
}
