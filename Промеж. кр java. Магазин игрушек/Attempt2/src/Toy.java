public class Toy {
    private String name;
    private Integer id;
    private Integer frequency;

    public Toy(Integer id, Integer frequency, String name){
        this.id = id;
        this.frequency = frequency;
        this.name = name;
    }

    @Override
    public String toString() {
        return id + " " + frequency + " " + name+ ";";
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
