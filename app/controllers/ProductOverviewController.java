package controllers;

import com.commercetools.sunrise.common.contexts.RequestScoped;
import com.commercetools.sunrise.productcatalog.productoverview.SunriseProductOverviewController;
import com.commercetools.sunrise.productcatalog.productoverview.search.facetedsearch.FacetedSearchComponent;
import com.commercetools.sunrise.productcatalog.productoverview.search.pagination.PaginationComponent;
import com.commercetools.sunrise.productcatalog.productoverview.search.searchbox.SearchBoxComponent;
import com.commercetools.sunrise.productcatalog.productoverview.search.sort.SortSelectorComponent;

import javax.inject.Inject;

@RequestScoped
public class ProductOverviewController extends SunriseProductOverviewController {

    @Inject
    public void setComponents(final SortSelectorComponent sortSelectorComponent,
                              final PaginationComponent paginationComponent,
                              final SearchBoxComponent searchBoxComponent,
                              final FacetedSearchComponent facetedSearchComponent) {
        registerControllerComponent(sortSelectorComponent);
        registerControllerComponent(paginationComponent);
        registerControllerComponent(searchBoxComponent);
        registerControllerComponent(facetedSearchComponent);
    }
}