package com.group2.FSD.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.group2.FSD.domain.Sales;

public interface SalesRepository extends JpaRepository<Sales, Integer> {
public List<Sales> findByOfficerid(Integer officerid);
}
