package querydsl.domains.filters;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import querydsl.domains.QUser;
import querydsl.infrastructure.filter.Filter;
import querydsl.infrastructure.filter.param.FilterParam;

import java.util.List;

public class UserFilterByName implements Filter<List<String>>{

    private FilterParam<String> name = FilterParam.of();

    public UserFilterByName (String name) {
       this.name.setValue(name);
    }

    @Override
    public Predicate createWherePredicate() {
        final BooleanBuilder builder = new BooleanBuilder();
        this.name.and(builder, QUser.user.name);
        return builder;
    }

    @Override
    public List<String> apply(JPAQueryFactory jpaQueryFactory) {
        JPAQuery<String> names = jpaQueryFactory.select(QUser.user.name).
                from(QUser.user).where(createWherePredicate());
        return names.fetch();
    }
}
