package com.example.messages.services;

import com.example.messages.modelo.Message;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    public List<Message> messages = new ArrayList<>();
    public Long nextId = 1L;

    public MessageService() {
        messages.add(new Message(nextId++, "Gisela", "Quiero trabajar remoto", LocalDateTime.now()));
        messages.add(new Message(nextId++, "Mariana", "Quiero recibirme ", LocalDateTime.now()));
    }
    
    public List<Message> getAllMessages() {
        return messages;
    }

    public Optional<Message> getMessageById(Long id) {
        return messages.stream().filter(msg -> msg.getId().equals(id)).findFirst();
    }

    public Message addMessage(Message msg) {
        msg.setId(nextId++);
        messages.add(msg);
        return msg;
    }

    public Optional<Message> updateMessage(Long id, Message updateMessage) {
        Optional<Message> oldMessage = getMessageById(id);
        if (oldMessage.isPresent()) {
            Message msg = oldMessage.get();
            msg.setUser(updateMessage.getUser());
            msg.setMessage(updateMessage.getMessage());
            return Optional.of(msg);
        }
        return Optional.empty();
    }

    public boolean deleteMessage(Long id) {
        return messages.removeIf(msg -> msg.getId().equals(id));
    }
}
