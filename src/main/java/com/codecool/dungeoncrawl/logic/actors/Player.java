package com.codecool.dungeoncrawl.logic.actors;

import com.codecool.dungeoncrawl.logic.Cell;
import com.codecool.dungeoncrawl.logic.CellType;
import com.codecool.dungeoncrawl.logic.GameMap;
import com.codecool.dungeoncrawl.logic.Items.Item;
import com.codecool.dungeoncrawl.logic.controller.FightController;
import com.codecool.dungeoncrawl.logic.controller.NameController;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


public class Player extends Actor {
    private List<Item> inventory = new ArrayList<>();

    private String[] developersNames = new String[]{"BARTEK", "DAREK", "MATEUSZ", "SYLWESTER", "KAROL"};

    private boolean developer;

    private String name;



    public Player(Cell cell,String name) {
        super(cell);
        super.setHealth(400);
        super.setDamage(100);
        super.setAbilityPower(150);
        super.setBlockPower(100);
        super.setExp(0);
        this.name = name.toUpperCase(Locale.ROOT);
    }

    public void pickUpItem(){
        inventory.add(this.getCell().getItem());
        this.getCell().setItem(null);
        for (Item i : inventory){
            System.out.print(i.getTileName() + " ");
        }

    }

    public boolean checkIfDeveloper() {
        for(String developersName : developersNames) {
            if (this.name.equals(developersName)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean checkIfMovePossible(int x, int y) {
        if((this.getCell().getNeighbor(x,y).getType() == CellType.WALL ||
                this.getCell().getNeighbor(x,y).getType() == CellType.WALL_2 ||
                this.getCell().getNeighbor(x,y).getType() == CellType.WALL_3 ) && !checkIfDeveloper()){

            return false;
        }
        if(this.getCell().getNeighbor(x,y).getActor() instanceof Monster)
        {
            FightController.isFightAvailable = true;
            FightController.monster = (Monster) this.getCell().getNeighbor(x,y).getActor();
            return false;
        }
        return true;
    }


    public List<Item> getInventory() {
        return inventory;
    }

    public String getTileName() {
        return "player";
    }
}