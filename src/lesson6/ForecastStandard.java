package lesson6;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Path;
import java.util.Scanner;

public class ForecastStandard {
    private static final String PROTOCOL = "https://";
    private static final String BASE_HOST = "dataservice.accuweather.com/";
    private static final String FORECASTS = "forecasts/";
    private static final String API_VERSION = "v1/";
    private static final String DAiLY = "daily/";
    private static final String PERIOD = "5day/";
    private static final String CITY_KEY = "295212" + "?";
    private static final String API_KEY = "apikey=8M3MG8LaMxvi4rSUVGhZzVPIfXUFxGm7";
    private static final String LANG = "&language=ru&";
    private static final String DETAILS = "details=false";


    //Вариант при помощи стандартной библиотеки.
    // Вообще можно было просто адрес URL ввести, но я пошел геморойным путем, задав поля)))
    public static void main(String[] args) throws IOException {
        URL url = new URL(PROTOCOL + BASE_HOST + FORECASTS + API_VERSION + DAiLY + PERIOD +
                CITY_KEY + API_KEY + LANG + DETAILS);
        System.out.println(url);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        Scanner scanner = new Scanner(httpURLConnection.getInputStream());
        System.out.println(scanner.nextLine());

//        InputStream inputStreamReader = httpURLConnection.getInputStream();
//        byte[] bytes = new byte[inputStreamReader.available()];
//        inputStreamReader.read(bytes);
//        System.out.print(new String(bytes));
//        System.out.println();
    }
}
