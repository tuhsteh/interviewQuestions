//  (()) -> true
//  (([[[[]]]])(([[]]))) -> true --trs
//  ()[]() -> true
//  (() -> false
//  [()()] -> true
//  [(]  -> false    --trs
//  )() -> false
//  [[[[)))) -> false
//  )( -> false

package com.qatommy.interview.orderedAndBalanced;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import static com.qatommy.interview.orderedAndBalanced.OrderedAndBalanced.orderedAndBalanced;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class OrderedAndBalancedTest {

    List<String> trueTestCases = Arrays.asList(
            "(())",
            "(([[[[]]]])(([[]])))",
            "()[]()",
            "(())",
            "[()()]"
    );

    List<String> falseTestCases = Arrays.asList(
            "(()",
            "[(]",
            ")()",
            "[[[[)))))",
            ")("
    );

    @Test
    public void testOrderedAndBalancedTrueCases() {
        trueTestCases.forEach(b -> {
            assertTrue(b, orderedAndBalanced(b));
        });
    }

    @Test
    public void testOrderedAndBalancedFalseCases() {
        falseTestCases.forEach(b -> {
            assertFalse(b, orderedAndBalanced(b));
        });
    }

}
