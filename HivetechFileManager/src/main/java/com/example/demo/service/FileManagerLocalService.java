package com.example.demo.service;

import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.stream.Stream;

@Service
public interface FileManagerLocalService extends BaseFileManager {
    Stream<Path> loadAll();

    Path load(String filename);

    void deleteAll();
}
