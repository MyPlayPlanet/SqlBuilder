package net.myplayplanet.sqlbuilder.test;

import net.myplayplanet.sqlbuilder.SqlBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SelectStatementTests {
    @Test
    public void select_a_b_from_cool() {
        SqlBuilder sqlBuilder = new SqlBuilder();

        String result = sqlBuilder.select("a", "b").from("cool").parent().build();

        Assertions.assertEquals("select a, b from cool;", result);
    }
    @Test
    public void select_a_b_from_cool_2() {
        SqlBuilder sqlBuilder = new SqlBuilder();

        String result = sqlBuilder.select("a").plus("b").from("cool").parent().build();

        Assertions.assertEquals("select a ,b from cool;", result);
    }

    @Test
    public void select__select_all_from_aaa__AS_blub_from_cool() {
        SqlBuilder sqlBuilder = new SqlBuilder();

        String result = sqlBuilder.selectNone().open().select("*").from("aaa").close().as("blub").from("cool").parent().build();

        Assertions.assertEquals("select (select * from aaa ) AS blub from cool;", result);
    }
}
