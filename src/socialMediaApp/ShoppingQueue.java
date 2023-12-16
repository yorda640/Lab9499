package socialMediaApp;


public class ShoppingQueue {
    private int capacity;
    private int front;
    private int rear;
    private String[] customers;

    public ShoppingQueue(int capacity) {
        this.capacity = capacity;
        this.front = -1;
        this.rear = -1;
        this.customers = new String[capacity];
    }

    public void enqueue(String customerName) {
        if (isFull()) {
            System.out.println("Queue is full. Cannot enqueue " + customerName);
            return;
        }
        if (isEmpty()) {
            front = 0;
            rear = 0;
        } else {
            rear = (rear + 1) % capacity;
        }
        customers[rear] = customerName;
        System.out.println(customerName + " joined the shopping queue.");
    }

    public String dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. No customer to dequeue.");
            return null;
        }
        String customer = customers[front];
        if (front == rear) {
            front = -1;
            rear = -1;
        } else {
            front = (front + 1) % capacity;
        }
        System.out.println(customer + " is being served and dequeued.");
        return customer;
    }

    public String peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty. No customer to peek.");
            return null;
        }
        return customers[front];
    }

    public boolean isEmpty() {
        return front == -1;
    }

    public boolean isFull() {
        return (rear + 1) % capacity == front;
    }

    public static void main(String[] args) {
        ShoppingQueue shoppingQueue = new ShoppingQueue(5);
        shoppingQueue.enqueue("Alice");
        shoppingQueue.enqueue("Bob");
        shoppingQueue.enqueue("Charlie");

        System.out.println("Next customer to be served: " + shoppingQueue.peek());
        System.out.println("Is the shopping queue empty? " + shoppingQueue.isEmpty());
        System.out.println("Is the shopping queue full? " + shoppingQueue.isFull());

        shoppingQueue.dequeue();
        shoppingQueue.dequeue();
        shoppingQueue.dequeue();

        System.out.println("Is the shopping queue empty? " + shoppingQueue.isEmpty());
        System.out.println("Is the shopping queue full? " + shoppingQueue.isFull());
    }
}
