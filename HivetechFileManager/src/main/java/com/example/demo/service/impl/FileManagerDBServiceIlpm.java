package com.example.demo.service.impl;

import com.example.demo.entity.FileEntity;
import com.example.demo.exception.FileStoreException;
import com.example.demo.repo.FileDBRepo;
import com.example.demo.service.FileManagerDBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FileManagerDBServiceIlpm implements FileManagerDBService {
    @Autowired
    FileDBRepo fileDBRepo;

    @Override
    public FileEntity store(MultipartFile file) {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        try {
            FileEntity FileDB = FileEntity.builder()
                    .name(fileName)
                    .type(file.getContentType())
                    .content(file.getBytes())
                    .build();
            return fileDBRepo.save(FileDB);
        } catch (IOException e) {
            throw new FileStoreException("Cant save file with cause "+e.getMessage(), e);
        }
    }

    @Override
    public List<FileEntity> store(MultipartFile[] files) {
        return Arrays.asList(files).stream().map(this::store).collect(Collectors.toList());
    }

    @Override
    public void delete(String filename) {
        fileDBRepo.deleteByNameEquals(filename);
    }

    @Override
    public Resource loadAsResource(String filename) {
        return new ByteArrayResource(fileDBRepo.findByNameEquals(filename).getContent());
    }
}
