package com.mavenProject.MavenProjectForFinalExamTournament.service.sportClub;

import com.mavenProject.MavenProjectForFinalExamTournament.entitiy.SportClub;
import com.mavenProject.MavenProjectForFinalExamTournament.exception.RecordNotFoundException;
import com.mavenProject.MavenProjectForFinalExamTournament.repositroy.SportClubRepository;
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
public class SportClubFuncTest {

    @Autowired
    private SportClubRepository sportClubRepository;
    @Autowired
    private SportClubServiceImpl sportClubService;

    @Test
    public void verifySave() {
        SportClub sport = SportClub.builder()
                .id(1L)
                .name("Desant")
                .build();
        SportClub actualSport = sportClubService.save(sport);

        assertThat(sport.getName(), is(actualSport.getName()));

        //поради някъва причина не е с ID 1 и може да хвърли exception, просто като ви изпише какво прябва да е било Id-то напишете чисото + 1
        assertThat(1L, is(actualSport.getId()));
    }

    @Test
    public void verifyFindAll() {
        sportClubService.findAll();
    }

    @Test
    public void verifyFindById() {
        SportClub sportClub = SportClub.builder()
                .name("MMA")
                .build();
        SportClub savedSportClub = sportClubRepository.save(sportClub);
        SportClub sportClubFoundId = sportClubService.findById(savedSportClub.getId());

        assertThat(sportClubFoundId, is(notNullValue()));
    }

    @Test
    public void verifyFindByIdThrowsException() {
        String message = "Клуб с ID 1 не е намерен";

        RecordNotFoundException exception = assertThrows(RecordNotFoundException.class, () -> {
            sportClubService.findById(1L);
        });

        assertThat(message, is(exception.getMessage()));
    }

    @Test
    public void verifyFindByNameThrowsException() {
        String message = "Клуб с име Десант не е намерен";

        RecordNotFoundException exception = assertThrows(RecordNotFoundException.class, () -> {
            sportClubService.findByName("Десант");
        });

        assertThat(message, is(exception.getMessage()));

    }
}
