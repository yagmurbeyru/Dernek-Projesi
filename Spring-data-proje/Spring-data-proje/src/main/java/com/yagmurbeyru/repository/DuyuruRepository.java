package com.yagmurbeyru.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yagmurbeyru.entities.Duyuru;

@Repository
public interface DuyuruRepository extends JpaRepository<Duyuru, Integer>{

}
