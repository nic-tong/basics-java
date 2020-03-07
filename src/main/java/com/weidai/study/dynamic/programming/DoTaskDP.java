package com.weidai.study.dynamic.programming;

import java.util.Collections;
import java.util.List;

import com.google.common.collect.Lists;

/**
 * Q：有如下8个任务 需要花费的时间分别如下，
 * 任务一需要再1时到4时完成  收益为5元
 * 任务二需要再3时到5时完成  收益为1元
 *      。。。。。
 * 任务时间不可冲突去做，问一天做哪几个任务的收益最大？
 *
 *
 *
 * |   |-----5-----|   |   |   |   |   |   |   |    1
 * |   |   |   |---1---|   |   |   |   |   |   |    2
 * |-----------8-----------|   |   |   |   |   |    3
 * |   |   |   |   |-----4-----|   |   |   |   |    4
 * |   |   |   |---------6---------|   |   |   |    5
 * |   |   |   |   |   |-------3-------|   |   |    6
 * |   |   |   |   |   |   |-------2-------|   |    7
 * |   |   |   |   |   |   |   |   |-----4-----|    8
 * 0---1---2---3---4---5---6---7---8---9---10--11------------------->时间
 *
 *  解题思路  每个任务都可能做和不做，对于第i个任务，对应的收益为OPT(i) = max(OPT(i-1),OPT(pre(i))+ a[i])
 *  当i=0时，OPT(0) = 5
 * @author lianghong.tlh
 * @date 2020/03/07
 */

public class DoTaskDP {

    /**
     * 获取每个任务的前一个任务
     * @param sortedMoneyTasks
     * @param current
     * @return
     */
    public static int getPreTask(MoneyTask[] sortedMoneyTasks, int current) {
        for(int i=current-1; i>= 0; i--) {
            if(sortedMoneyTasks[i].getEnd() <= sortedMoneyTasks[current].getStart()){
                return i;
            }
        }
        // 如果不存在 返回-1;
        return -1;
    }

    /**
     * 非递归的方式
     */
    public static int getMaxMoneyNonRecursive(MoneyTask[] sortedMoneyTasks) {

        int [] preTask = new int[sortedMoneyTasks.length];
        int [] optMoney = new int[sortedMoneyTasks.length];

        optMoney[0] = sortedMoneyTasks[0].getValue();
        preTask[0] = -1;
        for (int i=1; i< sortedMoneyTasks.length; i++) {
            preTask[i] = getPreTask(sortedMoneyTasks, i);
            // 做
            int preTaskId = preTask[i];
            int value1 = sortedMoneyTasks[i].getValue() + ((preTaskId == -1)? 0: optMoney[preTaskId]);

            // 不做
            int value2 = optMoney[i-1];
            optMoney[i] = Math.max(value1, value2);
        }

        return optMoney[sortedMoneyTasks.length-1];
    }


    public static int getMaxMoneyRecursive(MoneyTask[] sortedMoneyTasks, int current) {

        if(current == 0) {
            return sortedMoneyTasks[current].getValue();
        }

        int preTaskId = getPreTask(sortedMoneyTasks, current);
        int doTaskOpt = sortedMoneyTasks[current].getValue() + ((preTaskId == -1)? 0: getMaxMoneyRecursive(sortedMoneyTasks, preTaskId));
        int notDotakOpt = getMaxMoneyRecursive(sortedMoneyTasks,current-1);

        return Math.max(doTaskOpt, notDotakOpt);
    }

    public static void main(String[] args) {
        MoneyTask [] tasks = new MoneyTask[8];
        tasks[7] = new MoneyTask(1,4,5);
        tasks[6] = new MoneyTask(3,5,1);
        tasks[5] = new MoneyTask(0,6,8);
        tasks[4] = new MoneyTask(4,7,4);
        tasks[3] = new MoneyTask(3,8,6);
        tasks[2] = new MoneyTask(5,9,3);
        tasks[1] = new MoneyTask(6,10,2);
        tasks[0] = new MoneyTask(8,11,4);

        List<MoneyTask> list = Lists.newArrayList(tasks);
        Collections.sort(list);
        list.toArray(tasks);
        int maxMoney = getMaxMoneyNonRecursive(tasks);
        System.out.println(maxMoney);

        for(int i=0 ;i< tasks.length; i++) {
            System.out.println(getMaxMoneyRecursive(tasks,i));
        }
    }


    public static class MoneyTask implements Comparable<MoneyTask> {

        MoneyTask(int start, int end, int value) {
            this.start = start;
            this.end = end;
            this.value = value;
        }

        public int getStart() {
            return start;
        }

        public void setStart(int start) {
            this.start = start;
        }

        public int getEnd() {
            return end;
        }

        public void setEnd(int end) {
            this.end = end;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        int start;

        int end;

        int value;

        @Override
        public int compareTo(MoneyTask o) {
            return this.end - o.getEnd();
        }
    }

}

