package com.test.books.entity;

import jakarta.persistence.*;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.ZonedDateTime;
import java.util.UUID;

@Data
@Entity
@Table(schema = "public", name = "authors")
public class Author {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @CreationTimestamp
    @Column(name = "create_date", nullable = false)
    private ZonedDateTime createDate;

    @UpdateTimestamp
    @Column(name = "update_date", nullable = false)
    private ZonedDateTime updateDate;
}
