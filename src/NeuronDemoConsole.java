import java.util.Scanner;

import components.neuron.Neuron;
import components.neuron.Neuron1;

/**
 * Very simple implementation of the methods in the Artificial Neuron component.
 * This demo uses the console as the source of input/output.
 *
 * @author Grace Metz
 *
 */
public final class NeuronDemoConsole {

        /**
         * To prevent instantiation.
         */
        private NeuronDemoConsole() {
        }

        /**
         * Main.
         *
         * @param args
         */
        public static void main(String[] args) {
                // Decide whether today is a good day to go windsurfing
                // (conditions should be sunny and windy)

                Scanner in = new Scanner(System.in);

                Neuron windsurfingDecider = new Neuron1();

                System.out.println(
                                "Please enter a word that describes today's weather: ");
                windsurfingDecider.setInput(in.nextLine());
                System.out.println(
                                "Please enter how good that condition is for windsurfing (-1 to 1): ");
                windsurfingDecider.setWeight(Double.parseDouble(in.nextLine()));

                System.out.println("Enter another word? (y/n): ");
                String loop = in.nextLine();

                while (loop.equals("Y")) {
                        System.out.println(
                                        "Please enter a word that describes today's weather: ");
                        windsurfingDecider.setInput(in.nextLine());
                        System.out.println(
                                        "Please enter how good that condition is for windsurfing (-1 to 1): ");
                        windsurfingDecider.setWeight(
                                        Double.parseDouble(in.nextLine()));
                        System.out.println("Enter another word? (y/n): ");
                        loop = in.nextLine();
                }

                System.out.println("Today is a good day for windsurfing: ");
                System.out.println(windsurfingDecider.activate());

                in.close();
        }
}
