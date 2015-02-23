package com.andbroby.operators;

import com.andbroby.RegexNode;

/**
 * Created by broby on 23/02/15.
 */
public class ConcatenationNode extends BinaryNode {
    protected boolean matchEmptyString;

    public static ConcatenationNode createNode(RegexNode leftChild, RegexNode rightChild) {
        boolean matchEmptyString = leftChild.canMatchEmptyString() && rightChild.canMatchEmptyString();

        return new ConcatenationNode(leftChild, rightChild, matchEmptyString);
    }

    private ConcatenationNode(RegexNode leftChild, RegexNode rightChild, boolean matchEmptyString) {
        super(leftChild, rightChild, matchEmptyString);
        this.matchEmptyString = matchEmptyString;
    }

    public boolean shift(char c, boolean mark) {
        boolean oldMarkedLeft = this.leftChild.getMark();
        boolean markedLeft = this.leftChild.shift(c, mark);
        boolean markedRight = this.rightChild.shift(c, oldMarkedLeft || (mark && this.leftChild.canMatchEmptyString()));

        return (markedLeft && this.rightChild.canMatchEmptyString()) || markedRight;
    }
}
