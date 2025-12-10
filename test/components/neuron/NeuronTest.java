package components.neuron;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * JUnit test fixture for {@code Neuron}.
 *
 * @author Grace Metz
 *
 */
public abstract class NeuronTest {

    /**
     * Test constructor (only one possible constructor).
     */
    @Test
    public final void testConstructor() {
        Neuron testNeuron = new Neuron1();
        Neuron testNeuronExpected = new Neuron1();

        assertEquals(testNeuron, testNeuronExpected);
    }

    /*
     * Test kernel implementations
     */

    /**
     * Test the weights() method where the weights should be empty.
     */
    @Test
    public final void testWeightsEmpty() {
        Neuron testNeuron = new Neuron1();
        Neuron testNeuronExpected = new Neuron1();

        assertEquals(testNeuron.weights(), testNeuronExpected.weights());
    }

    /**
     * Test the weights() method where the weights have entries.
     */
    @Test
    public final void testWeightsFilled() {
        Neuron testNeuron = new Neuron1();
        Neuron testNeuronExpected = new Neuron1();

        testNeuron.setWeight(0);
        testNeuron.setWeight(0.2);

        testNeuronExpected.setWeight(0);
        testNeuronExpected.setWeight(0.2);

        assertEquals(testNeuron.weights(), testNeuronExpected.weights());
        assertEquals(testNeuron.weights().length(), 2);
    }

    /**
     * Test the inputs() method where the inputs should be empty.
     */
    @Test
    public final void testInputsEmpty() {
        Neuron testNeuron = new Neuron1();
        Neuron testNeuronExpected = new Neuron1();

        assertEquals(testNeuron.inputs().length(), 0);
        assertEquals(testNeuron.inputs(), testNeuronExpected.inputs());
    }

    /**
     * Test the inputs() method where the inputs have entries.
     */
    @Test
    public final void testInputsFilled() {
        Neuron testNeuron = new Neuron1();
        Neuron testNeuronExpected = new Neuron1();

        testNeuron.setInput("first");
        testNeuron.setInput("second");

        testNeuronExpected.setInput("first");
        testNeuronExpected.setInput("second");

        assertEquals(testNeuron.inputs().length(), 2);
        assertEquals(testNeuron.inputs(), testNeuronExpected.inputs());
    }

    /**
     * Test the setInput() method where the inputs are blank.
     */
    @Test
    public final void testSetInputsBlank() {
        Neuron testNeuron = new Neuron1();
        Neuron testNeuronExpected = new Neuron1();

        testNeuron.setInput("");
        testNeuron.setInput("");

        testNeuronExpected.setInput("");
        testNeuronExpected.setInput("");

        assertEquals(testNeuron.inputs().length(), 2);
        assertEquals(testNeuron.inputs(), testNeuronExpected.inputs());
    }

    /**
     * Test the setInput() method where the comparison should return false.
     */
    @Test
    public final void testSetInputsFilled() {
        Neuron testNeuron = new Neuron1();
        Neuron testNeuronExpected = new Neuron1();

        testNeuron.setInput("hi");
        testNeuron.setInput("Hello");

        testNeuronExpected.setInput("hi");

        assertEquals(testNeuron.inputs(), testNeuronExpected.inputs());
    }

    /**
     * Test the setInput() method with a mix of blank and empty inputs.
     */
    @Test
    public final void testSetInputsMixed() {
        Neuron testNeuron = new Neuron1();
        Neuron testNeuronExpected = new Neuron1();

        testNeuron.setInput("");
        testNeuron.setInput("Hello");

        testNeuronExpected.setInput("");
        testNeuronExpected.setInput("Hello");

        assertEquals(testNeuron.inputs().length(), 2);
        assertEquals(testNeuron.inputs(), testNeuronExpected.inputs());
    }

    /*
     * Test secondary implementations
     */

    /**
     * Test the activate() method where the inputs and weights have entries.
     */
    @Test
    public final void testActivateFilled() {
        Neuron testNeuron = new Neuron1();
        Neuron testNeuronExpected = new Neuron1();

        testNeuron.setInput("first");
        testNeuron.setInput("second");
        testNeuron.setWeight(0);
        testNeuron.setWeight(0.2);

        testNeuronExpected.setInput("first");
        testNeuronExpected.setInput("second");
        testNeuronExpected.setWeight(0);
        testNeuronExpected.setWeight(0.2);

        assertEquals(testNeuron.activate(), false);
        assertEquals(testNeuron.activate(), testNeuronExpected.activate());
    }

    /**
     * Test the activate() method where the inputs are full and weights are
     * empty.
     */
    @Test
    public final void testActivateFullAndEmpty() {
        Neuron testNeuron = new Neuron1();
        Neuron testNeuronExpected = new Neuron1();

        testNeuron.setInput("first");
        testNeuron.setInput("second");

        testNeuronExpected.setInput("first");
        testNeuronExpected.setInput("second");

        assertEquals(testNeuron.activate(), false);
        assertEquals(testNeuron.activate(), testNeuronExpected.activate());
    }

