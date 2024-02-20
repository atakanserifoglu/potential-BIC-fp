package com.potential.bic.fp.JSONHandler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.potential.bic.fp.Models.User;
import java.io.IOException;

public class jsonHandler {
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();

        // Serialization
        User user = new User("John Doe", 30);
        String jsonString = "";
        try {
            jsonString = mapper.writeValueAsString(user);
            System.out.println("Serialized JSON: " + jsonString);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Deserialization
        try {
            User deserializedUser = mapper.readValue(jsonString, User.class);
            System.out.println("Deserialized user: " + deserializedUser);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
