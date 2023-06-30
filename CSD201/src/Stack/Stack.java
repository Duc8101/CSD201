package Stack;

import java.util.LinkedList;

public class Stack {

    LinkedList<Object> list;

    public Stack() {
        list = new LinkedList<>();
    }

    // push
    public void push(Object obj) {
        list.addFirst(obj);
    }

    // check list empty
    public boolean isEmpty() {
        return list.isEmpty();
    }

    // pop
    public Object pop() {
        return isEmpty() ? null : list.removeFirst();
    }

    // top
    public Object top() {
        return isEmpty() ? null : list.getFirst();
    }

}
