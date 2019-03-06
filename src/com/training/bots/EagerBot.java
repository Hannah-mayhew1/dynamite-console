package com.training.bots;

import com.softwire.dynamite.bot.Bot;
import com.softwire.dynamite.game.Gamestate;
import com.softwire.dynamite.game.Move;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EagerBot implements Bot {

    int noOfDPlayed = 0;

    @Override
    public Move makeMove(Gamestate gamestate) {

        if (noOfDPlayed < 100) {
            noOfDPlayed++;
            return Move.D;
        }
        else {
                List<Move> moves = new ArrayList<>();
                moves.add(Move.R);
                moves.add(Move.S);
                moves.add(Move.P);

                Random move = new Random();
                return moves.get(move.nextInt(moves.size()));
            }
        }

    }