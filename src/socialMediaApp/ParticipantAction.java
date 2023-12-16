package socialMediaApp;


class ParticipantAction {
    public static final String JOIN_MEETING = "JOIN MEETING";
    public static final String LEAVE_MEETING = "LEAVE MEETING";
    public static final String RAISE_HAND = "RAISE HAND";
    public static final String LOWER_HAND = "LOWER HAND";

    private String actionType;
    private String participantName;

    public ParticipantAction(String actionType, String participantName) {
        this.actionType = actionType;
        this.participantName = participantName;
    }

    public String getActionType() {
        return actionType;
    }

    public String getParticipantName() {
        return participantName;
    }
}

