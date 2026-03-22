package com.JPM.java.packet.manager.controller;

import com.JPM.java.packet.manager.service.DowloadPacketinterface;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/dowload")
public class Dowload {

    final DowloadPacketinterface dowloadPacketinterface;

    public Dowload(DowloadPacketinterface dowloadPacketinterface) {
        this.dowloadPacketinterface = dowloadPacketinterface;
    }

    @PostMapping("/")
    public ResponseEntity<MultipartFile> postMethodName(
        @RequestParam("file") MultipartFile file
    ) {
        MultipartFile responseEntity = dowloadPacketinterface.salveFile(file);
        return ResponseEntity.ok(responseEntity);
    }

    @GetMapping("/")
    public ResponseEntity<Resource> getMethodName(@RequestBody String name) {
        Resource responseEntity = dowloadPacketinterface.getFile(name);
        return ResponseEntity.ok(responseEntity);
    }
}
