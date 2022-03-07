package com.masmovil.service;

import com.masmovil.domain.OfferState;
import com.masmovil.domain.dto.OfferDto;
import com.masmovil.repository.OfferRepository;
import com.masmovil.repository.entity.Offer;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OfferService {

    @Autowired
    private OfferRepository offerRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Transactional(readOnly = true)
    public List<OfferDto> findByAccountId(List<Long> accountId, LocalDate entryDate, LocalDate stateDate, List<OfferState> states) {
        List<OfferDto> offersDto = new ArrayList<>();
        ExampleMatcher caseInsensitiveExampleMatcher = ExampleMatcher.matchingAll().withIgnoreCase();
        accountId.forEach(id -> findByAccountIdByExample(entryDate, stateDate, states, offersDto, caseInsensitiveExampleMatcher, id));
        return offersDto;
    }

    private void findByAccountIdByExample(LocalDate entryDate, LocalDate stateDate, List<OfferState> states, List<OfferDto> offersDto, ExampleMatcher caseInsensitiveExampleMatcher, Long id) {
        if (!Objects.isNull(states)) {
            states.forEach(state -> {
                Example<Offer> example = Example.of(new Offer(id, entryDate, stateDate, state), caseInsensitiveExampleMatcher);
                offersDto.addAll(offerRepository.findAll(example).stream().map(offer -> modelMapper.map(offer, OfferDto.class)).collect(Collectors.toList()));
            });
        } else {
            Example<Offer> example = Example.of(new Offer(id, entryDate, stateDate, null), caseInsensitiveExampleMatcher);
            offersDto.addAll(offerRepository.findAll(example).stream().map(offer -> modelMapper.map(offer, OfferDto.class)).collect(Collectors.toList()));
        }
    }

    @Transactional(readOnly = true)
    public OfferDto findById(Long offerId) {
        Optional<Offer> offer = offerRepository.findById(offerId);
        return offer.map(value -> modelMapper.map(value, OfferDto.class)).orElse(null);
    }

    @Transactional(readOnly = true)
    public List<OfferDto> findByOriginId(Long originId) {
        List<Offer> offers = offerRepository.findByOriginOfferId(originId);
        return offers.stream().map(value -> modelMapper.map(value, OfferDto.class)).collect(Collectors.toList());
    }

    @Transactional
    public OfferDto save(OfferDto offerDto) {
        return modelMapper.map(offerRepository.save(modelMapper.map(offerDto, Offer.class)), OfferDto.class);
    }

}
