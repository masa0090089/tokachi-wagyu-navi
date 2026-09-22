package com.example.tokachi_wagyu_navi;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopRepository extends JpaRepository <Shop,Integer>{
}