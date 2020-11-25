package com.example.demo.controller;

import com.example.demo.service.FileManagerDBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController()
@RequestMapping(path = "/db-manager")
public class FileManagerDB {
    @Autowired
    FileManagerDBService fileManagerDBService;

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/files/{filename:.+}")
    public ResponseEntity<Resource> serveFile(@PathVariable String filename) {

        Resource file = fileManagerDBService.loadAsResource(filename);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }

    @PostMapping("/add-file")
    public ResponseEntity handleFileUpload(@RequestParam("file") MultipartFile[] file, @RequestParam("description") String desc) {
        return ResponseEntity.ok().body(fileManagerDBService.store(file));
    }
}
