package com;

import java.util.Arrays;
import java.util.function.Consumer;

public class Solution1 {
    private static void function ( int[] elements){
        int[] copyArr = new int[elements.length];
        boolean[] used = new boolean[elements.length];
        genAll(elements, copyArr, 0, used, next -> next = elements);
    }

    private static void genAll ( int[] elements, int[] current, int next, boolean[] used, Consumer<int[]> callback){
        for (int i = 0; i < elements.length; i++) { //смотрим на каждый элемент из исходного массива
            if (!used[i]) {//если он еще не использовался - ставим его следующим
                used[i] = true;//отмечаем его как уже использованный
                current[next] = elements[i];//записываем его в наш нынешний вариант
                genAll(elements, current, next +1, used, callback);//рекурсивно выбираем следующий элемент и т.д.
                used[i] = false;//пробуем дальше - убираем этот элемент, чтобы поставить какой-то другой
                if (next == elements.length - 1) {
                    callback.accept(current);
                    System.out.println(Arrays.toString(current));
                }
            }
        }
    }
}
