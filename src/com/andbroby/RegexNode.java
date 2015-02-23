package com.andbroby;

/**
 * Created by broby on 23/02/15.
 */
public abstract class RegexNode {
    protected boolean marked = false;
    protected boolean matchEmptyString;

    public RegexNode(boolean matchEmptyString) {
        this.matchEmptyString = matchEmptyString;
    }

    public abstract boolean shift(char c, boolean mark);

    public void reset() {
        this.marked = false;
    }

    public boolean canMatchEmptyString() {
        return this.matchEmptyString;
    }

    public boolean getMark() {
        return this.marked;
    }
}
