package app.daniyar.pointsviewer.server;

public class ResponseData<T> {
    private int mResult;
    private T mPayload;

    public int getResult() {
        return mResult;
    }

    public void setResult(int resultCode) {
        this.mResult = resultCode;
    }

    public T getPayload() {
        return mPayload;
    }

    public void setPayload(T payload) {
        this.mPayload = payload;
    }
}
