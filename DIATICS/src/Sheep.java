public class Sheep extends Animal {
    public Sheep(int gender) {
        super(gender, 2);
    }

    @Override
    public boolean isSameSpecies(Animal other) {
        return other instanceof Sheep;
    }
}
