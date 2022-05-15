package com.mavenProject.MavenProjectForFinalExamTournament.dto.tournament;

import com.mavenProject.MavenProjectForFinalExamTournament.dto.sport.SportSaveRequest;
import com.mavenProject.MavenProjectForFinalExamTournament.entitiy.SportClub;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class TournamentSaveRequest {

    @NotNull
    private String name;

    @NotNull
    private SportSaveRequest sport;

    private List<SportClub> sportClubs;

    @NotNull
    private String date;
}
