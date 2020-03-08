package ca.bcit.cmdf2020;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Message {
    String community;
    ArrayList<String> listOfMessage;
    // these are for threads
    String messageString;
    String time;
    String uuid;

    @RequiresApi(api = Build.VERSION_CODES.O)
    public String getTime(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
        time = LocalTime.now().toString();
        return time;
    }

}
