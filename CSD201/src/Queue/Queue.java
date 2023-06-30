package Queue;

import java.util.LinkedList;

public class Queue {

    LinkedList<Object> list;

    public Queue() {
        list = new LinkedList<>();
    }

    // enqueue
    public void enqueue(Object obj) {
        list.addLast(obj);
    }

    // check list empty
    public boolean isEmpty() {
        return list.isEmpty();
    }

    // dequeue
    public Object dequeue() {
        return isEmpty() ? null : list.removeFirst();
    }

    // front
    public Object front() {
        return isEmpty() ? null : list.getFirst();
    }

}
