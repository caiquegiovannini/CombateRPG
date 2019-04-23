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
public class Lutador {
    private String nome;
    private int escolha = 0, pontos = 15, hp = 20, forca = 5, agilidade = 5, resistencia = 5;
    
    public void criarLutador() {
        Scanner leitor = new Scanner(System.in);
        
        System.out.print("Qual o nome do lutador? ");
        this.nome = leitor.next();
        System.out.println("");
        
        System.out.println("Você tem 15 pontos para distribuir:");
        while (this.pontos > 0 && this.pontos <=15) {            
            //Força
            System.out.println("");
            System.out.println("Quantos pontos vai adicionar em Força?");
            System.out.print("5 + ");
            this.escolha = leitor.nextInt();
            if (this.escolha > this.pontos || this.escolha < 0) {
                System.out.println("Você possui apenas " + this.getPontos() + " pontos");
                System.out.println("");
                System.out.println("Quantos pontos vai adicionar em Força?");
                System.out.print("5 + ");
                this.escolha = leitor.nextInt();
            }
            this.forca += this.escolha;
            this.pontos -= this.escolha;
            this.setEscolha(0);
            if (this.pontos == 0) break;
            
            //Agilidade
            System.out.println("");
            System.out.println("Restam " + this.getPontos() + " pontos");
            System.out.println("Quantos pontos vai adicionar em Agilidade?");
            System.out.print("5 + ");
            this.escolha = leitor.nextInt();
            
            while (this.escolha > this.pontos || this.escolha < 0) {
                System.out.println("Você possui apenas " + this.getPontos() + " pontos");
                System.out.println("");
                System.out.println("Quantos pontos vai adicionar em Agilidade?");
                System.out.print("5 + ");
                this.escolha = leitor.nextInt();
            }
            this.agilidade += this.escolha;
            this.pontos -= this.escolha;
            this.setEscolha(0);
            if (this.pontos == 0) break;
            
            //Resistencia
            System.out.println("");
            System.out.println("Restam " + this.getPontos() + " pontos");
            System.out.println("Quantos pontos vai adicionar em Resistência?");
            System.out.print("5 + ");
            this.escolha = leitor.nextInt();
            while (this.escolha > this.pontos || this.escolha < 0) {
                System.out.println("Você possui apenas " + pontos + " pontos");
                System.out.println("");
                System.out.println("Quantos pontos vai adicionar em Resistência?");
                System.out.print("5 + ");
                this.escolha = leitor.nextInt();
            }
            
            this.resistencia += this.escolha;
            this.pontos -= this.escolha;
            this.setEscolha(0); 
            if (this.pontos == 0) {
                break;
            } else if (this.pontos > 0) {
                System.out.println("");
                System.out.println("Restam " + this.getPontos() + " pontos");
            }
        }
    }
    
    public void atributos() {
        System.out.println("HP: " + this.getHp());
        System.out.println("Força: " + this.getForca());
        System.out.println("Agilidade: " + this.getAgilidade());
        System.out.println("Resistencia: " + this.getResistencia());
    }
    
    public Lutador() {
        
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public int getEscolha() {
        return escolha;
    }
    
    public void setEscolha(int e) {
        this.escolha = e;
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
