package com.masmovil.repository.entity;

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
@Table(name = "cuenta")
public class Account implements Serializable {

    @Id
    @Column(name = "id_cuenta")
    private Long accountId;

    private String cif;

    @Column(name = "nombre")
    private String name;

    @Column(name = "sitio_web")
    private String webSite;

    @Column(name = "id_propietario")
    private String ownerId;

    @Column(name = "fec_inicio_propiedad")
    private Date startDateOwnership;

    @Column(name = "fec_fin_propiedad")
    private Date endDateOwnership;

    @Column(name = "marcas")
    private String brands;

    @Column(name = "canal")
    private String channel;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cuenta")
    private List<Contact> contacts;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cuenta")
    private List<Address> addresses;

    public Account(String ownerId, String name, String cif) {
        this.ownerId = ownerId;
        this.name = name;
        this.cif = cif;
    }
}
