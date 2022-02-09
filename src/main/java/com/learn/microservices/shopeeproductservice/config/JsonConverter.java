package com.learn.microservices.shopeeproductservice.config;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class JsonConverter {

	@Autowired
	private ObjectMapper objectMapper;

	public JSONObject addMapToJsonObject(JSONObject jsonObject, Map<String, String> elements) {
		if (CollectionUtils.isEmpty(elements)) {
			return jsonObject;
		}
		if (jsonObject == null)
			jsonObject = new JSONObject();

		Iterator<Entry<String, String>> it = elements.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, String> pairs = it.next();
			jsonObject.put(pairs.getKey(), pairs.getValue());
		}
		return jsonObject;
	}

	public String convertJsonToString(JSONObject jsonObject) {
		if (jsonObject == null)
			return null;
		try {
			return objectMapper.writeValueAsString(jsonObject);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public JSONObject convertStringToJson(String jsonString) {
		if (jsonString == null)
			return null;
		try {
			return objectMapper.readValue(jsonString, JSONObject.class);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String convertMapToString(Map<String, String> elements) {
		if (CollectionUtils.isEmpty(elements))
			return null;
		try {
			return objectMapper.writeValueAsString(elements);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}
}
