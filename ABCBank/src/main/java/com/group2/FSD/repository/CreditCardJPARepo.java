package com.group2.FSD.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.group2.FSD.domain.CreditCard;

public interface CreditCardJPARepo extends JpaRepository<CreditCard, Long> {

}
