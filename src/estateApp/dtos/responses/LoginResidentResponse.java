package estateApp.dtos.responses;

public class LoginResidentResponse {
    private String message;
    private boolean fullName;
    private long id;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isFullName() {
        return fullName;
    }

    public void setFullName(boolean fullName) {
        this.fullName = fullName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
