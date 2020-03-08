package ca.bcit.cmdf2020;

import java.util.ArrayList;

public class User {
    String userHashId; // generated at user creation
    String nickname = "Anon";
    // automatically set up as anonymous, can be changed by the user

    ArrayList<String> listOfCommunities = new ArrayList<>();
}
