package com.mavenProject.MavenProjectForFinalExamTournament.service.player;

import com.mavenProject.MavenProjectForFinalExamTournament.entitiy.Player;

import java.util.List;

public interface  PlayerService {

    Player save(Player player);

    List<Player> findAll();

    Player update(Player updatedPlayer, Long id);

    Player findByName(String name);

    Player findById(Long id);

    void deleteById(Long id);

    void deleteByName(String name);
}
