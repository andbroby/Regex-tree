package com.andbroby.operators;

import com.andbroby.RegexNode;

/**
 * Created by broby on 23/02/15.
 */
public class Repetition extends RegexNode {
    RegexNode re;

    public Repetition(RegexNode re) {
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
