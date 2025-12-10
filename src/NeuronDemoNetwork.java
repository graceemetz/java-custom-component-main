import components.map.Map;
import components.map.Map1L;
import components.neuron.Neuron;
import components.neuron.Neuron1;

/**
 * Demonstration of how multiple neurons may interact, using a {@code Map} for
 * input.
 *
 * A library is trying to decide whether or not they should get rid of a section
 * of books. They've condensed each section into the books' titles and weights
 * representing their ratings.
 *
 * A very small neural network will determine whether or not they should get rid
 * of one, or multiple, section(s).
 *
 * @author Grace Metz
 *
 */
public final class NeuronDemoNetwork {

        /**
         * To prevent instantiation.
         */
        private NeuronDemoNetwork() {
        }

        /**
         * Populate a Neuron object with inputs and weights from a Map.
         *
         * @param section
         *                the map of inputs and weights
         * @requires {@code |section| >= 0}
         * @ensures {@code populateNeurons =
         * the corresponding Neuron with inputs and weights populated}
         * @return a Neuron with inputs and weights populated according to the
         *         section Map
         */
        public static Neuron populateNeurons(Map<String, Double> section) {
                Neuron sectionNeuron = new Neuron1();

                for (Map.Pair<String, Double> pair : section) {
                        sectionNeuron.setInput(pair.key());
                        sectionNeuron.setWeight(pair.value());
                }

                return sectionNeuron;
        }

        /**
         * Main.
         *
         * @param args
         */
        public static void main(String[] args) {
                Map<String, Double> section1 = new Map1L<>();
                Map<String, Double> section2 = new Map1L<>();
                Map<String, Double> section3 = new Map1L<>();

                // For the sake of this example, three titles were chosen at
                // random from each section, along with their ratings,
                // in order to make this decision
                String[] section1Titles = { "Lord of the Rings", "Harry Potter",
                                "Wildwood" };
                String[] section2Titles = { "The Great Gatsby",
                                "The Catcher in the Rye", "1984" };
                String[] section3Titles = {
                                "Do Androids Dream of Electric Sheep?",
                                "Bladerunner", "The Hunger Games" };

                double[] section1Weights = { 0.5, 1, -0.2 };
                double[] section2Weights = { 0.1, -0.1, 0.2 };
                double[] section3Weights = { 0.3, 0.7, 0.9 };

                for (int i = 0; i < section1Titles.length; i++) {
                        section1.add(section1Titles[i], section1Weights[i]);
                        section2.add(section2Titles[i], section2Weights[i]);
                        section3.add(section3Titles[i], section3Weights[i]);
                }

                Neuron neuronOne = populateNeurons(section1);
                Neuron neuronTwo = populateNeurons(section2);
                Neuron neuronThree = populateNeurons(section3);

                System.out.println("Should we get rid of a section?: ");
                if (neuronOne.activate() && neuronTwo.activate()
                                && neuronThree.activate()) {
                        System.out.print("No");
                } else {
                        System.out.print("Yes");
                }
        }
}
