package ca.bcit.cmdf2020;

import android.os.Build;
import androidx.annotation.RequiresApi;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Message {
    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yy HH:mm:ss");
    private String messageHashID;
    private String community;
    private ArrayList<Message> listOfMessage;
    // these are for threads
    private String messageString;
    private String time;
    private String uuid;

    public Message() {}

    public Message(String msgHashID, String community, String msg) {
        this.messageHashID = msgHashID;
        this.community = community;
        this. messageString = msg;
        this.listOfMessage = new ArrayList<>();
        this.uuid = "some id thingy";
        this.time = LocalDateTime.now().format(dtf);
    }

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

    public String getMessageHashID() {
        return this.messageHashID;
    }

    public void setMessageHashID(String value) {
        this.messageHashID = value;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public String getTime(){
        return time;
    }
}
