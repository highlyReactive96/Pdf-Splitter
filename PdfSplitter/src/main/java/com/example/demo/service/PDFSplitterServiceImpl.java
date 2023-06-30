package com.example.demo.service;

import org.apache.pdfbox.multipdf.Splitter;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.pojos.PDFFile;
import com.example.demo.pojos.PageRange;
import com.example.demo.pojos.SplitPDFFile;
import com.example.demo.pojos.SplitRequest;
import com.example.demo.pojos.SplitResult;
import com.example.demo.repositories.PDFFileRepository;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class PDFSplitterServiceImpl implements PDFSplitterService {
    private final PDFFileRepository pdfFileRepository;

    @Autowired
    public PDFSplitterServiceImpl(PDFFileRepository pdfFileRepository) {
        this.pdfFileRepository = pdfFileRepository;
    }

    @Override
    public void uploadPDF(MultipartFile file) throws IOException {
        PDFFile pdfFile = new PDFFile();
        pdfFile.setName(file.getOriginalFilename());
        pdfFile.setData(file.getBytes());
        pdfFileRepository.save(pdfFile);
    }

    @Override
    public SplitResult splitPDF(SplitRequest splitRequest) throws IOException {
        PDFFile pdfFile = splitRequest.getPdfFileId();
        PDDocument document = PDDocument.load(pdfFile.getData());
        Splitter splitter = new Splitter();
        List<PageRange> pageRanges = splitRequest.getPageRanges();
        List<SplitPDFFile> splitPDFFiles = new ArrayList<>();

        for (PageRange pageRange : pageRanges) {
            splitter.setStartPage(pageRange.getStartPage());
            splitter.setEndPage(pageRange.getEndPage());
            List<PDDocument> splitDocuments = splitter.split(document);

            for (int i = 0; i < splitDocuments.size(); i++) {
                PDDocument splitDocument = splitDocuments.get(i);
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                splitDocument.save(outputStream);
                byte[] splitData = outputStream.toByteArray();

                SplitPDFFile splitPDFFile = new SplitPDFFile();
                splitPDFFile.setPageNumber(pageRange.getStartPage() + i);
                splitPDFFile.setData(splitData);
                splitPDFFiles.add(splitPDFFile);

                splitDocument.close();
            }
        }

        SplitResult splitResult = new SplitResult();
        splitResult.setPdfFileId(pdfFile);
        splitResult.setFileName(pdfFile.getName());
        splitResult.setSplitPDFFiles(splitPDFFiles);

        return splitResult;
    }
}
