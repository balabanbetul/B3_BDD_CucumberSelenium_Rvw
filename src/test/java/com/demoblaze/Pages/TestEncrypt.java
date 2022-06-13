package com.demoblaze.Pages;


import com.demoblaze.Utilities.EncryptionUtils;

public class TestEncrypt {
    public static void main(String[] args) {
        String username = EncryptionUtils.encrypt("etsB3","Eurotech123");
        System.out.println("username = " + username);

        //B6VlEc1zJLZ1kGn+QcIImA==
        String password = EncryptionUtils.encrypt("Test123+", "Eurotech123");
        System.out.println("password = " + password);


    }
}
