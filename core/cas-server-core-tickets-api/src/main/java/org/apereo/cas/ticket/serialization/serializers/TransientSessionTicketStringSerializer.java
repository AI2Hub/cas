package org.apereo.cas.ticket.serialization.serializers;

import org.apereo.cas.ticket.TransientSessionTicketImpl;
import org.apereo.cas.util.serialization.AbstractJacksonBackedStringSerializer;

import org.springframework.context.ConfigurableApplicationContext;
import java.io.Serial;

/**
 * This is {@link TransientSessionTicketStringSerializer}.
 *
 * @author Misagh Moayyed
 * @since 6.1.0
 */
public class TransientSessionTicketStringSerializer extends AbstractJacksonBackedStringSerializer<TransientSessionTicketImpl> {
    @Serial
    private static final long serialVersionUID = 8959617299162115085L;

    public TransientSessionTicketStringSerializer(final ConfigurableApplicationContext applicationContext) {
        super(MINIMAL_PRETTY_PRINTER, applicationContext);
    }

    @Override
    public Class<TransientSessionTicketImpl> getTypeToSerialize() {
        return TransientSessionTicketImpl.class;
    }
}
