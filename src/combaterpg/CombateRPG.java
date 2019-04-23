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
        Lutador l1 = new Lutador();        
        Scanner leitor = new Scanner(System.in);
        
        while (confirma != 1) {
            l1.criarLutador();
            System.out.println("");
            System.out.println("==== " + l1.getNome() + " ====");
            l1.atributos();
            System.out.println("");
            System.out.print("Confirmar? [1]-Sim / [2]-Não: ");
            confirma = leitor.nextInt();
            if (confirma > 2 || confirma < 1) {
                System.out.println("Opção inválida");
            }else if (confirma == 2) {
                continue;
            }
            System.out.println(l1.getNome() + "Está pronto para lutar!");
        }
        
        
    }
    
}
