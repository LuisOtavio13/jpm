package com.JPM.java.packet.manager.service;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface DowloadPacketinterface {
    Resource getFile(String name);
    MultipartFile salveFile(MultipartFile file);
}
