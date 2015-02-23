package com.andbroby.operators;

import com.andbroby.RegexNode;

/**
 * Created by broby on 23/02/15.
 */
public abstract class BinaryNode extends RegexNode {
    protected RegexNode leftChild;
    protected RegexNode rightChild;

    public BinaryNode(RegexNode leftChild, RegexNode rightChild, boolean empty) {
        super(empty);
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    public void reset() {
        this.leftChild.reset();
        this.rightChild.reset();
        super.reset();
    }
}
