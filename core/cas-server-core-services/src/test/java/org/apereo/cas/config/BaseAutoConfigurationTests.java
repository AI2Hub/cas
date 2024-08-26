package org.apereo.cas.config;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.actuate.autoconfigure.endpoint.EndpointAutoConfiguration;
import org.springframework.boot.actuate.autoconfigure.endpoint.web.WebEndpointAutoConfiguration;
import org.springframework.boot.actuate.autoconfigure.observation.ObservationAutoConfiguration;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.aop.AopAutoConfiguration;
import org.springframework.boot.autoconfigure.mail.MailSenderAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.cloud.autoconfigure.RefreshAutoConfiguration;

/**
 * This is {@link BaseAutoConfigurationTests}.
 *
 * @author Misagh Moayyed
 * @since 7.1.0
 */
public abstract class BaseAutoConfigurationTests {
    @ImportAutoConfiguration({
        MailSenderAutoConfiguration.class,
        AopAutoConfiguration.class,
        RefreshAutoConfiguration.class,
        WebMvcAutoConfiguration.class,
        EndpointAutoConfiguration.class,
        WebEndpointAutoConfiguration.class,
        ObservationAutoConfiguration.class,
        CasCoreMonitorAutoConfiguration.class,
        CasCoreUtilAutoConfiguration.class,
        CasCoreScriptingAutoConfiguration.class,
        CasCoreAutoConfiguration.class,
        CasCoreLogoutAutoConfiguration.class,
        CasCoreAuthenticationAutoConfiguration.class,
        CasCoreWebAutoConfiguration.class,
        CasCoreServicesAutoConfiguration.class,
        CasCoreTicketsAutoConfiguration.class,
        CasCoreNotificationsAutoConfiguration.class
    })
    @SpringBootConfiguration(proxyBeanMethods = false)
    public static class SharedTestConfiguration {
    }
}
