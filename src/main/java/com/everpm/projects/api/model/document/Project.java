package com.everpm.projects.api.model.document;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Document(collection = "projects")
public class Project {
    @Id
    private String id;
    private String name;
    private String description;
    private Long createdBy;
    private LocalDateTime createdAt;
    private List<Long> members;
}
