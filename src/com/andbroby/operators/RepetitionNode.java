package com.andbroby.operators;

import com.andbroby.RegexNode;

/**
 * Created by broby on 23/02/15.
 */
public class RepetitionNode extends RegexNode {
    private RegexNode re;

    public static RepetitionNode createNode(RegexNode re) {
        return new RepetitionNode(re);
    }

    private RepetitionNode(RegexNode re) {
        super(true);
        this.re = re;
    }

    public boolean shift(char c, boolean mark) {
        return this.re.shift(c, mark || this.marked);
    }

    public void reset() {
        re.reset();
        super.reset();
    }
}
