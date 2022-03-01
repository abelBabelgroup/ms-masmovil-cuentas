package com.masmovil.repository.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cuentas")
public class Account implements Serializable {

    @Id
    @Column(name = "ID_CUENTA")
    private Long accountId;

    private String cif;

    @Column(name = "NOMBRE")
    private String name;

    @Column(name = "ID_PROPIETARIO")
    private String ownerId;

    @Column(name = "FEC_INICIO_PROPIEDAD")
    private Date startDateOwnership;

    @Column(name = "FEC_FIN_PROPIEDAD")
    private Date endDateOwnership;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_CUENTA")
    private List<Contacto> contacts;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_SEDE")
    private List<Sede> addresses;

    public Account(String ownerId, String name, String cif) {
        this.ownerId = ownerId;
        this.name = name;
        this.cif = cif;
    }
}
