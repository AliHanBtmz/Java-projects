import java.util.ArrayList;

public class Field {

    Animal[][] field;

    /**
     * When choosing mother and father, use the 2 ArrayList below to avoid choosing them over and over again.
     */
    ArrayList<Animal> femaleAnimal = new ArrayList<>();
    ArrayList<Animal> maleAnimal = new ArrayList<>();

    /**
     * Most of the lists below are used to avoid repeating an action, such as walking, hunting, etc.
     */
    ArrayList<Lion> listOfLion = new ArrayList<>();
    ArrayList<Wolf> listOfWolf = new ArrayList<>();
    ArrayList<Chicken> listOfChicken = new ArrayList<>();
    ArrayList<Cow> listOfCow = new ArrayList<>();
    ArrayList<Sheep> listOfSheep = new ArrayList<>();
    ArrayList<Huntsman> listOfHuntsman = new ArrayList<>();

    public Field(int height, int width) {
        field = new Animal[height][width];

    }

    //----------------------------------------------------------------------------------------------------------------------------------------

    /**
     * Field operations are operations used to test code while writing it. It is easier to observe the constant variables in the main file by making them smaller.
     */
    public void printArea(String[][] area1) {

        for (String[] row : area1) {
            for (String element : row) {
                System.out.print(String.format("%-" + Main.WIDTH + "s", element));
            }
            System.out.println();
        }

    }

    public void clearArea(String[][] area1) {
        for (int i = 0; i < Main.WIDTH; i++) {
            for (int j = 0; j < Main.HEIGHT; j++) {
                area1[i][j] = "-";
            }
        }
    }

    public void setArea(String[][] area1) {
        for (int i = 0; i < Main.WIDTH; i++) {
            for (int j = 0; j < Main.HEIGHT; j++) {
                if (field[i][j] != null) {
                    if (field[i][j].isSameSpecies(new Lion(0))) {


                        if (field[i][j].gender == 0) {
                            area1[i][j] = "ML";
                        } else {
                            area1[i][j] = "FL";
                        }
                    } else if (field[i][j].isSameSpecies(new Wolf(0))) {

                        if (field[i][j].gender == 0) {
                            area1[i][j] = "MW";
                        } else {
                            area1[i][j] = "FW";
                        }

                    } else if (field[i][j].isSameSpecies(new Huntsman())) {

                        if (field[i][j].gender == 0) {
                            area1[i][j] = "HU";
                        } else {
                            area1[i][j] = "HU";
                        }

                    } else if (field[i][j].isSameSpecies(new Sheep(0))) {


                        if (field[i][j].gender == 0) {
                            area1[i][j] = "MS";
                        } else {
                            area1[i][j] = "FS";
                        }

                    } else if (field[i][j].isSameSpecies(new Cow(0))) {


                        if (field[i][j].gender == 0) {
                            area1[i][j] = "MI";
                        } else {
                            area1[i][j] = "FI";
                        }

                    } else if (field[i][j].isSameSpecies(new Chicken(0))) {


                        if (field[i][j].gender == 0) {
                            area1[i][j] = "MC";
                        } else {
                            area1[i][j] = "FC";
                        }
                    }

                }
            }
        }
    }

    //----------------------------------------------------------------------------------------------------------------------------------------

    /**
     * Methods for the lists we use to avoid repetition when choosing parents
     */
    public void setMaleFemale() {
        for (int i = 0; i < Main.WIDTH; i++) {
            for (int j = 0; j < Main.HEIGHT; j++) {
                if (!isEmpty(i, j) && field[i][j].gender == 1) {
                    femaleAnimal.add(field[i][j]);
                } else if (!isEmpty(i, j) && field[i][j].gender == 0)
                    maleAnimal.add(field[i][j]);
            }
        }
    }

    public void clearMaleFemale() {
        maleAnimal.clear();
        femaleAnimal.clear();
    }

    //----------------------------------------------------------------------------------------------------------------------------------------

