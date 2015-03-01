package com.andbroby;

/**
 * Created by broby on 01/03/15.
 */
public class EpsilonNode extends RegexNode {

    public static EpsilonNode createNode() {
        return new EpsilonNode();
    }

    private EpsilonNode() {
        super(true);
    }

    public boolean shift(char c, boolean mark) {
        return false;
    }
}