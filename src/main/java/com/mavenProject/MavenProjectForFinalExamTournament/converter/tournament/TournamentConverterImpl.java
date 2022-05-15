package com.mavenProject.MavenProjectForFinalExamTournament.converter.tournament;

import com.mavenProject.MavenProjectForFinalExamTournament.dto.sport.SportResponse;
import com.mavenProject.MavenProjectForFinalExamTournament.dto.tournament.TournamentResponse;
import com.mavenProject.MavenProjectForFinalExamTournament.dto.tournament.TournamentSaveRequest;
import com.mavenProject.MavenProjectForFinalExamTournament.entitiy.Sport;
import com.mavenProject.MavenProjectForFinalExamTournament.entitiy.Tournament;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Primary
public class TournamentConverterImpl implements TournamentConverter{
    @Override
    public Tournament convert(TournamentSaveRequest tournamentSaveRequest) {
        return Tournament.builder()
                .name(tournamentSaveRequest.getName())
                .sport(Sport.builder()
                        .name(tournamentSaveRequest.getSport().getName())
                        .build())
                .date(tournamentSaveRequest.getDate())
                .sportClubs(tournamentSaveRequest.getSportClubs())

                .build();
    }

    @Override
    public TournamentResponse convert(Tournament tournament) {
        return TournamentResponse.builder()
                .name(tournament.getName())
                .sport(SportResponse.builder()
                        .name(tournament.getSport().getName())
                        .build())
                .date(tournament.getDate())
                .build();
    }
}
