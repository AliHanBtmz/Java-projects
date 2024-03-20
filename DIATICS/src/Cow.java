public class Cow extends Animal {
    public Cow(int gender) {
        super(gender, 2);
    }

    @Override
    public boolean isSameSpecies(Animal other) {
        return other instanceof Cow;
    }
}
