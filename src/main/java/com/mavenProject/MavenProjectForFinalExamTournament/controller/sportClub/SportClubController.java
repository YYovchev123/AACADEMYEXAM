package com.mavenProject.MavenProjectForFinalExamTournament.controller.sportClub;

import com.mavenProject.MavenProjectForFinalExamTournament.dto.sportClub.SportClubResponse;
import com.mavenProject.MavenProjectForFinalExamTournament.dto.sportClub.SportClubSaveRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface SportClubController {

    ResponseEntity<SportClubResponse> save(SportClubSaveRequest sportClubSaveRequest);

    ResponseEntity<List<SportClubResponse>> findAll();


    ResponseEntity<SportClubResponse> findByName(String name);

    ResponseEntity<SportClubResponse> findById(Long id);

    ResponseEntity<HttpStatus> deleteById(Long id);

    ResponseEntity<HttpStatus> deleteByName(String name);
}
