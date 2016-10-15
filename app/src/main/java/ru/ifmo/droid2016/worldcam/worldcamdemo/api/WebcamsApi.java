package ru.ifmo.droid2016.worldcam.worldcamdemo.api;

import android.net.Uri;
import android.util.Log;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Методы для работы с Webcams API
 */
public final class WebcamsApi {

    // Зарегистрируйтесь на https://market.mashape.com/webcams-travel
    // и вставьте сюда ваш API key
    private static final String API_KEY = "CDLVXyKex8mshQSSBStRuCzzagP7p1tGp1zjsnx7W8L0F2PExD";

    // Name of HTTP header for API key
    private static final String KEY_HEADER_NAME = "X-Mashape-Key";

    private static final String BASE_URL_STRING = "https://webcamstravel.p.mashape.com";

    /**
     * Создает {@link HttpURLConnection} для выполнения запроса Webcams API /nearby с указанными
     * параметрами.
     *
     * Описание запроса: http://developers.webcams.travel/#webcams/list/nearby
     *
     * Для авторизации в API к запросу должен быть добавлен заголовок (HTTP header) c ключом API:
     *
     * X-Mashape-Key: <ключ API>
     */
    public static HttpURLConnection createNearbyRequest(double latitude,
                                                        double longitude,
                                                        double radius) throws IOException {
        final String strLat = String.valueOf(latitude);
        final String strLong = String.valueOf(longitude);
        final String strRad = String.valueOf(radius);
        final String path = "nearby=" + strLat + "," + strLong + "," + strRad;
        Uri.Builder builder = Uri.parse(BASE_URL_STRING).buildUpon().appendQueryParameter("show", "webcams:base,image,location");
        Uri uri = builder.build();
        final String LOG_TAG = "Uri built: ";
        Log.v(LOG_TAG, uri.toString());
        HttpURLConnection connection = (HttpURLConnection) new URL(uri.toString()).openConnection();
        connection.setRequestProperty(KEY_HEADER_NAME, API_KEY);
        return connection;
    }

    private WebcamsApi() {}
}
