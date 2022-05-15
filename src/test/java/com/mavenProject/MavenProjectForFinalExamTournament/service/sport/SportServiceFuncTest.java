package com.mavenProject.MavenProjectForFinalExamTournament.service.sport;

import com.mavenProject.MavenProjectForFinalExamTournament.entitiy.Sport;
import com.mavenProject.MavenProjectForFinalExamTournament.exception.RecordNotFoundException;
import com.mavenProject.MavenProjectForFinalExamTournament.repositroy.SportRepository;
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
public class SportServiceFuncTest {

    @Autowired
    private SportRepository sportRepository;
    @Autowired
    private SportServiceImpl sportService;

    @Test
    public void verifySave() {
        Sport sport = Sport.builder()
                .id(1L)
                .name("MMA")
                .build();
        Sport actualSport = sportService.save(sport);

        assertThat(sport.getName(), is(actualSport.getName()));

        //поради някъва причина не е с ID 1 и може да хвърли exception, просто като ви изпише какво прябва да е било Id-то напишете чисото + 1
        assertThat(1L, is(actualSport.getId()));
    }

    @Test
    public void verifyFindAll() {
        sportService.findAll();
    }

    @Test
    public void verifyFindById() {
        Sport sport = Sport.builder()
                .name("MMA")
                .build();
        Sport savedSport = sportRepository.save(sport);
        Sport sportFoundId = sportService.findById(savedSport.getId());

        assertThat(sportFoundId, is(notNullValue()));
    }

    @Test
    public void verifyFindByIdThrowsException() {
        String message = "Спорт с ID 1 не е намерен";

        RecordNotFoundException exception = assertThrows(RecordNotFoundException.class, () -> {
            sportService.findById(1L);
        });

        assertThat(message, is(exception.getMessage()));
    }

    @Test
    public void verifyFindByNameThrowsException() {
        String message = "Спорт с име ММА не е намерен";

        RecordNotFoundException exception = assertThrows(RecordNotFoundException.class, () -> {
            sportService.findByName("ММА");
        });

        assertThat(message, is(exception.getMessage()));
    }
}
