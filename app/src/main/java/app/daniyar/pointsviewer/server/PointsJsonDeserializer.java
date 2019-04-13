package app.daniyar.pointsviewer.server;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;
import java.util.Iterator;

import app.daniyar.pointsviewer.models.ErrorMessage;
import app.daniyar.pointsviewer.models.Point;
import app.daniyar.pointsviewer.models.PointsListData;

public class PointsJsonDeserializer extends JsonDeserializer<ResponseData> {
    @Override
    public ResponseData deserialize(JsonParser p, DeserializationContext ctxt) {
        ResponseData result = null;
        ObjectCodec objectCodec = p.getCodec();
        try {
            JsonNode tree = objectCodec.readTree(p);

            if (tree.has("result")) {
                ResponseData<PointsListData> successResult = new ResponseData<>();
                successResult.setResult(ResponseData.RESULT_OK);
                successResult.setPayload(parseResponseList(tree.get("response").get("points")));
                result = successResult;
            } else {
                JsonNode errorNode = tree.get("response");
                int resultCode = errorNode.get("result").asInt();
                ResponseData<ErrorMessage> badResult = new ResponseData<>();
                badResult.setResult(resultCode);
                badResult.setPayload(parseBadResponse(errorNode.get("message")));

                result = badResult;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    private ErrorMessage parseBadResponse(JsonNode message) {
        return new ErrorMessage(message.asText());
    }

    private PointsListData parseResponseList(JsonNode jsonNode) {
        PointsListData result = new PointsListData();

        if (jsonNode.isArray()) {
            Iterator<JsonNode> iterator = jsonNode.iterator();
            while (iterator.hasNext()) {
                JsonNode item = iterator.next();
                Point value = new Point((float) item.get("x").asDouble(), (float) item.get("y").asDouble());
                result.getPointsList().add(value);
            }
        }
        return result;
    }
}
