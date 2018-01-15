package com.jiangjian.study.java.advanced.spring.spel;

import org.springframework.expression.spel.SpelParserConfiguration;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jiangjian on 2017/7/19.
 */
public class TypeConversionSample {
    public List<Boolean> booleanList;

    public static void main(String[] args) {

// false is passed in here as a string. SpEL and the conversion service will
// correctly recognize that it needs to be a Boolean and convert it
        TypeConversionSample object = (TypeConversionSample) new SpelExpressionParser(new SpelParserConfiguration(true, true))
                .parseExpression("booleanList[4]").getValue(new TypeConversionSample());


// b will be false
        Boolean b = object.booleanList.get(2);
        System.out.println(b);
    }
}
