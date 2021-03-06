package com.company;

import java.util.Scanner;

abstract public class Ball extends SportsEquipment {

    private int diameter;
    private int weight;

    @Override
    protected void init(Scanner scanner) {
        super.init(scanner);
        String string;
        do {
            System.out.print("Вес мяча (г): ");
            try {
                weight = InventoryManagement.getInt(scanner);
            } catch (Exception e) {
                weight = 0;
            }
        } while (weight < 0);
        do {
            System.out.print("Диаметр мяча (см): ");
            try {
                diameter = InventoryManagement.getInt(scanner);
            } catch (Exception e) {
                diameter = 0;
            }
        } while (diameter < 0);
    }

    @Override
    public String toString() {
        String str = super.toString();
        return (str + "\n\tВес: " + weight + " г \n\tДиаметр: " + diameter + " см");
    }

    static class Volleyball extends Ball {
        //Давление внутри мяча
        int internalPressure;

        @Override
        protected void init(Scanner scanner) {
            super.init(scanner);
            do {
                System.out.print("Внутреннее давление в гПа:  ");
                try {
                    this.internalPressure = InventoryManagement.getInt(scanner);
                } catch (Exception e) {
                    this.internalPressure = 0;
                }
            } while (!(this.internalPressure > 0 ));
        }

        @Override
        public String toString() {
            String str = super.toString();
            return ("Волейбольный мяч" + str + "\n\tВнутреннее давление в гПа: " + this.internalPressure);
        }

        public Volleyball() {

        }
    }

    static class TennisBall extends Ball {
        //Добавить уникальные свойства
        String color;

        @Override
        protected void init(Scanner scanner) {
            super.init(scanner);
            do {
                System.out.print("Введите цвет мяча: ");
                this.color = scanner.nextLine();
            } while (this.color.isEmpty());
        }

        @Override
        public String toString() {
            String str = super.toString();
            return ( "Теннисный мяч" + str + "\n\tЦвет теннисного мяча: " + this.color);
        }
    }
}
