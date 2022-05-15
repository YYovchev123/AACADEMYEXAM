package com.mavenProject.MavenProjectForFinalExamTournament.converter.tournament;

import com.mavenProject.MavenProjectForFinalExamTournament.dto.tournament.TournamentResponse;
import com.mavenProject.MavenProjectForFinalExamTournament.dto.tournament.TournamentSaveRequest;
import com.mavenProject.MavenProjectForFinalExamTournament.entitiy.Tournament;

public interface TournamentConverter {

    Tournament convert(TournamentSaveRequest tournamentSaveRequest);

    TournamentResponse convert(Tournament tournament);
}
