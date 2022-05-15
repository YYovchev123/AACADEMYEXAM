package com.mavenProject.MavenProjectForFinalExamTournament.dto.player;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
public class PlayerSaveRequest {

    @NotNull
    private String name;

    @NotNull
    private Integer age;
}
