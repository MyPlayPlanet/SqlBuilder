package net.myplayplanet.sqlbuilder.test;

import net.myplayplanet.sqlbuilder.SqlBuilder;

public class Main {
    public static void main(String[] args) {
        SqlBuilder builder = new SqlBuilder();
        builder.select("a", "b").from("table").build();
        builder.select("*").where("?").eq("abc").and("b").eq("?").up().build();

    }

    void examples() {
        /*

        // select * from abc where ? = 25 order by id asc limit 100
        builder.select().from("abc").where("?").eq("25").orderBy("id").ascUp().Limit(100).build();

        // select a, b, c from abc where ? = 25 order by id asc limit 100
        builder.select("a", "b", "c").from("abc").where("?").eqUp("25").orderBy("id").ascUp().Limit(100).build();

        // select * from abc where ? = 25 and b < 10 order by id asc limit 100
        builder.select().from("abc").where("?").eq("25").and("b").smallerUp(10).orderBy("id").ascUp().Limit(100).build();


        // insert into table (a, b, c) values (?,?,?), (?,?,?) ON DUPLICATE KEY UPDATE a=values(a),b=values(b),c=values(c)
        builder.insert("table").into("a").column("b").column("c").values("?", "?", "?").valuesUp("?", "?", "?").onDupplicateKeyUpdate().build();

        // insert into table (a, b, c) values (?,?,?), (?,?,?), (?,?,?), (?,?,?), (?,?,?) ON DUPLICATE KEY UPDATE a=values(a),b=values(b),c=values(c)
        builder.insert("table").into("a").column("b").column("c").valuesMultiple(5, "?", "?", "?").onDupplicateKeyUpdate().build();

        */
    }
}
