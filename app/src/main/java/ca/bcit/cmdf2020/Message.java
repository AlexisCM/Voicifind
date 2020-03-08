package ca.bcit.cmdf2020;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Message {
    String community;
    ArrayList<Message> listOfMessage;
    // these are for threads
    String messageString;
    String time;
    String uuid;

    public String getCommunity() {
        return community;
    }

    public void setCommunity(String community) {
        this.community = community;
    }

    public ArrayList<Message> getListOfMessage() {
        return listOfMessage;
    }

    public void setListOfMessage(ArrayList<Message> listOfMessage) {
        this.listOfMessage = listOfMessage;
    }

    public String getMessageString() {
        return messageString;
    }

    public void setMessageString(String messageString) {
        this.messageString = messageString;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public String getTime(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
        time = LocalTime.now().toString();
        return time;
    }

}
