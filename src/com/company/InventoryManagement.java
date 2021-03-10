package com.company;

import java.util.List;
import java.util.Scanner;

public class InventoryManagement {
    private int countEquipment;

    static String returnFirstNumber(String string) {
        StringBuilder result = new StringBuilder();
        string = string.replaceAll("\\D", " ");
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) != ' ') {
                while (string.charAt(i) != ' ') {
                    //result += string.charAt(i);
                    result.append(string.charAt(i));
                    i++;
                    if (i == string.length()) break;
                }
                return result.toString();
            }
        }
        return "";
    }

    public int setCountEquipment(Scanner scanner) {
        System.out.print("Введите кол-во предметов инвентаря: ");
        scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        string = InventoryManagement.returnFirstNumber(string);
        this.countEquipment = Integer.parseInt(string);
        return this.countEquipment;
    }

    public void setTypeEquipment(Scanner scanner, int i, SportsEquipment[] sportsEquipments) {
        String string;
        short typeNumber = -1;
        System.out.print("Введите тип инвентаря: \n" +
                "1.Волейбольный мяч\n" +
                "2.Теннисный мяч\n" +
                "3.Ракетка\n" +
                "4.Штанга\n" +
                "5.Гиря\n" +
                "6.Метательное копье\n");
        do {
            string = scanner.nextLine();
            string = InventoryManagement.returnFirstNumber(string);
            typeNumber = Short.parseShort(string);
            switch (typeNumber) {
                case 0 : {
                    System.out.println("Вы выбрали волейбольный мяч. \n");
                    Ball.Volleyball volleyball = new Ball.Volleyball();
                    volleyball.init(scanner);
                    sportsEquipments[i] = volleyball;
                }break;
                case 1 : {
                    System.out.println("Вы выбрали теннисный мяч. \n");
                    Ball.TennisBall tennisBall = new Ball.TennisBall();
                    tennisBall.init(scanner);
                    sportsEquipments[i] = tennisBall;
                }break;
                case 2 : {
                    System.out.println("Вы выбрали ракетку. \n");
                    Racket racket = new Racket();
                    racket.init(scanner);
                    sportsEquipments[i] = racket;
                }break;
                case 3 : {
                    System.out.println("Вы выбрали штангу. \n");
                    TrainingEquipment.Weight weight = new TrainingEquipment.Weight ();
                    weight.init(scanner);
                    sportsEquipments[i] = weight;
                }break;
                case 4 : {
                    System.out.println("Вы выбрали гирю. \n");
                    TrainingEquipment.Barbel barbel = new TrainingEquipment.Barbel();
                    barbel.init(scanner);
                    sportsEquipments[i] = barbel;
                }break;
                case 5 : {
                    System.out.println("Вы выбрали метательное копье. \n");
                    ThrowingSpear throwingSpear = new ThrowingSpear();
                    throwingSpear.init(scanner);
                    sportsEquipments[i] = throwingSpear;
                }break;
            }

        }while (!(typeNumber >=0 && typeNumber <=6));
    }

    public void putEquipmentItem(Scanner scanner, SportsEquipment[]  sportsEquipments) {
        for (int i = 0; i < this.countEquipment; i++) {
            this.setTypeEquipment(scanner, i, sportsEquipments);
        }
    }
}
