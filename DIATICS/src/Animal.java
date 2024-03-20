import java.util.ArrayList;

public abstract class Animal {

    protected final int BIRTHRANGE = 3;// The distance required for the formation of a new animal
    protected int gender; //       Gender -->  0= Male   1=Female
    protected int STEPSIZE;//

    public Animal(int gender, int STEPSIZE) {

        this.gender = gender;
        this.STEPSIZE = STEPSIZE;

    }

    //The method used to determine whether animals are of the same species
    public abstract boolean isSameSpecies(Animal other);

    //method that calculates in which directions the animals should move based on the number of steps
    public void moveAnimal(Field field, int xi, int yj) {
        int x = xi;
        int y = yj;
        if ((Main.HEIGHT <= x + 1 || !field.isEmpty(x + 1, y)) && (0 > x - 1 || !field.isEmpty(x - 1, y)) && (0 > y - 1 || !field.isEmpty(x, y - 1)) && (Main.WIDTH <= y + 1 || !field.isEmpty(x, y + 1))) {
            return;

        }
        Main.stepNumber += this.STEPSIZE;

        for (int i = 0; i < this.STEPSIZE; ) {
            int number = Main.random.nextInt(4);

            switch (number) {
                case 0:
                    if (Main.WIDTH > x + 1 && field.isEmpty(x + 1, y)) {

                        field.field[x + 1][y] = field.field[x][y];
                        field.field[x][y] = null;
                        x++;
                        i++;
                        break;
                    } else {

                        break;
                    }
                case 1:
                    if (0 <= x - 1 && field.isEmpty(x - 1, y)) {

                        field.field[x - 1][y] = field.field[x][y];
                        field.field[x][y] = null;
                        x--;
                        i++;
                        break;
                    } else {

                        break;
                    }
                case 2:
                    if (Main.WIDTH > y + 1 && field.isEmpty(x, y + 1)) {

                        field.field[x][y + 1] = field.field[x][y];
                        field.field[x][y] = null;
                        y++;
                        i++;
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if (0 <= y - 1 && field.isEmpty(x, y - 1)) {

                        field.field[x][y - 1] = field.field[x][y];
                        field.field[x][y] = null;
                        y--;
                        i++;
                        break;

                    } else {

                        break;
                    }

            }

        }
    }

    //In this method, it tells us whether there is a male animal that has not previously mated with another female animal within 3 units of the female animal we have selected from the field.
    // If there are, we remove these 2 animals from the male and female lists. And we can say that we approve the formation of new animals around the female in the field class.
    public boolean isBirthable(Field field, int x, int y, Animal animal) {

        ArrayList<Animal> husbandable = new ArrayList<>();

        for (int i = (x - BIRTHRANGE); i <= (x + BIRTHRANGE); i++) {
            for (int j = (y - BIRTHRANGE); j <= (y + BIRTHRANGE); j++) {

                if (Main.WIDTH > i && Main.WIDTH > j && i >= 0 && j >= 0) {
                    if (field.field[i][j] != null) {
                        if (field.field[i][j].equals(animal)) {
                            continue;
                        }

                        if (isSameSpecies(field.field[i][j]) && field.field[i][j].gender == 0 && field.maleAnimal.contains(field.field[i][j])) {
                            husbandable.add(field.field[i][j]);
                        }
                    }
                }
            }
        }

        if (husbandable.size() > 0) {
            Animal fatherAnimal = husbandable.get(Main.random.nextInt(husbandable.size()));

            husbandable.remove(fatherAnimal);
            field.maleAnimal.remove(fatherAnimal);
            field.femaleAnimal.remove(animal);
            return true;

        } else
            return false;
    }


}


