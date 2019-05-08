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
public class Combate implements MenuDaLuta {

    private Jogador p1;
    private Adversarios p2;
    private Lutador jogaPrimeiro, jogaSegundo;
    private String moveP1, moveP2, resultado;
    private int turno = 0, escolha, escolhaP1 = 0, escolhaP2 = 0, ataqueP1, ataqueP2;
    private boolean perdeTurnoP1, perdeTurnoP2, atkChuteP1, atkChuteP2, atkSocoP1, atkSocoP2, defChuteP1, defChuteP2, defSocoP1, defSocoP2, desiste;
    Scanner leitor = new Scanner(System.in);
    Dados jogar = new Dados();

    public Combate(Jogador lutador1, Adversarios lutador2) {
        this.p1 = lutador1;
        this.p2 = lutador2;
    }

    public void apresentacao() {
        this.p1.atributos();
        System.out.println("\n------ vs ------\n");
        this.p2.atributos();
        System.out.println("\nTecle uma letra para começar a luta!");
        leitor.next();
        System.out.println("\n\n\n");
    }

    //Testes baseados em agilidade:
    public void testeIniciativa(Jogador p1, Adversarios p2) {
        int testeP1 = this.jogar.d20() + this.p1.agilidade;
        int testeP2 = this.jogar.d20() + this.p2.agilidade;
        if (testeP1 >= testeP2) {
            this.jogaPrimeiro = p1;
            this.jogaSegundo = p2;
        } else {
            this.jogaPrimeiro = p2;
            this.jogaSegundo = p1;
        }
    }

    //Luta
    public void iniciarCombate(Lutador player1, Lutador player2) {
        apresentacao();
        for (this.turno = 1; this.p1.getHp() > 0 && this.p2.getHp() > 0; this.turno++) {
            if (this.isPerdeTurnoP1()) {            //se Player1 perdeu o turno
                this.defSocoP1 = false;
                this.defSocoP2 = false;
                this.defChuteP1 = false;
                this.defChuteP2 = false;
                this.atkSocoP1 = false;
                this.atkSocoP2 = false;
                this.atkChuteP1 = false;
                this.atkChuteP2 = false;
                this.moveP1 = "";
                this.moveP2 = "";
                System.out.println(this.turno + "º turno - \n");
                this.turnoP1();
                this.turnoP2();
                this.testeIniciativa(p1, p2);
                System.out.println(this.turnoAcao(this.jogaPrimeiro, this.jogaSegundo));
                this.setPerdeTurnoP1(false);
            } else if (this.isPerdeTurnoP2()) {     //se Player2 perdeu o turno
                this.defSocoP1 = false;
                this.defSocoP2 = false;
                this.defChuteP1 = false;
                this.defChuteP2 = false;
                this.atkSocoP1 = false;
                this.atkSocoP2 = false;
                this.atkChuteP1 = false;
                this.atkChuteP2 = false;
                this.moveP1 = "";
                this.moveP2 = "";
                System.out.println(this.turno + "º turno - \n");
                this.turnoP1();
                this.turnoP2();
                this.testeIniciativa(p1, p2);
                System.out.println(this.turnoAcao(this.jogaPrimeiro, this.jogaSegundo));
                this.setPerdeTurnoP2(false);
            } else {                                //se ninguém perdeu o turno
                this.defSocoP1 = false;
                this.defSocoP2 = false;
                this.defChuteP1 = false;
                this.defChuteP2 = false;
                this.atkSocoP1 = false;
                this.atkSocoP2 = false;
                this.atkChuteP1 = false;
                this.atkChuteP2 = false;
                this.moveP1 = "";
                this.moveP2 = "";
                System.out.println(this.turno + "º turno - \n");
                this.turnoP1();
                this.turnoP2();
                this.testeIniciativa(p1, p2);
                System.out.println(this.turnoAcao(this.jogaPrimeiro, this.jogaSegundo));
            }
        }
    }

    public void turnoP1() {
        this.menuPrincipal();
        this.escolhaP1 = leitor.nextInt();
        switch (this.escolhaP1) {
            case 1:
                if (this.isPerdeTurnoP1()) {
                    System.out.println("Você não pode atacar neste turno");
                    this.turnoP1();
                } else {
                    atacar();
                }
                break;
            case 2:
                defender();
                break;
            case 3:
                verAtributos();
                System.out.println("");
                this.turnoP1();
                break;
            case 4:
                desistir();
                break;
            default:
                System.out.println("Opção Inválida!");
                this.turnoP1();
        }
    }

