package com.masmovil.repository;

import com.masmovil.repository.entity.OfferHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OfferHistoryRepository extends JpaRepository<OfferHistory, Long> {
    List<OfferHistory> findByOfferId(Long offerId);
}
