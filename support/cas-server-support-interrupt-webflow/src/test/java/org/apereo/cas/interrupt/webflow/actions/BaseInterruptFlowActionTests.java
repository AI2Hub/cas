package org.apereo.cas.interrupt.webflow.actions;

import org.apereo.cas.config.CasAuthenticationEventExecutionPlanTestConfiguration;
import org.apereo.cas.config.CasCoreAuthenticationAutoConfiguration;
import org.apereo.cas.config.CasCoreAutoConfiguration;
import org.apereo.cas.config.CasCoreCookieAutoConfiguration;
import org.apereo.cas.config.CasCoreLogoutAutoConfiguration;
import org.apereo.cas.config.CasCoreMultifactorAuthenticationAutoConfiguration;
import org.apereo.cas.config.CasCoreMultifactorAuthenticationWebflowAutoConfiguration;
import org.apereo.cas.config.CasCoreNotificationsAutoConfiguration;
import org.apereo.cas.config.CasCoreScriptingAutoConfiguration;
import org.apereo.cas.config.CasCoreServicesAutoConfiguration;
import org.apereo.cas.config.CasCoreTicketsAutoConfiguration;
import org.apereo.cas.config.CasCoreUtilAutoConfiguration;
import org.apereo.cas.config.CasCoreWebAutoConfiguration;
import org.apereo.cas.config.CasCoreWebflowAutoConfiguration;
import org.apereo.cas.config.CasInterruptAutoConfiguration;
import org.apereo.cas.config.CasInterruptWebflowAutoConfiguration;
import org.apereo.cas.config.CasPersonDirectoryAutoConfiguration;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.actuate.autoconfigure.endpoint.EndpointAutoConfiguration;
import org.springframework.boot.actuate.autoconfigure.endpoint.web.WebEndpointAutoConfiguration;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.cloud.autoconfigure.RefreshAutoConfiguration;
import org.springframework.context.annotation.Import;

/**
 * This is {@link BaseInterruptFlowActionTests}.
 *
 * @author Misagh Moayyed
 * @since 7.0.0
 */
public abstract class BaseInterruptFlowActionTests {
    @ImportAutoConfiguration({
        RefreshAutoConfiguration.class,
        WebMvcAutoConfiguration.class,
        EndpointAutoConfiguration.class,
        WebEndpointAutoConfiguration.class,
        CasCoreWebAutoConfiguration.class,
        CasCoreNotificationsAutoConfiguration.class,
        CasCoreServicesAutoConfiguration.class,
        CasCoreAuthenticationAutoConfiguration.class,
        CasCoreMultifactorAuthenticationAutoConfiguration.class,
        CasCoreMultifactorAuthenticationWebflowAutoConfiguration.class,
        CasCoreCookieAutoConfiguration.class,
        CasCoreLogoutAutoConfiguration.class,
        CasCoreTicketsAutoConfiguration.class,
        CasCoreWebflowAutoConfiguration.class,
        CasPersonDirectoryAutoConfiguration.class,
        CasCoreAutoConfiguration.class,
        CasCoreUtilAutoConfiguration.class,
        CasCoreScriptingAutoConfiguration.class,
        CasInterruptAutoConfiguration.class,
        CasInterruptWebflowAutoConfiguration.class
    })
    @SpringBootConfiguration(proxyBeanMethods = false)
    @Import(CasAuthenticationEventExecutionPlanTestConfiguration.class)
    public static class SharedTestConfiguration {
    }
}
