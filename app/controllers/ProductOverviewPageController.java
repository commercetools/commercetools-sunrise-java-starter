package controllers;

import com.commercetools.sunrise.common.contexts.RequestScoped;
import com.commercetools.sunrise.productcatalog.productoverview.SunriseProductOverviewPageController;
import com.commercetools.sunrise.productcatalog.productoverview.search.facetedsearch.FacetedSearchComponent;
import com.commercetools.sunrise.productcatalog.productoverview.search.pagination.PaginationComponent;
import com.commercetools.sunrise.productcatalog.productoverview.search.searchbox.SearchBoxComponent;
import com.commercetools.sunrise.productcatalog.productoverview.search.sort.SortSelectorComponent;

import javax.inject.Inject;

@RequestScoped
public class ProductOverviewPageController extends SunriseProductOverviewPageController {

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