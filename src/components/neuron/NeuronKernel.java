package components.neuron;

import components.queue.Queue;
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
     * Retrieve the weight assigned to the inputs within this node.
     *
     * @requires {@code |weights| >= 0}
     * @ensures {@code <weights> = weights}
     * @return the queue of weight values
     */
    Queue<Double> weights();

    /**
     * Return the inputs entered into the neuron.
     *
     * @requires {@code |inputs| >= 0}
     * @ensures {@code <inputs> = inputs}
     * @return the queue of input Strings
     */
    Queue<String> inputs();

    /**
     * Ensure that inputs are valid and usable by the neuron.
     *
     * @param value
     *            the String value being entered
     * @requires {@code <value> != null}
     * @ensures {@code <inputs> = #inputs * #value}
     */
    void setInput(String value);

}
