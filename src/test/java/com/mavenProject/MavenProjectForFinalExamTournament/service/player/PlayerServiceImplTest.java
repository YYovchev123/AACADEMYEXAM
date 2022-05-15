package com.mavenProject.MavenProjectForFinalExamTournament.service.player;

import com.mavenProject.MavenProjectForFinalExamTournament.entitiy.Player;
import com.mavenProject.MavenProjectForFinalExamTournament.exception.RecordNotFoundException;
import com.mavenProject.MavenProjectForFinalExamTournament.repositroy.PlayerRepository;
import org.junit.jupiter.api.BeforeAll;
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
class PlayerServiceImplTest {

    @Mock
    private PlayerRepository playerRepository;
    private PlayerServiceImpl playerService;

    @BeforeEach
    public void setUp() {
        playerService = new PlayerServiceImpl(playerRepository);
    }

    @Test
    public void verifyFindAll() {
        when(playerRepository.findAll()).thenReturn(List.of(Player.builder().build()));
        playerService.findAll();
        verify(playerRepository, times(1)).findAll();
    }

    @Test
    public void verifySave() {
        Player player = Player.builder().build();
        playerService.save(player);
        verify(playerRepository, times(1)).save(player);
    }

    @Test
    public void verifyUpdate() {
        Player player = Player.builder()
                .id(1L)
                .name("Yoan")
                .age(16)
                .build();
        when(playerRepository.findById(player.getId())).thenReturn(Optional.of(Player.builder()
                .id(1L)
                .name("Yoan")
                .age(16)
                .build()));
        Player playerReturned = playerService.update(player, player.getId());
        assertEquals(player.getId(), playerReturned.getId());
        assertEquals(player.getName(), playerReturned.getName());
    }

    @Test
    public void verifyFindByName() {
        String name = "Yoan";
        when(playerRepository.findByName(name)).thenReturn(Optional.of(Player.builder().build()));
        playerService.findByName(name);
        verify(playerRepository, times(1)).findByName(name);
    }

    @Test
    public void verifyFindById() {
        Long id = 1L;
        when(playerRepository.findById(id)).thenReturn(Optional.of(Player.builder().build()));
        playerService.findById(id);
        verify(playerRepository, times(1)).findById(id);
    }

    @Test
    public void verifyFindByNameThrowsException() {
        String message = "Играч с име Yoan не е намерен";
        RecordNotFoundException recordNotFoundException = assertThrows(RecordNotFoundException.class, () -> {
            playerService.findByName("Yoan");
        });
        assertEquals(message, recordNotFoundException.getMessage());
    }

    @Test
    public void verifyFindByIdThrowsException() {
        String message = "Играч с ID 1 не е намерен";
        RecordNotFoundException recordNotFoundException = assertThrows(RecordNotFoundException.class, () -> {
            playerService.findById(1L);
        });
        assertEquals(message, recordNotFoundException.getMessage());
    }

    @Test
    public void verifyDeleteByName() {
        String name = "Yoan";
        playerService.deleteByName(name);
        verify(playerRepository, times(1)).deleteByName(name);
    }

    @Test
    public void verifyDeleteById() {
        Long id = 1L;
        playerService.deleteById(id);
        verify(playerRepository, times(1)).deleteById(id);
    }
}