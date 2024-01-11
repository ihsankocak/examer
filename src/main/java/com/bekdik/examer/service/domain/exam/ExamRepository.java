package com.bekdik.examer.service.domain.exam;

import com.bekdik.examer.service.domain.solvable.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RepositoryRestResource
public interface ExamRepository extends JpaRepository<Exam,Long> {
Optional<List<Exam>> findByUsername(String username);
}
