package com.zhuzz.design.patternz.decorator.coffeetopping;

/**
 * 组件接口：咖啡，提供价格与描述
 * Component: coffee with cost and description
 */
public interface Coffee {
    double cost();

    String description();
}