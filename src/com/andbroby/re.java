package com.andbroby;

/**
 * Created by broby on 01/03/15.
 */
public class re {
    private RegexNode regexp;

    public re(RegexNode re) {
        this.regexp = re;
    }

    public boolean match(String string) {
        boolean result;

        if (string.isEmpty()) {
            return regexp.canMatchEmptyString();
        }

        result = regexp.shift(string.charAt(0), true);
        for (int i = 1; i < string.length(); i++) {
            result = regexp.shift(string.charAt(i), false);
        }

        regexp.reset();

        return result;
    }
}
