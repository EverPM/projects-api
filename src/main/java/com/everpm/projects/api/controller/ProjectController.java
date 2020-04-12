package com.everpm.projects.api.controller;

import com.everpm.projects.api.model.document.Project;
import com.everpm.projects.api.model.request.CreateProjectRequest;
import com.everpm.projects.api.repository.ProjectRepository;
import com.everpm.projects.api.service.ProjectService;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;

@RestController
public class ProjectController extends GenericBaseController {

    private ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }



    @RolesAllowed("ROLE_USER")
    @GetMapping("/projects")
    @ResponseStatus(HttpStatus.CREATED)
    public String create(@RequestBody @Validated CreateProjectRequest request, BindingResult bindingResult) throws Exception {
        System.out.println(request);
        if (bindingResult.hasErrors()) {
            System.out.println("===================");
            System.out.println(bindingResult.getFieldErrors().get(0).getDefaultMessage());
//            throw new Exception(bindingResult.getFieldErrors().get(0).toString());
        }
        Project project = transform(request, Project.class);
        System.out.println(project);

        projectService.create(project);
        return "welcome to ever pm";
    }
}

