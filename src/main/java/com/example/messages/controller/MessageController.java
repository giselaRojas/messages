package com.example.messages.Controller;

import com.example.messages.services.MessageService;
import com.example.messages.modelo.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class MessageController {
    
    @Autowired
    private MessageService messageService;

    @GetMapping("/messages")
    //Implementación de GET: Obtener lista completa de mensajes
    public List<Message> getAllMessages() {
        return messageService.getAllMessages();
    }

    @GetMapping("/message/{id}")
    //Implementación de GET por ID: Obtener mensaje específico
    public ResponseEntity<Message> getMessageById(@PathVariable Long id) {
        Optional<Message> message = messageService.getMessageById(id);
        return message.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/message")
    //"Implementación de POST: Crear nuevo mensaje"
    public ResponseEntity<Message> addMessage(@RequestBody Message message) {
        Message newMessage = messageService.addMessage(message);
        return ResponseEntity.status(HttpStatus.CREATED).body(newMessage);
    }

    @PutMapping("/message/{id}")
    //"Implementación de PUT: Actualizar mensaje existente"
    public ResponseEntity<Message> updateMessage(@PathVariable Long id, @RequestBody Message updatedMessage) {
        Optional<Message> message = messageService.updateMessage(id, updatedMessage);
        return message.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/message/{id}")
    //"Implementación de DELETE: Eliminar mensaje por ID"
    public ResponseEntity<Void> deleteMessage(@PathVariable Long id) {
        return messageService.deleteMessage(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
