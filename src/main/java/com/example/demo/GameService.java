package com.example.demo;

import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class GameService {
	
	public GameResult play(GameMove playerMove) {
        GameMove computerMove = generateRandomMove();
        return determineWinner(playerMove, computerMove);
    }

    private GameMove generateRandomMove() {
        Random random = new Random();
        GameMove[] moves = GameMove.values();
        return moves[random.nextInt(moves.length)];
    }

    private GameResult determineWinner(GameMove playerMove, GameMove computerMove) {
        if (playerMove == computerMove) {
            return GameResult.TIE;
        }

        switch (playerMove) {
            case ROCK:
                return (computerMove == GameMove.SCISSORS) ? GameResult.PLAYER_WINS : GameResult.COMPUTER_WINS;
            case PAPER:
                return (computerMove == GameMove.ROCK) ? GameResult.PLAYER_WINS : GameResult.COMPUTER_WINS;
            case SCISSORS:
                return (computerMove == GameMove.PAPER) ? GameResult.PLAYER_WINS : GameResult.COMPUTER_WINS;
            default:
                throw new IllegalArgumentException("Invalid move");
        }
    }

}
