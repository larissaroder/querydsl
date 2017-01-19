package querydsl.domains.filters;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import querydsl.domains.QPhone;
import querydsl.domains.QUser;
import querydsl.domains.User;
import querydsl.infrastructure.filter.Filter;
import querydsl.infrastructure.filter.param.FilterParam;

import java.util.List;

public class UserFilterPhoneNumber implements Filter<User>{

    private FilterParam<String> phone = FilterParam.of();

    public UserFilterPhoneNumber(String phone) {
       this.phone.setValue(phone);
    }

    @Override
    public Predicate createWherePredicate() {
        final BooleanBuilder builder = new BooleanBuilder();
        this.phone.and(builder, QPhone.phone.phoneNumber);
        return builder;
    }

    @Override
    public User apply(JPAQueryFactory jpaQueryFactory) {
        JPAQuery<User> user = jpaQueryFactory.select(QUser.user)
                .from(QUser.user)
                .innerJoin(QUser.user.phones, QPhone.phone)
                .where(createWherePredicate());
        return user.fetchOne();
    }
}
