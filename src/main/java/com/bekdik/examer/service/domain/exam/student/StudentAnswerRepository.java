package com.bekdik.examer.service.domain.exam.student;

import com.bekdik.examer.service.domain.exam.Exam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Collection;
import java.util.Optional;

@RepositoryRestResource
public interface StudentAnswerRepository extends JpaRepository<StudentAnswer,Long> {
}
