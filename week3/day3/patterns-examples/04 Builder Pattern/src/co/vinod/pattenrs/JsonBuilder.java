package co.vinod.pattenrs;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class JsonBuilder {

	Map<String, Object> data;

	public JsonBuilder() {
		data = new TreeMap<>();
	}

	public String build() {

		if (data.size() == 0) {
			return "{}";
		}

		StringBuilder sb = new StringBuilder(10000);
		sb.append("{");

		int i = 0;
		for (Entry<String, Object> entry : data.entrySet()) {
			sb.append(String.format("\"%s\"", entry.getKey()));
			sb.append(":");

			Object val = entry.getValue();

			if ((val instanceof String)) {
				sb.append(String.format("\"%s\"", val));
			}
			else if (val instanceof List) {
				Iterator<?> it = ((List<?>) val).iterator();
				sb.append("[");
				while (it.hasNext()) {
					Object v = it.next();
					if (v instanceof String) {
						sb.append(String.format("\"%s\"", v));
					} else {
						sb.append(v);
					}

					if (it.hasNext()) {
						sb.append(",");
					}
				}
				sb.append("]");
			} else {
				sb.append(entry.getValue());
			}
			if (i < data.size() - 1) {
				sb.append(",");
			}
			i++;
		}

		sb.append("}");
		return sb.toString();
	}

	public JsonBuilder addProperty(String key, Object value) {
		data.put(key, value);
		return this;
	}

	public JsonBuilder addArrayProperty(String key, Object... values) {
		data.put(key, Arrays.asList(values));
		return this;
	}
}
