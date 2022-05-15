package com.mavenProject.MavenProjectForFinalExamTournament.converter.sport;

import com.mavenProject.MavenProjectForFinalExamTournament.dto.sport.SportResponse;
import com.mavenProject.MavenProjectForFinalExamTournament.dto.sport.SportSaveRequest;
import com.mavenProject.MavenProjectForFinalExamTournament.entitiy.Sport;

public interface SportConverter {

    Sport convert(SportSaveRequest sportSaveRequest);

    SportResponse convert(Sport sport);
}
