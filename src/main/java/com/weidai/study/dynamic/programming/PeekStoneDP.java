package com.weidai.study.dynamic.programming;

import java.util.Scanner;

/**
 *
 * Q：一排石子 两个人每次只能拿一个，或者相邻的两个，谁最后拿完 谁胜利？ 有没有必胜的策略。
 *
 * 只需要保证最后剩下3个石子的时候 让对方先手，也即剩下6个的时候让对方先手，以此类推 剩余3n个的时候让对方先手。
 * 保证每个回合取个数的和为3个即可
 *
 * 所以 当石子个数为3N个时，让B先手，A有必胜策略
 * 当石子个数为3N+1或3N+2时，A先手有必胜策略
 *
 * @author lianghong.tlh
 * @date 2020/03/08
 */
public class PeekStoneDP {


    public static void peekStone() {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入石头的个数:");
        int stoneCount = sc.nextInt();
        System.out.println("开始游戏，石头个数为:" + stoneCount);
        while (stoneCount > 0) {
            if(stoneCount % 3 == 0) {
                System.out.print("请您取石头:");
                int peekCount;
                while(true) {
                    peekCount = sc.nextInt();
                    if(peekCount >0 && peekCount< 3) {
                        break;
                    }
                    System.out.print("每次只能取1个或2个石头，请重新取石头：");
                }

                stoneCount -= peekCount;
                System.out.println("您取的石头个数为：" + peekCount+", 当前石头个数为：" + stoneCount);
                if(stoneCount == 0) {
                    System.out.println("您最后取完石子，获取胜利!");
                    break;
                }
                int sysPeekCount = stoneCount % 3;
                stoneCount -= sysPeekCount;
                System.out.println("系统取的石头个数为:" + sysPeekCount +",  当前石头个数为：" + stoneCount);
                if(stoneCount == 0) {
                    System.out.println("系统最后取完石子，获取胜利!");
                    break;
                }
            } else {
                int sysPeekCount = stoneCount % 3;
                stoneCount -= sysPeekCount;
                System.out.println("系统取的石头个数为:" + sysPeekCount +",  当前石头个数为：" + stoneCount);
                if(stoneCount == 0) {
                    System.out.println("系统最后取完石子，获取胜利!");
                    break;
                }
                System.out.print("请您取石头:");
                int peekCount;
                while(true) {
                    peekCount = sc.nextInt();
                    if(peekCount >0 && peekCount< 3) {
                        break;
                    }
                    System.out.print("每次只能取1个或2个石头，请重新取石头：");
                }

                stoneCount -= peekCount;
                System.out.println("您取的石头个数为：" + peekCount+", 当前石头个数为：" + stoneCount);
                if(stoneCount == 0) {
                    System.out.println("您最后取完石子，获取胜利!");
                    break;
                }
            }
        }
    }


    public static void main(String[] args) {
        peekStone();
    }
}
