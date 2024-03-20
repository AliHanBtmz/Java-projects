import java.util.ArrayList;

public abstract class Hunter extends Animal {
    int huntRange;

    public Hunter(int gender, int STEPSIZE, int huntRange) {
        super(gender, STEPSIZE);
        this.huntRange = huntRange;
    }

    @Override
    public abstract boolean isSameSpecies(Animal other);

    // method by which we check which animals the hunter and hunted animals can understand
    public abstract boolean isHuntable(Animal animal);

    //In this method, if there is an animal within the hunting range of the animal to be hunted, it hunts it.
    public void hunt(Animal animal, int huntRange, Field field1, int x, int y) {
        ArrayList<Animal> huntable = new ArrayList<>();
        ArrayList<Integer> dedax = new ArrayList<>();
        ArrayList<Integer> deday = new ArrayList<>();

        for (int i = (x - huntRange); i <= (x + huntRange); i++) {
            for (int j = (y - huntRange); j <= (y + huntRange); j++) {
                if (Main.WIDTH > i && Main.WIDTH > j && i >= 0 && j >= 0) {
                    if (field1.field[i][j] != null && field1.field[i][j].equals(animal)) {
                        continue;
                    }

                    if (field1.field[i][j] != null && isHuntable(field1.field[i][j])) {
                        huntable.add(field1.field[i][j]);
                        dedax.add(i);
                        deday.add(j);
                    }
                }
            }
        }
        if (huntable.size() > 0) {
            int huntedAnimal = Main.random.nextInt(huntable.size());
            field1.removeAnimal(dedax.get(huntedAnimal), deday.get(huntedAnimal));

            field1.clearList();
        }
    }
}
