/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.messages.modelo;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

/**
 *
 * @author gise.r 
 */
@Repository
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Message {
    private Long id;
    private String user;
    private String message;
    private LocalDateTime dateCreated;  
}
