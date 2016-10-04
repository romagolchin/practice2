package ru.ifmo.droid2016.worldcam.worldcamdemo.api;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Методы для работы с Webcams API
 */
public final class WebcamsApi {

    // Зарегистрируйтесь на https://market.mashape.com/webcams-travel
    // и вставьте сюда ваш API key
    //private static final String API_KEY = "BtbbvoTtdzmshgg1PCapZq02ZsDjp1gEJ9tjsnJJEmSpZxUnh5";

    // Name of HTTP header for API key
    private static final String KEY_HEADER_NAME = "X-Mashape-Key";

    private static final String BASE_URL = "https://webcamstravel.p.mashape.com";

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
        // TODO
        return (HttpURLConnection) new URL(BASE_URL).openConnection();
    }

    private WebcamsApi() {}
}
