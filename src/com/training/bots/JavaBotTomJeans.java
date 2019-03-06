package com.training.bots;

import com.softwire.dynamite.bot.Bot;
import com.softwire.dynamite.game.Gamestate;
import com.softwire.dynamite.game.Move;
import com.softwire.dynamite.game.Round;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class JavaBotTomJeans implements Bot {

    int noOfDPlayed = 0;

    @Override
    public Move makeMove(Gamestate gamestate) {
        if (gamestate.getRounds().isEmpty()) {
            return makeRandomMove(gamestate);
        }

        List<Round> rounds = gamestate.getRounds();
        int lastRound = gamestate.getRounds().size() - 1;
        Round round = rounds.get(lastRound);


        if (firstFiveMovesEqualTo(Move.R, gamestate)) {
            return Move.P;
        } else if (firstFiveMovesEqualTo(Move.S, gamestate)) {
            return Move.R;
        } else if (firstFiveMovesEqualTo(Move.P, gamestate)) {
            return Move.S;
        } else if (firstFiveMovesEqualTo(Move.D, gamestate)) {
            if (noOfDPlayed < 100) {
                noOfDPlayed++;
                return Move.W;
            }
        } else if (twoDrawsInARow(gamestate)) {
            if (noOfDPlayed < 100) {
                noOfDPlayed++;
                return Move.D;
            }

        }
        else {
            return beatTheirPreviousMoveBot(gamestate);
        }

        return Move.R;
    }

    public Move makeRandomMove(Gamestate gamestate) {
        List<Move> moves = new ArrayList<>();
        moves.add(Move.R);
        moves.add(Move.S);
        moves.add(Move.P);

        Random move = new Random();
        return moves.get(move.nextInt(moves.size())); //generates/gets random number/index up to size of list

    }

    public boolean firstFiveMovesEqualTo(Move move, Gamestate gamestate) {
        if (gamestate.getRounds().size() > 5) {
            for (int round = 0; round < 5; round++) {
                if (!gamestate.getRounds().get(round).getP2().equals(move)) {
                    return false;
                }

            }
            return true;

        }
        return false;
    }

   public boolean twoDrawsInARow(Gamestate gamestate) {
        if (gamestate.getRounds().size() > 2) {
            Round lastRound = gamestate.getRounds().get(gamestate.getRounds().size() - 1);
            Round penRound = gamestate.getRounds().get(gamestate.getRounds().size() - 2);
            if (!penRound.getP1().equals(penRound.getP2())) {
                if (!lastRound.getP1().equals(lastRound.getP2())) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public Move beatTheirPreviousMoveBot(Gamestate gamestate) {
        if (gamestate.getRounds().isEmpty()) {
            return makeRandomMove(gamestate);
        }

        List<Round> rounds = gamestate.getRounds();
        int lastRound = gamestate.getRounds().size() - 1;
        Round round = rounds.get(lastRound);

        if (round.getP1().equals(Move.P)) {
            return Move.R;
        } else if (round.getP1().equals(Move.R)) {
            return Move.S;
        } else if (round.getP1().equals(Move.S)) {
            return Move.P;
        } else if (round.getP1().equals(Move.D)) {
            return Move.S;
        } else if (round.getP1().equals(Move.W)) {
            return makeRandomMove(gamestate);
        }

        return Move.R;
    }
}
