package routing;

import com.commercetools.sunrise.common.controllers.ReverseRouter;
import io.sphere.sdk.models.Base;
import play.mvc.Call;

public class ReverseRouterImpl extends Base implements ReverseRouter {
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
    public Call showCheckoutAddressesForm(final String languageTag) {
        return indexCall();
    }

    @Override
    public Call processCheckoutAddressesForm(final String languageTag) {
        return indexCall();
    }

    @Override
    public Call showCheckoutShippingForm(final String languageTag) {
        return indexCall();
    }

    @Override
    public Call processCheckoutShippingForm(final String languageTag) {
        return indexCall();
    }

    @Override
    public Call showCheckoutPaymentForm(final String languageTag) {
        return indexCall();
    }

    @Override
    public Call processCheckoutPaymentForm(final String languageTag) {
        return indexCall();
    }

    @Override
    public Call showCheckoutConfirmationForm(final String languageTag) {
        return indexCall();
    }

    @Override
    public Call processCheckoutConfirmationForm(final String languageTag) {
        return indexCall();
    }

    @Override
    public Call showCheckoutThankYou(final String languageTag) {
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
