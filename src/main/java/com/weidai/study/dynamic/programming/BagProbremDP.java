package com.weidai.study.dynamic.programming;

/**
 * 背包问题
 *
 * 问题描述：给定n种物品和一个背包，物品i的重量是wi，价值vi，背包容量为C，问如何选择装入背包的物品，使装入背包中的物品的总价值最大？
 * 对于每种物品总能选择完全装入或不装入，一个物品最多装入一次。
 * Opt[i,C]  的期望为 Max(vi+ Opt[i-1,C-wi], Opt[i-1, C])
 *
 * 出口为
 * 当C < wi 时 Opt[i-1, C]);
 *
 * 当i=0 时，C < w0 时 为0, C> w0 时为 v0;
 *
 * @author lianghong.tlh
 * @date 2020/03/09
 */
public class BagProbremDP {



    public static int getMaxValueRecursive(Product[] products, int i, int capability) {
        if(i==0) {
            return capability >= products[0].weight ? products[0].value : 0;
        }

        if(capability < products[i].weight) {
            return getMaxValueRecursive(products,i-1, capability);
        }

        int value1 = products[i].value + getMaxValueRecursive(products,i-1, capability - products[i].weight);
        int value2 =  getMaxValueRecursive(products,i-1, capability);

        return Math.max(value1, value2);
    }

    public static int getMaxValueNonRecursive(Product[] products, int capability) {

        int [][]optArray = new int[products.length][capability+1];
        for(int i=0; i< products.length;i++) {
            optArray[i][0] = 0;
        }
        for(int j=0; j < capability+1;j++) {
            optArray[0][j] = j >= products[0].weight ? products[0].value : 0;
        }
        for (int i=1; i< products.length; i++) {
            for(int j=1; j< capability+1; j++) {
                if(j < products[i].weight) {
                    optArray[i][j] = optArray[i-1][j];
                } else {
                    int value1 = optArray[i-1][j];
                    int value2 = products[i].value + optArray[i-1][j-products[i].weight];
                    optArray[i][j] = Math.max(value1, value2);
                }
            }
        }
        return optArray[products.length-1][capability];
    }


    public static void main(String[] args) {
        Product [] products = new Product[5];
        products[0] = new Product(5,2);
        products[1] = new Product(3,4);
        products[2] = new Product(6,7);
        products[3] = new Product(2,3);
        products[4] = new Product(9,14);

        System.out.println(getMaxValueRecursive(products, 4, 14));

        System.out.println(getMaxValueNonRecursive(products, 14));
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

        public Product(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }

        int weight;

        int value;
    }


}
