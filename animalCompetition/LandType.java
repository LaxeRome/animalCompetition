package animalCompetition;

public class LandType extends Animal {
    public double vision() {
        return 40;
    }

    public double speed() {
        return 50;
    }

    public double defense() {
        return 50;
    }

    public double attack() {
        return 75;
    }

    public double stamina() {
        return 50;
    }
    LandType() {
        System.out.println("LandType.");
    }
}