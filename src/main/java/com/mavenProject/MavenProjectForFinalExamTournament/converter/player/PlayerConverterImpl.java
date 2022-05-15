package com.mavenProject.MavenProjectForFinalExamTournament.converter.player;

import com.mavenProject.MavenProjectForFinalExamTournament.dto.player.PlayerResponse;
import com.mavenProject.MavenProjectForFinalExamTournament.dto.player.PlayerSaveRequest;
import com.mavenProject.MavenProjectForFinalExamTournament.dto.player.PlayerUpdateRequest;
import com.mavenProject.MavenProjectForFinalExamTournament.entitiy.Player;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Primary
public class PlayerConverterImpl implements PlayerConverter{
    @Override
    public Player convert(PlayerSaveRequest playerSaveRequest) {
        return Player.builder()
                .name(playerSaveRequest.getName())
                .age(playerSaveRequest.getAge())
                .build();
    }

    @Override
    public PlayerResponse convert(Player player) {
        return PlayerResponse.builder()
                .name(player.getName())
                .age(player.getAge())
                .build();
    }

    @Override
    public Player convert(PlayerUpdateRequest playerUpdateRequest) {
        return Player.builder()
                .id(playerUpdateRequest.getId())
                .name(playerUpdateRequest.getName())
                .age(playerUpdateRequest.getAge())
                .build();
    }

}
