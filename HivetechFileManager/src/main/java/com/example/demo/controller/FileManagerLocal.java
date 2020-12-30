package com.example.demo.controller;

import com.example.demo.exception.FileStoreException;
import com.example.demo.service.FileManagerLocalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@RestController()
@RequestMapping(path = "/local-manager")
public class FileManagerLocal {
    @Autowired
    private FileManagerLocalService fileManagerLocalService;

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/list-file")
    public List<Object> listUploadedFiles() throws IOException {
        return Arrays.asList(fileManagerLocalService.loadAll().toArray());
    }

    @GetMapping(value = "/files/{filename:.+}")
    public ResponseEntity<Resource> serveFile(@PathVariable String filename) {
        Resource file = fileManagerLocalService.loadAsResource(filename);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_TYPE, "image/jpg").body(file);
    }

    @PostMapping("/add-file")
    public ResponseEntity handleFileUpload(@RequestParam("file") MultipartFile[] file, @RequestParam("description") String desc) {
        return ResponseEntity.ok().body(fileManagerLocalService.store(file));
    }

    @ExceptionHandler(FileStoreException.class)
    public ResponseEntity<?> handleStorageFileNotFound(FileStoreException exc) {
        return new ResponseEntity(exc.getMessage(), HttpStatus.I_AM_A_TEAPOT);
    }
}
