package routing;

import com.commercetools.sunrise.common.controllers.ReverseRouter;
import com.commercetools.sunrise.common.reverserouter.*;
import io.sphere.sdk.models.Base;
import play.mvc.Call;

import common.routes.*;
import myaccount.routes.*;
import productcatalog.routes.*;
import shoppingcart.routes.*;
import controllers.routes.*;
import productcatalog.routes;

public class ReverseRouterImpl extends Base implements ReverseRouter, HomeReverseRouter, ProductReverseRouter, CheckoutReverseRouter, CartReverseRouter, MyOrdersReverseRouter, MyPersonalDetailsReverseRouter, AddressBookReverseRouter {
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
        return routes.HomeController.show(languageTag);
    }

    @Override
    public Call productOverviewPageCall(final String languageTag, final String categorySlug) {
        return routes.ProductOverviewController.searchProductsByCategorySlug(languageTag, categorySlug);
    }

    @Override
    public Call processSearchProductsForm(final String languageTag) {
        return routes.ProductOverviewController.searchProductsBySearchTerm(languageTag);
    }

    @Override
    public Call productDetailPageCall(final String languageTag, final String productSlug, final String sku) {
        return routes.ProductDetailController.showProductBySlugAndSku(languageTag, productSlug, sku);
    }

    @Override
    public Call processLogInForm(final String languageTag) {
        return indexCall();
    }

    @Override
    public Call showLogInForm(final String languageTag) {
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
    public Call addAddressToAddressBookCall(final String languageTag) {
        return indexCall();
    }

    @Override
    public Call addressBookCall(final String languageTag) {
        return indexCall();
    }

    @Override
    public Call addAddressToAddressBookProcessFormCall(final String languageTag) {
        return indexCall();
    }

    @Override
    public Call changeAddressInAddressBookCall(final String languageTag, final String addressId) {
        return indexCall();
    }

    @Override
    public Call changeAddressInAddressBookProcessFormCall(final String languageTag, final String addressId) {
        return indexCall();
    }

    @Override
    public Call removeAddressFromAddressBookProcessFormCall(final String languageTag, final String addressId) {
        return indexCall();
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
    public Call myOrderListPageCall(final String languageTag) {
        return indexCall();
    }

    @Override
    public Call myOrderDetailPageCall(final String languageTag, final String orderNumber) {
        return indexCall();
    }

    @Override
    public Call myPersonalDetailsPageCall(final String languageTag) {
        return indexCall();
    }

    @Override
    public Call myPersonalDetailsProcessFormCall(final String languageTag) {
        return indexCall();
    }

    private Call indexCall() {
        return routes.HomeController.index();
    }
}
