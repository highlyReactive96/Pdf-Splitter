package com.example.demo.pojos;

import javax.persistence.*;

import lombok.Data;

@Entity
@Table(name = "split_pdf_files")
@Data
public class SplitPDFFile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int pageNumber;

    @Lob
    private byte[] data;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "split_result_id")
    private SplitResult splitResult;

    // Constructors, getters, and setters
}
