package com.xv435.SeventhDeath.game;

import java.lang.String;
import java.util.Random;
/**
 * This class is a class for the creation of characters in my attempt at creating an RPG Game.
 * 
 * @author (xv435) 
 * @version (Alpha 0.0.1)
 */
public class Character extends Entity
{
    private int level;
    private Weapon weapon;
    private String name;
    private int hp;


    public Character(int levelStart, int weaponPower, String inputName)
    {
    	super(inputName + ".png");
        level = levelStart;
        weapon = new Weapon("Wooden Sword", 1);
        hp = level * 10;
        name = inputName;
    }
    
    public Weapon getWeapon()
    {
        return weapon;
    }
    public int getHp()
    {
        return hp;
    }
    public int getLevel()
    {
        return level;
    }
    public int takeDamage(int attackerWeapon, int attackerLevel)
    {
        int oldHp = hp;
        Random generator = new Random();
        int randomInt = generator.nextInt(2);
        hp = hp - ((attackerWeapon + attackerLevel) - (level / 2) + randomInt);
        return oldHp - hp;
    }
    public void heal(int amountToHeal)
    {
        hp = hp + amountToHeal;
    }
    public void levelUp(int amountToLevel)
    {
    level = level + amountToLevel;
    hp = level * 10;
    }
    public void changeWeapon(int weaponDamage, String weaponName)
    {
    	weapon.power = weaponDamage;
    	weapon.name = weaponName;
    }
    public String getName()
    {
    return name;
    }
}
