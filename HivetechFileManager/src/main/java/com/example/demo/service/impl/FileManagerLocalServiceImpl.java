package com.example.demo.service.impl;

import com.example.demo.config.FileStoreConfig;
import com.example.demo.exception.FileStoreException;
import com.example.demo.service.FileManagerLocalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

@Service
public class FileManagerLocalServiceImpl implements FileManagerLocalService {

    private final Path rootLocation;
    @Value("${mimes.type}")
    private List<String> listMimes;

    @Autowired
    public FileManagerLocalServiceImpl(FileStoreConfig properties) {
        this.rootLocation = Paths.get(properties.getLocation());
    }

    @Override
    public List<String> store(MultipartFile[] files) {
        return Arrays.asList(files).stream().map(this::store).collect(Collectors.toList());
//        List<String> result = new ArrayList<>();
//        for (MultipartFile file : files) {
//           result.add(store(file));
//        }
//        return result;
    }

    @Override
    public void delete(String filename) {

    }

    @Override
    public String store(MultipartFile file) {
        try {

            Path destinationFile = this.rootLocation.resolve(
                    Paths.get(file.getOriginalFilename()))
                    .normalize().toAbsolutePath();
            if (!destinationFile.getParent().equals(this.rootLocation.toAbsolutePath())) {
                // This is a security check
                throw new FileStoreException(
                        "Cannot store file outside current directory.");
            }
            try (InputStream inputStream = file.getInputStream()) {
                if (file.isEmpty()) {
                    return file.getOriginalFilename() + " is empty, not saving";
                }
                if (listMimes.contains(file.getContentType())) {
                    Files.copy(inputStream, destinationFile,
                            StandardCopyOption.REPLACE_EXISTING);
                    return file.getOriginalFilename() + " saved";
                }
            }
        } catch (IOException e) {
            throw new FileStoreException("Failed to store file.", e);
        }
        return file.getOriginalFilename() + " not an image file, it a " + file.getContentType();
    }


    @Override
    public Stream<Path> loadAll() {
        try {
            return Files.walk(this.rootLocation, 1)
                    .filter(path -> !path.equals(this.rootLocation))
                    .map(Path::toAbsolutePath);
        } catch (IOException e) {
            throw new FileStoreException("Failed to read stored files", e);
        }

    }

    @Override
    public Path load(String filename) {
        return rootLocation.resolve(filename);
    }

    @Override
    public Resource loadAsResource(String filename) {
        try {
            Path file = load(filename);
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new FileStoreException(
                        "Could not read file: " + filename);

            }
        } catch (MalformedURLException e) {
            throw new FileStoreException("Could not read file: " + filename, e);
        }
    }

    @Override
    public void deleteAll() {
        FileSystemUtils.deleteRecursively(rootLocation.toFile());
    }

}
