package org.example;

import java.util.Random;
import java.util.Scanner;

public class AkinatorNumber {
    public static void main(String[] args) {

        /*
        creazione di akinumber
         */

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int tentativi = 0;
        int numeroCasuale = 0;
        int numeroUtente = 0;
        int difficolta;
        int scelta = 0;

        while (scelta != 2) {

            //menu
            System.out.println("***********************************");
            System.out.println(" * AKINUMBER *  ");
            System.out.println("***********************************");
            System.out.println(" * 1 * GIOCA");
            System.out.println("***********************************");
            System.out.println(" * 2 * ESCI");
            System.out.println("***********************************");

            scelta = scanner.nextInt();

            //switch per il controllo del sotto menu per impostare la difficoltà
            switch (scelta) {
                case 1:
                    System.out.println("Seleziona la difficoltà:");
                    System.out.println(" * 1 * Facile (Massimo 10 tentativi)");
                    System.out.println(" * 2 * Medio (Massimo 7 tentativi)");
                    System.out.println(" * 3 * Difficile (Massimo 5 tentativi)");
                    difficolta = scanner.nextInt();

                    switch(difficolta) {

                        case 1:
                            tentativi = 10;
                            break;
                        case 2:
                            tentativi = 7;
                            break;
                        case 3:
                            tentativi = 5;
                            break;
                        default:
                            System.out.println("Difficoltà non valida, impostata a Facile (Massimo 10 tentativi)");
                            tentativi = 10;
                    }

                    numeroCasuale = random.nextInt(101);
                    System.out.print("Indovina a che numero sto pensando ⁉️ da 0 a 100 ⁉️ : ");
                    numeroUtente = scanner.nextInt();
                    break;
                case 2:
                    System.out.println("Grazie mille per aver giocato con Akinumber");
                    return;
                default:
                    System.out.println("Scelta non valida, riprova.");
            }

            //while per il controllo della risposta dell'utente con quella del bot
            while (numeroUtente != numeroCasuale && tentativi > 0) {

                if (numeroUtente > numeroCasuale) {
                    System.out.println("Acqua, il numero che hai inserito è troppo alto");
                } else if (numeroUtente < numeroCasuale) {
                    System.out.println("Acqua, il numero che hai inserito è troppo basso");
                }

                tentativi--;
                System.out.println("Tentativi rimasti: " + tentativi);

                if (tentativi > 0) {
                    System.out.print("Riprova: ");
                    numeroUtente = scanner.nextInt();
                }
            }

            if (numeroUtente == numeroCasuale) {
                System.out.println("COMPLIMENTI HAI VINTO!!");
            }else {
                System.out.println("Hai perso! Il numero era: " + numeroCasuale);
            }
        }
    }
}
