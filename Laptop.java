import java.util.Objects;

// Класс Laptop для описания ноутбука
public class Laptop {
    private String model;
    private int ramGb; // ОЗУ в гигабайтах
    private int hddGb; // Объем жесткого диска в гигабайтах
    private String os; // Операционная система
    private String color; //Цвет

    Laptop(String model, int ramGb, int hddGb, String os, String color) {
        this.model = model;
        this.ramGb = ramGb;
        this.hddGb = hddGb;
        this.os = os;
        this.color = color;
    }
    // Геттеры
    public String getModel() {
        return model;
    }
    public int getRamGb() {
        return ramGb;
    }

    public int getHddGb() {
        return hddGb;
    }

    public String getOs() {
        return os;
    }

    public String getColor() {
        return color;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setRamGb(int ramGb){
        this.ramGb = ramGb;
    }

    public void setHddGb(int hddGb) {
        this.hddGb = hddGb;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Model: " + model + ", RAM: " + ramGb + "GB, HDD: " + hddGb + "GB, OS: " + os + ", Color: " + color;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Laptop laptop = (Laptop) obj;
        return ramGb == laptop.ramGb &&
                hddGb == laptop.hddGb &&
                model.equals(laptop.model) &&
                os.equals(laptop.os) &&
                color.equals(laptop.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, ramGb, hddGb, os, color);
    }

}

