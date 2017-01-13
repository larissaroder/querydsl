package querydsl.infrastructure.filter;

import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQueryFactory;

import java.util.function.Function;

public interface Filter<R> extends Function<JPAQueryFactory, R> {

    Predicate createWherePredicate();

}
