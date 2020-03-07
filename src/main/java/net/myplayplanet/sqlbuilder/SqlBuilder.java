package net.myplayplanet.sqlbuilder;

public class SqlBuilder extends BaseBuilder<SqlBuilder> implements ISelectBuilderParent {
    public SqlBuilder() {
        super(new StringBuilder());
        this.setBuilder(this);
    }

    public SelectBuilder<SqlBuilder> select(String one, String... what) {
        return new SelectBuilder<>(this, one, what);
    }
    public SelectBuilder<SqlBuilder> selectNone() {
        return new SelectBuilder<>(this, null);
    }
    public SelectBuilder<SqlBuilder> selectAll() {
        return new SelectBuilder<>(this, "*");
    }

    public String build() {
        return this.getStringBuilder().toString().trim() + ";";
    }
}
