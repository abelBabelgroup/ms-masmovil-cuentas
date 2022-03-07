package com.masmovil.repository;

import com.masmovil.repository.entity.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OfferRepository extends JpaRepository<Offer, Long> {
    List<Offer> findByAccountId(Long accountId);
    List<Offer> findByOriginOfferId(Long originId);
}
