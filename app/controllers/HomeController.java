package controllers;

import play.mvc.*;

public class HomeController extends Controller {

    public Result index() {
        return ok("Your new application is ready.");
    }

}
