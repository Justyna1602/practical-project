package pl.sdacademy.entity;

public class Car {
    private Integer id;
    private Model model;
    private String vin;

    public Car(Integer id, Model model, String vin) {
        this.id = id;
        this.model = model;
        this.vin = vin;
    }

    public Integer getId() {
        return id;
    }

    public Model getModel() {
        return model;
    }

    public String getVin() {
        return vin;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", model=" + model +
                ", vin='" + vin + '\'' +
                '}';
    }
}
