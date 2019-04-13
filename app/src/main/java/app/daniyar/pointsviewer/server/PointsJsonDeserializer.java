package app.daniyar.pointsviewer.server;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class PointsJsonDeserializer extends JsonDeserializer<ResponseData> {
    @Override
    public ResponseData deserialize(JsonParser p, DeserializationContext ctxt) {
        return null;
    }
}
