package com;

import com.util.ArrayUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        int[] arr = ArrayUtils.readIntArrayFromConsole();
        ArrayList<Integer> ali = new ArrayList<>(Arrays.asList(ArrayUtils.toObject(arr)));
        for (List<Integer> i : step(ali, ali.size(), new ArrayList<>())) {
            System.out.println(i);
        }
    }

    public static List<List<Integer>> step(List<Integer> input, int k, List<List<Integer>> result) {
        if (k == 0) {
            return result;
        }
        if (result.size() == 0) {
            for (Integer i : input) {
                ArrayList<Integer> subList = new ArrayList<>();
                subList.add(i);
                result.add(subList);
            }
            return step(input, k - 1, result);
        }
        List<List<Integer>> newResult = new ArrayList<>();
        for (List<Integer> subList : result) {
            for(Integer i : input) {
                List<Integer> newSubList = new ArrayList<>(subList);
                newSubList.add(i);
                newResult.add(newSubList);
            }
        }
        return step(input, k - 1, newResult);
    }
}