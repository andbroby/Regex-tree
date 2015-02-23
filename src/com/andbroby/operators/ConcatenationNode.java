package com.andbroby.operators;

import com.andbroby.RegexNode;

/**
 * Created by broby on 23/02/15.
 */
public class ConcatenationNode extends BinaryNode {
    protected boolean empty;

    public static ConcatenationNode createNode(RegexNode leftChild, RegexNode rightChild) {
        boolean empty = leftChild.isEmpty() && rightChild.isEmpty();

        return new ConcatenationNode(leftChild, rightChild, empty);
    }

    private ConcatenationNode(RegexNode leftChild, RegexNode rightChild, boolean empty) {
        super(leftChild, rightChild, empty);
        this.empty = empty;
    }

    public boolean shift(char c, boolean mark) {
        boolean oldMarkedLeft = this.leftChild.getMark();
        boolean markedLeft = this.leftChild.shift(c, mark);
        boolean markedRight = this.rightChild.shift(c, oldMarkedLeft || (mark && this.leftChild.isEmpty()));

        return (markedLeft && this.rightChild.isEmpty()) || markedRight;
    }
}
