package com.company;

import java.util.LinkedHashSet;

public class test {
    public static void main(String[] args) {
        int [] a = new int[10];
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<String>();
        linkedHashSet.add("Hello");
        linkedHashSet.add("world");
        linkedHashSet.add("java");
        linkedHashSet.add("Hello");
        a[0] = 100;
        a[1] = 99;
        a[2] = 98;
        a[3] = 97;
        a[4] = 96;
        a[5] = 95;
        a[6] = 94;
        a[7] = 93;
        a[8] = 92;
        a[9] = 91;
        for(int i : a){
            System.out.println("值 = " + i);
        }
        for (String s:linkedHashSet){
            System.out.println(s);
        }

    }
}
