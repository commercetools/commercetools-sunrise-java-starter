package controllers;

import com.commercetools.sunrise.common.contexts.ProjectContext;
import com.commercetools.sunrise.common.inject.RequestScoped;
import com.commercetools.sunrise.productcatalog.home.HomeProductSuggestionsControllerComponent;
import com.commercetools.sunrise.productcatalog.home.SunriseHomePageController;
import play.mvc.Result;

import javax.inject.Inject;

@RequestScoped
public class HomeController extends SunriseHomePageController {
    @Inject
    private ProjectContext projectContext;

    public Result index() {
        return TODO;
    }

}
