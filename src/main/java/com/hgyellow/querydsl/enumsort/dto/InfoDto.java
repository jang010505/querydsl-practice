package com.hgyellow.querydsl.enumsort.dto;

import lombok.Builder;
import lombok.Data;

public class InfoDto {

    @Data
    @Builder
    public static class InfoResponseDto {
        private String typeName;
        private String content;
    }
}
