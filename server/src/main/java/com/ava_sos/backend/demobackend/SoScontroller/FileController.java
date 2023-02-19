package com.ava_sos.backend.demobackend.SoScontroller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.Base64.Decoder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.ava_sos.backend.demobackend.SoSdomain.Sos;
import com.ava_sos.backend.demobackend.SoSservice.ParserService;
import com.ava_sos.backend.demobackend.SoSservice.SosService;

@RestController
@RequestMapping("/file")
public class FileController {

    @Autowired
    private SosService sos_service;
    @Autowired
    public ParserService parser;

    @PostMapping("/upload_file")
    @CrossOrigin(origins = "http://localhost:4200")
    @ResponseBody
    public void uploadFile(@RequestPart("file") MultipartFile file, @RequestPart("sos_id") String id,
            @RequestPart("type") String t) throws IOException {
        byte[] bytes = file.getBytes();
        Path path;
        Sos sos = sos_service.findId(Long.parseLong(id));
        if (t.equals("1")) {
            new File("../uploads/mission_models/" + sos.getName()).mkdirs();
            path = Paths.get("../uploads/mission_models/" + sos.getName(), file.getOriginalFilename());
            Files.write(path, bytes);
            parser.parseMissionModel(sos);

        } else {
            new File("../uploads/constituents_models/" + sos.getName()).mkdirs();
            path = Paths.get("../uploads/constituents_models/" + sos.getName(), file.getOriginalFilename());
            Files.write(path, bytes);
            parser.parseConstituentModel(path.toString(), sos);
        }

    }

    @GetMapping("/mission_model/{path}")
    @CrossOrigin(origins = "http://localhost:4200")
    public byte[] getMkaosModel(@PathVariable("path") String path) {
        Decoder decoder = Base64.getDecoder();
        byte[] bytes = decoder.decode(path);
        String decodedPath = new String(bytes);
        try {
            byte[] file = Files.readAllBytes(Paths.get(decodedPath));

            return file;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}