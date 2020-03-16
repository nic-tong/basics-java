package com.weidai.study.dynamic.programming;

/**
 * n个人编号从1->n, 对应n个座位编号从1->n，问每个人都不做在自己的位置上有多少中可能性？
 * 将第n个元素  放在第k个上，那么第k个 放在 n上 的话 剩下元素有D(n-2)种方法，如果第k个不放在第n个元素上 剩下n-1个元素有D(n-1)种放法
 * 所以D(n) = (n-1)[D(n-2) + D(n-1)] 特殊的 当 n=1  D(n) = 0  , 当 n  =2 是 D(n) =1
 * @author lianghong.tlh
 * @date 2020/03/17
 */
public class ChooseSeatDP {

    public  static long getSolutionDP(Long n) {
        // n=1  无接
        if(n == 1){
           return 0L;
        }
        if(n == 2) {
            return 1L;
        }

        return (n-1) * (getSolutionDP(n-1) + getSolutionDP(n-2));
    }

    public  static long [] getSolutionNDP(Long n) {
        long [] results = new long[n.intValue()];
        // n=1  无接
        results[0] =  0L;
        if(n == 1){
            return results;
        }
        results[1] = 1L;
        if(n == 2) {
            return results;
        }
        for (int i=2; i<n; i++) {
            results[i] = (i) * (results[i-1] + results[i-2]);
        }
        return results;
    }





    public static void main(String[] args) {
        System.out.println(getSolutionDP(4L));
        long [] results = getSolutionNDP(30L);
        System.out.println(results);
    }
}
