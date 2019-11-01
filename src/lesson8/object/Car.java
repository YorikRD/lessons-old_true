package lesson8.object;

public class Car implements Cloneable{
    private String brand;
    private String color;
    private Owner owner;


    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        super.clone();
        // реализация
        Owner o = new Owner(this.owner.getName(), this.owner.getPhone());
        Car c = new Car(this.brand, this.color, o);
        return c;
    }

    public Car(String brand, String color, Owner owner) {
        setBrand(brand);
        setColor(color);
        this.owner = owner;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        //TODO: проверка входных данных
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;

        Car car = (Car) o;

        if (!getBrand().equals(car.getBrand())) return false;
        if (!getColor().equals(car.getColor())) return false;
        return owner.equals(car.owner);
    }

    @Override
    public int hashCode() {
        int result = getBrand().hashCode();
        result = 31 * result + getColor().hashCode();
        result = 31 * result + owner.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", color='" + color + '\'' +
                ", owner=" + owner +
                '}';
    }
}


