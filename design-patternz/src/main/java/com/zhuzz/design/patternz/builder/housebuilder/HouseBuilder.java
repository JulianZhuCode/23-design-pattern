package com.zhuzz.design.patternz.builder.housebuilder;

/** 抽象建造者：定义建造房屋各部分的步骤 | Abstract builder: defines build steps */
public abstract class HouseBuilder {
    protected House house = new House();

    public abstract void buildFoundation();

    public abstract void buildStructure();

    public abstract void buildRoof();

    public abstract void buildInterior();

    public House getHouse() {
        return house;
    }
}