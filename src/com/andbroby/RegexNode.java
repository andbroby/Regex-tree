package com.andbroby;

/**
 * Created by broby on 23/02/15.
 */
public abstract class RegexNode {
    protected boolean marked = false;
    protected boolean empty;

    public RegexNode(boolean empty) {
        this.empty = empty;
    }

    public abstract boolean shift(char c, boolean mark);

    public void reset() {
        this.marked = false;
    }


    public boolean isEmpty() {
        return this.empty;
    }
}
