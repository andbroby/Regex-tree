package com.andbroby.operators;

import com.andbroby.RegexNode;

/**
 * Created by broby on 23/02/15.
 */
public abstract class BinaryNode extends RegexNode {
    protected RegexNode left_child;
    protected RegexNode right_child;

    public BinaryNode(RegexNode left_child, RegexNode right_child) {
        super(left_child.isEmpty() || right_child.isEmpty());
        this.left_child = left_child;
        this.right_child = right_child;
    }

    public void reset() {
        this.left_child.reset();
        this.right_child.reset();
        super.reset();
    }
}
