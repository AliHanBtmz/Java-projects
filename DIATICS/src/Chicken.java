public class Chicken extends Animal {
    public Chicken(int gender) {
        super(gender, 1);
    }

    @Override
    public boolean isSameSpecies(Animal other) {
        return other instanceof Chicken;
    }
}
