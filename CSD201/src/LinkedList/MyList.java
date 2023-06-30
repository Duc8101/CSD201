package LinkedList;

public class MyList {

    Node head;
    Node tail;

    public MyList() {
        head = tail = null;
    }

    // check list empty
    boolean isEmpty() {
        return head == null;
    }

    // clear list
    void clear() {
        head = tail = null;
    }

    // add first
    void AddFirst(int value) {
        Node node = new Node(value);
        // if list empty
        if (isEmpty()) {
            head = tail = node;
        } else {
            // node link to head
            node.next = head;
            // update head is node
            head = node;
        }
    }

    // add last
    void AddLast(int value) {
        Node node = new Node(value);
        // if list empty
        if (isEmpty()) {
            head = tail = node;
        } else {
            // tail link to node
            tail.next = node;
            // update tail is node
            tail = node;
        }
    }

    // add node p after node q
    void AddAfter(int valueP, int valueQ) {
        Node p = new Node(valueP);
        Node q = new Node(valueQ);
        // if list not empty
        if (!isEmpty()) {
            // list only node head and q is head
            if (q.data == head.data && head.next == null) {
                AddLast(valueP);
            } else {
                // loop for traverse all node
                for (Node k = head; k != null; k = k.next) {
                    // if find node q
                    if (q.data == k.data) {
                        // p link to node after node q
                        p.next = k.next;
                        // q link to node p
                        k.next = p;
                    }
                }
            }
        }

    }

    // add node p before node q
    void AddBefore(int valueP, int valueQ) {
        Node p = new Node(valueP);
        Node q = new Node(valueQ);
        // if list not empty
        if (!isEmpty()) {
            // list only node head and q is head
            if (q.data == head.data && head.next == null) {
                AddFirst(valueP);
            } else {
                Node g = head; // node before node q
                Node k = head;
                // loop for traverse all node
                while (k != null) {
                    // if find node q
                    if (q.data == k.data) {
                        // link node p to node q
                        p.next = k;
                        // link node g to node p
                        g.next = p;
                    }
                    g = k;
                    k = k.next;
                }
            }
        }
    }

    // get size of list
    int GetSize() {
        int size = 0;
        // loop for traverse through list
        for (Node k = head; k != null; k = k.next) {
            size++;
        }
        return size;
    }

    // add node at random position
    void AddIndex(int value, int index) {
        // if list empty or add at first position
        if (isEmpty() || index == 0) {
            AddFirst(value);
            // if add position after final position
        } else if (index == GetSize()) {
            AddLast(value);
        } else {
            Node node = new Node(value);
            int FindIndex = 0;
            // loop for traverse all node
            Node g = head; // node before node at found position
            Node k = head;
            // loop for traverse all found node
            while (k != null) {
                // if found position
                if (FindIndex == index) {
                    node.next = k;
                    g.next = node;
                }
                g = k;
                k = k.next;
                FindIndex++;
            }
        }
    }

    // display list
    void DisplayList() {
        // loop for traverse through list
        for (Node k = head; k != null; k = k.next) {
            System.out.print(k.data + " ");
        }
        System.out.println();
    }

    // delete first
    void DeleteFirst() {
        // if list not empty
        if (!isEmpty()) {
            head = head.next;
        }

    }

    // delete last
    void DeleteLast() {
        // if list not empty
        if (!isEmpty()) {
            // loop for traverse through list
            for (Node k = head; k != null; k = k.next) {
                // if node after node k is tail
                if (k.next == tail) {
                    k.next = null;
                    tail = k;
                }
            }
        }

    }
    // delete node after node q

    void DeleteAfter(int value) {
        Node q = new Node(value);
        // loop for traverse through list
        for (Node k = head; k != null; k = k.next) {
            //if node q exist in list
            if (q.data == k.data && k.next != null) {
                Node g = k.next;
                k.next = g.next;
            }
        }
    }

    // delete node at any position
    void DeleteIndex(int index) {
        // if position out of range
        if (index < 0 || index > GetSize() - 1) {
            // do nothing
            // if first position
        } else if (index == 0) {
            DeleteFirst();
            // if final position
        } else if (index == GetSize() - 1) {
            DeleteLast();
        } else {
            int FoundIndex = 0;
            Node k;
            // loop for traverse through list
            for (k = head; k != null; k = k.next) {
                // if found position at position neead to be deleted
                if (FoundIndex == index - 1) {
                    break;
                }
                FoundIndex++;
            }
            Node g = k.next; // node deleted
            k.next = g.next;
        }
    }

    // delete node with random value
    void DeleteNode(int value) {
        // if node at first 
        if (head.data == value) {
            DeleteFirst();
            // if node at last   
        } else if (tail.data == value) {
            DeleteLast();
        } else {
            Node g = head;// node g is node before node deleted   
            Node k = head;
            // loop for traverse all node
            while (k != null) {
                // if exist node with value in list
                if (k.data == value) {
                    g.next = k.next;
                }
                g = k;
                k = k.next;
            }
        }
    }

}
