package models;

/**
 * @author I_Clarisse
 * @description eventParticipation model
 */
// participants are users who have applied for the job
public class EventParticipation {
    private int participationId;
    private int scheduleId;
    private int jobApplicationId;
    private int participantId;
    private String participationStatus;

    public EventParticipation(){}

    public EventParticipation(int participationId, int scheduleId, int participantId, String participationStatus){
        this.participationId = participationId;
        this.scheduleId = scheduleId;
        this.participantId = participantId;
        this.participationStatus = participationStatus;
    }

    public int getParticipationId() {
        return participationId;
    }

    public void setParticipationId(int participationId) {
        this.participationId = participationId;
    }

    public int getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(int scheduleId) {
        this.scheduleId = scheduleId;
    }

    public int getJobApplicationId() {
        return jobApplicationId;
    }

    public void setJobApplicationId(int jobApplicationId) {
        this.jobApplicationId = jobApplicationId;
    }

    public int getParticipantId() {
        return participantId;
    }

    public void setParticipantId(int participantId) {
        this.participantId = participantId;
    }

    public String getParticipationStatus() {
        return participationStatus;
    }

    public void setParticipationStatus(String participationStatus) {
        this.participationStatus = participationStatus;
    }
}