    /**
     * Methods for lists that we use to avoid repetition when performing procedures on animals
     */
    public void setList() {
        for (int i = 0; i < Main.HEIGHT; i++) {
            for (int j = 0; j < Main.WIDTH; j++) {
                if (field[i][j] != null) {
                    if (this.field[i][j].isSameSpecies(new Lion(0))) {
                        listOfLion.add((Lion) field[i][j]);
                    } else if (this.field[i][j].isSameSpecies(new Wolf(0))) {
                        listOfWolf.add((Wolf) field[i][j]);
                    } else if (this.field[i][j].isSameSpecies(new Huntsman())) {
                        listOfHuntsman.add((Huntsman) field[i][j]);
                    } else if (this.field[i][j].isSameSpecies(new Sheep(0))) {
                        listOfSheep.add((Sheep) field[i][j]);
                    } else if (this.field[i][j].isSameSpecies(new Cow(0))) {
                        listOfCow.add((Cow) field[i][j]);
                    } else if (this.field[i][j].isSameSpecies(new Chicken(0))) {
                        listOfChicken.add((Chicken) field[i][j]);
                    }
                }
            }
        }


    }

    public void clearList() {
        listOfLion.clear();
        listOfWolf.clear();
        listOfHuntsman.clear();
        listOfCow.clear();
        listOfChicken.clear();
        listOfSheep.clear();
    }

    public void printList() {
        System.out.println("\n");
        System.out.println("Lion " + listOfLion.size() + "\n" +
                "Wolf " + listOfWolf.size() + "\n" +
                "Hunter " + listOfHuntsman.size() + "\n" +
                "Cow " + listOfCow.size() + "\n" +
                "Chicken " + listOfChicken.size() + "\n" +
                "Sheep " + listOfSheep.size() + "\n");
        System.out.println("\n");
    }
    //----------------------------------------------------------------------------------------------------------------------------------------

    /**
     * Method that prints how many animals we have in the final
     */
    public void printNumberOfAnimal() {
        int numberLion = 0;
        int numberWolf = 0;
        int numberHuntsman = 0;
        int numberSheep = 0;
        int numberCow = 0;
        int numberChicken = 0;

        for (int i = 0; i < Main.WIDTH; i++) {
            for (int j = 0; j < Main.HEIGHT; j++) {
                if (field[i][j] != null) {

                    if (field[i][j].isSameSpecies(new Lion(0))) {

                        numberLion++;
                    } else if (field[i][j].isSameSpecies(new Wolf(0))) {

                        numberWolf++;

                    } else if (field[i][j].isSameSpecies(new Huntsman())) {

                        numberHuntsman++;

                    } else if (field[i][j].isSameSpecies(new Sheep(0))) {

                        numberSheep++;
                    } else if (field[i][j].isSameSpecies(new Cow(0))) {

                        numberCow++;

                    } else if (field[i][j].isSameSpecies(new Chicken(0))) {

                        numberChicken++;
                    }
                }

            }
        }

        System.out.println("\n");
        System.out.println("Final Number of Animal ");
        System.out.println("Lion number of : " + numberLion + "\n" +
                "Wolf number of : " + numberWolf + "\n" +
                "Hunter number of : " + numberHuntsman + "\n" +
                "Cow number of : " + numberCow + "\n" +
                "Chicken number of : " + numberChicken + "\n" +
                "Sheep number of : " + numberSheep + "\n");
        System.out.println("\n");
    }

    //----------------------------------------------------------------------------------------------------------------------------------------

    /**
     * The following methods are written for the operations of the animal within its field.
     */

    // The method by which we find out whether the point in the field is empty or not
    public boolean isEmpty(int x, int y) {
        return field[x][y] == null;
    }

    //method of placement in the field according to the given points
    public boolean addAnimal(int x, int y, Animal animal) {
        if (isEmpty(x, y)) {
            field[x][y] = animal;
            return true;
        } else
            return false;
    }

    //Method that deletes the animal at a given location. We use this method for animals that are hunted and killed.
    public void removeAnimal(int x, int y) {
        field[x][y] = null;

    }

