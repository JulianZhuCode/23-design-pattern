package com.zhuzz.design.patternz.builder;

/**
 * 建造者模式 - 房屋建造案例
 *
 * @author zhuzz
 * 2023/8/29 17:25
 */
public class HouseBuilderCase {
    public static void main(String[] args) {
        HouseBuilder concreteBuilder = new ConcreteHouseBuilder();
        Director director1 = new Director(concreteBuilder);
        House concreteHouse = director1.constructHouse();
        System.out.println("Concrete House: " + concreteHouse);

        HouseBuilder luxuryBuilder = new LuxuryHouseBuilder();
        Director director2 = new Director(luxuryBuilder);
        House luxuryHouse = director2.constructHouse();
        System.out.println("Luxury House: " + luxuryHouse);
    }

    static class House {
        private String foundation;
        private String structure;
        private String roof;
        private String interior;

        public void setFoundation(String foundation) {
            this.foundation = foundation;
        }

        public void setStructure(String structure) {
            this.structure = structure;
        }

        public void setRoof(String roof) {
            this.roof = roof;
        }

        public void setInterior(String interior) {
            this.interior = interior;
        }

        @Override
        public String toString() {
            return "House [foundation=" + foundation + ", structure=" + structure + ", roof=" + roof + ", interior=" + interior + "]";
        }
    }

    static abstract class HouseBuilder {
        protected House house = new House();

        public abstract void buildFoundation();

        public abstract void buildStructure();

        public abstract void buildRoof();

        public abstract void buildInterior();

        public House getHouse() {
            return house;
        }
    }

    static class ConcreteHouseBuilder extends HouseBuilder {
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

    static class LuxuryHouseBuilder extends HouseBuilder {
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

    static class Director {
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
}