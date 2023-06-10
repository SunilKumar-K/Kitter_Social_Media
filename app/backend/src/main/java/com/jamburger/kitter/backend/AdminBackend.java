package com.jamburger.kitter.backend;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class AdminBackend {
    public static void main(String[] args) {
        try {
            FileInputStream serviceAccount = new FileInputStream("C:\\Users\\jay40\\Documents\\Android_Projects\\Private Keys\\kitter-40793.json");

            FirebaseOptions options = FirebaseOptions.builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .setDatabaseUrl("https://kitter-40793-default-rtdb.firebaseio.com")
                    .build();
            FirebaseApp.initializeApp(options);
            System.out.println("App initialized Successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FirestoreManager.manageUsers();
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}