package org.example.competitor.vehicles;

public class Engine {
  private  String manufacturer;

  public String getManufacturer() {
    return manufacturer;
  }

  public void setManufacturer(String manufacturer) {
    this.manufacturer = manufacturer;
  }

  public int getCapacity() {
    return capacity;
  }

  public void setCapacity(int capacity) {
    this.capacity = capacity;
  }

  private int capacity;

  @Override
  public String toString() {
    return "Engine{" +
            "manufacturer='" + manufacturer + '\'' +
            ", capacity=" + capacity +
            '}';
  }
}
