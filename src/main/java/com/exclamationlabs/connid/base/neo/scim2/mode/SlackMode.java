package com.exclamationlabs.connid.base.neo.scim2.mode;

public enum SlackMode {
    SLACK_USER("urn:ietf:params:scim:schemas:extension:slack:profile:2.0:User"),
    SLACK_GROUP("urn:ietf:params:scim:schemas:extension:slack:profile:2.0:Group");

    private final String schema;

    SlackMode(String schema) {
        this.schema = schema;
    }

    public String getSchema() {
        return schema;
    }
}
