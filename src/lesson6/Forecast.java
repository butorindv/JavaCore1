package lesson6;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;

import java.io.IOException;

public class Forecast {
    private static final String BASE_HOST = "dataservice.accuweather.com";
    private static final String FORECASTS = "forecasts";
    private static final String API_VERSION = "v1";
    private static final String DAiLY = "daily";
    private static final String PERIOD = "5day";
    private static final String CITY_KEY = "295212";
    private static final String API_KEY = "8M3MG8LaMxvi4rSUVGhZzVPIfXUFxGm7";
    private static final String DETAILS = "true";


    public static void main(String[] args) throws IOException {

        OkHttpClient okHttpClient = new OkHttpClient();
        HttpUrl url = new HttpUrl.Builder()
                .scheme("https")
                .host(BASE_HOST)
                .addPathSegment(FORECASTS)
                .addPathSegment(API_VERSION)
                .addPathSegment(DAiLY)
                .addPathSegment(PERIOD)
                .addPathSegment(CITY_KEY)
                .addQueryParameter("apikey", API_KEY)
                .addQueryParameter("language", "ru")
                .addQueryParameter("details", DETAILS)
                .build();

        System.out.println(url.toString());

        Request requestHttp = new Request.Builder()
                .addHeader("accept", "application/json")//не понял для чего это добавлять. без него тоже работает
                .url(url)
                .build();

        String jsonResponse = okHttpClient.newCall(requestHttp).execute().body().string();
        System.out.println(jsonResponse);


    }

}
