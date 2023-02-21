package com.wildcodeschool.JpaHibernateApp.repository;

import com.wildcodeschool.JpaHibernateApp.entity.PotionIngredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PotionIngredientRepository extends JpaRepository<PotionIngredient, Long> {
}
