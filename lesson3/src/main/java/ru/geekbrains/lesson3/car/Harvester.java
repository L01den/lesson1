package ru.geekbrains.lesson3.car;

import ru.geekbrains.lesson3.refueling.Fueling;

import ru.geekbrains.lesson3.refueling.Refueling;
import ru.geekbrains.lesson3.wiping.Wiping;

import java.awt.*;

public class Harvester extends Car implements Fueling, Wiping {


    private Refueling refueling;
    private Wiping wiping;

    public Harvester(String make, String model, Color color) {
        super(make, model, color);
        setWheelsCount(6);
    }

    public void setRefuelingStation(Refueling refuelingStation) {
        this.refueling = refuelingStation;
    }

    /**
     * Заправить автомобиль
     */
    @Override
    public void fuel() {
        if (refueling != null){
            System.out.println("Вы заехали на заправку " + refueling.getClass().getSimpleName());
            refueling.fuel(fuelType);
            System.out.println("Заправка " + this.getClass().getSimpleName() + " окончена)");
        } else {
            System.out.println("Заедьте сначала на заправку");
        }

    }

    /**
     * Мойка
     * @param wiping
     */

    public void setWipingStation(Wiping wiping){
        this.wiping = wiping;
    }


    @Override
    public void wipMirrors() {
        if (wiping != null){
            System.out.println("Вы заехали на мойку " + wiping.getClass().getSimpleName());
            wiping.wipMirrors();
        } else {
            System.out.println("Заедьте сначала на мойку");
        }
    }

    @Override
    public void wipWindshield() {
        if (wiping != null){
            System.out.println("Вы заехали на мойку " + wiping.getClass().getSimpleName());
            wiping.wipWindshield();
        } else {
            System.out.println("Заедьте сначала на мойку");
        }
    }

    @Override
    public void wipHeadlights() {
        if (wiping != null){
            System.out.println("Вы заехали на мойку " + wiping.getClass().getSimpleName());
            wiping.wipHeadlights();
        } else {
            System.out.println("Заедьте сначала на мойку");
        }
    }


    @Override
    public void movement() {

    }

    @Override
    public void maintenance() {

    }

    @Override
    public boolean gearShifting() {
        return false;
    }

    @Override
    public boolean switchHeadlights() {
        return false;
    }

    @Override
    public boolean switchWipers() {
        return false;
    }

    public void sweeping() {
        System.out.println("Автомобиль метет улицу.");
    }

//


}
