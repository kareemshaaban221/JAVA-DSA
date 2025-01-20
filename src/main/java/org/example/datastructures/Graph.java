package org.example.datastructures;

import org.example.datastructures.abstracts.adts.QueueInterface;
import org.example.datastructures.abstracts.arrays.VectorInterface;
import org.example.helpers.interfaces.Callback;

@SuppressWarnings("unchecked")
public class Graph<T> {

    private class Node<T> {
        private T data;
        private VectorInterface<Integer> neighbors;

        public Node(T data, VectorInterface<Integer> neighbors) {
            this.data = data;
            this.neighbors = neighbors;
        }

        public boolean addNeighbor(int neighbor) {
            return neighbors.push(neighbor);
        }

        public int removeNeighbor(int neighbor) {
            return neighbors.remove(neighbors.indexOf(neighbor));
        }

        public VectorInterface<Integer> getNeighbors() {
            return neighbors;
        }

    }

    private boolean[][] representation;
    private VectorInterface<Node<T>> nodes;

    public Graph(boolean[][] representation, VectorInterface<T> nodes) {
        if (representation == null) { throw new IllegalArgumentException("Representation cannot be null"); }
        if (representation.length == 0) { throw new IllegalArgumentException("Representation cannot be empty"); }
        for (boolean[] row : representation) {
            if (row.length == 0) { throw new IllegalArgumentException("Representation cannot be empty"); }
            if (row.length != representation.length) { throw new IllegalArgumentException("Representation must be a square matrix"); }
        }

        this.representation = representation;
        if (nodes.size() != representation.length) { throw new IllegalArgumentException("Representation and nodes must have the same size"); }
        this.nodes = build(representation, nodes);
    }

    private VectorInterface<Node<T>> build(boolean[][] representation, VectorInterface<T> nodes) {
        VectorInterface<Node<T>> result = new DynamicArray<>();
        for (int i = 0; i < nodes.size(); i++) {
            VectorInterface<Integer> neighbors = new DynamicArray<>();
            for (int j = 0; j < nodes.size(); j++) {
                if (representation[i][j]) {
                    neighbors.set(j, 1);
                }
            }
            result.push(new Node<T>(nodes.get(i), neighbors));
        }
        return result;
    }

    public void traverse(Callback<T> callback) {
        QueueInterface<Node<T>> q = new DoublyLinkedList<>();
        VectorInterface<Node<T>> visited = new DynamicArray<>();
        boolean newLevel = false;
        visit(visited, q, callback, nodes.get(0), newLevel);
        while (! q.isEmpty()) {
            Node<T> node = q.dequeue();
            VectorInterface<Integer> neighbors = node.getNeighbors();
            newLevel = true;
            for (int i = 0; i < neighbors.capacity(); i++) {
                if (neighbors.get(i) == null) { continue; }
                Node<T> neighborNode = nodes.get(i);
                if (! visited.contains(neighborNode)) {
                    visit(visited, q, callback, neighborNode, newLevel);
                    newLevel = false;
                }
            }
        }
    }

    private void visit(
        VectorInterface<Node<T>> visited,
        QueueInterface<Node<T>> q,
        Callback<T> callback,
        Node<T> node,
        boolean newLevel
    ) {
        visited.push(node);
        q.enqueue(node);
        callback.run(node.data, newLevel);
    }

}
