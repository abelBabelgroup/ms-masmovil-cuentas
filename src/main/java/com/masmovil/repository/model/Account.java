package com.masmovil.repository.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
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

}
