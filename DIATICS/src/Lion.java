public class Lion extends Hunter {
    public Lion(int gender) {
        super(gender, 4, 5);
    }

    @Override
    public boolean isSameSpecies(Animal other) {
        return other instanceof Lion;
    }

    @Override
    public boolean isHuntable(Animal animal) {
        return (animal instanceof Sheep || animal instanceof Cow);
    }
}
