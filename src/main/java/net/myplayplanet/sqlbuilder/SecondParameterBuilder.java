package net.myplayplanet.sqlbuilder;

public class SecondParameterBuilder<Parent extends ISecondParameterBuilderParent, WhereParent extends IWhereBuilderParent> extends BaseBuilder<SecondParameterBuilder<Parent, WhereParent>> {
    Parent parent;
    private WhereParent whereParent;

    public SecondParameterBuilder(Parent parent, WhereParent whereParent, String secondParameter) {
        super(parent.getStringBuilder());
        this.parent = parent;
        this.whereParent = whereParent;
        this.getStringBuilder().append(secondParameter);
        this.getStringBuilder().append(" ");
    }

    public Parent and(String and) {
        this.getStringBuilder().append("and ");
        this.getStringBuilder().append(and);
        return parent;
    }
    public Parent or(String or) {
        this.getStringBuilder().append("or ");
        this.getStringBuilder().append(or);
        return parent;
    }

    public WhereParent up() {
        return whereParent;
    }
}