package com.jevon.studentrollrecorder.pojo;

import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.Locale;

/**
 * Created by mdls8 on 4/18/2016.
 */
public class SortByDate implements Comparator<Session> {
    public int compare(Session s1, Session s2){
        long s1Time = convertDate(s1);
        long s2Time = convertDate(s2);

        if (s1Time > s2Time) {
            return 1;
        }
        else if(s1Time < s2Time){
            return -1;
        }

        return 0;
    }

    private long convertDate(Session session){
        SimpleDateFormat dateFormat = new SimpleDateFormat("EE dd-MM-yy H", Locale.ENGLISH);
        Date sessionDate = new Date();

        try{
            sessionDate = dateFormat.parse(session.getDate());
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

        return sessionDate.getTime();
    }
}
