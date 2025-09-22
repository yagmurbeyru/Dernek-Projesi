package com.yagmurbeyru.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yagmurbeyru.entities.Haber;

@Repository
public interface HaberRepository extends JpaRepository<Haber, Integer>{

}
