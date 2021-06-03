package model;

public class LogEvent {

    private String id;
    private String state;
    private Integer timestamp;

    LogEvent() {

    }

    public String getId() {
        return id;
    }

    public String getState() {
        return state;
    }

    public  Integer getTimestamp() {
        return timestamp;
    }


    public void setId(String id) {
        this.id = id;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setTimestamp(Integer timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "LogEvent{" +
                "id='" + id + '\'' +
                ", state='" + state + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
