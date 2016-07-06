import com.commercetools.sunrise.common.controllers.ReverseRouter;
import com.commercetools.sunrise.common.localization.LocationSelectorControllerComponent;
import com.commercetools.sunrise.common.pages.DefaultPageNavMenuControllerComponent;
import com.commercetools.sunrise.common.reverserouter.*;
import com.commercetools.sunrise.framework.MultiControllerComponentResolver;
import com.commercetools.sunrise.framework.MultiControllerComponentResolverBuilder;
import com.commercetools.sunrise.shoppingcart.MiniCartControllerComponent;
import com.commercetools.sunrise.shoppingcart.common.CheckoutCommonComponent;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import routing.ReverseRouterImpl;

import javax.inject.Singleton;

/**
 * This class is a Guice module that tells Guice how to bind several
 * different types. This Guice module is created when the Play
 * application starts.
 *
 * Play will automatically use any class called `Module` that is in
 * the root package. You can create modules in other locations by
 * adding `play.modules.enabled` settings to the `application.conf`
 * configuration file.
 */
public class Module extends AbstractModule {
    @Override
    protected void configure() {
        bind(ReverseRouter.class).to(ReverseRouterImpl.class).in(Singleton.class);
        bind(ProductReverseRouter.class).to(ReverseRouterImpl.class).in(Singleton.class);
        bind(CheckoutReverseRouter.class).to(ReverseRouterImpl.class).in(Singleton.class);
        bind(HomeReverseRouter.class).to(ReverseRouterImpl.class).in(Singleton.class);
        bind(AddressBookReverseRouter.class).to(ReverseRouterImpl.class).in(Singleton.class);
        bind(CartReverseRouter.class).to(ReverseRouterImpl.class).in(Singleton.class);
        bind(MyOrdersReverseRouter.class).to(ReverseRouterImpl.class).in(Singleton.class);
        bind(MyPersonalDetailsReverseRouter.class).to(ReverseRouterImpl.class).in(Singleton.class);
    }

    @Provides
    public MultiControllerComponentResolver foo() {
        //here are also instanceof checks possible
        return new MultiControllerComponentResolverBuilder()
                .add(CheckoutCommonComponent.class, controller -> controller.getFrameworkTags().contains("checkout"))
                .add(MiniCartControllerComponent.class, controller -> !controller.getFrameworkTags().contains("checkout"))
                .add(DefaultPageNavMenuControllerComponent.class, controller -> !controller.getFrameworkTags().contains("checkout"))
                .add(LocationSelectorControllerComponent.class, controller -> !controller.getFrameworkTags().contains("checkout"))
                .build();
    }
}
