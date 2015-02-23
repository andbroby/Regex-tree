package com.andbroby;

/**
 * Created by broby on 23/02/15.
 */
public class Character extends RegexNode {
    char c;

    public Character(char c) {
        super(false);
        this.c = c;
    }

    @Override
    public boolean shift(char c, boolean mark) {
        boolean matched = mark && c == this.c;
        this.marked =  matched;
        return matched;
    }
}
