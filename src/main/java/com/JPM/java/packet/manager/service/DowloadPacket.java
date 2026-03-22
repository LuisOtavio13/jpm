package com.JPM.java.packet.manager.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.JPM.java.packet.manager.errors.FIles.FileError;

@Service
public class DowloadPacket implements DowloadPacketinterface {

    @Override
    public MultipartFile getFile(String name) {
        // TODO: add impl get file
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public MultipartFile salveFile(MultipartFile file) {
        if (file.isEmpty()) {
            throw new FileError("File is empty");

        }

        String extensao = file.getContentType();
        if (!extensao.equals("jar")) {
            throw new FileError("File is not valid");
        }
        try {

            Path path = Paths.get("/up");
            if (!Files.exists(path)) {
                Files.createDirectory(path);
            }
            String filename = file.getName();
            Path pathFile = path.resolve(filename);
            file.transferTo(pathFile.toFile());
            return file;

        } catch (IOException e) {
            throw new FileError("Erro ao salvar arquivo: " + e.getMessage());
        }

    }

}
