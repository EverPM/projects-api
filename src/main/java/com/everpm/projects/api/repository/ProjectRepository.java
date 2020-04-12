package com.everpm.projects.api.repository;

import com.everpm.projects.api.model.document.Project;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends MongoRepository<Project,String> {

}
