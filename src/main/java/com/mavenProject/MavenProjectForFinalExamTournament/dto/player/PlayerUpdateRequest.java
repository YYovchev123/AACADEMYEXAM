package com.mavenProject.MavenProjectForFinalExamTournament.dto.player;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class PlayerUpdateRequest {

    private Long id;
    private String name;
    private Integer age;
}
