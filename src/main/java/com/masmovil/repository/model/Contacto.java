package com.masmovil.repository.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

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
    @Size(max = 10)
    private String tipoDocumento;

    @Size(max = 20)
    private String documento;

    @NotNull
    @Size(max = 100)
    private String nombre;

    @NotNull
    @Size(max = 100)
    private String apellidos;

    @Size(max = 100)
    private String telefono;

    @NotNull
    @Size(max = 20)
    @Email
    private String email;

    @NotNull
    private String tipo;

    @NotNull
    private boolean apoderado;

}
