/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package combaterpg;


/**
 *
 * @author caiqu
 */
public class CombateRPG {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        Jogador player1 = new Jogador();
        Adversarios adversario = new Adversarios();
        
        player1.criarPersonagem();
        System.out.println("");
        System.out.println("================================");
        System.out.println("");
        adversario.gerarAdversario();
     
        Combate combate = new Combate(player1, adversario);
        combate.iniciarCombate(player1, adversario);
        
    }
    
}
