import java.util.Arrays;

// 两地调度
// 公司计划面试2n个人，给定一个数组 costs
// 其中costs[i]=[aCosti, bCosti]
// 表示第i人飞往a市的费用为aCosti，飞往b市的费用为bCosti
// 返回将每个人都飞到a、b中某座城市的最低费用
// 要求每个城市都有n人抵达
// 测试链接 : https://leetcode.cn/problems/two-city-scheduling/
//提交时， 复制粘贴内部类， 并且删除static关键字即可。
public class Code02_TwoCityScheduling{
    static class Solution {
        //贪心思路：
        //1. 假设2n个人都前往a地， 然后选出n个人改到b地。 换选b地的人应该花费小
        public int twoCitySchedCost(int[][] costs) {
            int[] array = new int[costs.length];
            int sum = 0;
            for(int i=0;i<costs.length;++i){
                sum += costs[i][0];
                array[i] = costs[i][1]-costs[i][0];//a换到b的代价
            }
            Arrays.sort(array);
            for(int j=0;j<costs.length/2;++j){
                sum += array[j];
            }
            return sum;
        }
    }
}