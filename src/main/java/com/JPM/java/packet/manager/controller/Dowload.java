package com.JPM.java.packet.manager.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.JPM.java.packet.manager.service.DowloadPacketinterface;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/dowload")
public class Dowload {
   final DowloadPacketinterface dowloadPacketinterface;

    public Dowload(DowloadPacketinterface dowloadPacketinterface){
        this.dowloadPacketinterface = dowloadPacketinterface;
    }

    //TODO: impl dowload file .jar
    @PostMapping("/")
    public String postMethodName(@RequestBody String entity) {
        
        
        return entity;
    }
    
}
