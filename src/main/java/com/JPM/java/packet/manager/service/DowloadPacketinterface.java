package com.JPM.java.packet.manager.service;



import org.springframework.web.multipart.MultipartFile;


public interface  DowloadPacketinterface {
    MultipartFile getFile(String name);
    MultipartFile salveFile(MultipartFile file);
}
