import components.queue.Queue;
import components.queue.Queue1L;

/**
 * {@code Neuron} represented as multiple {@link Queue}s with implementations of
 * primary methods.
 *
 * @convention [$this.inputs is a queue of String inputs] and [$this.weights is
 *             a queue of double weights]
 * @correspondence this = ($this.inputs, $this.weights)
 */
public class Neuron1 extends NeuronSecondary {

    /**
     * Queue of Strings to represent the values of each input.
     */
    private Queue<String> inputs = new Queue1L<>();

    /**
     * Queue of values to represent the weights of each input.
     */
    private Queue<Double> weights = new Queue1L<>();

    /**
     * Creator of initial representation.
     */
    private void createNewRep() {
        this.inputs = new Queue1L<>();
        this.weights = new Queue1L<>();
    }

    /**
     * No-argument constructor.
     */
    public Neuron1() {
        this.createNewRep();
    }

    @Override
    public final Queue<Double> weights() {
        return this.weights;
    }

    @Override
    public final Queue<String> inputs() {
        return this.inputs;
    }

    @Override
    public final void setInput(String value) {
        this.inputs.enqueue(value);
    }

    @Override
    public final void clear() {
        this.inputs = this.inputs.newInstance();
        this.weights = this.weights.newInstance();
    }

    @Override
    public final Neuron newInstance() {
        Neuron newIn = new Neuron1();
        return newIn;
    }

    @Override
    public final void transferFrom(Neuron arg0) {
        // TODO finish this for part 6
    }
}
