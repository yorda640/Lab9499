package socialMediaApp;



class CustomStack {
    private Node top;

    // Node class for the linked list
    private static class Node {
        ParticipantAction data;
        Node next;

        Node(ParticipantAction data) {
            this.data = data;
            this.next = null;
        }
    }

    public void push(ParticipantAction data) {
        Node newNode = new Node(data);
        if (top == null) {
            top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }
    }

    public ParticipantAction pop() {
        if (isEmpty()) {
            return null;
        }
        ParticipantAction temp = top.data;
        top = top.next;
        return temp;
    }

    public boolean isEmpty() {
        return top == null;
    }
}


class MeetingHistory {
    private CustomStack actionStack;

    public MeetingHistory() {
        actionStack = new CustomStack();
    }

    public void performAction(String actionType, String participantName) {
        ParticipantAction participantAction = new ParticipantAction(actionType, participantName);
        actionStack.push(participantAction);
        System.out.println(participantName + " performed " + actionType);
    }

    public void undoLastAction() {
        if (!actionStack.isEmpty()) {
            ParticipantAction undoneAction = actionStack.pop();
            System.out.println("Undo: " + undoneAction.getParticipantName() + " " +
                    undoneAction.getActionType());
            // Implement logic to undo the action if needed
            // For simplicity, this example doesn't include specific undo logic for each action type
        } else {
            System.out.println("No actions to undo.");
        }
    }

    public void printMeetingHistory() {
        CustomStack tempStack = new CustomStack();
        while (!actionStack.isEmpty()) {
            ParticipantAction action = actionStack.pop();
            tempStack.push(action);
            System.out.println(action.getParticipantName() + " " + action.getActionType());
        }
        // Restore the original order in the action stack
        while (!tempStack.isEmpty()) {
            actionStack.push(tempStack.pop());
        }
    }

    public boolean isEmpty() {
        return actionStack.isEmpty();
    }
}

