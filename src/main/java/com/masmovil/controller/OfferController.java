package com.masmovil.controller;

import com.masmovil.domain.dto.OfferDto;
import com.masmovil.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/offers")
public class OfferController {

    @Autowired
    private OfferService offerService;

    @GetMapping
    public List<OfferDto> getOffers(@RequestParam List<Long> accountId, @RequestParam(required = false) Date entryDate, @RequestParam(required = false) Date stateDate, @RequestParam(required = false) List<String> states) {
        return offerService.findByAccountId(accountId, entryDate, stateDate, states);
    }

    @GetMapping("/{offerId}")
    public OfferDto searchOffer(@PathVariable Long offerId) {
        return offerService.findById(offerId);
    }

    @PostMapping
    public OfferDto addOffer(@RequestBody OfferDto offerDto) {
        if (Objects.isNull(offerDto.getOfferId())) {
            if (Objects.isNull(offerDto.getOwnerId()) || Objects.isNull(offerDto.getAccountId())) {
                throw new RuntimeException("La oferta debe estar asignada a un propietario y una cuenta");
            }
            return offerService.save(offerDto);
        }

        // TODO: Gestionar los errores desde un handler
        throw new RuntimeException("Esa oferta ya existe");
    }

    @PutMapping("/{offerId}")
    public void updateOffer(@PathVariable Long offerId, @RequestBody OfferDto offerDto) {
        // TODO: Implementar histórico si se cambia el estado de la oferta
        OfferDto offerDb = offerService.findById(offerId);
        if (Objects.isNull(offerDb)) {
            // TODO: Gestionar los errores desde un handler
            throw new RuntimeException("La oferta que intenta modificar no existe");
        }
        offerDto.setOfferId(offerId);
        offerService.save(offerDto);
    }

    @PostMapping("/{offerId}/version")
    public OfferDto addOfferVersion(@PathVariable Long offerId) {
        // TODO: Implementar histórico si se cambia el estado de la oferta
        OfferDto offerDb = offerService.findById(offerId);
        if (Objects.isNull(offerDb)) {
            // TODO: Gestionar los errores desde un handler
            throw new RuntimeException("La oferta que intenta modificar no existe");
        }
        // Versiona la oferta indicada, pasándola a un estado CANCELED y creando una nueva oferta en estado CREATION con una versión superior. Devolverá la nueva oferta.
        // TODO: ENUM para los estados?
        // Versionamos la oferta actual
        offerDb.setState("CANCELED");
        offerService.save(offerDb);

        // Creamos nueva oferta a partir de la anterior
        offerDb.setOfferId(null);
        offerDb.setVersion(offerDb.getVersion() + 1);
        offerDb.setState("CREATION");

        return offerService.save(offerDb);
    }

    @GetMapping("/{offerId}/history")
    public OfferDto getOfferHistory() {
        return null;
    }


}
