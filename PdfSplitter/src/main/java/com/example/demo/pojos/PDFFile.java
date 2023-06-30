package com.example.demo.pojos;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "pdf_files")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PDFFile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Lob
    private byte[] data;

    // Constructors, getters, and setters(No Required Due to lombok annotations
}
