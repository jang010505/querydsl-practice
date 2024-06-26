package com.hgyellow.querydsl.enumsort.api;

import com.hgyellow.querydsl.enumsort.dto.InfoDto;
import com.hgyellow.querydsl.enumsort.service.InfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class InfoController {
    private final InfoService infoService;

    @GetMapping("/api/v1/info")
    public ResponseEntity<List<InfoDto.InfoResponseDto>> getAllOrderByCategoryV1() {
        HttpStatus status = HttpStatus.OK;
        List<InfoDto.InfoResponseDto> results = infoService.getAllOrderByCategoryV1();
        return new ResponseEntity<>(results, status);
    }

    @GetMapping("/api/v2/info")
    public ResponseEntity<List<InfoDto.InfoResponseDto>> getAllOrderByCategoryV2() {
        HttpStatus status = HttpStatus.OK;
        List<InfoDto.InfoResponseDto> results = infoService.getAllOrderByCategoryV2();
        return new ResponseEntity<>(results, status);
    }

    @GetMapping("/api/v3/info")
    public ResponseEntity<List<InfoDto.InfoResponseDto>> getAllOrderByCategoryV3() {
        HttpStatus status = HttpStatus.OK;
        List<InfoDto.InfoResponseDto> results = infoService.getAllOrderByCategoryV3();
        return new ResponseEntity<>(results, status);
    }

    @PostMapping("/api/info")
    public ResponseEntity<Void> insert() {
        HttpStatus status = HttpStatus.CREATED;
        infoService.insert();
        return new ResponseEntity<>(status);
    }
}