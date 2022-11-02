package fr.thomarz.identifier;

import java.util.HashMap;
import java.util.Map;

public class WebIdentifier {

    private Map<String, String> parameters = new HashMap<>();

    public WebIdentifier addParameter(String key, String value) {
        parameters.put(key, value);
        return this;
    }

    public WebIdentifier addParameter(WebIdentifiers identifiers, String value) {
        parameters.put(identifiers.getName(), value);
        return this;
    }

    public String get(String key) {
        return parameters.get(key);
    }

    public String get(WebIdentifiers identifiers) {
        return parameters.getOrDefault(identifiers.getName(), "");
    }

    @Override
    public String toString() {
        if (parameters.size() > 0) {
            int i = 0;
            StringBuilder stringBuilder = new StringBuilder();
            for (Map.Entry<String, String> parameter : parameters.entrySet()) {
                i++;
                stringBuilder.append(parameter.getKey()).append("=\"").append(parameter.getValue()).append("\"");
                if (i < parameters.size()) {
                    stringBuilder.append(" ");
                }
            }
            return " " + stringBuilder.toString();
        }
        return "";
    }
}
