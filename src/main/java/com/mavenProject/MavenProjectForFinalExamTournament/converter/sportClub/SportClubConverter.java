package com.mavenProject.MavenProjectForFinalExamTournament.converter.sportClub;

import com.mavenProject.MavenProjectForFinalExamTournament.dto.sportClub.SportClubResponse;
import com.mavenProject.MavenProjectForFinalExamTournament.dto.sportClub.SportClubSaveRequest;
import com.mavenProject.MavenProjectForFinalExamTournament.entitiy.SportClub;

public interface SportClubConverter {

    SportClub convert(SportClubSaveRequest sportClubSaveRequest);

    SportClubResponse convert(SportClub sportClub);

}
