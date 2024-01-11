package com.bekdik.examer.application;

import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;

import jakarta.persistence.metamodel.Type;
@org.springframework.context.annotation.Configuration
public class Configuration {

    private EntityManager entityManager;
    @Autowired
    public Configuration(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Bean
    public RepositoryRestConfigurer repositoryRestConfigurer() {

        return RepositoryRestConfigurer.withConfig(repositoryRestConfiguration ->
                repositoryRestConfiguration.exposeIdsFor(  entityManager.getMetamodel().getEntities().stream()
                        .map(Type::getJavaType)
                        .toArray(Class[]::new))
        );
    }
}
