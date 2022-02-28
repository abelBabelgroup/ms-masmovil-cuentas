package com.masmovil.repository.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@Table(name = "ofertas_historico")
public class OfertaHistorico implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_HISTORICO")
    private Long idHistorico;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_OFERTA")
    private Oferta idOferta;

    @NotNull
    @Size(max = 20)
    private String estado;

    @Column(name = "FEC_ESTADO")
    @Temporal(TemporalType.DATE)
    private Date fecEstado;

    @Column(name = "USUARIO_ESTADO")
    @Email
    @Size(max = 50)
    private String usuarioEstado;
}
