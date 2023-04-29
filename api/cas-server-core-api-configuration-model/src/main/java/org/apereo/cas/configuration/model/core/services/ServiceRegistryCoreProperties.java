package org.apereo.cas.configuration.model.core.services;

import org.apereo.cas.configuration.model.support.services.json.JsonServiceRegistryProperties;
import org.apereo.cas.configuration.support.RequiresModule;

import com.fasterxml.jackson.annotation.JsonFilter;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.io.Serializable;

/**
 * This is {@link ServiceRegistryCoreProperties}.
 *
 * @author Misagh Moayyed
 * @since 6.4.0
 */
@RequiresModule(name = "cas-server-core-services", automated = true)
@Getter
@Setter
@Accessors(chain = true)
@JsonFilter("ServiceRegistryCoreProperties")
public class ServiceRegistryCoreProperties implements Serializable {
    @Serial
    private static final long serialVersionUID = -268826011744304210L;

    /**
     * Flag that indicates whether to initialise active service
     * registry implementation with a default set of service definitions included
     * with CAS by default in JSON format.
     * The initialization generally tends to find JSON service definitions
     * from {@link JsonServiceRegistryProperties#getLocation()}.
     * <p>
     * In cases where the location points to an embedded directory or resource inside a JAR/ZIP file,
     * such as those that might have been packaged with the CAS application as part of the build and assembly process,
     * embedded services are first exported out into a temporary directory and then read as file-system resources.
     * In such scenarios, you may want to turn off the watcher via
     * {@link JsonServiceRegistryProperties#isWatcherEnabled()}.
     */
    private boolean initFromJson;

    /**
     * Flag that indicates whether service definitions that ship with CAS by default
     * should be included in the initialization process and imported into CAS service registry.
     */
    private boolean initDefaultServices = true;

    /**
     * Determine how services are internally managed, queried, cached and reloaded by CAS.
     * Accepted values are the following:
     *
     * <ul>
     * <li>DEFAULT: Keep all services inside a concurrent map.</li>
     * <li>DOMAIN: Group registered services by their domain having been explicitly defined.</li>
     * </ul>
     */
    private ServiceManagementTypes managementType = ServiceManagementTypes.DEFAULT;

    /**
     * Types of service managers that one can control.
     */
    public enum ServiceManagementTypes {
        /**
         * Group service definitions by their domain.
         */
        DOMAIN,
        /**
         * Default option to keep definitions in a map as they arrive.
         */
        DEFAULT
    }
}
