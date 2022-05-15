package com.mavenProject.MavenProjectForFinalExamTournament.dto.sport;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SportSaveRequest {

    @NotNull
    private String name;
}
