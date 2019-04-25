/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package combaterpg;

import java.util.Scanner;

/**
 *
 * @author caiqu
 */
public class CombateRPG {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      int confirma = 0;
        Lutador lut = new Lutador();
        Adversarios adv = new Adversarios();        
        Scanner leitor = new Scanner(System.in);
        
        while (confirma != 1) {
            lut.criarLutador();
            System.out.println("");
            System.out.println("==== " + lut.getNome() + " ====");
            lut.atributos();
            System.out.println("");
            System.out.print("Confirmar? [1]-Sim / [2]-Não: ");
            confirma = leitor.nextInt();
            System.out.println("");
            if (confirma > 2 || confirma < 1) {
                System.out.println("Opção inválida");
            }else if (confirma == 2) {
                continue;
            }
            System.out.println(lut.getNome() + " está pronto para lutar!");
        }
       
        System.out.println("================================");
        System.out.println("Um novo adversário aparece para lutar!");
        adv.gerarAdversario();
    }
    
}
