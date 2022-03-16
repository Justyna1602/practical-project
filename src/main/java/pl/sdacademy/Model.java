package pl.sdacademy;

public class Model {
    private Integer id;
    private Make make;
    private String name;

    public Model(Integer id, Make make, String name) {
        this.id = id;
        this.make = make;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public Make getMake() {
        return make;
    }

    public String getName() {
        return name;
    }
}
