package querydsl.infrastructure.filter.param;


import com.google.common.base.Objects;
import com.querydsl.jpa.impl.JPAQuery;

public class FilterPageableParam {

    private static final int DELAY = 1;

    private static final Integer DEFAULT_LIMIT = 10;

    private Integer limit;

    private Integer offset;

    private FilterPageableParam() {

    }

    public static FilterPageableParam of() {
        return new FilterPageableParam();
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }


    public void append(JPAQuery queryFactory) {
        appendLimit(queryFactory);
        appendOffset(queryFactory);
    }

    private void appendLimit(JPAQuery queryFactory) {
        if (limit != null) {
            queryFactory.limit(limit);
        }
    }

    private void appendOffset(JPAQuery queryFactory) {
        if (offset != null) {
            Integer theLimit = Objects.firstNonNull(this.limit, DEFAULT_LIMIT);
            Integer theOffset = (this.offset - DELAY) * theLimit;
            queryFactory.offset(theOffset);
        }
    }

}
