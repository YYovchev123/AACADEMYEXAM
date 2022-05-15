package com.mavenProject.MavenProjectForFinalExamTournament.controller.sport;

import com.mavenProject.MavenProjectForFinalExamTournament.dto.sport.SportResponse;
import com.mavenProject.MavenProjectForFinalExamTournament.dto.sport.SportSaveRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface SportController {

    ResponseEntity<SportResponse> save(SportSaveRequest sportSaveRequest);

    ResponseEntity<List<SportResponse>> findAll();

    ResponseEntity<SportResponse> findById(Long id);

    ResponseEntity<SportResponse> findByName(String name);

    ResponseEntity<HttpStatus> deleteById(Long id);

    ResponseEntity<HttpStatus> deleteByName(String name);
}
