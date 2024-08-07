package org.apereo.cas.config;

import org.apereo.cas.configuration.CasConfigurationProperties;
import org.apereo.cas.configuration.features.CasFeatureModule;
import org.apereo.cas.ticket.artifact.SamlArtifactTicket;
import org.apereo.cas.ticket.artifact.SamlArtifactTicketImpl;
import org.apereo.cas.ticket.query.SamlAttributeQueryTicket;
import org.apereo.cas.ticket.query.SamlAttributeQueryTicketImpl;
import org.apereo.cas.ticket.serialization.TicketSerializationExecutionPlanConfigurer;
import org.apereo.cas.util.serialization.AbstractJacksonBackedStringSerializer;
import org.apereo.cas.util.spring.boot.ConditionalOnFeatureEnabled;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ScopedProxyMode;

import java.io.Serial;

/**
 * This is {@link SamlIdPTicketSerializationConfiguration}.
 *
 * @author Bob Sandiford
 * @since 5.2.0
 */
@EnableConfigurationProperties(CasConfigurationProperties.class)
@ConditionalOnFeatureEnabled(feature = CasFeatureModule.FeatureCatalog.SAMLIdentityProvider)
@Configuration(value = "SamlIdPTicketSerializationConfiguration", proxyBeanMethods = false)
class SamlIdPTicketSerializationConfiguration {

    @Bean
    @RefreshScope(proxyMode = ScopedProxyMode.DEFAULT)
    public TicketSerializationExecutionPlanConfigurer samlIdPTicketSerializationExecutionPlanConfigurer(
        final ConfigurableApplicationContext applicationContext) {
        return plan -> {
            plan.registerTicketSerializer(new SamlArtifactTicketStringSerializer(applicationContext));
            plan.registerTicketSerializer(new SamlAttributeQueryTicketStringSerializer(applicationContext));

            plan.registerTicketSerializer(SamlArtifactTicket.class.getName(), new SamlArtifactTicketStringSerializer(applicationContext));
            plan.registerTicketSerializer(SamlAttributeQueryTicket.class.getName(), new SamlAttributeQueryTicketStringSerializer(applicationContext));
        };
    }

    private static final class SamlArtifactTicketStringSerializer extends AbstractJacksonBackedStringSerializer<SamlArtifactTicketImpl> {
        @Serial
        private static final long serialVersionUID = -2198623586274810263L;

        SamlArtifactTicketStringSerializer(final ConfigurableApplicationContext applicationContext) {
            super(MINIMAL_PRETTY_PRINTER, applicationContext);
        }

        @Override
        public Class<SamlArtifactTicketImpl> getTypeToSerialize() {
            return SamlArtifactTicketImpl.class;
        }
    }

    private static final class SamlAttributeQueryTicketStringSerializer extends AbstractJacksonBackedStringSerializer<SamlAttributeQueryTicketImpl> {
        @Serial
        private static final long serialVersionUID = -2198623586274810263L;

        SamlAttributeQueryTicketStringSerializer(final ConfigurableApplicationContext applicationContext) {
            super(MINIMAL_PRETTY_PRINTER, applicationContext);
        }

        @Override
        public Class<SamlAttributeQueryTicketImpl> getTypeToSerialize() {
            return SamlAttributeQueryTicketImpl.class;
        }
    }
}
