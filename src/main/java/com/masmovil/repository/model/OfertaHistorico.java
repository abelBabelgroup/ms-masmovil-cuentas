package com.masmovil.repository.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
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

    @NotNull
    @Max(20)
    private String estado;

    @Column(name = "FEC_ESTADO")
    @Temporal(TemporalType.DATE)
    private Date fecEstado;

    @Column(name = "USUARIO_ESTADO")
    @Email
    @Max(50)
    private String usuarioEstado;
}
