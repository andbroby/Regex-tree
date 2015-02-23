package com.andbroby;

public class Main {

    public static void main(String[] args) {
        boolean matches = match(new Character('c'), "cd");
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
