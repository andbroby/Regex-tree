package com.andbroby.operators;

import com.andbroby.RegexNode;

/**
 * Created by broby on 23/02/15.
 */
public class CharacterNode extends RegexNode {
    private char c;

    public static CharacterNode createNode(char c) {
        return new CharacterNode(c);
    }

    private CharacterNode(char c) {
        super(false);
        this.c = c;
    }

    public boolean shift(char c, boolean mark) {
        boolean matched = mark && c == this.c;
        this.marked =  matched;

        return matched;
    }
}
