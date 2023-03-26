package com.akhilscode;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MoneyRepository extends JpaRepository<Money, Integer> {
    List findByItemId(Integer ID);
}
