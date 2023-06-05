
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //создаём "коробку" вручную через консоль:
        Toy[] box1 = new Toy[3];
        for (int i = 0; i < 3; i++){
            box1[i] = makeToy();
        }

        //создаём еще 2 коробки сразу, чтоб много не писать:
        Toy[] box2 = new Toy[3];
        box2[0] = new Toy(4, "Собачка", 1);
        box2[1] = new Toy(5, "Пирамидка", 2);
        box2[2] = new Toy(6, "Машинка", 3);

        Toy[] box3 = new Toy[3];
        box3[0] = new Toy(7,  "Домик", 3);
        box3[1] = new Toy(8, "Барби", 1);
        box3[2] = new Toy(9, "Пазл", 2);

        //кладём каждую коробку в свою очередь с приоритетностью по частоте выпадения:
        PriorityQueue queue1 = new PriorityQueue(Comparator.comparingInt(Toy::getFrequency));
        for (Toy toy: box1) {
            queue1.add(toy);
        }
        PriorityQueue queue2 = new PriorityQueue(Comparator.comparingInt(Toy::getFrequency));
        for (Toy item: box2) {
            queue2.add(item);
        }
        PriorityQueue queue3 = new PriorityQueue(Comparator.comparingInt(Toy::getFrequency));
        for (Toy toy: box3) {
            queue3.add(toy);
        }

        PriorityQueue allQueue = new PriorityQueue(Comparator.comparingInt(Toy::getFrequency).reversed());
        allQueue.addAll(queue1);
        allQueue.addAll(queue2);
        allQueue.addAll(queue3);


        //на всякий случай печатаем для проверки:
        System.out.println("В ОЧЕРЕДИ СЕЙЧАС:");
        for (Object item: allQueue) {
            System.out.println(item.toString());
        }

        //Создаём файл и записываем в него:
        int size = allQueue.size();
        try (PrintWriter writer = new PrintWriter(new FileWriter("toys.txt"))){
            for (int i = 0; i < size; i++) {
                Toy toy = (Toy) allQueue.poll();
                writer.printf("%d %d %s\n", (i+1), toy.getFrequency(), toy.getName());
            }
        } catch (IOException e){
            System.out.println("Ошибка записи в файл: "+ e.getMessage());

        }

    }

    public static Toy makeToy(){
        Scanner sc = new Scanner(System.in);
        String userIn;

        while(true) {
            System.out.println("Введите данные через запятую.\nID, Название, Вес\nВаш ввод:_");
            userIn = sc.nextLine();
            String[] toyInfo = userIn.split(", ");

            if (toyInfo.length !=3) {
                System.out.println("Неверное количество данных, введите еще раз");
                continue;
            }

            try {
                int id = Integer.parseInt(toyInfo[0]);
                String name = toyInfo[1].trim();
                int frequency = Integer.parseInt(toyInfo[2]);
                Toy toy = new Toy(id, name, frequency);
                return toy;
            } catch (NumberFormatException e) {
                System.out.println("Неверный формат данных, введите еще раз");
            }
        }
    }
    
}
