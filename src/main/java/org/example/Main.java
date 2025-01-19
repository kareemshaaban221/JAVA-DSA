package org.example;

import org.example.datastructures.DoublyLinkedList;
import org.example.datastructures.DynamicArray;
import org.example.datastructures.StaticArray;
import org.example.datastructures.abstracts.adts.ListInterface;
import org.example.datastructures.abstracts.adts.QueueInterface;
import org.example.datastructures.abstracts.adts.StackInterface;
import org.example.datastructures.abstracts.arrays.ArrayInterface;
import org.example.datastructures.abstracts.arrays.VectorInterface;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
@SuppressWarnings("unchecked")
public class Main {
    public static void main(String[] args) {
        testStaticArray();
        testDynamicArray();
        testDoublyLinkedList();
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

    public static void testDoublyLinkedList() {
        System.out.println("::: ::: ::: Doubly Linked List Tests ::: ::: :::");
        StackInterface<String> list = new DoublyLinkedList<>();
        list.push("Kareem");
        list.push("Mohamed");
        list.push("Shaban");
        System.out.println(list);
        VectorInterface<String> vec = new DynamicArray<>(new String[]{list.pop(), list.pop(), list.pop()});
        System.out.println(vec);
        System.out.println(list);

        QueueInterface<String> list2 = new DoublyLinkedList<>();
        list2.enqueue("Kareem");
        list2.enqueue("Mohamed");
        list2.enqueue("Shaban");
        System.out.println(list2);
        VectorInterface<String> vec2 = new DynamicArray<>(new String[]{list2.dequeue(), list2.dequeue(), list2.dequeue()});
        System.out.println(vec2);
        System.out.println(list2);

        ListInterface<String> list3 = new DoublyLinkedList<>();
        list3.enqueue("Kareem");
        list3.enqueue("Mohamed");
        list3.enqueue("Shaban");
        System.out.println(list3);
        list3.reverse();
        System.out.println(list3);
    }
}