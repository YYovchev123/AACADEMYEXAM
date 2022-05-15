package com.mavenProject.MavenProjectForFinalExamTournament.dto.tournament;

import com.mavenProject.MavenProjectForFinalExamTournament.dto.sport.SportResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TournamentResponse {

    private String name;

    private SportResponse sport;

    private String date;
}
