package ru.geekbrains.lesson1.store3D.models;

public class Texture {
    private static int counter = 1;

    private int id;

    /// <summary>
    /// Наименование
    /// </summary>
    private String name;

    {
        id = ++counter;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Texture(String name) {
        this.name = name;
    }
}
