package com.hgyellow.querydsl.enumsort.service;

import com.hgyellow.querydsl.enumsort.domain.entity.Category;
import com.hgyellow.querydsl.enumsort.domain.entity.Info;
import com.hgyellow.querydsl.enumsort.domain.repository.InfoJpaRepository;
import com.hgyellow.querydsl.enumsort.domain.repository.InfoQueryDSLRepository;
import com.hgyellow.querydsl.enumsort.dto.InfoDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class InfoService {
    private final InfoJpaRepository infoJpaRepository;
    private final InfoQueryDSLRepository infoQueryDSLRepository;

    @Transactional
    public List<InfoDto.InfoResponseDto> getAllOrderByCategoryV1() {
        List<Info> infos = infoQueryDSLRepository.findAllOrderByCategoryV1();

        return infos.stream()
                .map(this::EntityToDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public List<InfoDto.InfoResponseDto> getAllOrderByCategoryV2() {
        List<Info> infos = infoQueryDSLRepository.findAllOrderByCategoryV2();

        return infos.stream()
                .map(this::EntityToDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public List<InfoDto.InfoResponseDto> getAllOrderByCategoryV3() {
        List<Info> infos = infoQueryDSLRepository.findAllOrderByCategoryV3();

        return infos.stream()
                .map(this::EntityToDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public void insert() {
        List<Info> infos = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            infos.add(Info.builder()
                            .content(String.valueOf(i))
                            .type(Category.getRandom())
                            .build());
        }

        infoJpaRepository.saveAll(infos);
    }

    private InfoDto.InfoResponseDto EntityToDto(Info info) {
        return InfoDto.InfoResponseDto.builder()
                .content(info.getContent())
                .typeName(info.getType().getOriginName())
                .build();
    }
}
