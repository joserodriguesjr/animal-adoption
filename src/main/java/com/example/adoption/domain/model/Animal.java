package com.example.adoption.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

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
    @Column(name = "created_date", nullable = false, updatable = false)
    private Date createdDate;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @LastModifiedDate
    @Column(name = "last_modified_date")
    private Date lastModifiedDate;

    @Column(name = "name", length = 255, nullable = false)
    private String name;

    @Column(name = "description", length = 255, nullable = true)
    private String description;

    @Column(name = "image_url", length = 255, nullable = true)
    private String imageURL;

    @Column(name = "category", length = 255, nullable = false)
    private String category;

    @Column(name = "birth_date", length = 255, nullable = false)
    private Date birthDate;

    @Column(name = "status", length = 255, nullable = true)
    private Status status;
    public enum Status {DISPONIVEL, ADOTADO}
}
