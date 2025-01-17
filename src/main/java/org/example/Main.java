package org.example;

import org.example.datastructures.StaticArray;
import org.example.datastructures.interfaces.ArrayInterface;

import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        ArrayList<ArrayInterface<String>> params = getParams();

        ArrayInterface<ArrayInterface<String>> result = new StaticArray<>(params);

        for (ArrayInterface<String> item : result) {
            for (String str : item) {
                System.out.println(str);
            }
            System.out.println("---");
        }

        System.out.println();

        System.out.println(result);
        System.out.println(result.isEmpty());
    }

    private static ArrayList<ArrayInterface<String>> getParams() {
        ArrayList<String> data = new ArrayList<>();
        data.add("Kareem");
        data.add("Mohamed");
        data.add("Shaban");

        ArrayList<String> data2 = new ArrayList<>();
        data2.add("Rahma");
        data2.add("Mohamed");
        data2.add("Shaban");

        ArrayInterface<String> array = new StaticArray<>(data);
        ArrayInterface<String> array2 = new StaticArray<>(data2);

        ArrayList<ArrayInterface<String>> params = new ArrayList<>();
        params.add(array);
        params.add(array2);
        return params;
    }
}