package com.potential.bic.fp.JSONHandler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.potential.bic.fp.Models.User;
import java.io.IOException;

public class jsonHandler {
    ObjectMapper mapper = new ObjectMapper();

    public void Serialize( User user)
    {
        String jsonString = "";
        try {
            jsonString = mapper.writeValueAsString(user);
            System.out.println("Serialized JSON: " + jsonString);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }   

    public void deSerialize( User user){
        String jsonString = "";
        try {
            User deserializedUser = mapper.readValue(jsonString, User.class);
            System.out.println("Deserialized user: " + deserializedUser);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
