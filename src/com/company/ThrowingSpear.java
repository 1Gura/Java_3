package com.company;

import java.util.Scanner;

public class ThrowingSpear extends SportsEquipment {
    private float weight;
    private float length;

    @Override
    protected void init(Scanner scanner) {
        super.init(scanner);
        String string;
        do {
            System.out.print("Вес копья (кг): ");
            string = scanner.nextLine();
            string = InventoryManagement.returnFirstNumber(string);
            try {
                this.weight = Short.parseShort(string);
            } catch (Exception e) {
                this.weight = 0;
            }
        } while (this.weight < 0);

        do {
            System.out.print("Длина копья (см): ");
            string = scanner.nextLine();
            string = InventoryManagement.returnFirstNumber(string);
            try {
                this.length = Short.parseShort(string);
            } catch (Exception e) {
                this.length = 0;
            }
        } while (this.length < 0);

    }

    @Override
    public String toString() {
        String str = super.toString();
        return (str + "\nВес копья: " + this.weight + "длина копья" + this.length);
    }
}
