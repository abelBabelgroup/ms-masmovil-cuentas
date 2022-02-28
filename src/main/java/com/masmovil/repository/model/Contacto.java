package com.masmovil.repository.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

@Entity
@Data
@NoArgsConstructor
@Table(name = "contacto")
public class Contacto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CONTACTO")
    private Long idContacto;

    @Column(name = "ID_CUENTA")
    private Integer idCuenta;

    @Column(name = "TIPO_DOCUMENTO")
    @Max(10)
    private String tipoDocumento;

    @Max(20)
    private String documento;

    @NotNull
    @Max(100)
    private String nombre;

    @NotNull
    @Max(100)
    private String apellidos;

    @Max(100)
    private String telefono;

    @NotNull
    @Max(20)
    @Email
    private String email;

    @NotNull
    private String tipo;

    @NotNull
    private boolean apoderado;

}
