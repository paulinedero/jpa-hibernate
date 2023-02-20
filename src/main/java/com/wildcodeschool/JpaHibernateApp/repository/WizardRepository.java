package com.wildcodeschool.JpaHibernateApp.repository;

import com.wildcodeschool.JpaHibernateApp.entity.Wizard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WizardRepository extends JpaRepository<Wizard, Long> {
}

