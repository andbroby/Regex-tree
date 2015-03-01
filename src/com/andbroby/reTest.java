package com.andbroby;

import com.andbroby.operators.AlternativeNode;
import com.andbroby.operators.CharacterNode;
import com.andbroby.operators.ConcatenationNode;
import com.andbroby.operators.RepetitionNode;
import junit.framework.TestCase;

public class reTest extends TestCase {

    public void testMatch() throws Exception {
        /**
         * Testing the character pattern c
         */
        CharacterNode c = CharacterNode.createNode('c');
        RegexNode regexpc = c;
        re reC = new re(regexpc);

        assertEquals(true, reC.match("c"));
        assertEquals(false, reC.match("a"));

        /**
         * Testing the concatenation pattern ab
         */
        CharacterNode a = CharacterNode.createNode('a');
        CharacterNode b = CharacterNode.createNode('b');
        ConcatenationNode concat = ConcatenationNode.createNode(a, b);
        re re2 = new re(concat);

        assertEquals(true, re2.match("ab"));
        assertEquals(false, re2.match("aabb"));
        assertEquals(false, re2.match("ba"));
        assertEquals(false, re2.match("a"));
        assertEquals(false, re2.match("b"));

        /**
         * Testing the alternative pattern a|b
         */
        AlternativeNode alt = AlternativeNode.createNode(a,b);
        RegexNode regexp = alt;
        re re1 = new re(regexp);

        assertEquals(true, re1.match("b"));
        assertEquals(false, re1.match("c"));
        assertEquals(true, re1.match("ab"));
        assertEquals(true, re1.match("ba"));

        /**
         * Testing the repetition pattern a*
         */
        CharacterNode a1 = CharacterNode.createNode('a');
        RepetitionNode rep1 = RepetitionNode.createNode(a1);
        RegexNode regexp2 = rep1;
        re re3 = new re(regexp2);

        assertEquals(true, re3.match("b"));
        assertEquals(true, re3.match("aa"));
        assertEquals(true, re3.match("aab"));
        assertEquals(true, re3.match("abab"));
        assertEquals(true, re3.match("aa(aa)"));
        assertEquals(true, re3.match("ab"));
        assertEquals(true, re3.match("b"));

    }
}