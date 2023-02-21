package com.wildcodeschool.JpaHibernateApp.repository;

import com.wildcodeschool.JpaHibernateApp.entity.Effect;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EffectRepository extends JpaRepository<Effect, Long> {
}
