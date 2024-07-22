package org.hiedacamellia.mystiasizakaya.content.datacomponent;

import java.util.Objects;

public class Value {

    private String key;
    // Can be mutable, but care needs to be taken when using
    private String value;

    public Value(String key, String value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.key, this.value);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        } else {
            return obj instanceof Value ex
                    && Objects.equals(this.key, ex.key)
                    && Objects.equals(this.value, ex.value);
        }
    }
}
