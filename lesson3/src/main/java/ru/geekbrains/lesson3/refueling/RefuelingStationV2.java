package ru.geekbrains.lesson3.refueling;

import ru.geekbrains.lesson3.enam.FuelType;

public class RefuelingStationV2 implements Refueling {
    @Override
    public void fuel(FuelType fuelType) {
        switch (fuelType){
            case Diesel -> System.out.println("Заправка дизельным топливом");
            case Gasoline -> System.out.println("Заправка бензином");
        }
    }
}