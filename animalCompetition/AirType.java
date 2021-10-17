package animalCompetition;
public class AirType extends Animal {
    public double vision() {
        return 100;
    }

    public double speed() {
        return 70;
    }

    public double defense() {
        return 30;
    }

    public double attack() {
        return 40;
    }

    public double stamina() {
        return 40;
    }
    AirType(){
        System.out.println("Airtype.");
    }
}