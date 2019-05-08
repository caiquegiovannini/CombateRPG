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

    private String primeiroNome[] = {"O Grande ", "O Incrível ", "O Especialista ", "O Imperdoável ", "O Ninja ", "O Poderoso ", "O Incontrolável "};  //[7]
    private String segundoNome[] = {"Esmagador-de-Crânios", "Destruidor-de-Famílias", "Quebra-Ossos", "Aleijador", "Chutador-de-Bundas", "Finalizador"};  //[6]

    public void gerarAdversario() {
        while (this.confirma != 1) {
            //Nome
            int nRandom = (int) (0 + Math.random() * (7 - 0));
            int sRandom = (int) (0 + Math.random() * (6 - 0));
            this.nome = this.primeiroNome[nRandom] + this.segundoNome[sRandom];
            //Atributos
            this.setPontos(15);
            this.setHp(80);
            this.setForca(5);
            this.setAgilidade(5);
            this.setResistencia(5);
            while (this.pontos > 0 && this.pontos <= 15) {
                //Força
                int forRandom = (int) (0 + Math.random() * (this.pontos - 0));
                this.forca += forRandom;
                this.pontos -= forRandom;
                if (this.pontos <= 0) {
                    break;
                }
                //Agilidade
                int agiRandom = (int) (0 + Math.random() * (this.pontos - 0));
                this.agilidade += agiRandom;
                this.pontos -= agiRandom;
                if (this.pontos <= 0) {
                    break;
                }
                //Resistencia
                int resRandom = (int) (1 + Math.random() * (this.pontos - 1));
                this.resistencia += resRandom;
                this.pontos -= resRandom;
                if (this.pontos <= 0) {
                    break;
                }
            }
            this.hp += (this.forca + this.resistencia) / 2;

            
            System.out.println("Um novo adversário aparece!");
            this.atributos();
            
            System.out.print("Confirmar? [1]-Sim / [2]-Não: ");
            this.confirma = leitor.nextInt();
            System.out.println("");
            if (this.confirma > 2 || this.confirma < 1) {
                System.out.println("Opção inválida");
            }else if (this.confirma == 2) {
                continue;
            }
            System.out.println("");
                System.out.println("Prepare-se para lutar!");
                System.out.println("");
        }
    }

    public Adversarios() {
        
    }

    public String[] getPrimeiroNome() {
        return primeiroNome;
    }

    public void setPrimeiroNome(String[] n) {
        this.primeiroNome = n;
    }

    public String[] getSegundoNome() {
        return segundoNome;
    }

    public void setSegundoNome(String[] sn) {
        this.segundoNome = sn;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public void setNome(String n) {
        this.nome = n;
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
