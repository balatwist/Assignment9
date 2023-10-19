package Problem1;

public class ArrayQueueImpl {
    private int[] arr = new int[10];
    private int front = -1;
    private int rear = 0;

    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return -1;
        }
        return arr[front];
    }

    public void enqueue(int obj) {
        if (front == -1) { // If the queue is empty
            front = 0;
        }
        if (rear == arr.length) { // Queue is full, so we resize it
            resize();
        }
        arr[rear++] = obj;
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return -1;
        }
        int removedValue = arr[front];
        front++;
        if (front == rear) {
            front = -1;
            rear = 0;
        }
        return removedValue;
    }

    public boolean isEmpty() {
        return front == -1;
    }

    public int size() {
        if (isEmpty()) return 0;
        return rear - front;
    }

    private void resize() {
        int[] newArr = new int[arr.length * 2];
        int newSize = size();
        System.arraycopy(arr, front, newArr, 0, newSize);
        arr = newArr;
        front = 0;
        rear = newSize;
    }

    public static void main(String[] args) {
        ArrayQueueImpl queue = new ArrayQueueImpl();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        System.out.println(queue.dequeue());
        System.out.println(queue.peek());
        System.out.println(queue.size());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
    }
}
