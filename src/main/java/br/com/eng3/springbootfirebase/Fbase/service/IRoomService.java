package br.com.eng3.springbootfirebase.Fbase.service;

import java.util.Map;

public interface IRoomService {
    Boolean roomAvaible(String DocumentId, Map<String, String> request);
}
