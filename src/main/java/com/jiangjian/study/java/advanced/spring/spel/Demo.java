package com.jiangjian.study.java.advanced.spring.spel;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

/**
 * Created by jiangjian on 2017/7/19.
 */
public class Demo {
    public static void main(String[] args) {
        ExpressionParser parser = new SpelExpressionParser();
        Expression expression = parser.parseExpression("'hello'.concat('jiangjian')");
        Expression expression1 = parser.parseExpression("'hello'.bytes.length");
        System.out.println(expression.getValue());
        System.out.println(expression1.getValue(Integer.class));
    }
}
