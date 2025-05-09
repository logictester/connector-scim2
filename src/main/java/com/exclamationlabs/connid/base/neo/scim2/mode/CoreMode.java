package com.exclamationlabs.connid.base.neo.scim2.mode;

public enum CoreMode {
    CORE_USER("urn:ietf:params:scim:schemas:core:2.0:User"),
    CORE_GROUP("urn:ietf:params:scim:schemas:core:2.0:Group");

    private final String schema;

    CoreMode(String schema) {
        this.schema = schema;
    }

    public String getSchema() {
        return schema;
    }
}
