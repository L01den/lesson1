package ru.geekbrains.lesson1.store3D.models;

import ru.geekbrains.lesson1.store3D.inmemory.ModelChangedObserver;

import java.util.List;

public class Scene {

    private static int counter = 1;

    private int id;
    private List<PoligonalModel> models;
    private List<Flash> flashes;
    private List<Camera> cameras;

    {
        id = ++counter;
    }

    public Scene(List<PoligonalModel> models, List<Camera> cameras) {
        this.models = models;
        this.cameras = cameras;
        System.out.println("Сцена создана");
    }

    public Scene(List<PoligonalModel> models, List<Flash> flashes, List<Camera> cameras) {
        this.models = models;
        this.flashes = flashes;
        this.cameras = cameras;
        System.out.println("Сцена создана");
    }

    public void addModel(PoligonalModel model){
        models.add(model);
    }

    public void removeModel(PoligonalModel model) {
        models.remove(model);
    }

    public void addCamera(Camera camera){
        cameras.add(camera);
    }

    public Camera getCamera(int idCamera){
        return cameras.get(idCamera);
    }

    public void removeCamera(Camera camera) {
        cameras.remove(camera);
    }

    public void addFlash(Flash flash){
        flashes.add(flash);
    }

    public Flash getFlash(int idFlash){
        return flashes.get(idFlash);
    }
    public void removeFlash(Flash flash) {
        flashes.remove(flash);
    }

    public List<PoligonalModel> getModels() {
        return models;
    }

    public List<Flash> getFlashes() {
        return flashes;
    }

    public void setFlashes(List<Flash> flashes) {
        this.flashes = flashes;
    }

    public List<Camera> getCameras() {
        return cameras;
    }



}
