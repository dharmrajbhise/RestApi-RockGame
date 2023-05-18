package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	
	@Autowired
	private GameService gs;

    @Autowired
    public void GameController(GameService gs) {
        this.gs = gs;
    }

    @GetMapping("/play/{playerMove}")
    public String playGame(@PathVariable("playerMove") GameMove playerMove) {
        GameResult result = gs.play(playerMove);
        return result.toString();
    }

}
