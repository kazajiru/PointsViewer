package app.daniyar.pointsviewer.server;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = PointsJsonDeserializer.class)
public class ResponseData<T> {
    public static final int RESULT_OK = 0;
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
