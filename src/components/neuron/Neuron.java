package components.neuron;

/**
 * Interface for additional methods within the Artificial Neuron component.
 *
 * @author Grace Metz
 *
 */
public interface Neuron extends NeuronKernel {

    /**
     * Using the sigmoid activation function: an output >= 0.5 means a yes, or
     * the neuron has fired.
     *
     * @requires {@code |this.weights| >= 0 && |this.inputs| >= 0}
     * @ensures {@code <activate> = true || false}
     * @return whether the neuron has fired.
     */
    boolean activate();

    /**
     * Set an object's weight and ensure that it is usable by the neuron.
     *
     * @param value
     *            the weight being entered
     * @requires {@code -1 <= value <= 1}
     * @ensures {@code this.weights = #this.weights * #value}
     */
    void setWeight(double value);

    /**
     * Sum the weights.
     *
     * @requires {@code |this.weights| >= 0}
     * @ensures {@code sum = this.weights[0] + ... + this.weights[|this.weights|]}
     * @return the sum of the weights.
     */
    double sum();

}
