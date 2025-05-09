package com.exclamationlabs.connid.base.neo.scim2.schema;

import com.exclamationlabs.connid.base.edition.neo.IamType;
import com.exclamationlabs.connid.base.neo.scim2.Mode;
import org.identityconnectors.framework.common.exceptions.ConfigurationException;

import java.util.Collections;
import java.util.Set;

import static com.exclamationlabs.connid.base.neo.scim2.schema.SchemaName.*;

public class SchemaFactory {
    private SchemaFactory() {
        // Prevent instantiation
    }

    public static Set<Scim2Schema> forMode(Mode mode, IamType iamType) {
        if (iamType == IamType.USER) {
            Set<Scim2Schema> result;
            switch (mode) {
                case AWS: result = Collections.emptySet(); break;
                case Slack: result = Set.of(
                        new Scim2Schema(SLACK_USER.name(),
                                "urn:ietf:params:scim:schemas:extension:slack:profile:2.0:User")); break;

                default: throw new ConfigurationException("Unsupported mode: " + mode);
            }
            return result;
        } else if (iamType == IamType.GROUP) {
            Set<Scim2Schema> result;
            switch (mode) {
                case AWS: result = Collections.emptySet(); break;
                case Slack: result = Set.of(
                        new Scim2Schema(SLACK_GROUP.name(),
                                "urn:ietf:params:scim:schemas:extension:slack:profile:2.0:Group")); break;

                default: throw new ConfigurationException("Unsupported mode: " + mode);
            }
            return result;
        }
        throw new ConfigurationException("Unsupported IamType: " + iamType);
    }
}
