package com.exclamationlabs.connid.base.neo.scim2.schema;

import lombok.Getter;

@Getter
public class Scim2Schema {
    private String name;
    private String urn;
    private Scim2Schema() {}
    public Scim2Schema(String name, String urn) {
        this.name = name;
        this.urn = urn;
    }
}
