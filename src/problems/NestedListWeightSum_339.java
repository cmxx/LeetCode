package problems;

import java.util.List;

import supporting.NestedInteger;

public class NestedListWeightSum_339 {
    // #339 Nested List Weight Sum

    // The methods in NestedInteger will not actually work correctly.

    // Status: passed. 3ms. 7.91%. My solution.
    int res = 0;

    public int depthSum(List<NestedInteger> nestedList) {
        for (int i = 0; i < nestedList.size(); i++) {
            helper(nestedList.get(i), 1);
        }
        return res;
    }

    public void helper(NestedInteger n, int d) {
        if (n.isInteger())
            res += n.getInteger() * d;
        else {
            d += 1;
            helper2(n.getList(), d);
        }
    }

    public void helper2(List<NestedInteger> n, int d) {
        for (int i = 0; i < n.size(); i++) {
            helper(n.get(i), d);
        }
    }

    // ------------------My Solution ends------------------------

    // Optimized Solution. 
    // 1ms.   77.19%
    public int op(List<NestedInteger> nestedList) {
        return op_helper(nestedList, 1);
    }

    public int op_helper(List<NestedInteger> list, int depth) {
        int res = 0;
        for (NestedInteger e : list) {
            res += e.isInteger() ? e.getInteger() * depth : op_helper(e.getList(), depth + 1);
        }
        return res;

    }

}
