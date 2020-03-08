package ca.bcit.cmdf2020;

import java.util.ArrayList;

public class User {
    String userHashId; // generated at user creation
    String nickname = "Anon";
    // automatically set up as anonymous, can be changed by the user

    ArrayList<String> listOfCommunities = new ArrayList<>();

    public String getUserHashId() {
        return userHashId;
    }

    public void setUserHashId(String userHashId) {
        this.userHashId = userHashId;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public ArrayList<String> getListOfCommunities() {
        return listOfCommunities;
    }

    public void setListOfCommunities(ArrayList<String> listOfCommunities) {
        this.listOfCommunities = listOfCommunities;
    }
}
