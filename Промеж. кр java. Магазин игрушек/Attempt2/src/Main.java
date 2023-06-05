import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //создали объекты игрушки:
        Toy toy1 = new Toy(1,3,"Мишка");
        Toy toy2 = new Toy(2, 2, "Конструктор");
        Toy toy3 = new Toy(3, 1, "Волшебная палочка");

        Toy toy4 = new Toy(4, 1, "Собачка");
        Toy toy5 = new Toy(5, 2, "Пирамидка");
        Toy toy6 = new Toy(6, 3, "Машинка");

        Toy toy7 = new Toy(7, 3, "Домик");
        Toy toy8 = new Toy(8, 2, "Барби");
        Toy toy9 = new Toy(9, 1, "Пазл");

        Toy[] stockroom = new Toy[]{toy1, toy2, toy3, toy4, toy5, toy6, toy7, toy8, toy9};

        //разместили игрушки по коробам:
        List<String> box1 = new ArrayList<>();

        List<Toy> checkArr = new ArrayList<>();
        while (checkArr.size() < stockroom.length){
            for (int i = 0; i < stockroom.length; i++) {
                Toy toy = getToy(stockroom);
                if (!(checkArr.contains(stockroom[i]))) {
                    String myStr = "" + toy.getId() + " " + toy.getFrequency();
                    box1.add(myStr);
                }
            }
        }

        //выводим собержимое коробки в консоль:
        System.out.println(box1.toString());


    }
//    public static String shortInfo(Toy[] stockroom){
//        Toy toy = getToy(stockroom);
//
//    }
    public static void print(String[] box) {
        for (String item: box) {
            System.out.println(item);
        }
    }
    public static Toy getToy(Toy[] box) { //получаем игрушки относительно %-ов вероятности
        int randNum = (int) (Math.random() * 10) + 1;
        if (randNum <= 6) {
            for (Toy toy: box) {
                if (toy.getFrequency() == 3) {
                    return toy;
                }
            }
        }
        if (randNum > 6 && randNum <= 8) {
            for (Toy toy: box) {
                if (toy.getFrequency() == 2) {
                    return toy;
                }
            }
        }
        if (randNum > 8 && randNum <= 10) {
            for (Toy toy: box) {
                if (toy.getFrequency() == 1) {
                    return toy;
                }
            }
        }
        return null;
    }
}