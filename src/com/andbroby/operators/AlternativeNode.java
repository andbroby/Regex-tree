package com.andbroby.operators;

import com.andbroby.RegexNode;

/**
 * Created by broby on 23/02/15.
 */
public class AlternativeNode extends BinaryNode {
    protected boolean empty;

    public static AlternativeNode createNode(RegexNode leftChild, RegexNode rightChild) {
        boolean empty = leftChild.isEmpty() || rightChild.isEmpty();

        return new AlternativeNode(leftChild, rightChild, empty);
    }

    private AlternativeNode(RegexNode leftChild, RegexNode rightChild, boolean empty) {
        super(leftChild, rightChild, empty);
        this.empty = empty;
    }

    public boolean shift(char c, boolean mark) {
        boolean markedLeft = this.leftChild.shift(c, mark);
        boolean markedRight = this.rightChild.shift(c, mark);
        boolean matched = markedLeft || markedRight;

        return matched;
    }
}
