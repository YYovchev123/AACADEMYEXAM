package com.mavenProject.MavenProjectForFinalExamTournament.converter.sport;

import com.mavenProject.MavenProjectForFinalExamTournament.dto.sport.SportResponse;
import com.mavenProject.MavenProjectForFinalExamTournament.dto.sport.SportSaveRequest;
import com.mavenProject.MavenProjectForFinalExamTournament.entitiy.Sport;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Primary
public class SportConverterImpl implements SportConverter{
    @Override
    public Sport convert(SportSaveRequest sportSaveRequest) {
        return Sport.builder()
                .name(sportSaveRequest.getName())
                .build();
    }

    @Override
    public SportResponse convert(Sport sport) {
        return SportResponse.builder()
                .name(sport.getName())
                .build();
    }
}
