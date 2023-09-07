package ru.geekbrains.lesson3;

import ru.geekbrains.lesson3.car.Car;
import ru.geekbrains.lesson3.car.FlyCar;
import ru.geekbrains.lesson3.car.Harvester;
import ru.geekbrains.lesson3.car.SportCar;
import ru.geekbrains.lesson3.enam.FuelType;
import ru.geekbrains.lesson3.refueling.RefuelingStation;
import ru.geekbrains.lesson3.refueling.RefuelingStationV2;
import ru.geekbrains.lesson3.wiping.WipingStantion1;

import java.awt.*;

public class Program {

    /**
     * 1. Спроектировать абстрактный класс «Car» у которого должны
     *  быть свойства: марка, модель, цвет, тип кузова, число колёс, тип
     *  топлива, тип коробки передач, объём двигателя; методы:
     *  движение, обслуживание, переключение передач, включение
     *  фар, включение дворников.
     *
     * 2. Создать конкретный автомобиль путём наследования класса
     *  «Car».
     * 3. Расширить абстрактный класс «Car», добавить метод: подметать
     * улицу. Создать конкретный автомобиль путём наследования
     * класса «Car». Провести проверку принципа SRP.
     *
     * 4. Расширить абстрактный класс «Car», добавить метод:
     * включение противотуманных фар, перевозка груза. Провести
     * проверку принципа OCP.
     *
     * 5. Создать конкретный автомобиль путём наследования класса
     * «Car», определить число колёс = 3. Провести проверку принципа LSP.
     *
     * 6. Создать конкретный автомобиль путём наследования класса
     * «Car», определить метод «движение» - «полёт». Провести
     * проверку принципа LSP.
     *
     * 7. Создать интерфейс «Заправочная станция», создать метод:
     * заправка топливом.
     *
     *
     * 8. Имплементировать метод интерфейса «Заправочная станция» в
     * конкретный класс «Car».
     *
     * 9. Добавить в интерфейс «Заправочная станция» методы: протирка
     * лобового стекла, протирка фар, протирка зеркал.
     *
     * 10. Имплементировать все методы интерфейса «Заправочная
     * станция» в конкретный класс «Car». Провести проверку
     * принципа ISP. Создать дополнительный/е интерфейсы и
     * имплементировать их в конкретный класс «Car». Провести
     * проверку принципа ISP.
     *
     * 11. Создать путём наследования класса «Car» два
     * автомобиля: с бензиновым и дизельным двигателями,
     * имплементировать метод «Заправка топливом» интерфейса
     * «Заправочная станция». Реализовать заправку каждого
     * автомобиля подходящим топливом. Провести проверку принципа DIP.
     *
     * @param args
     */
    public static void main(String[] args) {

        RefuelingStation refuelingStation = new RefuelingStation();
        RefuelingStationV2 refuelingStationV2 = new RefuelingStationV2();
        WipingStantion1 wipingStantion = new WipingStantion1();

        Harvester harvester = new Harvester("A", "B", Color.ORANGE);
        harvester.setFuelType(FuelType.Diesel);

        harvester.setRefuelingStation(refuelingStation);
        harvester.fuel();

        harvester.setWipingStation(wipingStantion);
        harvester.wipHeadlights();
        harvester.sweeping();

        System.out.println();

        SportCar sportCar = new SportCar("SSS", "S+", Color.DARK_GRAY);
        sportCar.setFuelType(FuelType.Gasoline);

        sportCar.fuel();
        sportCar.setRefuelingStation(refuelingStationV2);
        sportCar.fuel();

        sportCar.setWipingStation(wipingStantion);
        sportCar.wipWindshield();
        sportCar.wipMirrors();
        System.out.println("Цена шиномонтажа " + calculateMaintenance(sportCar));

        System.out.println();

        FlyCar flyCar = new FlyCar("Flash", "Volga", Color.BLACK);
        flyCar.setFuelType(FuelType.Gasoline);
        flyCar.fly();


        flyCar.setRefuelingStation(refuelingStation);
        flyCar.fuel();

        flyCar.setWipingStation(wipingStantion);
        flyCar.wipWindshield();
        flyCar.wipMirrors();
    }

    public static double calculateMaintenance(Car car){
        int wheelsCount = car.getWheelsCount();
        if (wheelsCount >= 6){
            return wheelsCount*1500;
        }
        else {
            return wheelsCount*1000;
        }
    }

}
