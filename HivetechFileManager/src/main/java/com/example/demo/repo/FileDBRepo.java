package com.example.demo.repo;

import com.example.demo.entity.FileEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FileDBRepo extends JpaRepository<FileEntity, Long> {
    FileEntity findByNameEquals(String filename);
    void deleteByNameEquals(String fileName);
}
