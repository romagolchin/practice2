package ru.ifmo.droid2016.worldcam.worldcamdemo.loader;

import android.support.annotation.NonNull;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

import ru.ifmo.droid2016.worldcam.worldcamdemo.model.Webcam;
import ru.ifmo.droid2016.worldcam.worldcamdemo.utils.IOUtils;

/**
 * Методы для парсинга ответов от Webcams API при помощи JSONObject (DOM parser)
 */
public final class WebcamsDomParser {

    @NonNull
    public static List<Webcam> parseWebcams(InputStream in) throws
            IOException,
            JSONException,
            BadResponseException {
        List<Webcam> result = Collections.emptyList();
        String content = IOUtils.readToString(in, "UTF-8");
        JSONObject root = new JSONObject(content);
        JSONArray webcams = root.getJSONArray("webcams");
        for (int i = 0; i < webcams.length(); ++i) {
            JSONObject object = (JSONObject) webcams.get(i);
            String id = object.getJSONObject("id").toString();
            String title = object.getJSONObject("title").toString();
            String imageUrl = object.getJSONObject("image").getJSONObject("current").getJSONObject("preview").toString();
            result.add(new Webcam(id, title, imageUrl));
        }
        return result;
    }

    private WebcamsDomParser() {
    }
}
