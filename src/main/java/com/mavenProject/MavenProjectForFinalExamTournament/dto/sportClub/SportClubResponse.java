package com.mavenProject.MavenProjectForFinalExamTournament.dto.sportClub;

import com.mavenProject.MavenProjectForFinalExamTournament.dto.sport.SportResponse;
import com.mavenProject.MavenProjectForFinalExamTournament.entitiy.Player;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SportClubResponse {

    private String name;

    private SportResponse sport;

    private List<Player> players;
}
