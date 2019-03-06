package com.training.bots;

import com.softwire.dynamite.bot.Bot;
import com.softwire.dynamite.game.Gamestate;
import com.softwire.dynamite.game.Move;

public class ScissorBot implements Bot {

    @Override
    public Move makeMove(Gamestate gamestate) {
        return Move.S;
    }
}
