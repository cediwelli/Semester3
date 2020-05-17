package de.uni_hannover.hci.aufgabe3.model;

public class Dog extends de.uni_hannover.hci.aufgabe3.Animal {

  public Dog(String name) {
    super(name);
  }


  @Override
  public String getName() {
    return super.name_;
  }

  @Override
  public int getArms() {
    return 0;
  }

  @Override
  private int getLegs() {
    return 4;
  }

  @Override
  public String toString() {
    return String.format("%s is a dog with %d legs and %d arms.", this.getName(), this.getArms(), this.getLegs());
  }
}