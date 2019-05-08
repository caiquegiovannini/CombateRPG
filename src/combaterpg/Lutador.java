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
public abstract class Lutador {
    protected String nome;
    protected int confirma = 0, pontos = 15, hp = 80, forca = 5, agilidade = 5, resistencia = 5;    
    Scanner leitor = new Scanner(System.in);

    
    public void atributos() {
        System.out.println("\n==== " + this.getNome() + " ====");
        System.out.println("HP: " + this.getHp()); 
        System.out.println("Força: " + this.getForca()); 
        System.out.println("Agilidade: " + this.getAgilidade());
        System.out.println("Resistencia: " + this.getResistencia());
    }
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String n) {
        this.nome = n;
    }
    
    public int getPontos() {
        return pontos;
    }
    
    public void setPontos(int p) {
        this.pontos = p;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getForca() {
        return forca;
    }

    public void setForca(int forca) {
        this.forca = forca;
    }

    public int getAgilidade() {
        return agilidade;
    }

    public void setAgilidade(int agilidade) {
        this.agilidade = agilidade;
    }

    public int getResistencia() {
        return resistencia;
    }

    public void setResistencia(int resistencia) {
        this.resistencia = resistencia;
    }
    
    
}
