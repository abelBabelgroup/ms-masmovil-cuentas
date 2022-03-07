package com.masmovil.repository.entity;

import com.masmovil.domain.OfferState;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@Table(name = "oferta_historico")
public class OfferHistory implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_historico")
    private Long historyId;

    @Column(name = "id_oferta")
    private Long offerId;

    @Column(name = "estado")
    @Enumerated(EnumType.STRING)
    private OfferState state;

    @Column(name = "fec_estado")
    private LocalDate stateDate;

    @Column(name = "usuario_estado")
    private String userState;
}
