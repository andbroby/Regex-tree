package com.andbroby.operators;

import com.andbroby.RegexNode;

/**
 * Created by broby on 23/02/15.
 */
public class AlternativeNode extends BinaryNode {
    boolean empty;

    public AlternativeNode(RegexNode left_child, RegexNode right_child) {
        super(left_child, right_child);
        empty = left_child.isEmpty() || right_child.isEmpty();
    }

    public boolean shift(char c, boolean mark) {
        boolean marked_left = this.left_child.shift(c, mark);
        boolean marked_right = this.right_child.shift(c, mark);
        boolean marked = marked_left || marked_right;
        super.setMark(marked);
        return marked_left || marked_right;
    }
}
