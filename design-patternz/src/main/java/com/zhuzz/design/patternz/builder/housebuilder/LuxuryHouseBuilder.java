package com.zhuzz.design.patternz.builder.housebuilder;

/** 具体建造者：建造豪华房屋 */
public class LuxuryHouseBuilder extends HouseBuilder {
    @Override
    public void buildFoundation() {
        house.setFoundation("Strong Foundation");
    }

    @Override
    public void buildStructure() {
        house.setStructure("Reinforced Structure");
    }

    @Override
    public void buildRoof() {
        house.setRoof("Elegant Roof");
    }

    @Override
    public void buildInterior() {
        house.setInterior("Luxury Interior");
    }
}