package com.zhuzz.design.patternz.builder.housebuilder;

/**
 * 具体建造者：建造普通房屋
 * Concrete builder: standard house
 */
public class ConcreteHouseBuilder extends HouseBuilder {
    @Override
    public void buildFoundation() {
        house.setFoundation("Standard Foundation");
    }

    @Override
    public void buildStructure() {
        house.setStructure("Standard Structure");
    }

    @Override
    public void buildRoof() {
        house.setRoof("Standard Roof");
    }

    @Override
    public void buildInterior() {
        house.setInterior("Standard Interior");
    }
}