public class Huntsman extends Hunter {
    public Huntsman() {
        super(0, 1, 8);
    }

    @Override
    public boolean isSameSpecies(Animal other) {
        return other instanceof Huntsman;
    }

    @Override
    public boolean isHuntable(Animal animal) {
        return true;
    }
}
