package net.myplayplanet.sqlbuilder;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

public abstract class BaseBuilder<Builder extends BaseBuilder<Builder>> {
    @Setter(AccessLevel.PROTECTED)
    private Builder builder;
    @Getter
    private StringBuilder stringBuilder;

    public BaseBuilder(StringBuilder stringBuilder) {
        this.stringBuilder = stringBuilder;
    }
    public Builder open() {
        this.getStringBuilder().append("(");
        return builder;
    }
    public Builder close() {
        this.getStringBuilder().append(") ");
        return builder;
    }

    public Builder as(String as) {
        this.getStringBuilder().append("AS ");
        this.getStringBuilder().append(as);
        this.getStringBuilder().append(" ");
        return builder;
    }

    public Builder plus(String and) {
        this.getStringBuilder().append(",");
        if (and == null) {
            return builder;
        }
        this.getStringBuilder().append(and);
        this.getStringBuilder().append(" ");
        return builder;
    }
    public Builder plus() {
        return plus(null);
    }
}
