package br.com.eng3.springbootfirebase.Fbase.controllers;

import java.text.ParseException;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import br.com.eng3.springbootfirebase.Fbase.service.RoomService;

@RestController
@RequestMapping(value = "/firebase/booking", method = RequestMethod.GET)
public class BookingController {
	@Autowired
	private RoomService roomService;

	@GetMapping("/{DocumentId}")
	public Boolean roomAvaible(@PathVariable String DocumentId, @RequestBody Map<String, String> request) throws InterruptedException, ExecutionException, ParseException {
		return roomService.roomAvaible(DocumentId, request);
	}
}
