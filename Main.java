//only for stack and queue, entering the elements and removing them    
    
    import java.util.Scanner;

// Node class
class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

// Stack class
class Stack {
    private Node top;

    public Stack() {
        this.top = null;
    }

    public void push(int data) {
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
    }

    public int pop() {
        if (top == null) {
            System.out.println("Stack is empty");
            return -1;
        }
        int data = top.data;
        top = top.next;
        return data;
    }

    public boolean isEmpty() {
        return top == null;
    }
}

// Queue class
class Queue {
    private Node front, rear;

    public Queue() {
        this.front = this.rear = null;
    }

    public void enqueue(int data) {
        Node newNode = new Node(data);
        if (rear == null) {
            front = rear = newNode;
            return;
        }
        rear.next = newNode;
        rear = newNode;
    }

    public int dequeue() {
        if (front == null) {
            System.out.println("Queue is empty");
            return -1;
        }
        int data = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        return data;
    }

    public boolean isEmpty() {
        return front == null;
    }
}

// Main class
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack stack = new Stack();
        Queue queue = new Queue();

        System.out.println("Enter 5 numbers to push into the stack:");
        for (int i = 0; i < 5; i++) {
            int num = scanner.nextInt();
            stack.push(num);
        }

        System.out.println("Popping from stack:");
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }

        System.out.println("Enter 5 numbers to enqueue into the queue:");
        for (int i = 0; i < 5; i++) {
            int num = scanner.nextInt();
            queue.enqueue(num);
        }

        System.out.println("Dequeuing from queue:");
        while (!queue.isEmpty()) {
            System.out.println(queue.dequeue());
        }

        scanner.close();
    }
}