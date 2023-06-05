public class Toy {
    private String name;
    private Integer id;
    private Integer frequency;

    public Toy(Integer id, String name, Integer frequency){
        this.id = id;
        this.name = name;
        this.frequency = frequency;
    }

    @Override
    public String toString() {
        return id + " " + name + " " + frequency +  ";";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFrequency() {
        return frequency;
    }

    public void setFrequency(Integer frequency) {
        this.frequency = frequency;
    }
}
