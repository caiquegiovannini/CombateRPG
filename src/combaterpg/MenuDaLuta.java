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
public interface MenuDaLuta {
    public void atacar();
        public void atkSoco(Lutador n);
        public void atkChute(Lutador n);
    public void defender();
        public void defSoco(Lutador n);
        public void defChute(Lutador n);
    public void verAtributos();
    public void desistir();
}
