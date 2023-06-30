package com.example.demo.pojos;

import javax.persistence.*;

import lombok.Data;

import java.util.List;

@Entity
@Table(name = "split_requests")
@Data
public class SplitRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fileName;

    @ManyToOne
    @JoinColumn(name = "pdf_file_id")
    private PDFFile pdfFileId;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "splitRequest")
    private List<PageRange> pageRanges;

    // Constructors, getters, and setters
}
