package org.example;

import org.example.datastructures.DynamicArray;
import org.example.datastructures.StaticArray;
import org.example.datastructures.abstracts.arrays.ArrayInterface;
import org.example.datastructures.abstracts.arrays.VectorInterface;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
@SuppressWarnings("unchecked")
public class Main {
    public static void main(String[] args) {
        testStaticArray();
        testDynamicArray();
    }

    public static void testStaticArray() {
        System.out.println("::: ::: ::: Static Array Tests ::: ::: :::");
        String[] myArr = new String[]{"Kareem", "Mohamed", "Shaban"};
        ArrayInterface<String> array = new StaticArray<>(myArr);
        ArrayInterface<String>[] params = (ArrayInterface<String>[]) new ArrayInterface[]{array};
        ArrayInterface<ArrayInterface<String>> array2 = new StaticArray<>(params);

        System.out.println(array2);
        System.out.println(array2.isEmpty());
    }

    public static void testDynamicArray() {
        System.out.println("::: ::: ::: Dynamic Array Tests ::: ::: :::");
        VectorInterface<Integer> v = new DynamicArray<>(new Integer[]{1, 2, 3});
        System.out.println("Capacity: " + v.capacity());
        System.out.println(v);
        v.unshift(4);
        System.out.println(v);
        System.out.println("Capacity: " + v.capacity());
        v.unshift(5);
        System.out.println(v);
        v.unshift(6);
        System.out.println(v);
        System.out.println("Capacity: " + v.capacity());
        v.unshift(7);
        System.out.println(v);
        System.out.println("Capacity: " + v.capacity());
        v.shift();
        System.out.println(v);
        v.shift();
        System.out.println(v);
        int val = v.pop();
        System.out.println(v);
        v.push(val);
        System.out.println(v);
        val = v.dequeue();
        System.out.println(v);
        v.enqueue(val);
        System.out.println(v);
    }
}