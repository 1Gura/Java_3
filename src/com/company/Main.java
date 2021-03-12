package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        InventoryManagement inventoryManagement = new InventoryManagement();
        Scanner scanner = new Scanner(System.in);
        SportsEquipment []sportsEquipments = new SportsEquipment[inventoryManagement.setCountEquipment(scanner)];
        System.out.println("Предметов в инвентаре будет: " + inventoryManagement.outCountEquipment());
        inventoryManagement.putEquipmentItem(scanner, sportsEquipments);
        inventoryManagement.outEquipmentAll(sportsEquipments);
        inventoryManagement.outEquipmentTennis(sportsEquipments);
    }
}
