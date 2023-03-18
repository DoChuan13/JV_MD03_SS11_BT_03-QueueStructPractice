import customUtils.ConsoleColors;
import customUtils.InputMethod;
import queuePractice.Queue;

import java.util.Scanner;

public class main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.enQueue(10);
        System.out.println(ConsoleColors.GREEN + "Queue first element=>> " + ConsoleColors.RESET);
        queue.displayQueue();
        queue.enQueue(20);
        System.out.println(ConsoleColors.GREEN + "Queue after 2 elements=>> " + ConsoleColors.RESET);
        queue.displayQueue();
        queue.enQueue(30);
        queue.enQueue(40);
        queue.enQueue(50);
        System.out.println(ConsoleColors.GREEN + "Queue after 5 elements=>> " + ConsoleColors.RESET);
        queue.displayQueue();
        System.out.println("Delete first " + queue.deQueue());
        System.out.println(ConsoleColors.YELLOW + "Queue after delete 1 element=>> " + ConsoleColors.RESET);
        queue.displayQueue();
        System.out.println("Delete second " + queue.deQueue());
        System.out.println(ConsoleColors.YELLOW + "Queue after delete 2 elements=>> " + ConsoleColors.RESET);
        queue.displayQueue();
        System.out.println("Delete third " + queue.deQueue());
        System.out.println("Delete four " + queue.deQueue());
        System.out.println("Delete five " + queue.deQueue());
        System.out.println(ConsoleColors.YELLOW + "Queue after delete more 3 elements=>> " + ConsoleColors.RESET);
        queue.displayQueue();

        System.out.println("Press any key to out of range...");
        InputMethod.getString();
        System.out.println("----------------------Out of Range----------------------");
        System.out.println("Delete six " + queue.deQueue());
    }
}
