package org.example;

import org.example.datastructures.DoublyLinkedList;
import org.example.datastructures.DynamicArray;
import org.example.datastructures.Graph;
import org.example.datastructures.StaticArray;
import org.example.datastructures.abstracts.adts.ListInterface;
import org.example.datastructures.abstracts.adts.QueueInterface;
import org.example.datastructures.abstracts.adts.StackInterface;
import org.example.datastructures.abstracts.arrays.ArrayInterface;
import org.example.datastructures.abstracts.arrays.VectorInterface;
import org.example.helpers.interfaces.Callback;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
@SuppressWarnings("unchecked")
public class Main {
    public static void main(String[] args) {
        testStaticArray();
        testDynamicArray();
        testDoublyLinkedList();
        testGraph();
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

    public static void testGraph() {
        System.out.println("::: ::: ::: Graph Tests ::: ::: :::");
        VectorInterface<String> nodes = new DynamicArray<>(new String[]{"(A)", "(B)", "(C)", "(D)", "(E)"});
        boolean[][] representation = new boolean[][]{
                {false, true, false, true, false},
                {true, false, true, false, false},
                {false, true, false, false, false},
                {true, true, false, false, true},
                {false, false, false, true, false}};
        Graph<String> graph = new Graph<>(representation, nodes);
        Callback<String> callback = new Callback<>() {
            @Override
            public void run(String object, boolean newLevel) {
                if (newLevel) { System.out.println("\n"); }
                System.out.print("- " + object);
            }
        };
        graph.traverse(callback);
        /**
         * BFS (Queue-based Traversal) Output:
         * - (A)
         *
         * - (B)- (D)
         *
         * - (C)
         *
         * - (E)
         *
         * DFS (Stack-based Traversal) Output:
         * - (A)
         *
         * - (B)- (D)
         *
         * - (E)
         *
         * - (C)
         *
         * Explaination:
         * The output above is the expected output for both BFS and DFS traversals.
         * In both traversals the B node and the D node are printed first because they are direct neighbors of the A node.
         * Note that the E node is neighbor of the D node, and the C node is neighbor of the B node.
         * First Implementation (BFS):
         * - Prints the C node first because it is the first inserted node in the queue because its parent (the B node) comes first
         * Second Implementation (DFS):
         * - Prints the E node first because it is the first inserted node in the stack because its parent (the D node) was pushed lastly,
         *   So it will be printed first (FIFO).
         */
    }
}