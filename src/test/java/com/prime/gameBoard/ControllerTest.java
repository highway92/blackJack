package com.prime.gameBoard;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ControllerTest {
    @Mock
    private InputReader inputReader;

    @InjectMocks
    private Controller controller;

    @Test
    @DisplayName("플레이어 추가 시 'yes' 입력하면 true를 반환한다")
    void addMorePlayerShouldReturnTrueWhenInputIsYes() {
        when(inputReader.readInput()).thenReturn("yes");
        assertTrue(controller.addMorePlayer());
    }

    @Test
    @DisplayName("플레이어 추가 시 'no' 입력하면 false를 반환한다")
    void addMorePlayerShouldReturnFalseWhenInputIsNo() {
        when(inputReader.readInput()).thenReturn("no");
        assertFalse(controller.addMorePlayer());
    }

    @Test
    @DisplayName("플레이어 추가 시 잘못된 입력 후 'yes' 입력하면 true를 반환한다")
    void addMorePlayerShouldReturnTrueWhenInvalidInputFollowedByYes() {
        when(inputReader.readInput())
                .thenReturn("invalid")
                .thenReturn("yes");
        assertTrue(controller.addMorePlayer());
    }
}
