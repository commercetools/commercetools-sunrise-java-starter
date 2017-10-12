package cms.contentful;

import com.commercetools.sunrise.cms.CmsService;
import com.commercetools.sunrise.cms.contentful.ContentfulCmsService;
import com.commercetools.sunrise.play.configuration.SunriseConfigurationException;
import play.Configuration;

import javax.inject.Inject;
import javax.inject.Provider;
import java.util.Optional;
import java.util.concurrent.ForkJoinPool;

public class ContentfulCmsServiceProvider implements Provider<CmsService> {

    private static final String CONFIG_PATH = "sunrise.cms.contentful";
    private static final String CONFIG_SPACE_ID = "spaceId";
    private static final String CONFIG_ACCESS_TOKEN = "accessToken";

    private final Configuration configuration;

    @Inject
    ContentfulCmsServiceProvider(final Configuration globalConfig) {
        this.configuration = globalConfig.getConfig(CONFIG_PATH);
    }

    @Override
    public CmsService get() {
        final String productContentTypeId = "page";
        final String pageSlugFieldId = "slug";
        final String spaceId = Optional.ofNullable(configuration.getString(CONFIG_SPACE_ID))
                .orElseThrow(() -> new SunriseConfigurationException("Missing contentful's space ID", CONFIG_SPACE_ID, CONFIG_PATH));
        final String accessToken = Optional.ofNullable(configuration.getString(CONFIG_ACCESS_TOKEN))
                .orElseThrow(() -> new SunriseConfigurationException("Missing contentful's access token", CONFIG_ACCESS_TOKEN, CONFIG_PATH));
        return ContentfulCmsService.of(spaceId, accessToken, productContentTypeId, pageSlugFieldId, ForkJoinPool.commonPool());
    }
}
