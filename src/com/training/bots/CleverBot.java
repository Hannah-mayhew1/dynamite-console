package com.training.bots;

import com.softwire.dynamite.bot.Bot;
import com.softwire.dynamite.game.Gamestate;
import com.softwire.dynamite.game.Move;
import com.softwire.dynamite.game.Round;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CleverBot implements Bot {

    @Override
    public Move makeMove(Gamestate gamestate) {

//        List<Round> rounds = gamestate.getRounds();
//        Round firstRound = rounds.get(0);
//        Move myFirstMove = firstRound.getP1();
//        Move theirFirstMove = firstRound.getP2();

        if (gamestate.getRounds().isEmpty()) {
            return makeRandomMove(gamestate);
        }

        List<Round> rounds = gamestate.getRounds();
        int lastRound = gamestate.getRounds().size() - 1;
        Round round = rounds.get(lastRound);

        if (round.getP2().equals(Move.P)) {
            return Move.S;
        }
        else if (round.getP2().equals(Move.R)) {
            return Move.P;
        }
        else if (round.getP2().equals(Move.S)) {
            return Move.R;
        }
        else if (round.getP2().equals(Move.D)) {
            return Move.W;
        }
        else if (round.getP2().equals(Move.W)) {
            return Move.S;
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
}
