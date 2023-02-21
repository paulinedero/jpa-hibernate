package com.wildcodeschool.JpaHibernateApp.repository;

import com.wildcodeschool.JpaHibernateApp.entity.Potion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PotionRepository extends JpaRepository<Potion, Long> {
}
