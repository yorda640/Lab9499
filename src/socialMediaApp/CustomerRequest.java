package socialMediaApp;

class CustomerRequest {
    private String customerName;
    private String requestType;

    public CustomerRequest(String customerName, String requestType) {
        this.customerName = customerName;
        this.requestType = requestType;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getRequestType() {
        return requestType;
    }
}

class CustomQueue {
    private Node front;
    private Node rear;

    // Node class for the linked list
    private static class Node {
        CustomerRequest data;
        Node next;

        Node(CustomerRequest data) {
            this.data = data;
            this.next = null;
        }
    }

    public void enqueue(CustomerRequest data) {
        Node newNode = new Node(data);
        if (rear == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
    }

    public CustomerRequest dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        Node temp = front;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        return temp.data;
    }

    public boolean isEmpty() {
        return front == null;
    }
}

