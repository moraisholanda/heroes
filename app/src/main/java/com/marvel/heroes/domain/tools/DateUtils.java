package com.marvel.heroes.domain.tools;

import android.util.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Created by sergio on 21/06/16.
 */
public class DateUtils {

    public static String parseDate(String data) {
        String inputFormat = "yyyy-MM-dd'T'HH:mm:ssZ";

        String dataFormatada="";
        try {
            final String outputFormat = "MMM d, yyyy";

            dataFormatada = TimeStampConverter(inputFormat, data, outputFormat);

        } catch (ParseException e) {
            Log.d("Erro","erro parse data "+e.getMessage());
        }
        return dataFormatada;
    }

    private static String TimeStampConverter(final String inputFormat, String inputTimeStamp, final String outputFormat)throws ParseException {
        return new SimpleDateFormat(outputFormat).format(new SimpleDateFormat(inputFormat).parse(inputTimeStamp));
    }
}
