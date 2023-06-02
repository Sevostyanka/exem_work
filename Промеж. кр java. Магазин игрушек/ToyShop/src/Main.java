import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        //создали объекты игрушки
        Toy toy1 = new Toy(1, "Мишка", 2);
        Toy toy2 = new Toy(2, "Кукла", 3);
        Toy toy3 = new Toy(3, "Точилка", 1);
        Toy toy4 = new Toy(4, "Шарик", 1);
        Toy toy5 = new Toy(5, "Львёнок", 2);
        Toy toy6 = new Toy(6, "Барби", 3);
        Toy toy7 = new Toy(7, "Машинка", 2);
        Toy toy8 = new Toy(8, "Пазл", 1);
        Toy toy9 = new Toy(9, "Часы", 3);

        // создали три массива с игрушками
        Toy[] box1 = new Toy[] {toy1, toy2, toy3};
        Toy[] box2 = new Toy[] {toy4, toy5, toy6};
        Toy[] box3 = new Toy[] {toy7, toy8, toy9};

        //сюда будем скидывать отсортированные игрушки
        PriorityQueue <Toy> mainBox = new PriorityQueue<>();

        //сортируем игрушки по весу относительно случайности выпадения

        sortToys(box1, mainBox);
        sortToys(box2, mainBox);
        sortToys(box2, mainBox);

        //распечатаем, что в очереди, чтоб посмотреть... и ОШИБКА! Почему?
        for (Toy item: mainBox) {
            System.out.println(item);
        }

    }
    public static void sortToys(Toy [] box, PriorityQueue <Toy> mainBox) {
        List<Toy> checkArr = new ArrayList<>();
        for (int i = 0; i <3; i++) {
            Toy item = getToy(box);
            if (!(checkArr.contains(item))){
                checkArr.add(item);
                mainBox.add(item);
            }
        }
    }
    public static Toy getToy(Toy[] box) {
        int randNum = (int) (Math.random() * 10) + 1;
        if (randNum <= 6) {
            for (Toy toy: box) {
                if (toy.getWeight() == 3) {
                    return toy;
                }
            }
        }
        if (randNum > 6 && randNum <= 8) {
            for (Toy toy: box) {
                if (toy.getWeight() == 3) {
                    return toy;
                }
            }
        }
        if (randNum > 8 && randNum <= 10) {
            for (Toy toy: box) {
                if (toy.getWeight() == 3) {
                    return toy;
                }
            }
        }
        return null;
    }

}