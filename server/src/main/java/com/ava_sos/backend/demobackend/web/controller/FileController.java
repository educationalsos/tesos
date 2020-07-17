package com.ava_sos.backend.demobackend.web.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
@RestController
@RequestMapping("/file")
public class FileController {
    
    @PostMapping("/upload_file")
    @CrossOrigin(origins = "http://localhost:4200")
    @ResponseBody
    public void uploadFile(@RequestPart("file") MultipartFile file, @RequestPart("name") String sos, @RequestPart("type") String t) throws IOException {
        byte[] bytes = file.getBytes();
        Path path;
        if (t.equals("1")) {
            new File("../uploads/mkaos_models/"+sos).mkdirs();
            path = Paths.get("../uploads/mkaos_models/"+sos, file.getOriginalFilename());
            
        } else {
            new File("../uploads/constituents_models/"+sos).mkdirs();
            path = Paths.get("../uploads/constituents_models/"+sos, file.getOriginalFilename());
        }
        Files.write(path, bytes);
 
    }

    @GetMapping("/mkaos_model/{path}")
    @CrossOrigin(origins = "http://localhost:4200")
    public byte[] getMkaosModel(@PathVariable("path") String path) {
        Decoder decoder = Base64.getDecoder();
        byte[] bytes = decoder.decode(path);
        String decodedPath = new String(bytes);
        try { 
            Encoder encoder = Base64.getEncoder();
            byte[] file = Files.readAllBytes(Paths.get(decodedPath));
            
            return file;
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    }
}