import components.queue.Queue;
import components.queue.Queue1L;
import components.standard.Standard;

/**
 * Interface for the essential methods and values within the Artificial Neuron
 * component.
 *
 * @author Grace Metz
 *
 */
public interface NeuronKernel extends Standard<Neuron> {

    /**
     * Queue of Strings to represent the values of each input.
     */
    Queue<String> inputs = new Queue1L<>();

    /**
     * Queue of values to represent the weights of each input.
     */
    Queue<Double> weights = new Queue1L<>();

    /**
     * Retrieve the weight assigned to the inputs within this node.
     *
     * @return the queue of weight values
     */
    Queue<Double> weights();

    /**
     * Return the inputs entered into the neuron.
     *
     * @return the queue of input Strings
     */
    Queue<String> inputs();

    /**
     * Ensure that inputs are valid and usable by the neuron.
     *
     * @param value
     *            the String value being entered
     */
    void setInput(String value);

}