    /**
     * Test the activate() method where the weights are -1 (minimum value).
     */
    @Test
    public final void testActivateMin() {
        Neuron testNeuron = new Neuron1();
        Neuron testNeuronExpected = new Neuron1();

        testNeuron.setWeight(-1);
        testNeuron.setWeight(-1);

        testNeuronExpected.setWeight(-1);
        testNeuronExpected.setWeight(-1);

        assertEquals(testNeuron.activate(), false);
        assertEquals(testNeuron.activate(), testNeuronExpected.activate());
    }

    /**
     * Test the activate() method where the weights are all one (highest value).
     */
    @Test
    public final void testActivateMax() {
        Neuron testNeuron = new Neuron1();
        Neuron testNeuronExpected = new Neuron1();

        testNeuron.setWeight(1);
        testNeuron.setWeight(1);

        testNeuronExpected.setWeight(1);
        testNeuronExpected.setWeight(1);

        assertEquals(testNeuron.activate(), true);
        assertEquals(testNeuron.activate(), testNeuronExpected.activate());
    }

    /**
     * Test the setWeight() method where the weights are all negative.
     */
    @Test
    public final void testSetWeightNeg() {
        Neuron testNeuron = new Neuron1();
        Neuron testNeuronExpected = new Neuron1();

        testNeuron.setWeight(-1);
        testNeuron.setWeight(-0.5);

        testNeuronExpected.setWeight(-1);
        testNeuronExpected.setWeight(-0.5);

        assertEquals(testNeuron.weights(), testNeuronExpected.weights());
    }

    /**
     * Test the setWeight() method where the weights are all zero.
     */
    @Test
    public final void testSetWeightZero() {
        Neuron testNeuron = new Neuron1();
        Neuron testNeuronExpected = new Neuron1();

        testNeuron.setWeight(0);
        testNeuron.setWeight(0);

        testNeuronExpected.setWeight(0);
        testNeuronExpected.setWeight(0);

        assertEquals(testNeuron.weights().length(), 2);
        assertEquals(testNeuron.weights(), testNeuronExpected.weights());
    }

    /**
     * Test the setWeight() method where the weights are all one (max value).
     */
    @Test
    public final void testSetWeightMax() {
        Neuron testNeuron = new Neuron1();
        Neuron testNeuronExpected = new Neuron1();

        testNeuron.setWeight(1);
        testNeuron.setWeight(1);

        testNeuronExpected.setWeight(1);
        testNeuronExpected.setWeight(1);

        assertEquals(testNeuron.weights().length(), 2);
        assertEquals(testNeuron.weights(), testNeuronExpected.weights());
    }

    /**
     * Test the sum() method where the weights are all one (max value).
     */
    @Test
    public final void testSumMax() {
        Neuron testNeuron = new Neuron1();
        Neuron testNeuronExpected = new Neuron1();

        testNeuron.setWeight(1);
        testNeuron.setWeight(1);

        testNeuronExpected.setWeight(1);
        testNeuronExpected.setWeight(1);

        assertEquals(testNeuron.sum(), 2);
        assertEquals(testNeuron.weights(), testNeuronExpected.weights());
    }

    /**
     * Test the sum() method where the weights are all zero.
     */
    @Test
    public final void testSumZero() {
        Neuron testNeuron = new Neuron1();
        Neuron testNeuronExpected = new Neuron1();

        testNeuron.setWeight(0);
        testNeuron.setWeight(0);

        testNeuronExpected.setWeight(0);
        testNeuronExpected.setWeight(0);

        assertEquals(testNeuron.sum(), 0);
        assertEquals(testNeuron.weights(), testNeuronExpected.weights());
    }

    /**
     * Test the sum() method where the weights are all -1 (minimum value).
     */
    @Test
    public final void testSumMin() {
        Neuron testNeuron = new Neuron1();
        Neuron testNeuronExpected = new Neuron1();

        testNeuron.setWeight(-1);
        testNeuron.setWeight(-1);

        testNeuronExpected.setWeight(-1);
        testNeuronExpected.setWeight(-1);

        assertEquals(testNeuron.sum(), -2);
        assertEquals(testNeuron.weights(), testNeuronExpected.weights());
    }

    /*
     * Test Standard and "base" method implementations
     */

    /**
     * Test the toString() method where the weights and inputs are empty.
     */
    @Test
    public final void testToStringEmpty() {
        Neuron testNeuron = new Neuron1();
        Neuron testNeuronExpected = new Neuron1();

        String expectedString = "Neuron [weights=][inputs=]";

        assertEquals(testNeuron.toString(), expectedString);
        assertEquals(testNeuron, testNeuronExpected);
    }

