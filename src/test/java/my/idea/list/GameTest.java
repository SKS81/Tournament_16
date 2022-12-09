package my.idea.list;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class GameTest {

    Game game = new Game();

    @Test
    public void shouldWhyIsRegisteredStrengther0() {
        Player player1 = new Player(1, "Sasha", 15);
        Player player2 = new Player(2, "Diana", 15);
        game.register(player1);
        game.register(player2);
        int expectedPlayer = 0;
        int actualPlayer = game.round("Sasha", "Diana");
        Assertions.assertEquals(expectedPlayer, actualPlayer);
    }

    @Test
    public void shouldWhyIsRegisteredStrengther1() {
        Player player1 = new Player(1, "Sasha", 15);
        Player player2 = new Player(2, "Diana", 10);
        game.register(player1);
        game.register(player2);
        int expectedPlayer = 1;
        int actualPlayer = game.round("Sasha", "Diana");
        Assertions.assertEquals(expectedPlayer, actualPlayer);
    }

    @Test
    public void shouldWhyIsRegisteredStrengther2() {
        Player player1 = new Player(1, "Sasha", 10);
        Player player2 = new Player(2, "Diana", 15);
        game.register(player1);
        game.register(player2);
        int expectedPlayer = 2;
        int actualPlayer = game.round("Sasha", "Diana");
        Assertions.assertEquals(expectedPlayer, actualPlayer);
    }

    @Test
    public void shouldWhyIsUnregistered1Strengther() {
        Player player2 = new Player(2, "Diana", 15);
        game.register(player2);
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Sasha", "Diana");
        });
    }

    @Test
    public void shouldWhyIsUnregistered2Strengther() {
        Player player1 = new Player(1, "Sasha", 10);
        game.register(player1);
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Sasha", "Diana");
        });
    }

    @Test
    public void shouldWhyIsUnregistered0Strengther() {
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Sasha", "Diana");
        });
    }
}