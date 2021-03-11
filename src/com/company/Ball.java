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
        return (str + "\n\tВес: " + weight + " г \n\tДиаметр: " + diameter + " см");
    }

    static class Volleyball extends Ball {
        //Добавить уникальные свойства
        float internalPressure;

        @Override
        protected void init(Scanner scanner) {
            super.init(scanner);
            do {
                String string;
                System.out.print("Внутреннее давление в гПа:  ");
                string = scanner.nextLine();
                string = InventoryManagement.returnFirstNumber(string);
                try {
                    this.internalPressure = Float.parseFloat(string);
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
            return ( "Теннисный мяч" + str + "Цвет теннисного мяча: " + this.color);
        }
    }
}
