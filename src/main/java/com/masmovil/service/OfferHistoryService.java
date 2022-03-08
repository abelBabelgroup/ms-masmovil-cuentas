package com.masmovil.service;

import com.masmovil.domain.dto.OfferDto;
import com.masmovil.domain.dto.OfferHistoryDto;
import com.masmovil.repository.OfferHistoryRepository;
import com.masmovil.repository.entity.OfferHistory;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OfferHistoryService {

    @Autowired
    private OfferHistoryRepository offerHistoryRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Transactional(readOnly = true)
    public List<OfferHistoryDto> findByOfferId(Long offerId) {
        return offerHistoryRepository.findByOfferId(offerId).stream().map(value -> modelMapper.map(value, OfferHistoryDto.class)).collect(Collectors.toList());
    }

    @Transactional
    public OfferHistoryDto save(OfferHistoryDto offerHistoryDto) {
        return modelMapper.map(offerHistoryRepository.save(modelMapper.map(offerHistoryDto, OfferHistory.class)), OfferHistoryDto.class);
    }

    public void saveHistory(OfferDto offerDb, String user) {
        OfferHistoryDto offerHistoryDto = new OfferHistoryDto();
        offerHistoryDto.setOfferId(offerDb.getOfferId());
        offerHistoryDto.setState(offerDb.getState());
        offerHistoryDto.setStateDate(offerDb.getStateDate());
        offerHistoryDto.setUserState(user);

        save(offerHistoryDto);
    }

}
