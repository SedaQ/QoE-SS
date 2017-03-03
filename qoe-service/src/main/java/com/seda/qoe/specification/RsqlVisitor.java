package com.seda.qoe.specification;

import cz.jirutka.rsql.parser.ast.AndNode;
import cz.jirutka.rsql.parser.ast.ComparisonNode;
import cz.jirutka.rsql.parser.ast.OrNode;
import cz.jirutka.rsql.parser.ast.RSQLVisitor;
import org.springframework.data.jpa.domain.Specification;

/**
 * Created by Pavel Šeda
 *
 */
public class RsqlVisitor<T> implements RSQLVisitor<Specification<T>, Void> {

    private RsqlSpecificationBuilder<T> builder;

    public RsqlVisitor() {
        builder = new RsqlSpecificationBuilder<T>();
    }

    @Override
    public Specification<T> visit(final AndNode node, final Void param) {
        return builder.createSpecification(node);
    }

    @Override
    public Specification<T> visit(final OrNode node, final Void param) {
        return builder.createSpecification(node);
    }

    @Override
    public Specification<T> visit(final ComparisonNode node, final Void params) {
        return builder.createSpecification(node);
    }

}