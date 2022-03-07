package com.masmovil.repository.entity;

import com.masmovil.domain.ContactType;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@Table(name = "contacto")
public class Contact implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_contacto")
    private Long contactId;

    @Column(name = "id_cuenta")
    private Long accountId;

    @Column(name = "tipo_documento")
    private String documentType;

    @Column(name = "documento")
    private String document;

    @Column(name = "nombre")
    private String name;

    @Column(name = "apellidos")
    private String surname;

    @Column(name = "telefono")
    private String phoneNumber;

    private String email;

    @Column(name = "tipo")
    @Enumerated(EnumType.STRING)
    private ContactType type;

    @Column(name = "apoderado")
    private boolean manager;

}
