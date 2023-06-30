package com.example.demo.pojos;

import javax.persistence.*;

import lombok.Data;

@Entity
@Table(name = "page_ranges")
@Data
public class PageRange {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int startPage;
    private int endPage;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "split_request_id")
    private SplitRequest splitRequest;

    // Constructors, getters, and setters
}

