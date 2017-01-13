package querydsl.infrastructure.filter;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import static com.google.common.base.Preconditions.checkNotNull;

@Service
public class FilterService {

    @PersistenceContext
    private EntityManager entityManager;

    public <R> R find(Filter<R> filter) {
        checkNotNull(filter, "O filtro deve ser informado para realizar a consulta");
        JPAQueryFactory queryFactory = new JPAQueryFactory(entityManager);
        return filter.apply(queryFactory);
    }

}
