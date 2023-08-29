package ru.geekbrains.lesson1.store3D;

import ru.geekbrains.lesson1.store3D.inmemory.ModelChangedObserver;
import ru.geekbrains.lesson1.store3D.inmemory.ModelStore;
import ru.geekbrains.lesson1.store3D.inmemory.Observer1;
import ru.geekbrains.lesson1.store3D.inmemory.Observer2;
import ru.geekbrains.lesson1.store3D.models.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Program {

    public static void main(String[] args) {

        Observer1 observer1 = new Observer1();



        Poligon p1 = new Poligon();
        List<Poligon> poligons = new ArrayList<>();
        poligons.add(p1);

        PoligonalModel poligonalModel1 = new PoligonalModel(poligons);
        PoligonalModel poligonalModel2 = new PoligonalModel(poligons);
        List<PoligonalModel> poligonalModels = new ArrayList<>();
        poligonalModels.add(poligonalModel1);
        poligonalModels.add(poligonalModel2);

        Flash flash = new Flash(new Point3D(1, 1, 2),
                                new Angle3D(45),
                                Color.CYAN,
                          10);
        List<Flash> flashes = new ArrayList<>();
        flashes.add(flash);

        Camera camera = new Camera(new Point3D(10, 15, 40),
                                    new Angle3D(10));
        List<Camera> cameras = new ArrayList<>();
        cameras.add(camera);

        Scene scene = new Scene(poligonalModels, cameras);
        List<Scene> scenes = new ArrayList<>();
        scenes.add(scene);

        ModelStore store = new ModelStore(poligonalModels, flashes, scenes, cameras);
        store.RegisterModelChanger(observer1);
    }

}
