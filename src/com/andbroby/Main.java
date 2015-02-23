package com.andbroby;

import com.andbroby.operators.*;
import com.andbroby.operators.CharacterNode;

public class Main {

    public static void main(String[] args) {
        RegexNode re = new AlternativeNode(new CharacterNode('c'), new CharacterNode('b'));
        boolean matches = match(re, "c");
        System.out.println(matches);
    }

    private static boolean match(RegexNode re, String string) {
        boolean result;

        if (string.isEmpty()) {
            return re.isEmpty();
        }

        result = re.shift(string.charAt(0), true);
        for (int i = 1; i < string.length(); i++) {
            result = re.shift(string.charAt(i), false);
        }

        re.reset();

        return result;
    }
}
