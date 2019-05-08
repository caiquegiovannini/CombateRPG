/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package combaterpg;

import java.util.Random;

/**
 *
 * @author caiqu
 */
public class Dados {
    private int dado;
    
    public int d20() {
        dado = new Random().nextInt(20) + 1;
        return dado;
    }
    
    public int d10() {
        dado = new Random().nextInt(10) + 1;
        return dado;
    }
    
    public int d6() {
        dado = new Random().nextInt(6) + 1;
        return dado;
    }
    
}