    public void turnoP2() {
        if (this.isPerdeTurnoP2() == false) {
            this.escolhaP2 = this.jogar.d10();                //teste atacar ou defender
            if (this.escolhaP2 >= 3) {                        //vai atacar
                this.escolhaP2 = this.jogar.d6();
                if (this.escolhaP2 >= 3) {
                    atkSoco(this.p2);
                } else {
                    atkChute(this.p2);
                }
            } else {                                        //vai defender
                this.escolhaP2 = this.jogar.d6();
                if (this.escolhaP2 > 3) {
                    defSoco(this.p2);
                } else {
                    defChute(this.p2);
                }
            }
        }
    }

    public String acaoP1() {
        if (this.isAtkSocoP1()) {           //Atacou com soco
            if (this.isDefSocoP2()) {       //Se oponente defendeu
                this.moveP1 = this.p2.getNome() + " defendeu seu soco.\nVocê está incapacitado de atacar no próximo turno!";
                this.setPerdeTurnoP1(true);
            } else if (this.ataqueP1 > this.p2.resistencia) {   //Se o ataque for maior que a resistencia do inimigo
                this.p2.setHp(this.p2.getHp() - (this.ataqueP1 - this.p2.getResistencia()));
                this.moveP1 = "Você deu um direto com " + this.ataqueP1 + " de força\nDeixou " + this.p2.getNome() + " com " + this.p2.getHp() + " de HP";
            } else {
                this.moveP1 = "Seu soco é muito fraco. Seu oponente nem sentiu o golpe";
            }
        } else if (this.isAtkChuteP1()) {               //Atacou com chute
            if (this.isDefChuteP2()) {                  //Se oponente defendeu
                this.moveP1 = this.p2.getNome() + " defendeu seu chute.\nVocê está incapacitado de atacar no próximo turno!";
                this.setPerdeTurnoP1(true);
            } else if (this.ataqueP1 > this.p2.resistencia) {
                this.p2.setHp(this.p2.getHp() - (this.ataqueP1 - this.p2.getResistencia()));
                this.moveP1 = "Você chutou com " + this.ataqueP1 + " de força\nDeixou " + this.p2.getNome() + " com " + this.p2.getHp() + " de HP";
            } else {
                this.moveP1 = "Você deu um chute muito fraco. Seu oponente nem se abalou";
            }
        } else if (this.isDefSocoP1() && this.isDefSocoP2() || this.isDefChuteP1() && this.isDefChuteP2()       //Se os dois estão defendendo
                || this.isDefSocoP1() && this.isDefChuteP2() || this.isDefChuteP1() && this.isDefSocoP2()) {
            this.moveP1 = "\nOs dois lutadores estão na defensiva.";
        } else if (this.isDesiste()) {
            this.moveP1 = this.endGame();
        }
        return this.moveP1;
    }

    public String acaoP2() {
        if (this.isAtkSocoP2()) {                 //Atacou com soco
            if (this.isDefSocoP1()) {             //Se oponente defendeu
                this.moveP2 = "Voce bloqueou o soco de seu oponente!\nO contra-ataque será certeiro!";
                this.setPerdeTurnoP2(true);
            } else if (this.ataqueP2 > this.p1.resistencia) {
                this.p1.setHp(this.p1.getHp() - (this.ataqueP2 - this.p1.getResistencia()));
                this.moveP2 = this.p2.getNome() + " acertou um cruzado com " + this.ataqueP2 + " de força em você";
            } else {
                this.moveP2 = this.p2.getNome() + " disparou um soco fraco. Você aguentou o impacto com tranquilidade";
            }
        } else if (this.isAtkChuteP2()) {               //Atacou com chute
            if (this.isDefChuteP1()) {                  //Se oponente defendeu
                this.moveP2 = "Voce aparou o chute de seu oponente!\nO contra-ataque será certeiro!";
                this.setPerdeTurnoP2(true);
            } else if (this.ataqueP2 > this.p1.resistencia) {
                this.p1.setHp(this.p1.getHp() - (this.ataqueP2 - this.p1.getResistencia()));
                this.moveP2 = this.p2.getNome() + " te deu um chute com " + this.ataqueP2 + " de força";
            } else {
                this.moveP2 = this.p2.getNome() + " te deu um chute fraco. Não te fez nem cócegas";
            }
        }
        return this.moveP2;
    }

