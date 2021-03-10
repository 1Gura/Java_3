package com.company;

import java.util.Scanner;

abstract public class Ball extends SportsEquipment {

    private float diameter;
    private short weight;

    @Override
    protected void init(Scanner scanner) {
        super.init(scanner);
        String string;
        do {
            System.out.print("Вес мяча в граммах: ");
            string = scanner.nextLine();
            string = InventoryManagement.returnFirstNumber(string);
            try {
                weight = Short.parseShort(string);
            } catch (Exception e) {
                weight = 0;
            }
        } while (weight < 0);
        do {
            System.out.print("Диаметр мяча в сантиметрах: ");
            string = scanner.nextLine();
            string = InventoryManagement.returnFirstNumber(string);
            try {
                diameter = Short.parseShort(string);
            } catch (Exception e) {
                diameter = 0;
            }
        } while (diameter < 0);
    }

    @Override
    public String toString() {
        String str = super.toString();
        return ("\nМяч: " + str + "\n\t - Вес: " + weight + " г \n\t - Диаметр: " + diameter + " см \n\t");
    }

    static class Volleyball extends Ball {
        //Добавить уникальные свойства
        float internalPressure;

        @Override
        protected void init(Scanner scanner) {
            super.init(scanner);
            do {
                String string;
                System.out.print("Внутреннее давление в кг/см2:  ");
                string = scanner.nextLine();
                string = InventoryManagement.returnFirstNumber(string);
                try {
                    this.internalPressure = Float.parseFloat(string) / 10;
                } catch (Exception e) {
                    this.internalPressure = 0;
                }
            } while (!(this.internalPressure > 0 && this.internalPressure < 1));
        }

        @Override
        public String toString() {
            String str = super.toString();
            return (str + "\nЦвет теннисного мяца: " + this.internalPressure);
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
            return (str + "\nЦвет теннисного мяца: " + this.color);
        }
    }
}
