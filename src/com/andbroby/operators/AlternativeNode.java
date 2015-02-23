package com.andbroby.operators;

import com.andbroby.RegexNode;

/**
 * Created by broby on 23/02/15.
 */
public class AlternativeNode extends BinaryNode {
    protected boolean matchEmptyString;

    public static AlternativeNode createNode(RegexNode leftChild, RegexNode rightChild) {
        boolean empty = leftChild.canMatchEmptyString() || rightChild.canMatchEmptyString();

        return new AlternativeNode(leftChild, rightChild, empty);
    }

    private AlternativeNode(RegexNode leftChild, RegexNode rightChild, boolean matchEmptyString) {
        super(leftChild, rightChild, matchEmptyString);
        this.matchEmptyString = matchEmptyString;
    }

    public boolean shift(char c, boolean mark) {
        boolean markedLeft = this.leftChild.shift(c, mark);
        boolean markedRight = this.rightChild.shift(c, mark);
        boolean matched = markedLeft || markedRight;

        return matched;
    }
}
