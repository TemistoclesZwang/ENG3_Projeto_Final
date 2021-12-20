package br.com.eng3.springbootfirebase.Fbase.repository.Firebase;

import java.io.FileInputStream;

import javax.annotation.PostConstruct;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

import org.springframework.stereotype.Service;

@Service
public class FirebaseInitialization {

   private final static FirebaseOptions.Builder BUILDER = FirebaseOptions.builder();

   @PostConstruct
   public void initialization() {
      FileInputStream serviceAccount = null;

      try {
         // INSERIR A KEY DO FIREBASE;
         //serviceAccount =
         //new FileInputStream("");

      FirebaseOptions options = BUILDER
         .setCredentials(GoogleCredentials.fromStream(serviceAccount))
         .setDatabaseUrl("https://hospedagens-bd-default-rtdb.firebaseio.com")
         .build();
      FirebaseApp.initializeApp(options);
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
}
