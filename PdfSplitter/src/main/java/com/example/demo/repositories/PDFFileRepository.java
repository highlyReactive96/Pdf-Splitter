package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.pojos.PDFFile;

@Repository
public interface PDFFileRepository extends JpaRepository<PDFFile, Long> {
}
