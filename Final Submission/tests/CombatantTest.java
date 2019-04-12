package tests;

import utilities.Combatant;

import static org.junit.Assert.*;

import org.junit.Test;

// ---------- TEAM 08 --------
// --Guransh Mangat, Bassel Hassan, George Abouseta, Yihan Wei, Liam Miller -----

public class CombatantTest
{
      @Test
      public void test_setRemainingEnergy_2energy()
      {
            Combatant c = new Combatant();
            c.setRemainingEnergy(2);
            assertEquals("The remaining energy expected was", 2, c.getRemainingEnergy(), 0.00001);
      }
      @Test
      public void test_setBlock_newBlock15()
      {
            Combatant c = new Combatant();
            c.setBlock(15);
            assertEquals("The new block value expected was", 15, c.getBlock(), 0.00001);
      }
      @Test
      public void test_setMaxEnergy_newMaxEnergy5()
      {
            Combatant c = new Combatant();
            c.setMaxEnergy(5);
            assertEquals("The new max energy expected was", 5, c.getMaxEnergy(), 0.00001);
      }
      @Test
      public void test_setMaxHealth_newMaxHealth130()
      {
            Combatant c = new Combatant();
            c.setMaxHealth(130);
            assertEquals("The new max health expected was", 130, c.getMaxHealth(), 0.00001);
      }
      @Test
      public void test_setHealth_newHealth50()
      {
            Combatant c = new Combatant();
            c.setHealth(50);
            assertEquals("The new health expected was", 50, c.getRemainingHealth(), 0.00001);
      }
      @Test
      public void test_altHealth_gainHealth30()
      {
            Combatant c = new Combatant();
            c.setHealth(50);
            c.altHealth(-30);
            assertEquals("The new health expected was", 80, c.getRemainingHealth(), 0.00001);
      }
      @Test
      public void test_altHealth_has20BlockTakes30Damage()
      {
            Combatant c = new Combatant();
            c.setBlock(20);
            c.setHealth(60);
            c.altHealth(30);
            assertEquals("The new health expected was", 50, c.getRemainingHealth(), 0.00001);
      }
      @Test
      public void test_altHealth_has30BlockTakes20Damage()
      {
            Combatant c = new Combatant();
            c.setBlock(30);
            c.setHealth(60);
            c.altHealth(20);
            assertEquals("The health value expected was", 60, c.getRemainingHealth(), 0.00001);
      }
      @Test
      public void test_altEnergy_lose3Energy()
      {
            Combatant c = new Combatant();
            c.setRemainingEnergy(3);
            c.altEnergy(3);
            assertEquals("The remaining energy value expected was", 0, c.getRemainingEnergy(), 0.00001);
      }
      @Test
      public void test_altBlock_has25BlockGains6Block()
      {
            Combatant c = new Combatant();
            c.setBlock(25);
            c.altBlock(6);
            assertEquals("The block value expected was", 30, c.getBlock(), 0.00001);
      }
      @Test
      public void test_altBlock_has25BlockGains5Block()
      {
            Combatant c = new Combatant();
            c.setBlock(25);
            c.altBlock(5);
            assertEquals("The block value expected was", 30, c.getBlock(), 0.00001);
      }
}
