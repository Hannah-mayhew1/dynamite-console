package com.training.bots;

import com.softwire.dynamite.bot.Bot;
import com.softwire.dynamite.game.Gamestate;
import com.softwire.dynamite.game.Move;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class RandomBot implements Bot {

    @Override
    public Move makeMove(Gamestate gamestate) {
        List<Move> moves = new ArrayList<>();
        moves.add(Move.R);
        moves.add(Move.S);
        moves.add(Move.P);

        Random move = new Random();
        return moves.get(move.nextInt(moves.size())); //generates/gets random number/index up to size of list

    }
}