    public String turnoAcao(Lutador prim, Lutador seg) {
        if (prim == this.p1) {
            this.acaoP1();
            if (this.p2.getHp() <= 0) {
                return this.endGame();
            } else {
                this.acaoP2();
                if (this.p1.getHp() <= 0) {
                    return this.endGame();
                }
            }
        } else {
            this.acaoP2();
            if (this.p1.getHp() <= 0) {
                return this.endGame();
            } else {
                this.acaoP1();
                if (this.p2.getHp() <= 0) {
                    return this.endGame();
                }
            }
        }
        return this.moveP1 + "\n\n" + this.moveP2;
    }

    public String endGame() {
        if (this.p1.getHp() <= 0) {
            this.escolha = this.jogar.d6();
            if (this.escolha > 3) {
                this.resultado = "Você foi nocauteado...\n";
            } else {
                this.resultado = "Você recebeu um golpe certeiro e foi ao chão incapaz de levantar...\n";
            }
            this.resultado += this.p2.getNome() + " é o vencedor!\n\n"
                    + "VOCÊ PERDEU\n"
                    + "-----------\n"
                    + " GAME OVER";
        } else if (this.p2.getHp() <= 0) {
            this.escolha = this.jogar.d6();
            if (this.escolha > 3) {
                this.resultado = "Você nocauteou seu adversário...\n";
            } else {
                this.resultado = "Você acertou um golpe em cheio e levou seu oponente ao chão\n"
                        + "Ele é incapaz de levantar...\n";
            }
            this.resultado += this.p1.getNome() + " é o vencedor!\n\n"
                    + "  PARABÉNS\n"
                    + "-----------\n"
                    + "VOCÊ VENCEU";
        } else if (this.p1.getHp() > 0 && this.p2.getHp() > 0) {
            this.resultado = "Você não aguentou a pressão e decidiu desistir...\n"
                    + "Seu oponente ganha por WO\n\n"
                    + "PERDEDOR\n"
                    + "---------\n"
                    + "GAME OVER";
            this.p1.setHp(0);
        }
        return resultado;
    }

    public void menuPrincipal() {
        System.out.println("-----------------    ----------------\n"
                + "|  1 - ATACAR   |    | 2 - DEFENDER |\n"
                + "-----------------    ----------------\n\n"
                + "-----------------    ----------------\n"
                + "| 3 - ATRIBUTOS |    | 4 - DESISTIR |\n"
                + "-----------------    ----------------\n");
    }

    public void menuAtk() {
        System.out.println("Atacar com: \n"
                + "-------------    -------------\n"
                + "| 1 - SOCO  |    | 2 - CHUTE |\n"
                + "-------------    -------------\n\n");
    }

    public void menuDef() {
        System.out.println("Defender: \n"
                + "-------------    -------------\n"
                + "| 1 - SOCO  |    | 2 - CHUTE |\n"
                + "-------------    -------------\n\n");
    }

    //Menu da luta
    @Override
    public void atacar() {
        menuAtk();
        this.escolhaP1 = leitor.nextInt();
        switch (this.escolhaP1) {
            case 1:
                this.escolhaP1 = 1;
                atkSoco(this.p1);
                break;
            case 2:
                this.escolhaP1 = 2;
                atkChute(this.p1);
                break;
            default:
                System.out.println("Opção Inválida!");
                this.atacar();
        }
    }

    @Override
    public void atkSoco(Lutador n) {
        if (n == this.p1) {
            this.setAtkSocoP1(true);
            this.ataqueP1 = this.p1.getForca() + this.jogar.d20();
        } else if (n == this.p2) {
            this.setAtkSocoP2(true);
            this.ataqueP2 = this.p2.getForca() + this.jogar.d20();
        }
    }

    @Override
    public void atkChute(Lutador n) {
        if (n == this.p1) {
            this.setAtkChuteP1(true);
            this.ataqueP1 = this.p1.getForca() + this.jogar.d10();
        } else if (n == this.p2) {
            this.setAtkChuteP2(true);
            this.ataqueP2 = this.p2.getForca() + this.jogar.d10();
        }
    }

    @Override
    public void defender() {
        menuDef();
        this.escolhaP1 = leitor.nextInt();
        switch (this.escolhaP1) {
            case 1:
                this.escolhaP1 = 3;
                defSoco(this.p1);
                break;
            case 2:
                this.escolhaP1 = 4;
                defChute(this.p1);
                break;
            default:
                System.out.println("Opção Inválida!");
                this.defender();
        }
    }

    @Override
    public void defSoco(Lutador n) {
        if (n == this.p1) {
            this.setDefSocoP1(true);
        } else if (n == this.p2) {
            this.setDefSocoP2(true);
        }
    }

