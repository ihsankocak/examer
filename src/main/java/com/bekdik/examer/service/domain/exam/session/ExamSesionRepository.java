package com.bekdik.examer.service.domain.exam.session;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ExamSesionRepository extends JpaRepository<ExamSession,Long> {
}
