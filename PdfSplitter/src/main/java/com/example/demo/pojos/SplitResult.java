package com.example.demo.pojos;

import javax.persistence.*;

import lombok.Data;

import java.util.List;

@Entity
@Table(name = "split_results")
@Data
public class SplitResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "pdf_file_id")
    private PDFFile pdfFileId;

    private String fileName;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "splitResult")
    private List<SplitPDFFile> splitPDFFiles;

    // Constructors, getters, and setters
}
