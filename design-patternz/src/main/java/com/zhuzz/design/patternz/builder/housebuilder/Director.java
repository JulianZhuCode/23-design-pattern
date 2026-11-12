package com.zhuzz.design.patternz.builder.housebuilder;

/** 指挥者：按固定顺序组装房屋 | Director: builds in a fixed order */
public class Director {
    private HouseBuilder builder;

    public Director(HouseBuilder builder) {
        this.builder = builder;
    }

    public House constructHouse() {
        builder.buildFoundation();
        builder.buildStructure();
        builder.buildRoof();
        builder.buildInterior();
        return builder.getHouse();
    }
}