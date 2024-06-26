package com.hgyellow.querydsl.enumsort.domain.entity;

import com.hgyellow.querydsl.common.util.converter.AbstractEnumNameConverter;
import com.hgyellow.querydsl.common.util.converter.EnumName;
import com.querydsl.core.types.Expression;
import com.querydsl.core.types.Ops;
import com.querydsl.core.types.dsl.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Category implements EnumName<String> {
    CT1(0, "Category1"),
    CT2(1, "Category2"),
    CT3(2, "Category3"),
    CT4(3, "Category4"),
    CT5(4, "Category5"),
    CT6(5, "Category6"),
    CT7(6, "Category7"),
    CT8(7, "Category8"),
    CT9(8, "Category9"),
    CT10(9, "Category10"),;

    private final int order;
    private final String originName;

    public static NumberExpression<Integer> getQueryDSLExpressionV2(QInfo qInfo) {
        return new CaseBuilder()
                .when(qInfo.type.eq(CT1)).then(CT1.order)
                .when(qInfo.type.eq(CT2)).then(CT2.order)
                .when(qInfo.type.eq(CT3)).then(CT3.order)
                .when(qInfo.type.eq(CT4)).then(CT4.order)
                .when(qInfo.type.eq(CT5)).then(CT5.order)
                .when(qInfo.type.eq(CT6)).then(CT6.order)
                .when(qInfo.type.eq(CT7)).then(CT7.order)
                .when(qInfo.type.eq(CT8)).then(CT8.order)
                .when(qInfo.type.eq(CT9)).then(CT9.order)
                .when(qInfo.type.eq(CT10)).then(CT10.order)
                .otherwise(Category.values().length);
    }

    public static NumberExpression<Integer> getQueryDSLExpressionV3(QInfo qInfo) {
        CaseBuilder.Cases<Integer, NumberExpression<Integer>> cases = new CaseBuilder.Cases<>(Integer.class) {
            @Override
            protected NumberExpression<Integer> createResult(Class<? extends Integer> type, Expression<Integer> last) {
                return Expressions.numberOperation(type, Ops.CASE, last);
            }
        };

        for (Category category : Category.values()) {
            cases = cases.when(qInfo.type.eq(category)).then(category.order);
        }

        return cases.otherwise(Category.values().length);
    }


    public static Category getRandom() {
        int v = (int) (Math.random() * 10);

        for (Category category: Category.values()) {
            if (category.order == v) {
                return category;
            }
        }

        return CT10;
    }

    @Override
    public String getName() {
        return this.name();
    }

    @jakarta.persistence.Converter(autoApply = true)
    static class Converter extends AbstractEnumNameConverter<Category, String> {
        public Converter() {
            super(Category.class);
        }
    }
}
