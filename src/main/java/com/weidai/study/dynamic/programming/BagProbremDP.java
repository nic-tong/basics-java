package com.weidai.study.dynamic.programming;

/**
 * 背包问题
 *
 * 问题描述：给定n种物品和一个背包，物品i的重量是wi，价值vi，背包容量为C，问如何选择装入背包的物品，使装入背包中的物品的总价值最大？
 * 对于每种物品总能选择完全装入或不装入，一个物品最多装入一次。
 *
 *
 * @author lianghong.tlh
 * @date 2020/03/09
 */
public class BagProbremDP {



    public int getMaxValueRecursive(Product[] products, int i, int capability) {
        if(i==0) {
            return capability > products[0].weight ? products[0].value : 0;
        }

        if(capability < products[i].weight) {
            return 0;
        }

        int value1 = products[i].value + getMaxValueRecursive(products,i-1, capability- products[i].weight);
        int value2 =  getMaxValueRecursive(products,i-1, capability);

        return Math.max(value1, value2);
    }

    public static void main(String[] args) {

    }


    public static class Product {

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        int weight;

        int value;
    }


}
