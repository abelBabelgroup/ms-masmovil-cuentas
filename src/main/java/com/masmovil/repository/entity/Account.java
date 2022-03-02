package com.masmovil.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
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
    private List<Contact> contacts;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_CUENTA")
    private List<Address> addresses;

    public Account() {
        this.contacts = new ArrayList<>();
        this.addresses = new ArrayList<>();
    }

    public Account(String ownerId, String name, String cif) {
        this.ownerId = ownerId;
        this.name = name;
        this.cif = cif;
    }
}
