package br.com.eng3.springbootfirebase.Fbase.service;
import java.text.ParseException;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import br.com.eng3.springbootfirebase.Fbase.Utils.DateUtils;
import br.com.eng3.springbootfirebase.Fbase.model.Booking;
import br.com.eng3.springbootfirebase.Fbase.repository.Firebase.FirebaseRoomRepository;

@Service
@Validated
public class RoomService implements IRoomService {

    @Override
    public Boolean roomAvaible(String DocumentId, Map<String, String> request) {
        Date reqstartdate;
        Date reqenddate; 
        List<Booking> bookingsRoom;
        int qtdBookingsInRange = 0;
        
        Boolean response = false;

        try {
            reqstartdate = DateUtils.stringToDate(request.get("reqstartdate"));
            reqenddate = DateUtils.stringToDate(request.get("reqenddate"));
            bookingsRoom = FirebaseRoomRepository.getBookings(DocumentId);
            
            if(bookingsRoom.size() == 0) {
                response = true;
            } else {
                for (Booking booking : bookingsRoom) {
                    if(DateUtils.inDateRange(booking, reqstartdate, reqenddate)){
                        qtdBookingsInRange++;
                    } 
                }
                if (qtdBookingsInRange == FirebaseRoomRepository.getRoomQuantity(DocumentId)) {
                    response = false;
                } else {
                    response = true;
                }
            }
        } catch (ParseException | InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        return response;
    }
}
