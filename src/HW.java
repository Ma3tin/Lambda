import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HW {
    public static void main(String[] args) {
        System.out.print("Zadej čísla: ");
        Scanner sc = new Scanner(System.in);
        Stream numbers = readNumbers();
        printMenu();
        int choiceNumber = Integer.parseInt(sc.nextLine());
        switch (choiceNumber) {
            case 1:
                taskOne(numbers);
                break;
            case 2:
                taskTwo(numbers);
                break;
            case 3:
                taskThree(numbers);
                break;
            case 4:
                taskFour(numbers);
                break;
            case 5:
                taskFive(numbers);
                break;
            case 6:
                taskSix(numbers);
                break;
        }
    }

    static Stream<Integer> readNumbers() {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        List<String> numbers = Arrays.asList(input.split(" "));
        return numbers.stream().map(s -> Integer.valueOf(s));
    }

    static void taskOne(Stream<Integer> nbrs) {
        System.out.println(nbrs.filter((i) -> i % 11 == 0).collect(Collectors.toList()));
    }

    static void taskTwo(Stream<Integer> nbrs) {
        System.out.println(nbrs.filter((i) -> (i * i * i) % 10 == 3).collect(Collectors.toList()));
    }

    static void taskThree(Stream<Integer> nbrs) {
        System.out.println(nbrs.map((i) -> i * i).collect(Collectors.toList()));
    }

    static void taskFour(Stream<Integer> nbrs) {
        System.out.println(nbrs.map((i) -> Math.round((((double) i) * 0.8) / 10) * 10).collect(Collectors.toList()));
    }

    static void taskFive(Stream<Integer> nbrs) {
        System.out.println(nbrs.reduce(1, (i, j) -> i * j));
    }

    static void taskSix(Stream<Integer> nbrs) {
        System.out.println(nbrs.reduce(0, (i, j) -> i + j));
    }

    static void printMenu() {
        System.out.println("Co chcete s čísli udělat?");
        System.out.println("1) Vypsat všechna čísla dělitelná 11");
        System.out.println("2) Vypsat všechna čísla, jejichž třetí mocnina končí na znak \"3\"");
        System.out.println("3) Vypsat dvojnásobky všech čísel");
        System.out.println("4) Vypsat 80 % z každého čísla zaokrouhlenou na nejbližší desítku nahoru");
        System.out.println("5) Vypsat produkt všech čísel");
        System.out.println("6) Vypsat sumu všech čísel");
    }
}
