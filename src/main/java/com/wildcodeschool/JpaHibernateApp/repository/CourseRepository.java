package com.wildcodeschool.JpaHibernateApp.repository;

import com.wildcodeschool.JpaHibernateApp.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
}
