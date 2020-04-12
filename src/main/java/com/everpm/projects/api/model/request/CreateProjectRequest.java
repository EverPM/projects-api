package com.everpm.projects.api.model.request;

import lombok.Data;
import javax.validation.constraints.NotBlank;

@Data
public class CreateProjectRequest extends GenericRequest {
    @NotBlank
    private String name;
    private String description;
}
