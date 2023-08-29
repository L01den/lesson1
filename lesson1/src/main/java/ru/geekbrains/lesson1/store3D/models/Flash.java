package ru.geekbrains.lesson1.store3D.models;

import java.awt.*;

public class Flash {

    private Point3D point;
    private Angle3D angle;
    private Color color;
    private float power;

    public Flash(Point3D point, Angle3D angle, Color color, float power) {
        this.point = point;
        this.angle = angle;
        this.color = color;
        this.power = power;
        System.out.println("Свет установлен");
    }

    public Point3D getPoint() {
        return point;
    }

    public void move(Point3D point) {
        this.point = point;
    }

    public Angle3D getAngle() {
        return angle;
    }

    public void rotate(Angle3D angle) {
        this.angle = angle;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public float getPower() {
        return power;
    }

    public void setPower(float power) {
        this.power = power;
    }
}
