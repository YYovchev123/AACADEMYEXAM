package com.mavenProject.MavenProjectForFinalExamTournament.converter.player;

import com.mavenProject.MavenProjectForFinalExamTournament.dto.player.PlayerResponse;
import com.mavenProject.MavenProjectForFinalExamTournament.dto.player.PlayerSaveRequest;
import com.mavenProject.MavenProjectForFinalExamTournament.dto.player.PlayerUpdateRequest;
import com.mavenProject.MavenProjectForFinalExamTournament.entitiy.Player;

public interface PlayerConverter {

    Player convert(PlayerSaveRequest playerSaveRequest);

    PlayerResponse convert(Player player);

    Player convert(PlayerUpdateRequest playerUpdateRequest);
}
