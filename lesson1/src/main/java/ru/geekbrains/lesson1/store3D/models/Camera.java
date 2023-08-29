package ru.geekbrains.lesson1.store3D.models;


public class Camera {

    private Point3D point;

    private Angle3D angle;

    public Camera(Point3D point, Angle3D angle) {
        this.point = point;
        this.angle = angle;
        System.out.println("Камера стоит");
    }

    public void rotate(Angle3D angle){
        this.angle = angle;
    }

    public void move(Point3D point){
        this.point = point;
    }
}
