package com.mavenProject.MavenProjectForFinalExamTournament.dto.sportClub;

import com.mavenProject.MavenProjectForFinalExamTournament.dto.sport.SportSaveRequest;
import com.mavenProject.MavenProjectForFinalExamTournament.entitiy.Player;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SportClubSaveRequest {

    @NotNull
    private String name;

    private SportSaveRequest sport;

    private List<Player> players;
}
