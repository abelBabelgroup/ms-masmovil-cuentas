package com.masmovil.controller;

import com.masmovil.domain.dto.OfferDto;
import com.masmovil.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/offers")
public class OfferController {

    @Autowired
    private OfferService offerService;

    @PostMapping
    public ResponseEntity<OfferDto> addOffer(){
        return null;
    }

    @PostMapping("/{offerId}/version")
    public ResponseEntity<OfferDto> addOfferVersion(){
        return null;
    }

    @GetMapping
    public ResponseEntity<OfferDto> getOffer(@RequestParam Long accountId){
        return null;
    }

    @GetMapping("/{offerId}")
    public ResponseEntity<OfferDto> searchOffer(){
        return null;
    }

    @GetMapping("/{{offerId}}/history")
    public ResponseEntity<OfferDto> getOfferHistory(){
        return null;
    }

    @PutMapping("/{offerId}")
    public ResponseEntity<OfferDto> updateOffer(){
        return null;
    }
}
