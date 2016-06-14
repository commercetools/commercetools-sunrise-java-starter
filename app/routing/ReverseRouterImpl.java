package routing;

import com.commercetools.sunrise.common.controllers.ReverseRouter;
import com.commercetools.sunrise.common.reverserouter.CheckoutReverseRouter;
import com.commercetools.sunrise.common.reverserouter.HomeReverseRouter;
import com.commercetools.sunrise.common.reverserouter.ProductReverseRouter;
import io.sphere.sdk.models.Base;
import play.mvc.Call;

public class ReverseRouterImpl extends Base implements ReverseRouter, HomeReverseRouter, ProductReverseRouter, CheckoutReverseRouter {
    @Override
    public Call themeAssets(final String file) {
        return controllers.routes.WebJarAssets.at(file);
    }

    @Override
    public Call processChangeLanguageForm() {
        return indexCall();
    }

    @Override
    public Call processChangeCountryForm(final String languageTag) {
        return indexCall();
    }

    @Override
    public Call homePageCall(final String languageTag) {
        return controllers.routes.HomeController.show(languageTag);
    }

    @Override
    public Call productOverviewPageCall(final String languageTag, final String categorySlug) {
        return controllers.routes.ProductOverviewPageController.searchProductsByCategorySlug(languageTag, categorySlug);
    }

    @Override
    public Call processSearchProductsForm(final String languageTag) {
        return controllers.routes.ProductOverviewPageController.searchProductsBySearchTerm(languageTag);
    }

    @Override
    public Call productDetailPageCall(final String languageTag, final String productSlug, final String sku) {
        return controllers.routes.ProductDetailPageController.showProductBySlugAndSku(languageTag, productSlug, sku);
    }

    @Override
    public Call showCart(final String languageTag) {
        return indexCall();
    }

    @Override
    public Call processAddProductToCartForm(final String languageTag) {
        return indexCall();
    }

    @Override
    public Call processDeleteLineItemForm(final String languageTag) {
        return indexCall();
    }

    @Override
    public Call processChangeLineItemQuantityForm(final String languageTag) {
        return indexCall();
    }

    @Override
    public Call checkoutAddressesPageCall(final String languageTag) {
        return indexCall();
    }

    @Override
    public Call checkoutAddressesProcessFormCall(final String languageTag) {
        return indexCall();
    }

    @Override
    public Call checkoutShippingPageCall(final String languageTag) {
        return indexCall();
    }

    @Override
    public Call checkoutShippingProcessFormCall(final String languageTag) {
        return indexCall();
    }

    @Override
    public Call checkoutPaymentPageCall(final String languageTag) {
        return indexCall();
    }

    @Override
    public Call checkoutPaymentProcessFormCall(final String languageTag) {
        return indexCall();
    }

    @Override
    public Call checkoutConfirmationPageCall(final String languageTag) {
        return indexCall();
    }

    @Override
    public Call checkoutConfirmationProcessFormCall(final String languageTag) {
        return indexCall();
    }

    @Override
    public Call checkoutThankYouPageCall(final String languageTag) {
        return indexCall();
    }

    @Override
    public Call showLogInForm(final String languageTag) {
        return indexCall();
    }

    @Override
    public Call processLogInForm(final String languageTag) {
        return indexCall();
    }

    @Override
    public Call processSignUpForm(final String languageTag) {
        return indexCall();
    }

    @Override
    public Call processLogOut(final String languageTag) {
        return indexCall();
    }

    @Override
    public Call showMyPersonalDetailsForm(final String languageTag) {
        return indexCall();
    }

    @Override
    public Call processMyPersonalDetailsForm(final String languageTag) {
        return indexCall();
    }

    @Override
    public Call showMyOrders(final String languageTag) {
        return indexCall();
    }

    @Override
    public Call showMyOrder(final String languageTag, final String orderNumber) {
        return indexCall();
    }

    private Call indexCall() {
        return controllers.routes.HomeController.index();
    }
}
