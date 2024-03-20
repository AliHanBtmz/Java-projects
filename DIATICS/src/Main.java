import java.util.Random;

class Main {
    // Gender  0=Male  -    1=Female
    protected static Random random = new Random();
    private static final int STOP_CONDITION = 1000;
    public static int stepNumber = 0;
    protected static final int WIDTH = 500;
    protected static final int HEIGHT = 500;
    private static final int NUM_SHEEP = 30;
    private static final int NUM_COW = 10;
    private static final int NUM_CHICKEN = 20;
    private static final int NUM_LION = 8;
    private static final int NUM_WOLF = 10;
    private static final int NUM_HUNTER = 1;

    /**
     * The following data is the data used to test the code
     */

//    private static final int NUM_CHICKEN = 2;
//    private static final int NUM_SHEEP = 2;
//    private static final int NUM_COW = 2;
//    private static final int NUM_LION = 2;
//    private static final int NUM_WOLF = 2;
//    private static final int NUM_HUNTER = 1;
    public static void main(String[] args) {

        Field field1 = new Field(HEIGHT, WIDTH);

        String[][] area1 = new String[WIDTH][HEIGHT];//The double String array I wrote to visually examine

        //I initially filled area with (-)
        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT; j++) {
                if (area1[i][j] == null) {
                    area1[i][j] = "-";
                }
            }
        }

        /** Objects created for object control*/
        Huntsman huntsman = new Huntsman();
        Wolf wolf = new Wolf(0);
        Lion lion = new Lion(0);


        /** Placement procedures **/

        field1.SetAnimal(NUM_HUNTER, "Huntsman");
        field1.SetAnimal(NUM_WOLF, "Wolf");
        field1.SetAnimal(NUM_LION, "Lion");
        field1.SetAnimal(NUM_COW, "Cow");
        field1.SetAnimal(NUM_SHEEP, "Sheep");
        field1.SetAnimal(NUM_CHICKEN, "Chicken");

//------------------------------------------------------------------------------------------------------------------------------

        field1.setArea(area1);
        System.out.println("First View");
        /**Activating this area will give more effective results when the height and width values are small. */
//      field1.printArea(area1);
        field1.clearArea(area1);
        field1.printList();

        /**   Move işleminin yapıldığı yer*/

        while (stepNumber < STOP_CONDITION) {

            System.out.println("Move View");
            field1.move();
            field1.setArea(area1);
            /**Activating this area will give more effective results when the height and width values are small. */
//          field1.printArea(area1);
            field1.clearArea(area1);
            field1.setList();
            field1.printList();
            field1.clearList();
            System.out.println("////////////////////////////////////////////////////////////////");


            System.out.println("Hunt View");
            field1.deadAnimal(lion, wolf, huntsman);
            field1.setArea(area1);
            /**Activating this area will give more effective results when the height and width values are small. */
//          field1.printArea(area1);
            field1.clearList();
            field1.setList();
            field1.printList();
            System.out.println("////////////////////////////////////////////////////////////////");


            System.out.println("Birth View");
            field1.birth();
            field1.clearMaleFemale();
            field1.setArea(area1);
            /**Activating this area will give more effective results when the height and width values are small. */
//          field1.printArea(area1);
            field1.clearArea(area1);
            field1.clearList();
            field1.setList();
            field1.printList();

            System.out.println("////////////////////////////////////////////////////////////////");
            System.out.println(stepNumber);


        }
        field1.printNumberOfAnimal();

    }
}