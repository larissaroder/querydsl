package querydsl.services.abstractservice;

import org.springframework.beans.factory.annotation.Autowired;
import querydsl.infrastructure.filter.Filter;
import querydsl.infrastructure.filter.FilterService;

public abstract class AbstractService {

    protected final FilterService filterService;

    @Autowired
    public AbstractService(FilterService filterService) {
        this.filterService = filterService;
    }

    public <R> R find(Filter<R> filter) {
        return filterService.find(filter);
    }
}