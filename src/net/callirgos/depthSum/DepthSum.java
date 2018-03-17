package net.callirgos.depthSum;

import java.util.List;

public class DepthSum {
  public interface NestedInteger {
      // Constructor initializes an empty nested list.
      //public NestedInteger();
      // Constructor initializes a single integer.
      //public NestedInteger(int value);
      // @return true if this NestedInteger holds a single integer, rather than a nested list.
      public boolean isInteger();
      // @return the single integer that this NestedInteger holds, if it holds a single integer
      // Return null if this NestedInteger holds a nested list
      public Integer getInteger();
      // Set this NestedInteger to hold a single integer.
      public void setInteger(int value);
      // Set this NestedInteger to hold a nested list and adds a nested integer to it.
      public void add(NestedInteger ni);
      // @return the nested list that this NestedInteger holds, if it holds a nested list
      // Return null if this NestedInteger holds a single integer
      public List<NestedInteger> getList();
  }

    public int depthSumWeight(List<NestedInteger> nestedList, int depth)
    {
        int weight = 0;
        System.out.println(depth);
        for(NestedInteger intOrList : nestedList)
        {
            if(intOrList.isInteger())
            {
                weight += intOrList.getInteger() * depth;
            }
            else
            {
                weight += depthSumWeight(intOrList.getList(), depth++);
            }
        }
        return weight;
    }
    public int depthSum(List<NestedInteger> nestedList) {

        return depthSumWeight(nestedList, 1 );
    }
}
