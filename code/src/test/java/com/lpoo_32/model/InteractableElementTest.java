package com.lpoo_32.model;

import com.lpoo_32.exceptions.*;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mockito;

import static org.junit.Assert.*;


public class InteractableElementTest {
    private PlayerModel player;

    @Rule
    public final ExpectedException thrown = ExpectedException.none();

    @Before
    public void initializeValues(){
        Position pos = Mockito.mock(Position.class);
        this.player = new PlayerModel(pos);
    }


    @Test
    public void spikes() throws HealthOVF, HungerRestored, HungerOVF, ThirstOVF, ThirstRestored, Bedtime {
        InteractableElement spike = new SpikesModel(20, null);
        spike.interact(player);
        assertEquals(100, player.getWater().getValue());
        assertEquals(100, player.getFood().getValue());
        assertEquals(80, player.getHealth().getValue());
    }


    @Test
    public void statusOVF() throws HealthOVF, HungerRestored, HungerOVF, ThirstOVF, ThirstRestored, Bedtime {
        InteractableElement spike = new SpikesModel(200, null);
        thrown.expect(HealthOVF.class);
        spike.interact(player);
    }
    @Test
    public void food() throws HealthOVF, HungerRestored, HungerOVF, ThirstOVF, ThirstRestored, Bedtime {
        InteractableElement spike = new SpikesModel(20, null);
        spike.interact(player);
        assertEquals(100, player.getWater().getValue());
        assertEquals(100, player.getFood().getValue());
        assertEquals(80, player.getHealth().getValue());
        InteractableElement food = new FoodModel(20, null);
        food.interact(player);
        assertEquals(100, player.getWater().getValue());
        assertEquals(100, player.getFood().getValue());
        assertEquals(100, player.getHealth().getValue());
    }

    @Test
    public void water() throws HealthOVF, HungerRestored, HungerOVF, ThirstOVF, ThirstRestored, Bedtime {
        this.player.setWater(new NourishStatus(70, NourishType.HUNGER));
        InteractableElement water = new WaterModel(15,null);
        assertEquals(70, this.player.getWater().getValue());
        assertEquals(100, this.player.getFood().getValue());
        assertEquals(100, this.player.getHealth().getValue());
        water.interact(player);
        assertEquals(90, this.player.getWater().getValue());
        assertEquals(100, this.player.getFood().getValue());
        assertEquals(100, this.player.getHealth().getValue());
    }
}