    //We use this method to place all of the starting animals in random locations in the field
    public void SetAnimal(int numberOfAnimal, String animal) {
        int gender = 0;
        for (int i = 0; i < numberOfAnimal; i++) {

            int tempx = Main.random.nextInt(Main.HEIGHT);
            int tempy = Main.random.nextInt(Main.WIDTH);
            if (isEmpty(tempx, tempy)) {
                switch (animal) {
                    case "Lion":

                        addAnimal(tempx, tempy, new Lion(gender));
                        listOfLion.add((Lion) field[tempx][tempy]);
                        break;
                    case "Wolf":
                        addAnimal(tempx, tempy, new Wolf(gender));
                        listOfWolf.add((Wolf) field[tempx][tempy]);
                        break;
                    case "Huntsman":
                        addAnimal(tempx, tempy, new Huntsman());
                        listOfHuntsman.add((Huntsman) field[tempx][tempy]);
                        break;
                    case "Sheep":
                        addAnimal(tempx, tempy, new Sheep(gender));
                        listOfSheep.add((Sheep) field[tempx][tempy]);
                        break;
                    case "Chicken":
                        addAnimal(tempx, tempy, new Chicken(gender));
                        listOfChicken.add((Chicken) field[tempx][tempy]);
                        break;
                    case "Cow":
                        addAnimal(tempx, tempy, new Cow(gender));
                        listOfCow.add((Cow) field[tempx][tempy]);
                        break;
                }

            } else {
                i--;
                continue;
            }
            if (i == (numberOfAnimal / 2) - 1) {
                gender++;
            }

        }
    }

    //In this method, it is checked what type of prey the animal selected from the field is and whether it has been hunted before, and if not, the hunting method is called and it is hunted.
    public void deadAnimal(Lion lion, Wolf wolf, Huntsman huntsman) {
        for (int i = 0; i < Main.WIDTH; i++) {
            for (int j = 0; j < Main.HEIGHT; j++) {

                if (field[i][j] != null) {
                    if (field[i][j].isSameSpecies(new Lion(0)) && !listOfLion.contains(field[i][j])) {
                        listOfLion.add((Lion) field[i][j]);

                        lion.hunt(field[i][j], lion.huntRange, this, i, j);

                    } else if (field[i][j].isSameSpecies(new Wolf(0)) && !listOfWolf.contains(field[i][j])) {
                        listOfWolf.add((Wolf) field[i][j]);
                        wolf.hunt(field[i][j], wolf.huntRange, this, i, j);

                    } else if (field[i][j].isSameSpecies(new Huntsman()) && !listOfHuntsman.contains(field[i][j])) {
                        listOfHuntsman.add((Huntsman) field[i][j]);

                        huntsman.hunt(field[i][j], huntsman.huntRange, this, i, j);

                    }

                }
            }


        }


    }

    //The method where the animal is placed in the area where it is calculated where the animal should go in the moveAnimal method in the animal class.
    public void move() {
        for (int i = 0; i < Main.WIDTH; i++) {
            for (int j = 0; j < Main.HEIGHT; j++) {

                if (field[i][j] != null) {
                    if (field[i][j].isSameSpecies(new Lion(0)) && listOfLion.contains(field[i][j])) {
                        listOfLion.remove(field[i][j]);
                        field[i][j].moveAnimal(this, i, j);


                    } else if (field[i][j].isSameSpecies(new Wolf(0)) && listOfWolf.contains(field[i][j])) {
                        listOfWolf.remove(field[i][j]);
                        field[i][j].moveAnimal(this, i, j);


                    } else if (field[i][j].isSameSpecies(new Huntsman()) && listOfHuntsman.contains(field[i][j])) {
                        listOfHuntsman.remove(field[i][j]);
                        field[i][j].moveAnimal(this, i, j);


                    } else if (field[i][j].isSameSpecies(new Sheep(0)) && listOfSheep.contains(field[i][j])) {
                        listOfSheep.remove(field[i][j]);
                        field[i][j].moveAnimal(this, i, j);


                    } else if (field[i][j].isSameSpecies(new Cow(0)) && listOfCow.contains(field[i][j])) {
                        listOfCow.remove(field[i][j]);
                        field[i][j].moveAnimal(this, i, j);


                    } else if (field[i][j].isSameSpecies(new Chicken(0)) && listOfChicken.contains(field[i][j])) {
                        listOfChicken.remove(field[i][j]);
                        field[i][j].moveAnimal(this, i, j);


                    }
                }
            }
        }
    }

