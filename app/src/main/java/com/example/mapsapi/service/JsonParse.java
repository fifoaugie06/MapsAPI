package com.example.mapsapi.service;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class JsonParse {
    public List<HashMap<String, String>> parse(JSONObject jsonObject){
        JSONArray jsonArray = null;
        try {
            jsonArray = jsonObject.getJSONArray("results");
        }catch (JSONException e){
            e.printStackTrace();
        }
        return getPlaces(jsonArray);
    }

    private List<HashMap<String, String>> getPlaces(JSONArray jsonArray) {
        List<HashMap<String, String>> placesList = new ArrayList<HashMap<String, String>>();
        HashMap<String, String> place = null;

        for (int i = 0; i < jsonArray.length(); i++) {
            try {
                place = getPlace((JSONObject) jsonArray.get(i));
                placesList.add(place);

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return placesList;
    }

    private HashMap<String, String> getPlace(JSONObject jsonObject) {
        HashMap<String, String> place = new HashMap<String, String>();
        String placeName = "-NA-";
        String vicinity = "-NA-";
        String latitude = "";
        String longitude = "";

        try {
            // extract nama
            if (!jsonObject.isNull("name")) {
                placeName = jsonObject.getString("name");
            }

            // extract nama jalan
            if (!jsonObject.isNull("vicinity")) {
                vicinity = jsonObject.getString("vicinity");
            }

            latitude = jsonObject.getJSONObject("geometry").getJSONObject("location").getString("lat");
            longitude = jsonObject.getJSONObject("geometry").getJSONObject("location").getString("lng");

            place.put("place_name", placeName);
            place.put("vicinity", vicinity);
            place.put("lat", latitude);
            place.put("lng", longitude);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return place;
    }
}
