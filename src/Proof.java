import java.util.ArrayList;
import java.util.Scanner;

/**
 * Very simple implementation of the methods in the Artificial Neuron component.
 *
 * @author Grace Metz
 *
 */
public final class Proof {

    /**
     * To prevent instantiation.
     */
    private Proof() {
    }

    /**
     * Ensure that inputs are valid and usable by the neuron.
     *
     * @param inputs
     *            the list of inputs
     * @param input
     *            the String being entered
     */
    public static void setInput(ArrayList<String> inputs, String input) {
        if (!input.equals(" ") && !input.isEmpty() && input.length() > 1) {
            inputs.add(input);
        } else {
            System.out.println("Input must be a word.");
        }
    }

    /**
     * Set all weights and ensure they are usable by the neuron.
     *
     * @param weights
     *            the list of weights
     * @param weight
     *            the weight being entered
     */
    public static void setWeight(ArrayList<Double> weights, double weight) {
        if (weight >= -1 && weight <= 1) {
            weights.add(weight);
        } else {
            System.out.println("Weight must be between -1 and 1.");
        }

    }

    /**
     * Sum the weights.
     *
     * @param weights
     *            the list of weights
     *
     * @return the sum of the weights
     */
    public static double sum(ArrayList<Double> weights) {
        double sum = 0;

        for (int i = 0; i < weights.size(); i++) {
            sum = sum + weights.get(i);
        }

        return sum;
    }

    /**
     * Using the sigmoid activation function: an output >= 0.5 means a yes, or
     * the neuron has fired.
     *
     * @param sum
     *            the sum of the weights
     *
     * @return whether the neuron has fired.
     */
    public static boolean activate(double sum) {
        double s = 1.0 / (1.0 + Math.exp(-sum));
        boolean fired = false;

        if (s >= 0.5) {
            fired = true;
        }

        return fired;
    }

    /**
     * Main.
     *
     * @param args
     */
    public static void main(String[] args) {
        // Decide whether today is a good day to go windsurfing
        // (conditions should be sunny and windy)
        // Using methods setWeight, setInput, activate, and sum

        Scanner in = new Scanner(System.in);

        ArrayList<String> words = new ArrayList<>();
        ArrayList<Double> importance = new ArrayList<>();

        System.out.println(
                "Please enter a word that describes today's weather: ");
        String word = in.nextLine();
        setInput(words, word);
        System.out.println(
                "Please enter how good that condition is for windsurfing (-1 to 1): ");
        setWeight(importance, Double.parseDouble(in.nextLine()));
        System.out.println("Enter another word? (y/n): ");
        String loop = in.nextLine();

        while (loop.equals("Y")) {
            System.out.println(
                    "Please enter a word that describes today's weather: ");
            word = in.nextLine();
            setInput(words, word);
            System.out.println(
                    "Please enter how good that condition is for windsurfing (-1 to 1): ");
            setWeight(importance, Double.parseDouble(in.nextLine()));
            System.out.println("Enter another word? (y/n): ");
            loop = in.nextLine();
        }

        double total = sum(importance);

        System.out.println("Today is a good day for windsurfing: ");
        System.out.println(activate(total));

        in.close();
    }
}
