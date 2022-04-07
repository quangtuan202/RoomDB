package com.example.roomdb.utils;

import android.icu.text.SimpleDateFormat;

import androidx.room.TypeConverter;

import java.text.ParseException;
import java.util.Date;

public class TimestampConverter {
    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @TypeConverter
    public static Date dateFromTimeStamp(String value){
        if(value!=null){
            try{
                return simpleDateFormat.parse(value);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return null;
        }
        return null;
    }

    @TypeConverter
    public static String dateToTimeStamp(Date value){
        if(value!=null) {
            String dateString = simpleDateFormat.format(value);
            return dateString;
        }
        return null;
    }


}
