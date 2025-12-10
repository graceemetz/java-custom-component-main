package components.neuron;

import components.queue.Queue;
import components.queue.Queue1L;

/**
 * Interface for additional methods within the Artificial Neuron component.
 *
 * @author Grace Metz
 *
 */
public abstract class NeuronSecondary implements Neuron {

    /**
     * Queue of Strings to represent the values of each input.
     */
    private Queue<String> inputs = new Queue1L<String>();

    /**
     * Queue of values to represent the weights of each input.
     */
    private Queue<Double> weights = new Queue1L<Double>();

    /**
     * Using the sigmoid activation function: an output >= 0.5 means a yes, or
     * the neuron has fired.
     *
     * @requires {@code |this.weights| >= 0 && |this.inputs| >= 0}
     * @ensures {@code <activate> = true || false}
     * @return whether the neuron has fired.
     */
    @Override
    public boolean activate() {
        double s = 1.0 / (1.0 + Math.exp(this.sum()));
        boolean fired = false;

        if (s >= 0.5) {
            fired = true;
        }

        return fired;
    }

    /**
     * Set an object's weight and ensure they are usable by the neuron.
     *
     * @param value
     *            the weight being entered
     * @requires {@code -1 <= value <= 1}
     * @ensures {@code this.weights = #this.weights * #value}
     */
    @Override
    public void setWeight(double value) {
        assert value >= -1 && value <= 1;
        this.weights.enqueue(value);
    }

    /**
     * Sum the weights.
     *
     * @return the sum of the weights.
     */
    @Override
    public double sum() {
        double sum = 0;
        double weight = 0;
        if (this.weights.length() > 0) {
            weight = this.weights.dequeue();
            sum = this.sum() + weight;
        }
        this.weights.enqueue(weight);

        return sum;
    }

    /**
     * Return the data in the Neuron component as a String.
     *
     * @return the String representing the Neuron.
     */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("Neuron [weights=");
        result.append(this.weights.toString());
        result.append("]");
        result.append("[inputs=");
        result.append(this.inputs.toString());
        result.append("]");
        return result.toString();
    }

    /**
     * Return whether or not this equals an object.
     *
     * @return whether this equals an object.
     */
    @Override
    public boolean equals(Object o) {
        Neuron object = this.newInstance();

        if (!(o == null || this.getClass() != o.getClass())) {
            object = (Neuron) o;
        }

        return this.weights.equals(object.weights())
                && this.inputs.equals(object.inputs())
                && this.weights.length() == object.weights().length()
                && this.inputs.length() == object.inputs().length();
    }
}
