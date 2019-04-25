package com.lpoo_32.view;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertTrue;

public class TerminalElementFactoryTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void getElement() {
        TerminalElementFactory factory = new TerminalElementFactory();
        ElementView water = factory.getElement(ElementType.WATER, null);
        assertTrue(water instanceof WaterView);
        ElementView food = factory.getElement(ElementType.FOOD, null);
        assertTrue(food instanceof FoodView);
        ElementView spikes = factory.getElement(ElementType.SPIKES, null);
        assertTrue(spikes instanceof SpikesView);
        thrown.expect(IllegalStateException.class);
        factory.getElement(ElementType.NONE, null);
    }
}