package edu.colorado.csci3010.sp22.individual_project.model.entities;

import edu.colorado.csci3010.sp22.individual_project.observers.AttackEvent;
import edu.colorado.csci3010.sp22.individual_project.observers.Event;
import edu.colorado.csci3010.sp22.individual_project.observers.Listener;
import edu.colorado.csci3010.sp22.individual_project.observers.Observable;

import java.util.ArrayList;

public abstract class LivingEntity extends Entity implements Observable {
    protected int health;
    protected int speed;
    protected int defense;
    protected int attack;
    protected double accuracy;
    protected Weapon weapon;
    private ArrayList<Listener> listeners;

    public LivingEntity(Type type, int health, int speed, int defense, int attack, double accuracy) {
        super(type);
        this.health = health;
        this.speed = speed;
        this.defense = defense;
        this.attack = attack;
        this.accuracy = accuracy;
        this.listeners = new ArrayList<>();
    }

    public int getHealth() {
        return this.health;
    }

    public int getSpeed() {
        return this.speed;
    }

    public int getDefense() {
        return this.defense;
    }

    public int getAttack() {
        return this.attack;
    }

    public double getAccuracy() {
        return this.accuracy;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public void setAccuracy(double accuracy) {
        this.accuracy = accuracy;
    }

    public void createAttackEvent(boolean hit, int damageDealt, LivingEntity attackee) {
        this.updateListeners(new AttackEvent(hit, damageDealt, this, attackee));
    }

    @Override
    public void addListener(Listener l) {
        if (this.listeners.contains(l)) return;
        this.listeners.add(l);
    }

    @Override
    public void removeListener(Listener l) {
        this.listeners.remove(l);
    }

    @Override
    public void updateListeners(Event e) {
        for (Listener l: this.listeners) {
            l.update(e);
        }
    }

}
