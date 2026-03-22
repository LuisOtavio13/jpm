package com.JPM.java.packet.manager.service;

import com.JPM.java.packet.manager.errors.FIles.FileError;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class DowloadPacket implements DowloadPacketinterface {

    @Override
    public Resource getFile(String name) {
        File arquivo = new File("/up/" + name);

        if (!arquivo.exists() || !arquivo.isFile()) {
            throw new RuntimeException("file not found");
        }

        Resource resource = new FileSystemResource(arquivo);
        return resource;
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
