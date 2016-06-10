package inject;

import com.commercetools.sunrise.common.controllers.ReverseRouter;
import com.commercetools.sunrise.shoppingcart.checkout.CheckoutCommonComponent;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import framework.MultiControllerComponentResolver;
import framework.MultiControllerComponentResolverBuilder;
import routing.ReverseRouterImpl;
import wedecidelatercommon.*;

import javax.inject.Singleton;

public class ComponentsModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(ReverseRouter.class).to(ReverseRouterImpl.class).in(Singleton.class);
        bind(ProductReverseRouter.class).to(ReverseRouterImpl.class).in(Singleton.class);
        bind(CheckoutReverseRouter.class).to(ReverseRouterImpl.class).in(Singleton.class);
        bind(HomeReverseRouter.class).to(ReverseRouterImpl.class).in(Singleton.class);
    }

    @Provides
    public MultiControllerComponentResolver foo() {
        //here are also instanceof checks possible
        return new MultiControllerComponentResolverBuilder()
                .add(CheckoutCommonComponent.class, controller -> controller.getFrameworkTags().contains("checkout"))
                .add(MiniCartControllerComponent.class, controller -> !controller.getFrameworkTags().contains("checkout"))
                .add(DefaultNavMenuControllerComponent.class, controller -> !controller.getFrameworkTags().contains("checkout"))
                .add(LocationSelectorControllerComponent.class, controller -> !controller.getFrameworkTags().contains("checkout"))
                .build();
    }
}
