package com.masmovil.controller;

import com.masmovil.domain.OfferState;
import com.masmovil.domain.dto.OfferDto;
import com.masmovil.domain.dto.OfferHistoryDto;
import com.masmovil.service.OfferHistoryService;
import com.masmovil.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/offers")
public class OfferController {

    @Autowired
    private OfferService offerService;

    @Autowired
    private OfferHistoryService offerHistoryService;

    @GetMapping
    public List<OfferDto> getOffers(@RequestParam List<Long> accountId, @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate entryDate,
                                    @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate stateDate, @RequestParam(required = false) List<OfferState> states) {
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
            if (Objects.isNull(offerDto.getOriginOfferId())) {
                return offerService.saveWithoutOriginOffer(offerDto);
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
        if (offerDb.getState() != offerDto.getState()) {
            // TODO: Coger el user desde la sesión, front, o donde sea oportuno
            offerDto.setOfferId(offerId);
            offerHistoryService.saveHistory(offerDto, "SpringSecurity.USER");
        }
        offerDto.setOfferId(offerId);
        offerService.save(offerDto);
    }

    @PostMapping("/{offerId}/version")
    public OfferDto addOfferVersion(@PathVariable Long offerId) {
        // TODO: Implementar histórico si se cambia el estado de la oferta
        OfferDto offerDto = offerService.findById(offerId);
        if (Objects.isNull(offerDto)) {
            // TODO: Gestionar los errores desde un handler
            throw new RuntimeException("La oferta que intenta modificar no existe");
        }
        return offerService.saveVersion(offerDto);
    }

    @GetMapping("/{offerId}/version")
    public List<OfferDto> getOfferVersions(@PathVariable Long offerId) {
        return offerService.findByOriginId(offerId);
    }

    @GetMapping("/{offerId}/history")
    public List<OfferHistoryDto> getOfferHistory(@PathVariable Long offerId) {
        return offerHistoryService.findByOfferId(offerId);
    }


}
