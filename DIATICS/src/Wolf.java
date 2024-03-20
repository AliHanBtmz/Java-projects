public class Wolf extends Hunter {
    public Wolf(int gender) {
        super(gender, 3, 4);
    }

    @Override
    public boolean isSameSpecies(Animal other) {
        return other instanceof Wolf;
    }

    public boolean isHuntable(Animal animal) {

        return (animal instanceof Sheep || animal instanceof Chicken || animal instanceof Cow);
    }
}
