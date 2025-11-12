/**
 * Interface for additional methods within the Artificial Neuron component.
 *
 * @author Grace Metz
 *
 */
public interface NeuronSecondary extends NeuronKernel {

    /**
     * Using the sigmoid activation function: an output >= 0.5 means a yes, or
     * the neuron has fired.
     *
     * @return whether the neuron has fired.
     */
    boolean activate();

    /**
     * Set an object's weight and ensure they are usable by the neuron.
     *
     * @param value
     *            the weight being entered
     */
    void setWeight(int value);

    /**
     * Sum the weights.
     *
     * @return the sum of the weights.
     */
    int sum();

}
