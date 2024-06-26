package com.hgyellow.querydsl.enumsort.domain.repository;

import com.hgyellow.querydsl.enumsort.domain.entity.Category;
import com.hgyellow.querydsl.enumsort.domain.entity.Info;
import com.hgyellow.querydsl.enumsort.domain.entity.QInfo;
import com.querydsl.core.types.Order;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.dsl.CaseBuilder;
import com.querydsl.core.types.dsl.NumberExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class InfoQueryDSLRepository extends QuerydslRepositorySupport {
    private final JPAQueryFactory jpaQueryFactory;
    private final QInfo qInfo = QInfo.info;

    public InfoQueryDSLRepository(JPAQueryFactory jpaQueryFactory) {
        super(Info.class);
        this.jpaQueryFactory = jpaQueryFactory;
    }

    public List<Info> findAllOrderByCategoryV1() {
        NumberExpression<Integer> order = new CaseBuilder()
                .when(qInfo.type.eq(Category.CT1)).then(0)
                .when(qInfo.type.eq(Category.CT2)).then(1)
                .when(qInfo.type.eq(Category.CT3)).then(2)
                .when(qInfo.type.eq(Category.CT4)).then(3)
                .when(qInfo.type.eq(Category.CT5)).then(4)
                .when(qInfo.type.eq(Category.CT6)).then(5)
                .when(qInfo.type.eq(Category.CT7)).then(6)
                .when(qInfo.type.eq(Category.CT8)).then(7)
                .when(qInfo.type.eq(Category.CT9)).then(8)
                .when(qInfo.type.eq(Category.CT10)).then(9)
                .otherwise(10);


        return jpaQueryFactory
                .selectFrom(qInfo)
                .orderBy(new OrderSpecifier<>(
                        Order.ASC,
                        order))
                .fetch();
    }

    public List<Info> findAllOrderByCategoryV2() {
        return jpaQueryFactory
                .selectFrom(qInfo)
                .orderBy(new OrderSpecifier<>(
                        Order.ASC,
                        Category.getQueryDSLExpressionV2(qInfo)))
                .fetch();
    }

    public List<Info> findAllOrderByCategoryV3() {
        return jpaQueryFactory
                .selectFrom(qInfo)
                .orderBy(new OrderSpecifier<>(
                        Order.ASC,
                        Category.getQueryDSLExpressionV3(qInfo)))
                .fetch();
    }
}
