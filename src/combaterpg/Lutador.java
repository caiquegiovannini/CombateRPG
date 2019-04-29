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
public abstract class Lutador {
    protected int pontos = 15, hp = 20, forca = 5, agilidade = 5, resistencia = 5;
    
    public Lutador() {
        
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
