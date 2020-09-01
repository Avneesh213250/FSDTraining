package com.group2.FSD.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.group2.FSD.domain.SalesType;

public interface SalesTypeJPA extends JpaRepository<SalesType, Integer> {
 public SalesType findByType(String sales_type);
}
