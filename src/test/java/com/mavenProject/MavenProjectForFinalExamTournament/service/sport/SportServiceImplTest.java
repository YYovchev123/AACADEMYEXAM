package com.mavenProject.MavenProjectForFinalExamTournament.service.sport;

import com.mavenProject.MavenProjectForFinalExamTournament.entitiy.Sport;
import com.mavenProject.MavenProjectForFinalExamTournament.exception.RecordNotFoundException;
import com.mavenProject.MavenProjectForFinalExamTournament.repositroy.SportRepository;
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
class SportServiceImplTest {

    @Mock
    private SportRepository sportRepository;
    private SportServiceImpl sportService;

    @BeforeEach
    public void setUp() {
        sportService = new SportServiceImpl(sportRepository);
    }

    @Test
    public void verifyFindAll() {
        when(sportRepository.findAll()).thenReturn(List.of(Sport.builder().build()));
        sportService.findAll();
        verify(sportRepository, times(1)).findAll();
    }

    @Test
    public void verifySave() {
        Sport sport = Sport.builder().build();
        sportService.save(sport);
        verify(sportRepository, times(1)).save(sport);
    }

    @Test
    public void verifyFindByName() {
        String name = "MMA";
        when(sportRepository.findByName(name)).thenReturn(Optional.of(Sport.builder().build()));
        sportService.findByName(name);
        verify(sportRepository, times(1)).findByName(name);
    }

    @Test
    public void verifyFindById() {
        Long id = 1L;
        when(sportRepository.findById(id)).thenReturn(Optional.of(Sport.builder().build()));
        sportService.findById(id);
        verify(sportRepository, times(1)).findById(id);
    }

    @Test
    public void verifyFindByNameThrowsException() {
        String message = "Спорт с име MMA не е намерен";
        RecordNotFoundException recordNotFoundException = assertThrows(RecordNotFoundException.class, () -> {
            sportService.findByName("MMA");
        });
        assertEquals(message, recordNotFoundException.getMessage());
    }

    @Test
    public void verifyFindByIdThrowsException() {
        String message = "Спорт с ID 1 не е намерен";
        RecordNotFoundException recordNotFoundException = assertThrows(RecordNotFoundException.class, () -> {
            sportService.findById(1L);
        });
        assertEquals(message, recordNotFoundException.getMessage());
    }

    @Test
    public void verifyDeleteByName() {
        String name = "MMA";
        sportService.deleteByName(name);
        verify(sportRepository, times(1)).deleteByName(name);
    }

    @Test
    public void verifyDeleteById() {
        Long id = 1L;
        sportService.deleteById(id);
        verify(sportRepository, times(1)).deleteById(id);
    }
}