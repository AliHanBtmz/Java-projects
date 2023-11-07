import java.io.*;

public class gameRecord {
    public static void gameRecord(Card[][] cards){

        try (ObjectOutputStream out =new ObjectOutputStream(new FileOutputStream("kayıt.bin"))){

            System.out.println("the game is being saved...");


            out.writeObject(cards);




        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static Card[][] uploadRecording(){
        try (ObjectInputStream in=new ObjectInputStream(new FileInputStream("kayıt.bin"))){

            Card[][] çıktı=(Card[][]) in.readObject();
            return çıktı;

        } catch (FileNotFoundException e) {

            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
