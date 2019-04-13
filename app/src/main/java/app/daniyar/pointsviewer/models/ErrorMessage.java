package app.daniyar.pointsviewer.models;

public class ErrorMessage {
    private String mErrorMessage;

    public ErrorMessage() {
    }

    public ErrorMessage(String message) {
        this.mErrorMessage = message;
    }

    public String getErrorMessage() {
        return mErrorMessage;
    }

    public void setErrorMessage(String mErrorMessage) {
        this.mErrorMessage = mErrorMessage;
    }
}
