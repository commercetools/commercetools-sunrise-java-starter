package controllers;

import com.commercetools.sunrise.productcatalog.productdetail.SunriseProductDetailController;
import play.mvc.Result;

public class TestDeployController extends SunriseProductDetailController {

    public Result hello() {
        return ok("Hello Deploy!");
    }
}
