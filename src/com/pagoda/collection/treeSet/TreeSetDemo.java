package com.pagoda.collection.treeSet;

import java.lang.reflect.Field;
import java.util.TreeSet;

public class TreeSetDemo {
    public static void main(String[] args) {
        TreeSet treeSet=new TreeSet();

        treeSet.add("a");
        treeSet.add("b");

        Class aClass=treeSet.getClass();
        try {
//            Field field= aClass.getDeclaredField("NavigableMap");
            Field field= aClass.getDeclaredField("PRESENT");
            field.setAccessible(true);

//            Map map= (Map) field.get(treeSet);
            Object map=  field.get(treeSet);


             System.out.printf(map.toString());

            treeSet.add("b");

            Field field1= aClass.getDeclaredField("PRESENT");
            field1.setAccessible(true);

//            Map map= (Map) field.get(treeSet);
            Object map1=  field1.get(treeSet);


            System.out.printf(map1.toString());

            Field[] fields= aClass.getDeclaredFields();

            for (Field field2:
            fields) {
                field2.setAccessible(true);
                System.out.println(field2.getName()+":"+field2.get(treeSet));
            }


        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
