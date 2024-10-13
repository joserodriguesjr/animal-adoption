package com.example.adoption.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.util.Date;

@EntityListeners(AuditingEntityListener.class)
@Entity
@Table(name = "animals")
@Data
public class Animal {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "animal_id")
    private Long id;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @CreatedDate
    @Column(name = "created_date")
    private Date createdDate;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @LastModifiedDate
    @Column(name = "last_modified_date")
    private Date lastModifiedDate;

    @Column(name = "name", length = 100, nullable = false)
    private String name;

    @Column(name = "description", length = 500)
    private String description;

    @Column(name = "image_url")
    private String imageURL;

    @Column(name = "category", length = 100, nullable = false)
    private String category;

    @Column(name = "birth_date", nullable = false)
    private LocalDate birthDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private Status status;
    public enum Status {DISPONIVEL, ADOTADO}
}
