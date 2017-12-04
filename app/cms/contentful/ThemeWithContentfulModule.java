package cms.contentful;

import com.commercetools.sunrise.cms.CmsService;
import com.commercetools.sunrise.framework.template.cms.FileBasedCmsServiceProvider;
import com.commercetools.sunrise.framework.template.engine.HandlebarsTemplateEngineProvider;
import com.commercetools.sunrise.framework.template.engine.TemplateEngine;
import com.commercetools.sunrise.framework.template.i18n.ConfigurableI18nResolverProvider;
import com.commercetools.sunrise.framework.template.i18n.I18nResolver;
import com.commercetools.sunrise.play.configuration.SunriseConfigurationException;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;

import javax.inject.Singleton;

public final class ThemeWithContentfulModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(TemplateEngine.class)
                .toProvider(HandlebarsTemplateEngineProvider.class)
                .in(Singleton.class);

        bind(I18nResolver.class)
                .toProvider(ConfigurableI18nResolverProvider.class)
                .in(Singleton.class);
    }

    /**
     * Provides the CMS Service for Contentful if the configuration is provided, otherwise provides a simple File-Based CMS.
     * If you do not plan on using Contentful, please remove the dependency from {@code build.sbt}, the file
     * {@link ContentfulCmsServiceProvider} and directly call the {@link FileBasedCmsServiceProvider} in the code below.
     * @return the CMS Service used, either Contentful if configured or a simple file based CMS
     */
    @Provides
    @Singleton
    public CmsService provideCmsService(final ContentfulCmsServiceProvider contentfulCmsServiceProvider,
                                        final FileBasedCmsServiceProvider fileBasedCmsServiceProvider) {
        try {
            return contentfulCmsServiceProvider.get();
        } catch (SunriseConfigurationException e) {
            return fileBasedCmsServiceProvider.get();
        }
    }
}
