package ru.geekbrains.lesson3.wiping;

public class WipingStantion1 implements Wiping{
    @Override
    public void wipMirrors() {
        System.out.println("Зеркала помыты");
    }

    @Override
    public void wipWindshield() {
        System.out.println("Лобовое стекло помыто");
    }

    @Override
    public void wipHeadlights() {
        System.out.println("Фары помыты");
    }
}
