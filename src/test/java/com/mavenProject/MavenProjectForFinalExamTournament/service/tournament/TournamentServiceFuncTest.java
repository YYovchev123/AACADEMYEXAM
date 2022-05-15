package com.mavenProject.MavenProjectForFinalExamTournament.service.tournament;

import com.mavenProject.MavenProjectForFinalExamTournament.entitiy.Tournament;
import com.mavenProject.MavenProjectForFinalExamTournament.exception.RecordNotFoundException;
import com.mavenProject.MavenProjectForFinalExamTournament.repositroy.TournamentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class TournamentServiceFuncTest {

    @Autowired
    private TournamentRepository tournamentRepository;
    @Autowired
    private TournamentServiceImpl tournamentService;

    @Test
    public void verifySave() {
        Tournament tournament = Tournament.builder()
                .id(1L)
                .build();
        Tournament actualTournament = tournamentService.save(tournament);

        assertThat(tournament.getName(), is(actualTournament.getName()));

        assertThat(1L, is(actualTournament.getId()));
    }

    @Test
    public void verifyFindAll() {
        tournamentService.findAll();
    }

    @Test
    public void verifyFindById() {
        Tournament tournament = Tournament.builder()
                .name("KickBoxing")
                .build();
        Tournament savedTournament = tournamentRepository.save(tournament);
        Tournament tournamentFoundId = tournamentService.findById(savedTournament.getId());

        assertThat(tournamentFoundId, is(notNullValue()));
    }

    @Test
    public void verifyFindByIdThrowsException() {
        String message = "Турнир с ID 12 не е намерен!";

        RecordNotFoundException exception = assertThrows(RecordNotFoundException.class, () -> {
            tournamentService.findById(12L);
        });

        assertThat(message, is(exception.getMessage()));
    }

    @Test
    public void verifyFindByNameThrowsException() {
        String message = "Турнир с име КикБокс не е намерен!";

        RecordNotFoundException exception = assertThrows(RecordNotFoundException.class, () -> {
            tournamentService.findByName("КикБокс");
        });

        assertThat(message, is(exception.getMessage()));
    }
}
