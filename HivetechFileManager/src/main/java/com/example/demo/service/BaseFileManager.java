package com.example.demo.service;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface BaseFileManager <T> {
    T store(MultipartFile file);

    List<T> store(MultipartFile[] files);

    void delete(String item);

    Resource loadAsResource(String filename);
}
