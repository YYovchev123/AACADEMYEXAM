package com.mavenProject.MavenProjectForFinalExamTournament.service.sportClub;

import com.mavenProject.MavenProjectForFinalExamTournament.entitiy.SportClub;

import java.util.List;

public interface SportClubService {

    SportClub save(SportClub sportClub);

    List<SportClub> findAll();

    SportClub update(SportClub updatedSportClub, Long id);

    SportClub findByName(String name);

    SportClub findById(Long id);

    void deleteById(Long id);

    void deleteByName(String name);
}
