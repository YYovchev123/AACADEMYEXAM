package com.mavenProject.MavenProjectForFinalExamTournament.controller.player;

import com.mavenProject.MavenProjectForFinalExamTournament.converter.player.PlayerConverter;
import com.mavenProject.MavenProjectForFinalExamTournament.dto.player.PlayerResponse;
import com.mavenProject.MavenProjectForFinalExamTournament.dto.player.PlayerSaveRequest;
import com.mavenProject.MavenProjectForFinalExamTournament.dto.player.PlayerUpdateRequest;
import com.mavenProject.MavenProjectForFinalExamTournament.entitiy.Player;
import com.mavenProject.MavenProjectForFinalExamTournament.service.player.PlayerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/players")
public class PlayerControllerImpl implements PlayerController{

    private final PlayerService playerService;
    private final PlayerConverter playerConverter;

    @Override
    @PostMapping
    public ResponseEntity<PlayerResponse> save(@RequestBody @Valid PlayerSaveRequest playerSaveRequest) {
        Player player = playerConverter.convert(playerSaveRequest);
        Player savedPlayer = playerService.save(player);
        PlayerResponse playerResponse = playerConverter.convert(savedPlayer);
        return ResponseEntity.ok().body(playerResponse);
    }

    @Override
    @GetMapping
    public ResponseEntity<List<PlayerResponse>> findAll() {
        return ResponseEntity.ok(playerService.findAll().stream().map(playerConverter::convert).collect(Collectors.toList()));
    }

    @Override
    @PutMapping(value = "/update")
    public ResponseEntity<PlayerResponse> update(@RequestBody PlayerUpdateRequest playerUpdateRequest) {
        Player player = playerConverter.convert(playerUpdateRequest);
        Player updatedPlayer = playerService.update(player , player.getId());
        PlayerResponse playerResponse = playerConverter.convert(updatedPlayer);
        return ResponseEntity.ok().body(playerResponse);
    }

    @Override
    @GetMapping(value = "/name/{name}")
    public ResponseEntity<PlayerResponse> findByName(@PathVariable String name) {
        Player player = playerService.findByName(name);
        PlayerResponse playerResponse = playerConverter.convert(player);
        return ResponseEntity.ok().body(playerResponse);
    }

    @Override
    @GetMapping(value = "/id/{id}")
    public ResponseEntity<PlayerResponse> findById(@PathVariable Long id) {
        Player player = playerService.findById(id);
        PlayerResponse playerResponse = playerConverter.convert(player);
        return  ResponseEntity.ok().body(playerResponse);
    }

    @Override
    @DeleteMapping(value = "/deleteId/{id}")
    public ResponseEntity<HttpStatus> deleteById(@PathVariable Long id) {
        playerService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @Override
    @DeleteMapping(value = "/deleteName/{name}")
    public ResponseEntity<HttpStatus> deleteByName(@PathVariable String name) {
        playerService.deleteByName(name);
        return ResponseEntity.ok().build();
    }
}
