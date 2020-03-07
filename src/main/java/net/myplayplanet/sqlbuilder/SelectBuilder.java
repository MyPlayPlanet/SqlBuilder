package net.myplayplanet.sqlbuilder;

public class SelectBuilder<T extends ISelectBuilderParent> extends BaseBuilder<SelectBuilder<T>> implements IWhereBuilderParent {
    T parent;

    public SelectBuilder(T sqlBuilder, String one, String... what) {
        super(sqlBuilder.getStringBuilder());
        this.setBuilder(this);
        this.parent = sqlBuilder;
        this.select(one, what);
    }

    public SelectBuilder<T> select(String one, String... what) {

        this.getStringBuilder().append("select ");
        if(one == null) {
            return this;
        }
        this.getStringBuilder().append(one);
        for (String s : what) {
            this.getStringBuilder().append(", ");
            this.getStringBuilder().append(s);
        }
        this.getStringBuilder().append(" ");
        return this;
    }
    public SelectBuilder<T> selectNone() {
        return select(null);
    }
    public SelectBuilder<T> selectAll() {
        return select("*");
    }

    public SelectBuilder<T> from(String table) {
        parent.getStringBuilder().append("from ");
        parent.getStringBuilder().append(table);
        parent.getStringBuilder().append(" ");
        return this;
    }

    public WhereBuilder<SelectBuilder<T>> where(String propertyOne) {
        return new WhereBuilder<>(this, propertyOne);
    }

    public String build() {
        return parent.getStringBuilder().toString();
    }
}
