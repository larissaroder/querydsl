package querydsl.infrastructure.filter.param;


import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.ComparableExpression;
import com.querydsl.core.types.dsl.StringPath;

/**
 * Class to append params on query checking if the value is null
 *
 * @param <T>
 */
public class FilterParam<T extends Comparable> {

    private T value;

    private FilterParam() {

    }

    /**
     * Factory method to build new FilterParam
     *
     * @param <T>
     * @return
     */
    public static <T extends Comparable> FilterParam<T> of() {
        return new FilterParam<>();
    }

    public void setValue(T value) {
        this.value = value;
    }

    public void and(BooleanBuilder builder, ComparableExpression<T> qPath) {
        if (value != null) {
            builder.and(qPath.eq(value));
        }
    }

    public void andContainsIgnoreCase(BooleanBuilder builder, StringPath qPath) {
        if (value != null) {
            builder.and(qPath.containsIgnoreCase(value.toString()));
        }
    }

}
