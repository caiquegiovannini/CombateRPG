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
public class Adversarios extends Lutador {
    private String primeiroNome[] = {"O Grande ","O Incrível ","O Especialista ","O Imperdoável ","O Ninja ","O Poderoso ","O Incontrolável "};  //[7]
    private String segundoNome[] = {"Esmagador-de-Crânios","Destruidor-de-Famílias","Quebra-Ossos","Aleijador","Chutador-de-Bundas","Finalizador"};  //[6]
    
    public void gerarAdversario() { 
        //Nome
        int nRandom = (int) (0 + Math.random() * (7 - 0));
        int sRandom = (int) (0 + Math.random() * (6 - 0));        
        //Atributos
        while (this.pontos > 0 && this.pontos <= 15) {
            //Força
            int forRandom = (int) (0 + Math.random() * (this.pontos - 0));
            this.forca += forRandom;
            this.pontos -= forRandom;
            if (this.pontos <= 0) break;
            //Agilidade
            int agiRandom = (int) (0 + Math.random() * (this.pontos - 0));
            this.agilidade += agiRandom;
            this.pontos -= agiRandom;
            if (this.pontos <= 0) break;
            //Resistencia
            int resRandom = (int) (1 + Math.random() * (this.pontos - 1));
            this.resistencia += resRandom;
            this.pontos -= resRandom;
            if (this.pontos <= 0) break;            
        }
        this.hp += (this.forca + this.resistencia) / 2;
        
        System.out.println(this.primeiroNome[nRandom] + this.segundoNome[sRandom]);
        System.out.println("HP: " + this.getHp());
        System.out.println("Força: " + this.getForca());
        System.out.println("Agilidade: " + this.getAgilidade());
        System.out.println("Resistencia: " + this.getResistencia());        
    }
    
    public Adversarios() {
        
    }
    
    public String[] getPrimeiroNome() {
        return primeiroNome;
    }
    
    public void setNome(String[] n) {
        this.primeiroNome = n;
    }

    public String[] getSegundoNome() {
        return segundoNome;
    }

    public void setSegundoNome(String[] sn) {
        this.segundoNome = sn;
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
    public void setForca(int f) {
        this.forca = f;
    }

    @Override
    public int getAgilidade() {
        return agilidade;
    }

    @Override
    public void setAgilidade(int a) {
        this.agilidade = a;
    }

    @Override
    public int getResistencia() {
        return resistencia;
    }

    @Override
    public void setResistencia(int r) {
        this.resistencia = r;
    }

}
