package com.weidai.study.leetcode;

import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.Lists;
import org.apache.commons.collections4.CollectionUtils;

/**
 * @author lianghong.tlh
 * @date 2020/03/20
 */
public class MergeSortedList {


    public static List<Integer>  merge(List<Integer> list1, List<Integer> list2) {
        if(CollectionUtils.isEmpty(list1)){
            return list2;
        }
        if(CollectionUtils.isEmpty(list2)) {
            return list1;
        }

        List<Integer> newList = new ArrayList<>();
        int i=0, j =0;
        while(i < list1.size() || j< list2.size()) {
            if(i == list1.size()) {
                newList.add(list2.get(j));
                j++;
                continue;
            }
            if(j == list2.size()) {
                newList.add(list1.get(i));
                i++;
                continue;
            }

            if(list1.get(i) < list2.get(j)) {
                newList.add(list1.get(i));
                i++;
                continue;
            }
            if(list1.get(i) >= list2.get(j)) {
                newList.add(list2.get(j));
                j++;
            }
        }
        return newList;
    }

    public static void main(String[] args) {
        List<Integer> list1 = Lists.newArrayList(1,3,5,6,7,9,10,100);
        List<Integer> list2 = Lists.newArrayList(2,5,6,8,11,19,30,21,33,56,89);

        List<Integer> newList = merge(list1, list2);

        newList.forEach(n-> System.out.print(n+","));
    }
}
