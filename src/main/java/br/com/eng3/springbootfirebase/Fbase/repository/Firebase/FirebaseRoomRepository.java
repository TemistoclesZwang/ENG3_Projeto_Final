package br.com.eng3.springbootfirebase.Fbase.repository.Firebase;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.Query;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.firebase.cloud.FirestoreClient;

import org.springframework.stereotype.Repository;

import br.com.eng3.springbootfirebase.Fbase.model.Booking;

@Repository
public abstract class FirebaseRoomRepository {
    
    private static Firestore dbFirestore = FirestoreClient.getFirestore();
    
    public static List<Booking> getBookings(String DocumentId) throws InterruptedException, ExecutionException {
        String COLLECTION_NAME = "booking";
        List<Booking> bookings = new ArrayList<>();
        Query query = dbFirestore.collection(COLLECTION_NAME).whereEqualTo("roomId", DocumentId);
        ApiFuture<QuerySnapshot> fqSnapshot = query.get();
        QuerySnapshot qSnapshot = fqSnapshot.get();
        List<QueryDocumentSnapshot> documents = qSnapshot.getDocuments();
        
        for (QueryDocumentSnapshot document : documents) {
            bookings.add(document.toObject(Booking.class));
        }
        return bookings;
    }

    public static Long getRoomQuantity(String DocumentId) throws InterruptedException, ExecutionException {
        String COLLECTION_NAME = "rooms";
        DocumentReference documentReference = dbFirestore.collection(COLLECTION_NAME).document(DocumentId);
        ApiFuture<DocumentSnapshot> future = documentReference.get();
        DocumentSnapshot document = future.get();
        
        Long quantity = (Long) document.get("quantity");
        return quantity;
    }
}
