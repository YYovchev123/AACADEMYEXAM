package com.mavenProject.MavenProjectForFinalExamTournament.service.sportClub;

import com.mavenProject.MavenProjectForFinalExamTournament.entitiy.SportClub;
import com.mavenProject.MavenProjectForFinalExamTournament.exception.RecordNotFoundException;
import com.mavenProject.MavenProjectForFinalExamTournament.repositroy.SportClubRepository;
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
class SportClubServiceImplTest {

    @Mock
    private SportClubRepository sportClubRepository;
    private SportClubServiceImpl sportClubService;

    @BeforeEach
    public void setUp() {
        sportClubService = new SportClubServiceImpl(sportClubRepository);
    }

    @Test
    public void verifyFindAll() {
        when(sportClubRepository.findAll()).thenReturn(List.of(SportClub.builder().build()));
        sportClubService.findAll();
        verify(sportClubRepository, times(1)).findAll();
    }

    @Test
    public void verifySave() {
        SportClub sportClub = SportClub.builder().build();
        sportClubService.save(sportClub);
        verify(sportClubRepository, times(1)).save(sportClub);
    }

    @Test
    public void verifyFindByName() {
        String name = "Десант";
        when(sportClubRepository.findByName(name)).thenReturn(Optional.of(SportClub.builder().build()));
        sportClubService.findByName(name);
        verify(sportClubRepository, times(1)).findByName(name);
    }

    @Test
    public void verifyFindById() {
        Long id = 1L;
        when(sportClubRepository.findById(id)).thenReturn(Optional.of(SportClub.builder().build()));
        sportClubService.findById(id);
        verify(sportClubRepository, times(1)).findById(id);
    }

    @Test
    public void verifyFindByNameThrowsException() {
        String message = "Клуб с име Десант не е намерен";
        RecordNotFoundException recordNotFoundException = assertThrows(RecordNotFoundException.class, () -> {
            sportClubService.findByName("Десант");
        });
        assertEquals(message, recordNotFoundException.getMessage());
    }

    @Test
    public void verifyFindByIdThrowsException() {
        String message = "Клуб с ID 1 не е намерен";
        RecordNotFoundException recordNotFoundException = assertThrows(RecordNotFoundException.class, () -> {
            sportClubService.findById(1L);
        });
        assertEquals(message, recordNotFoundException.getMessage());
    }

    @Test
    public void verifyDeleteByName() {
        String name = "Десант";
        sportClubService.deleteByName(name);
        verify(sportClubRepository, times(1)).deleteByName(name);
    }

    @Test
    public void verifyDeleteById() {
        Long id = 1L;
        sportClubService.deleteById(id);
        verify(sportClubRepository, times(1)).deleteById(id);
    }
}