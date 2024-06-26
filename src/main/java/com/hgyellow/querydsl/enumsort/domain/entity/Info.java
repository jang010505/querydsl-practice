package com.hgyellow.querydsl.enumsort.domain.entity;

import com.hgyellow.querydsl.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Getter
@ToString
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Info extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "type", length = 100)
    private Category type;

    @Column(name = "content", columnDefinition="longtext")
    private String content;
}