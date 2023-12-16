package socialMediaApp;

public class OnlineMeetingSystem {
    public static void main(String[] args) {
        MeetingHistory meetingHistory = new MeetingHistory();

        // Simulate participants joining and performing actions
        meetingHistory.performAction(ParticipantAction.JOIN_MEETING, "Alice");
        meetingHistory.performAction(ParticipantAction.RAISE_HAND, "Bob");
        meetingHistory.performAction(ParticipantAction.LEAVE_MEETING, "Charlie");

        // Print the current state of the meeting history
        System.out.println("Meeting History:");
        meetingHistory.printMeetingHistory();

        // Undo the last action and print the updated history
        meetingHistory.undoLastAction();
        System.out.println("Updated Meeting History:");
        meetingHistory.printMeetingHistory();
    }
}