    @Override
    public void defChute(Lutador n) {
        if (n == this.p1) {
            this.setDefChuteP1(true);
        }
        if (n == this.p2) {
            this.setDefChuteP2(true);
        }
    }

    @Override
    public void verAtributos() {
        this.p1.atributos();
    }

    @Override
    public void desistir() {
        this.setDesiste(true);
    }

    public Jogador getP1() {
        return p1;
    }

    public void setP1(Jogador p1) {
        this.p1 = p1;
    }

    public Adversarios getP2() {
        return p2;
    }

    public void setP2(Adversarios p2) {
        this.p2 = p2;
    }

    public Lutador getJogaPrimeiro() {
        return jogaPrimeiro;
    }

    public void setJogaPrimeiro(Lutador primeiro) {
        this.jogaPrimeiro = primeiro;
    }

    public Lutador getJogaSegundo() {
        return jogaSegundo;
    }

    public void setJogaSegundo(Lutador segundo) {
        this.jogaSegundo = segundo;
    }

    public int getTurno() {
        return turno;
    }

    public void setTurno(int turno) {
        this.turno = turno;
    }

    public boolean isPerdeTurnoP1() {
        return perdeTurnoP1;
    }

    public void setPerdeTurnoP1(boolean perdeTurnoP1) {
        this.perdeTurnoP1 = perdeTurnoP1;
    }

    public boolean isPerdeTurnoP2() {
        return perdeTurnoP2;
    }

    public void setPerdeTurnoP2(boolean perdeTurnoP2) {
        this.perdeTurnoP2 = perdeTurnoP2;
    }

    public boolean isAtkChuteP1() {
        return atkChuteP1;
    }

    public void setAtkChuteP1(boolean atkChuteP1) {
        this.atkChuteP1 = atkChuteP1;
    }

    public boolean isAtkChuteP2() {
        return atkChuteP2;
    }

    public void setAtkChuteP2(boolean atkChuteP2) {
        this.atkChuteP2 = atkChuteP2;
    }

    public boolean isAtkSocoP1() {
        return atkSocoP1;
    }

    public void setAtkSocoP1(boolean atkSocoP1) {
        this.atkSocoP1 = atkSocoP1;
    }

    public boolean isAtkSocoP2() {
        return atkSocoP2;
    }

    public void setAtkSocoP2(boolean atkSocoP2) {
        this.atkSocoP2 = atkSocoP2;
    }

    public String getMoveP1() {
        return moveP1;
    }

    public void setMoveP1(String moveP1) {
        this.moveP1 = moveP1;
    }

    public String getMoveP2() {
        return moveP2;
    }

    public void setMoveP2(String moveP2) {
        this.moveP2 = moveP2;
    }

    public boolean isDefSocoP1() {
        return defSocoP1;
    }

    public void setDefSocoP1(boolean defSocoP1) {
        this.defSocoP1 = defSocoP1;
    }

    public boolean isDefSocoP2() {
        return defSocoP2;
    }

    public void setDefSocoP2(boolean defSocoP2) {
        this.defSocoP2 = defSocoP2;
    }

    public boolean isDefChuteP1() {
        return defChuteP1;
    }

    public void setDefChuteP1(boolean defChuteP1) {
        this.defChuteP1 = defChuteP1;
    }

    public boolean isDefChuteP2() {
        return defChuteP2;
    }

    public void setDefChuteP2(boolean defChuteP2) {
        this.defChuteP2 = defChuteP2;
    }

    public boolean isDesiste() {
        return desiste;
    }

    public void setDesiste(boolean desiste) {
        this.desiste = desiste;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public int getEscolha() {
        return escolha;
    }

    public void setEscolha(int escolha) {
        this.escolha = escolha;
    }

    public int getEscolhaP1() {
        return escolhaP1;
    }

    public void setEscolhaP1(int escolhaP1) {
        this.escolhaP1 = escolhaP1;
    }

    public int getEscolhaP2() {
        return escolhaP2;
    }

    public void setEscolhaP2(int escolhaP2) {
        this.escolhaP2 = escolhaP2;
    }

    public int getAtaqueP1() {
        return ataqueP1;
    }

    public void setAtaqueP1(int ataqueP1) {
        this.ataqueP1 = ataqueP1;
    }

    public int getAtaqueP2() {
        return ataqueP2;
    }

    public void setAtaqueP2(int ataqueP2) {
        this.ataqueP2 = ataqueP2;
    }

}
