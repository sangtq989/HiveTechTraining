package com.example.demo.service;

import org.springframework.web.multipart.MultipartFile;

public interface BaseFileManager {
    void store(MultipartFile file);

    void store(MultipartFile[] files);
}
