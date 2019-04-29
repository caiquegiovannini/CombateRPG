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
public class Jogador extends Lutador {
    private String nome;
    private int confirma = 0,escolha = 0;
    Scanner leitor = new Scanner(System.in);
    
    public void criarPersonagem() {
        while (this.confirma != 1) {
            atribuirPontos();
            System.out.println("");
            System.out.println("==== " + this.getNome() + " ====");
            atributos();
            System.out.println("");
            System.out.print("Confirmar? [1]-Sim / [2]-Não: ");
            this.confirma = leitor.nextInt();
            System.out.println("");
            if (this.confirma > 2 || this.confirma < 1) {
                System.out.println("Opção inválida");
            }else if (this.confirma == 2) {
                continue;
            }
            System.out.println(this.getNome() + " está pronto para lutar!");
        }
    }
    
    public void atribuirPontos() {
        this.setPontos(15);
        this.setHp(20);
        this.setForca(5);
        this.setAgilidade(5);
        this.setResistencia(5);
        //Nome
        System.out.print("Qual o nome do lutador? ");
        this.nome = leitor.next();
        //Atributos
        System.out.println("Você tem 15 pontos para distribuir:");
        while (this.pontos > 0 && this.pontos <=15) {            
            //Força
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
            this.hp += (this.forca + this.resistencia) / 2;
    }
    
    public void atributos() {
        System.out.println("HP: " + this.getHp());
        System.out.println("Força: " + this.getForca());
        System.out.println("Agilidade: " + this.getAgilidade());
        System.out.println("Resistencia: " + this.getResistencia());
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

    @Override
    public int getHp() {
        return hp;
    }

    @Override
    public void setHp(int hp) {
        this.hp = hp;
    }

    @Override
    public int getForca() {
        return forca;
    }

    @Override
    public void setForca(int forca) {
        this.forca = forca;
    }

    @Override
    public int getAgilidade() {
        return agilidade;
    }

    @Override
    public void setAgilidade(int agilidade) {
        this.agilidade = agilidade;
    }

    @Override
    public int getResistencia() {
        return resistencia;
    }

    @Override
    public void setResistencia(int resistencia) {
        this.resistencia = resistencia;
    }
    
}
