import java.util.*;

public class Fikstur {

    Scanner scanner = new Scanner(System.in);
    ArrayList<String> list = new ArrayList<>();

    public void run() {
        System.out.print("Enter the number of teams : ");
        int a = scanner.nextInt();


        for (int i = 0; i < a; i++) {
            String team = scanner.next();
            list.add(team);
        }


        System.out.println("**********************************************");
        System.out.println("Teams");
        for (String team : list) {

            System.out.println(" * " + team);
        }
        if (a % 2 != 0) {
            list.add("Bay");
            a++;
        }
        System.out.println("**********************************************");
        int round = a - 1;
        int mac = a / 2;
        Collections.shuffle(list);


        for (int i = 1; i <= round; i++) {
            System.out.println(i + " Round");

            System.out.println(list.get(0) + " VS " + list.get(list.size() / 2));
            for (int j = 1; j < mac; j++) {
                System.out.println(list.get(j) + " VS " + list.get(list.size() - j));


            }
            System.out.println("**********************************************");
            ArrayList<String> newList = new ArrayList<>(list.size());
            newList.add(list.get(0));
            newList.add(list.get(list.size() - 1));

            for (int j = 1; j <= list.size() - 2; j++) {
                newList.add(list.get(j));
            }
            list = newList;


        }


    }


}

