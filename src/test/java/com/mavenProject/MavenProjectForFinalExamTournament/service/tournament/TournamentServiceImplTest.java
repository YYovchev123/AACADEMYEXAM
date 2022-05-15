package com.mavenProject.MavenProjectForFinalExamTournament.service.tournament;

import com.mavenProject.MavenProjectForFinalExamTournament.entitiy.Tournament;
import com.mavenProject.MavenProjectForFinalExamTournament.exception.RecordNotFoundException;
import com.mavenProject.MavenProjectForFinalExamTournament.repositroy.TournamentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TournamentServiceImplTest {

    @Mock
    private TournamentRepository tournamentRepository;
    private TournamentServiceImpl tournamentService;

    @BeforeEach
    public void setUp() {
        tournamentService = new TournamentServiceImpl(tournamentRepository);
    }

    @Test
    public void verifyFindAll() {
        when(tournamentRepository.findAll()).thenReturn(List.of(Tournament.builder().build()));
        tournamentService.findAll();
        verify(tournamentRepository, times(1)).findAll();
    }

    @Test
    public void verifySave() {
        Tournament tournament = Tournament.builder().build();
        tournamentService.save(tournament);
        verify(tournamentRepository, times(1)).save(tournament);
    }

    @Test
    public void verifyFindByName() {
        String name = "КикБокс Варна";
        when(tournamentRepository.findByName(name)).thenReturn(Optional.of(Tournament.builder().build()));
        tournamentService.findByName(name);
        verify(tournamentRepository, times(1)).findByName(name);
    }

    @Test
    public void verifyFindById() {
        Long id = 1L;
        when(tournamentRepository.findById(id)).thenReturn(Optional.of(Tournament.builder().build()));
        tournamentService.findById(id);
        verify(tournamentRepository, times(1)).findById(id);
    }

    @Test
    public void verifyFindByNameThrowsException() {
        String message = "Турнир с име КикБокс Варна не е намерен!";
        RecordNotFoundException recordNotFoundException = assertThrows(RecordNotFoundException.class, () -> {
            tournamentService.findByName("КикБокс Варна");
        });
        assertEquals(message, recordNotFoundException.getMessage());
    }

    @Test
    public void verifyFindByIdThrowsException() {
        String message = "Турнир с ID 1 не е намерен!";
        RecordNotFoundException recordNotFoundException = assertThrows(RecordNotFoundException.class, () -> {
            tournamentService.findById(1L);
        });
        assertEquals(message, recordNotFoundException.getMessage());
    }

    @Test
    public void verifyDeleteByName() {
        String name = "КикБокс Варна";
        tournamentService.deleteByName(name);
        verify(tournamentRepository, times(1)).deleteByName(name);
    }

    @Test
    public void verifyDeleteById() {
        Long id = 1L;
        tournamentService.deleteById(id);
        verify(tournamentRepository, times(1)).deleteById(id);
    }


}