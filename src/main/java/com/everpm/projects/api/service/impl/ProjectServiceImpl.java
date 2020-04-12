package com.everpm.projects.api.service.impl;

import com.everpm.projects.api.model.document.Project;
import com.everpm.projects.api.repository.ProjectRepository;
import com.everpm.projects.api.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class ProjectServiceImpl implements ProjectService {

    private ProjectRepository projectRepository;

    @Autowired
    public JavaMailSender emailSender;

    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public Project create(Project project) {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("chathurangat@gmail.com");
        message.setSubject("test email");
        message.setFrom("info@asirimangala.com");
        message.setText("test email body");
        emailSender.send(message);

        return projectRepository.save(project);
    }
}
