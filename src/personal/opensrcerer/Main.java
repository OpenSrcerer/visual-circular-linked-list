/*
 * Made for the Project in CS215, due November 22nd 2021.
 * This work is licensed under the GNU General Public License v3.0
 * GNU © 2021 Daniel Stefani / OpenSrcerer
 */

package personal.opensrcerer;

import personal.opensrcerer.circularList.CircularLinkedList;
import personal.opensrcerer.entities.Suicider;
import personal.opensrcerer.entities.SuiciderCircularLinkedList;
import personal.opensrcerer.util.NameGenerator;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * The main class for the program.
 */
public class Main {
    /**
     * The Buffered Input Stream to be used for input.
     */
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    /**
     * Default main method.
     * @param args Arguments for default main method.
     */
    public static void main(String[] args) {
        runProgram();
    }

    /**
     * The method that takes in input and executes
     * the relevant method of the list.
     */
    private static void runProgram() {
        System.out.print("""
                Welcome to Kitsos' life-saving program.
                Please begin by entering the number of individuals
                that will commit suicide:
                """);
        int suiciders = getNumberInput(true);
        System.out.print("""
                Great! Now please insert the magic number you have
                chosen for the suicides:
                """);
        int magicNumber = getNumberInput(false);

        CircularLinkedList<Suicider> list = new CircularLinkedList<>();
        for (int i = 1; i <= suiciders; ++i) {
            list.add(new Suicider(i, ""));
        }
        // Run the program initially once to get Kitsos' position for name display
        int kitsosPosition = list.removeUntilLast(magicNumber).getPosition();

        list = new SuiciderCircularLinkedList();
        for (int i = 1; i <= suiciders; ++i) {
            if (i == kitsosPosition) {
                list.add(new Suicider(i, "Kitsos"));
                continue;
            }
            list.add(new Suicider(i, NameGenerator.getRandomName()));
        }
        System.out.println("The position Kitsos should stay in is: "
                + list.removeUntilLast(magicNumber).getPosition());
    }

    /**
     * A wrapper method to handle exceptions and parse numbers.
     * @param suiciders Whether the method is parsing the number of suiciders.
     * @return A parsed integer.
     */
    private static int getNumberInput(boolean suiciders) {
        int parsedInput = 0;
        while (parsedInput <= 0) {
            try {
                parsedInput = Integer.parseInt(br.readLine());

                if (suiciders && parsedInput == 1) {
                    System.out.println("Why don't you just run away then?");
                    throw new NumberFormatException();
                }

                if (suiciders && parsedInput > 200) {
                    System.out.println("The number of suiciders is limited to 200 due to name generation limitations.");
                    throw new NumberFormatException();
                }
            } catch (Exception ex) {
                parsedInput = 0;
                System.out.println("Please try again, but enter a valid integer this time.");
            }
        }
        return parsedInput;
    }
}
