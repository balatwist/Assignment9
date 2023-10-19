package Problem2;

public class LinkedStack {
    class Node {
        Object data;
        Node next;

        public Node(Object data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node top;
    private int size;


    public LinkedStack() {
        top = null;
        size = 0;
    }

    public void push(Object item) {
        Node newNode = new Node(item);
        newNode.next = top;
        top = newNode;
        size++;
    }

    public Object pop() {
        if (isEmpty()) {
            System.out.println("Stack is Empty");
            return null;
        }
        Object item = top.data;
        top = top.next;
        size--;
        return item;
    }

    public Object peek() {
        if (isEmpty()) {
            System.out.println("Stack is Empty");
            return null;
        }
        return top.data;
    }

    public boolean isEmpty() {
        return (top == null);
    }

    public int size() {
        return size;
    }

    public static void main(String[] args) {
        LinkedStack s = new LinkedStack();
        s.push(5);
        s.push(7);
        s.push(3);
        System.out.println(s.pop());
        System.out.println(s.peek()); 
    }
}

