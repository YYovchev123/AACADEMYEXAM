package com.mavenProject.MavenProjectForFinalExamTournament.controller.tournament;

import com.mavenProject.MavenProjectForFinalExamTournament.dto.tournament.TournamentResponse;
import com.mavenProject.MavenProjectForFinalExamTournament.dto.tournament.TournamentSaveRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TournamentController {

    ResponseEntity<TournamentResponse> save(TournamentSaveRequest tournamentSaveRequest);

    ResponseEntity<List<TournamentResponse>> findAll();


    ResponseEntity<TournamentResponse> findByName(String name);

    ResponseEntity<TournamentResponse> findById(Long id);

    ResponseEntity<HttpStatus> deleteById(Long id);

    ResponseEntity<HttpStatus> deleteByName(String name);
}
