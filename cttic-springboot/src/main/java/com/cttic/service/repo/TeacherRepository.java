package com.cttic.service.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cttic.service.domain.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Integer> {

}
