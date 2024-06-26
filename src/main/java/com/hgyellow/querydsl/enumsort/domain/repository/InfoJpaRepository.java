package com.hgyellow.querydsl.enumsort.domain.repository;

import com.hgyellow.querydsl.enumsort.domain.entity.Info;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InfoJpaRepository extends JpaRepository<Info, Long> {

}
