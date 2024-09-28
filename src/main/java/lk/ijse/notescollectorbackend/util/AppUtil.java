package lk.ijse.notescollectorbackend.util;

import java.util.Base64;
import java.util.UUID;

public class AppUtil {
    public static String generateNoteId(){
        return "NOTE-"+UUID.randomUUID();

    }

    public static String generateUserId(){
        return "USER-"+UUID.randomUUID();

    }

    public static String profilePicToBase64(String profilePic){
        //bye collection eka - profile pic eka base64 string ekk bawata herawima
        Base64.getEncoder().encodeToString(profilePic.getBytes());
        return profilePic;
    }
}
