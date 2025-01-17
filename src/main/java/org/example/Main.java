package org.example;

import org.example.datastructures.StaticArray;
import org.example.datastructures.interfaces.ArrayInterface;

import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
@SuppressWarnings("unchecked")
public class Main {
    public static void main(String[] args) {
        String[] myArr = new String[]{"Kareem", "Mohamed", "Shaban"};
        ArrayInterface<String> array = new StaticArray<>(myArr);
        ArrayInterface<String>[] params = (ArrayInterface<String>[]) new ArrayInterface[]{array};
        ArrayInterface<ArrayInterface<String>> array2 = new StaticArray<>(params);

//        System.out.println(array);
//        System.out.println(array.isEmpty());
    }
}