    /**
     * Test the toString() method where the weights and inputs are filled.
     */
    @Test
    public final void testToStringFilled() {
        Neuron testNeuron = new Neuron1();
        Neuron testNeuronExpected = new Neuron1();

        testNeuron.setInput("hi");
        testNeuron.setInput("hello");
        testNeuron.setWeight(0);
        testNeuron.setWeight(1);

        testNeuronExpected.setInput("hi");
        testNeuronExpected.setInput("hello");
        testNeuronExpected.setWeight(0);
        testNeuronExpected.setWeight(1);

        String expectedString = "Neuron [weights=0, 1][inputs=hi, hello]";

        assertEquals(testNeuron.toString(), expectedString);
        assertEquals(testNeuron, testNeuronExpected);
    }

    /**
     * Test the toString() method where the weights are empty and inputs are
     * filled.
     */
    @Test
    public final void testToStringWeightsEmpty() {
        Neuron testNeuron = new Neuron1();
        Neuron testNeuronExpected = new Neuron1();

        testNeuron.setInput("hi");
        testNeuron.setInput("hello");

        testNeuronExpected.setInput("hi");
        testNeuronExpected.setInput("hello");

        String expectedString = "Neuron [weights=][inputs=hi, hello]";

        assertEquals(testNeuron.toString(), expectedString);
        assertEquals(testNeuron, testNeuronExpected);
    }

    /**
     * Test the toString() method where the weights are filled and inputs are
     * empty.
     */
    @Test
    public final void testToStringInputsEmpty() {
        Neuron testNeuron = new Neuron1();
        Neuron testNeuronExpected = new Neuron1();

        testNeuron.setWeight(0);
        testNeuron.setWeight(1);

        testNeuronExpected.setWeight(0);
        testNeuronExpected.setWeight(1);

        String expectedString = "Neuron [weights=0, 1][inputs=]";

        assertEquals(testNeuron.toString(), expectedString);
        assertEquals(testNeuron, testNeuronExpected);
    }

    /**
     * Test the equals() method where it should return true.
     */
    @Test
    public final void testEqualsTrue() {
        Neuron testNeuron = new Neuron1();
        Neuron testNeuronExpected = new Neuron1();

        assertEquals(testNeuron.equals(testNeuronExpected), true);
        assertEquals(testNeuron, testNeuronExpected);
    }

    /**
     * Test the equals() method where it should return false.
     */
    @Test
    public final void testEqualsFalse() {
        Neuron testNeuron = new Neuron1();
        Neuron testNeuronExpected = new Neuron1();

        testNeuronExpected.setInput("new neuron");
        testNeuronExpected.setWeight(0);

        assertEquals(testNeuron.equals(testNeuronExpected), false);
        assertEquals(testNeuron, testNeuronExpected);
    }

    /**
     * Test the clear() method where both the weights and inputs are empty.
     */
    @Test
    public final void testClearEmpty() {
        Neuron testNeuron = new Neuron1();
        Neuron testNeuronExpected = new Neuron1();

        testNeuron.clear();

        assertEquals(testNeuron, testNeuronExpected);
        assertEquals(testNeuron.weights().length(), 0);
        assertEquals(testNeuron.inputs().length(), 0);
    }

    /**
     * Test the clear() method where both the weights and inputs are full.
     */
    @Test
    public final void testClearFull() {
        Neuron testNeuron = new Neuron1();
        Neuron testNeuronExpected = new Neuron1();

        testNeuron.setInput("hi");
        testNeuron.setInput("hello");
        testNeuron.setWeight(0);
        testNeuron.setWeight(1);

        testNeuron.clear();

        assertEquals(testNeuron, testNeuronExpected);
        assertEquals(testNeuron.weights().length(), 0);
        assertEquals(testNeuron.inputs().length(), 0);
    }

    /**
     * Test the newInstance() method (only one possible constructor).
     */
    @Test
    public final void testNewInstance() {
        Neuron testNeuronExpected = new Neuron1();
        Neuron testNeuron = testNeuronExpected.newInstance();

        assertEquals(testNeuron, testNeuronExpected);
    }

    /**
     * Test the transferFrom() method where both weights and inputs are filled.
     */
    @Test
    public final void testTransferFromFilled() {
        Neuron testNeuronExpected = new Neuron1();
        Neuron testNeuron = new Neuron1();

        Neuron testNeuronTransfer = new Neuron1();
        testNeuronTransfer.setInput("new neuron");
        testNeuronTransfer.setWeight(0);
        testNeuron.transferFrom(testNeuronTransfer);

        testNeuronExpected.setInput("new neuron");
        testNeuronExpected.setWeight(0);

        assertEquals(testNeuron, testNeuronExpected);
        assertEquals(testNeuronTransfer.weights().length(), 0);
        assertEquals(testNeuronTransfer.inputs().length(), 0);
    }

    /**
     * Test the transferFrom() method where both weights and inputs are empty.
     */
    @Test
    public final void testTransferFromEmpty() {
        Neuron testNeuronExpected = new Neuron1();
        Neuron testNeuron = new Neuron1();

        Neuron testNeuronTransfer = new Neuron1();
        testNeuron.transferFrom(testNeuronTransfer);

        assertEquals(testNeuron, testNeuronExpected);
        assertEquals(testNeuronTransfer.weights().length(), 0);
        assertEquals(testNeuronTransfer.inputs().length(), 0);
    }

}