    //In this method, we find the female animal in the area, and if this female animal has not previously mated, we create a new animal.
    // We check if there is an empty space around the female animal within 1 unit, if not, we check within 2 units, and if there is still no room, we continue checking in increments of 1 unit.
    // Prioritizing the nearest surroundings, we randomly create the new animal in one of the empty spaces.
    public void birth() {
        setMaleFemale();
        int k = 1;
        int count = 0;

        ArrayList<Integer> cordinateX = new ArrayList<>();
        ArrayList<Integer> cordinateY = new ArrayList<>();

        for (int i = 0; i < Main.WIDTH; i++) {
            for (int j = 0; j < Main.HEIGHT; j++) {
                if (field[i][j] != null && field[i][j].gender == 1) {
                    Animal animal = field[i][j];

                    if (femaleAnimal.contains(animal) && animal.isBirthable(this, i, j, field[i][j])) {
                        for (int m = (i - k); m <= (i + k); m++) {
                            for (int l = (j - k); l <= (j + k); l++) {

                                if (Main.WIDTH > m && Main.WIDTH > l && m >= 0 && l >= 0) {

                                    if (field[m][l] != null && field[m][l].equals(animal)) {
                                        continue;
                                    }
                                    if (isEmpty(m, l)) {

                                        cordinateX.add(m);
                                        cordinateY.add(l);
                                        count++;


                                    }


                                }

                            }

                        }

                    }
                    if (count > 0) {
                        int rand = Main.random.nextInt(count);

                        int newAnimalX = cordinateX.get(rand);
                        int newAnimalY = cordinateY.get(rand);
                        int gender = Main.random.nextInt(2);

                        if (this.field[i][j].isSameSpecies(new Lion(0))) {
                            addAnimal(newAnimalX, newAnimalY, new Lion(gender));

                        } else if (this.field[i][j].isSameSpecies(new Wolf(0))) {
                            addAnimal(newAnimalX, newAnimalY, new Wolf(gender));

                        } else if (this.field[i][j].isSameSpecies(new Sheep(0))) {
                            addAnimal(newAnimalX, newAnimalY, new Sheep(gender));

                        } else if (this.field[i][j].isSameSpecies(new Cow(0))) {
                            addAnimal(newAnimalX, newAnimalY, new Cow(gender));

                        } else if (this.field[i][j].isSameSpecies(new Chicken(0))) {
                            addAnimal(newAnimalX, newAnimalY, new Chicken(gender));
                        }


//                                addAnimal(newAnimalX, newAnimalY, new Lion(gender));
                        cordinateX.clear();
                        cordinateY.clear();
                        count = 0;

                    }

                }
            }


//

        }


//    public void newBirthkonumu(int x, int y, Animal femaleAnimal) {
//        int k = 1;
//        int x=femaleAnimal.
//        ArrayList<Animal> emptyField = new ArrayList<>();
//        ArrayList<Integer> xLocation = new ArrayList<>();
//        ArrayList<Integer> yLocation = new ArrayList<>();
//
//        for (int i = (x - k); i <= (x + k); i++) {
//            for (int j = (y - k); j <= (y + k); j++) {
//
//                if (Main.WIDTH > i && Main.WIDTH > j && i >= 0 && j >= 0) {
//                    if (femaleAnimal.isFemaleAnimal(field[i][j])){
//
//                    }
//                    if (field[i][j].equals(femaleAnimal)) {
//                        continue;
//                    }
//                    if (isEmpty(i, j)&& ) {
//                        xLocation.add(i);
//                        yLocation.add(j);
//                        emptyField.add(field[i][j]);
//                        addAnimal(i, j, femaleAnimal);
//                    }
//                }
//                if (i == (x + k) && xLocation.isEmpty()) {
//                    k++;
//                }
//            }
//        }
//        int realLocation = Main.random.nextInt(xLocation.size());
//        int newX = xLocation.get(realLocation);
//        int newY = yLocation.get(realLocation);
//        addAnimal(newX, newX, femaleAnimal);
//
////        Animal hunt=emptyField.get(niceLocation);
//
//
//
//
//
//
//
//}
//


    }
}



