package Yalco.sec13.chap03.ex01;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class Main {
    @Count(value = 3) // 괄호값 { 필드명 = 값}
    private int apples; // apple이란 이름은 3을 가짐 , 어노테이션을 통해 값을 부여

    // default가 없을 시에는 생략 가능
    @Count
    private int bananas;

    // 필드가 하나고 필드명이 value일시
    // 값만 넣을 수 있다,.
    @Count(5)
    private int cacaos;

    // 값이 여럿일 경우 순서는 무관하다
    @PersonNames(last ="홍", first = "길동")
    private Object seller;

    // 어노테이션의 값을 다른 어노테이션의 값으로 활용
    @PersonInfo(
            personNames = @PersonNames(first = "우우우", last = "김"),
            age = 30,
            married = true
    )
    private Object sellerInfo;

    @LocsAvail(
            quick = {"서울","대전","강원"}, //배열을 { }안에 작성
            visit = "판교", // 하나만 있을시 { } 생략가능
            delivery = {} // 요소가 없을시 { } 생략불가
    )
    private Object store;

    public static void main(String[] args) {
        List<Object> annotVals = new ArrayList<>();

        for (Field f : Main.class.getDeclaredFields()) {
            for (Annotation a : f.getAnnotations()) {
                if (a instanceof Count) {
                    annotVals.add(((Count) a).value());
                }
                if (a instanceof PersonNames) {
                    annotVals.add(((PersonNames) a).first());
                    annotVals.add(((PersonNames) a).last());
                }
                if (a instanceof PersonInfo) {
                    annotVals.add(((PersonInfo) a).personNames().first());
                    annotVals.add(((PersonInfo) a).personNames().last());
                    annotVals.add(((PersonInfo) a).age());
                    annotVals.add(((PersonInfo) a).married());
                }
                if (a instanceof LocsAvail) {
                    annotVals.add(((LocsAvail) a).visit());
                    annotVals.add(((LocsAvail) a).delivery());
                    annotVals.add(((LocsAvail) a).quick());
                }
            }
        }
    }

}
