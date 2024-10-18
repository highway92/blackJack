package com.prime.gameBoard;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ControllerTest {
    private final Controller controller = new Controller();

    @Test
    @DisplayName("플레이어 추가시 yes,no,y,n 이외의 값은 불가능 하다")
    void addMorePlayerInputTest() {
        boolean result = controller.addMorePlayer();
    }

}