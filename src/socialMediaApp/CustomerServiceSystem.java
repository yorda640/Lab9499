package socialMediaApp;

public class CustomerServiceSystem {
    public static void main(String[] args) {
        CustomQueue serviceQueue = new CustomQueue();

        // Simulate customer requests
        serviceQueue.enqueue(new CustomerRequest("Alice", "Billing"));
        serviceQueue.enqueue(new CustomerRequest("Bob", "Technical Support"));
        serviceQueue.enqueue(new CustomerRequest("Charlie", "Returns"));

        // Serve customers in the order they arrived
        while (!serviceQueue.isEmpty()) {
            CustomerRequest servedRequest = serviceQueue.dequeue();
            System.out.println("Serving customer: " + servedRequest.getCustomerName()
                    + " - Request Type: " + servedRequest.getRequestType());
        }
    }
}


