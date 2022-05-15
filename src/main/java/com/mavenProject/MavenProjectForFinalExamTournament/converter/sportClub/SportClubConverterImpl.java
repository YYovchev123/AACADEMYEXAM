package com.mavenProject.MavenProjectForFinalExamTournament.converter.sportClub;

import com.mavenProject.MavenProjectForFinalExamTournament.dto.sportClub.SportClubResponse;
import com.mavenProject.MavenProjectForFinalExamTournament.dto.sportClub.SportClubSaveRequest;
import com.mavenProject.MavenProjectForFinalExamTournament.dto.sport.SportResponse;
import com.mavenProject.MavenProjectForFinalExamTournament.entitiy.Sport;
import com.mavenProject.MavenProjectForFinalExamTournament.entitiy.SportClub;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Primary
public class SportClubConverterImpl implements SportClubConverter{

    @Override
    public SportClub convert(SportClubSaveRequest sportClubSaveRequest) {
        return SportClub.builder()
                .name(sportClubSaveRequest.getName())
                .sport(Sport.builder()
                        .name(sportClubSaveRequest.getSport().getName())
                        .build())
                .players(sportClubSaveRequest.getPlayers())
                .build();
    }

    @Override
    public SportClubResponse convert(SportClub sportClub) {
        return SportClubResponse.builder()
                .name(sportClub.getName())
                .sport(SportResponse.builder()
                        .name(sportClub.getSport().getName())
                        .build())
                .players(sportClub.getPlayers())
                .build();
    }
}
