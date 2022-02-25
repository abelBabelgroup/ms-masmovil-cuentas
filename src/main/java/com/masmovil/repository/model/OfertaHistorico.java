package com.masmovil.repository.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@Table(name = "ofertas_historico")
public class OfertaHistorico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_HISTORICO")
    private Long idHistorico;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_OFERTA")
    private Oferta idOferta;

    private String estado;

    @Column(name = "FEC_ESTADO")
    private Date fecEstado;

    @Column(name = "USUARIO_ESTADO")
    private String usuarioEstado;
}
