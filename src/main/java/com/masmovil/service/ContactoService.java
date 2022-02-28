package com.masmovil.service;

import com.masmovil.domain.dto.ContactoDto;
import com.masmovil.domain.dto.CuentaDto;

public interface ContactoService{

    ContactoDto crearContacto(ContactoDto contacto);
    CuentaDto actualizarContacto(Long cuentaId);
    CuentaDto eliminarContacto(Long cuentaId);
}
