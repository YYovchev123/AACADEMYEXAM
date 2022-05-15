package com.mavenProject.MavenProjectForFinalExamTournament.controller.player;

import com.mavenProject.MavenProjectForFinalExamTournament.dto.player.PlayerResponse;
import com.mavenProject.MavenProjectForFinalExamTournament.dto.player.PlayerSaveRequest;
import com.mavenProject.MavenProjectForFinalExamTournament.dto.player.PlayerUpdateRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PlayerController {

    ResponseEntity<PlayerResponse> save(PlayerSaveRequest playerSaveRequest);

    ResponseEntity<List<PlayerResponse>> findAll();

    ResponseEntity<PlayerResponse> update(PlayerUpdateRequest playerUpdateRequest);

    ResponseEntity<PlayerResponse> findByName(String name);

    ResponseEntity<PlayerResponse> findById(Long id);

    ResponseEntity<HttpStatus> deleteById(Long id);

    ResponseEntity<HttpStatus> deleteByName(String name);


}
