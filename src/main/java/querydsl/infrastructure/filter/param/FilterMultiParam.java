package querydsl.infrastructure.filter.param;

import com.google.common.collect.Lists;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.ComparableExpression;
import com.querydsl.core.types.dsl.StringPath;

import java.util.List;

/**
 * Class to append multiple params on query checking if the value is null
 *
 * @param <T>
 */
public class FilterMultiParam<T extends Comparable> {

    private List<T> values = Lists.newLinkedList();

    private FilterMultiParam() {
    }

    /**
     * Factory method to build new FilterMultiParam
     *
     * @param <T>
     * @return
     */
    public static <T extends Comparable> FilterMultiParam<T> of() {
        return new FilterMultiParam<>();
    }

    public void setValue(T value) {
        this.values.add(value);
    }

    public void setAllvalues(List<T> value) {
        this.values.addAll(value);
    }

    /**
     * Append params values with AND operator on query if values is not null and is not empty
     *
     * @param builder
     * @param qPath
     */
    public void and(BooleanBuilder builder, ComparableExpression<T> qPath) {
        if (values != null && !values.isEmpty()) {
            this.values.forEach(value -> builder.and(qPath.eq(value)));
        }
    }

    /**
     * Append param value with AND operator on query if value is not null, not empty and ignoring case
     *
     * @param builder
     * @param qPath
     */
    public void andContainsIgnoreCase(BooleanBuilder builder, StringPath qPath) {
        if (values != null && !values.isEmpty()) {
            values.forEach(value -> builder.and(qPath.containsIgnoreCase(value.toString())));
        }
    }

}
