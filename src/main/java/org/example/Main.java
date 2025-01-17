package org.example;

import org.example.datastructures.StaticArray;
import org.example.datastructures.interfaces.ArrayInterface;

import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ArrayList<String> myArr = new ArrayList<>();
        myArr.add("Kareem");
        myArr.add("Mohamed");
        myArr.add("Shaban");
        ArrayInterface<String> array = new StaticArray<>(myArr);
        ArrayList<ArrayInterface<String>> params = new ArrayList<>();
        params.add(array);
        ArrayInterface<ArrayInterface<String>> array2 = new StaticArray<>(params);

        System.out.println(array);
        System.out.println(array.isEmpty());
    }
}