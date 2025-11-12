/**
 * Layered implementations of secondary methods for {@code Neuron}.
 */
public abstract class NeuronSecondary implements Neuron {

    /**
     * Using the sigmoid activation function: an output >= 0.5 means a yes, or
     * the neuron has fired.
     *
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
     * Enter a weight to be used by the neuron.
     *
     * @param value
     *            the weight being entered
     */
    @Override
    public void setWeight(double value) {
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
     * Return the data in the Neuron component as a string.
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

        return this.weights.equals(object.weights)
                && this.inputs.equals(object.inputs);
    }
}
