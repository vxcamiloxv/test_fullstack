package dto;

public class Inventory
{
    private int id;
    private String name;
    private String description;
    private int type_id;
    private double unit_price;

    public Inventory() {

    }

    public Inventory(int id, String name, String description, int type_id, double unit_price) {
        super();
        this.id = id;
        this.name = name;
        this.description = description;
        this.type_id = type_id;
        this.unit_price = unit_price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String geDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTypeId() {
        return type_id;
    }

    public void setTypeId(int type_id) {
        this.type_id = type_id;
    }

    public double getUnitPrice() {
        return unit_price;
    }

    public void setUnitPrice(double unit_price) {
        this.unit_price = unit_price;
    }

    @Override
    public String toString() {
        return "Inventory [id=" + id + ", name=" + name + ", description=" + description
            + ", type_id=" + type_id + ", unit_price=" + unit_price + "]";
    }

}
