package com.example.demo.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.example.demo.pojos.SplitRequest;
import com.example.demo.pojos.SplitResult;

public interface PDFSplitterService {
    void uploadPDF(MultipartFile file) throws IOException;

    SplitResult splitPDF(SplitRequest splitRequest) throws IOException;
}
