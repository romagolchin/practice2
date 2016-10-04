package ru.ifmo.droid2016.worldcam.worldcamdemo.loader;

import android.support.annotation.NonNull;

import org.json.JSONException;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

import ru.ifmo.droid2016.worldcam.worldcamdemo.model.Webcam;

/**
 * Методы для парсинга ответов от Webcams API при помощи JSONObject (DOM parser)
 */
public final class WebcamsDomParser {

    @NonNull
    public static List<Webcam> parseWebcams(InputStream in) throws
            IOException,
            JSONException,
            BadResponseException {
        // TODO
        return Collections.emptyList();
    }

    private WebcamsDomParser() {}
}
