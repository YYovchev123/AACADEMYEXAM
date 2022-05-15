package com.mavenProject.MavenProjectForFinalExamTournament.service.player;

import com.mavenProject.MavenProjectForFinalExamTournament.entitiy.Player;
import com.mavenProject.MavenProjectForFinalExamTournament.exception.RecordNotFoundException;
import com.mavenProject.MavenProjectForFinalExamTournament.repositroy.PlayerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class PlayerServiceFuncTest {

    @Autowired
    private PlayerServiceImpl playerService;
    @Autowired
    public PlayerRepository playerRepository;

    @Test
    public void verifySave() {
        Player player = Player.builder()
                .id(1L)
                .name("Yoan")
                .age(16)
                .build();
        Player actualRole = playerService.save(player);

        assertThat(player.getName(), is(actualRole.getName()));

        //поради някъва причина не е с ID 1 и може да хвърли exception, просто като ви изпише какво прябва да е било Id-то напишете чисото + 1
        assertThat(1L, is(actualRole.getId()));
    }

    @Test
    public void verifyFindAll() {
        playerService.findAll();
    }

    @Test
    public void verifyUpdate() {
        Player player = Player.builder()
                .id(11L)
                .name("Yoan")
                .age(16)
                .build();

        Player updatedPlayer =  playerService.update(player, player.getId());

        assertThat(player.getId(), is(updatedPlayer.getId()));

    }

    @Test
    public void verifyFindById() {
        Player player = Player.builder()
                .name("Yoan")
                .age(16)
                .build();
        Player savedPlayer = playerRepository.save(player);
        Player playerFoundId = playerService.findById(savedPlayer.getId());

        assertThat(playerFoundId, is(notNullValue()));
    }

    @Test
    public void verifyFindByIdThrowsException() {
        String message = "Играч с ID 1 не е намерен";

        RecordNotFoundException exception = assertThrows(RecordNotFoundException.class, () -> {
            playerService.findById(1L);
        });

        assertThat(message, is(exception.getMessage()));
    }

    @Test
    public void verifyFindByNameThrowsException() {
        String message = "Играч с име Йоан не е намерен";

        RecordNotFoundException exception = assertThrows(RecordNotFoundException.class, () -> {
            playerService.findByName("Йоан");
        });

        assertThat(message, is(exception.getMessage()));
    }
}
