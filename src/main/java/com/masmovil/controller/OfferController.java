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
import java.util.Date;
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
        // LocalDate.parse("2022-02-03T23:00:00.000+00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSz"))
        //LocalDate entry = entryDate != null ? LocalDate.parse(entryDate, DateTimeFormatter.ofPattern("yyyy-MM-dd")) : null;
        return offerService.findByAccountId(accountId, entryDate, stateDate, states);
    }

    @GetMapping("/fecha")
    public Date getOffersFecha(@RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date entryDate) {
        // LocalDate.parse("2022-02-03T23:00:00.000+00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSz"))
        //LocalDate entry = entryDate != null ? LocalDate.parse(entryDate, DateTimeFormatter.ofPattern("yyyy-MM-dd")) : null;
        return entryDate;
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
                offerDto.setOriginOfferId(-1L);
                OfferDto newOfferDto = offerService.save(offerDto);
                offerDto.setOfferId(newOfferDto.getOfferId());
                offerDto.setOriginOfferId(newOfferDto.getOfferId());
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
            saveHistory(offerDb, "SpringSecurity.USER");
        }
        offerDto.setOfferId(offerId);
        offerService.save(offerDto);
    }

    private void saveHistory(OfferDto offerDb, String user) {
        OfferHistoryDto offerHistoryDto = new OfferHistoryDto();
        offerHistoryDto.setOfferId(offerDb.getOfferId());
        offerHistoryDto.setState(offerDb.getState());
        offerHistoryDto.setStateDate(offerDb.getStateDate());
        offerHistoryDto.setUserState(user);

        offerHistoryService.save(offerHistoryDto);
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
        offerDb.setState(OfferState.CANCELADA);
        saveHistory(offerDb, "SpringSecurity.USER");
        offerService.save(offerDb);

        // Creamos nueva oferta a partir de la anterior
        offerDb.setOfferId(null);
        // TODO: con que origen de oferta?
        offerDb.setVersion(offerDb.getVersion() + 1);
        offerDb.setState(OfferState.CREADA);

        return offerService.save(offerDb);
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
