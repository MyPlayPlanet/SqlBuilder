package net.myplayplanet.sqlbuilder;

public class WhereBuilder<T extends IWhereBuilderParent> extends BaseBuilder<WhereBuilder<T>> implements ISecondParameterBuilderParent {
    T parent;

    public WhereBuilder(T parent, String firstParameter) {
        super(parent.getStringBuilder());
        this.parent = parent;
        this.getStringBuilder().append("where ");
        this.getStringBuilder().append(firstParameter);
        this.getStringBuilder().append(" ");
    }

    public SecondParameterBuilder<WhereBuilder<T>, T> eq(String secondParameter) {
        this.getStringBuilder().append("= ");
        return new SecondParameterBuilder<>(this, parent, secondParameter);
    }
§
}
