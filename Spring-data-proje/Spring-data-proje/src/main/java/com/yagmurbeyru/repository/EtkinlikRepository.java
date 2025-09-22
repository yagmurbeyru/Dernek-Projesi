package com.yagmurbeyru.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yagmurbeyru.entities.Etkinlik;

@Repository
public interface EtkinlikRepository extends JpaRepository<Etkinlik, Integer>{

}
