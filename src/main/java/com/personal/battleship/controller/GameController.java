package com.personal.battleship.controller;

import com.personal.battleship.service.GameService;
import com.personal.battleship.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/game")
public class GameController {

    private GameService gameService;

    public GameController(GameService gameService) {

        this.gameService = gameService;

    }
    @PostMapping("/new_game")
    public Boolean newGame() {
        return false;
    }
    @PostMapping("/continue_game")
    public Boolean continueGame() {
        return false;
    }
    @PostMapping("/attack")
    public Boolean attack() {
        return false;
    }
    @GetMapping("/show_ally_grid")
    public Boolean showAllyGrid() {
        return false;
    }
    @GetMapping("/show_enemy_grid")
    public Boolean showEnemyGrid() {
        return false;
    }
    @GetMapping("/show_history")
    public Boolean showHistory() {
        return false;
    }
    @PutMapping("/return_back_to")
    public Boolean returnBackTo() {
        return false;
    }

}
