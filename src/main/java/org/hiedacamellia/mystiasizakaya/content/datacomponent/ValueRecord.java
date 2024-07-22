package org.hiedacamellia.mystiasizakaya.content.datacomponent;

public record ValueRecord(String value) {
    public boolean isEmpty() {
        return value.isEmpty();
    }
}

