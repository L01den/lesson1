package ru.geekbrains.lesson3.car;

import ru.geekbrains.lesson3.refueling.Fueling;
import ru.geekbrains.lesson3.refueling.Refueling;
import ru.geekbrains.lesson3.wiping.Wiping;

import java.awt.*;

public class SportCar extends Car implements Fueling, Wiping {

    private Refueling refueling;
    private Wiping wiping;

    public SportCar(String make, String model, Color color) {
        super(make, model, color);
        setWheelsCount(3);
    }


    public void setRefuelingStation(Refueling refuelingStation) {
        this.refueling = refuelingStation;
    }

    /**
     * Заправить автомобиль
     */
    @Override
    public void fuel() {
        if (refueling != null) {
            System.out.println("Вы заехали на заправку " + refueling.getClass().getSimpleName());
            refueling.fuel(fuelType);
            System.out.println("Заправка " + this.getClass().getSimpleName() + " окончена)");
        } else {
            System.out.println("Заедьте сначала на заправку");
        }

    }

    /**
     * Мойка
     *
     * @param wiping
     */

    public void setWipingStation(Wiping wiping) {
        this.wiping = wiping;
    }

    public Wiping washing() {
        return wiping;
    }


    @Override
    public void wipMirrors() {
        if (wiping != null) {
            wiping.wipMirrors();
        } else {
            System.out.println("Заедьте сначала на мойку");
        }
    }

    @Override
    public void wipWindshield() {
        if (wiping != null) {
            wiping.wipWindshield();
        } else {
            System.out.println("Заедьте сначала на мойку");
        }
    }

    @Override
    public void wipHeadlights() {
        if (wiping != null) {
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
}
