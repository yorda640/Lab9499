package socialMediaApp;

public class ProfileNavigationStack {
    private int capacity;
    private int top;
    private String[] profileHistory;

    public ProfileNavigationStack(int capacity) {
        this.capacity = capacity;
        this.top = -1;
        this.profileHistory = new String[capacity];
    }

    public void push(String profileId) {
        if (top < capacity - 1) {
            top++;
            profileHistory[top] = profileId;
        } else {
            System.out.println("Navigation stack is full. Cannot push.");
        }
    }

    public String pop() {
        if (top >= 0) {
            String poppedProfile = profileHistory[top];
            top--;
            return poppedProfile;
        } else {
            System.out.println("Navigation stack is empty. Cannot pop.");
            return null;
        }
    }

    public String peek() {
        if (top >= 0) {
            return profileHistory[top];
        } else {
            System.out.println("Navigation stack is empty. Cannot peek.");
            return null;
        }
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == capacity - 1;
    }

    public static void main(String[] args) {
        ProfileNavigationStack navigationStack = new ProfileNavigationStack(5);

        navigationStack.push("user1");
        navigationStack.push("user2");
        navigationStack.push("user3");

        System.out.println("Last visited profile: " + navigationStack.peek()); // Output: user3
        navigationStack.pop();

        System.out.println("Last visited profile after pop: " + navigationStack.peek()); // Output: user2

        System.out.println("Is the navigation stack empty? " + navigationStack.isEmpty()); // Output: false

        System.out.println("Is the navigation stack full? " + navigationStack.isFull()); // Output: false
    }
}

