package simulador;

import simulador.batalla.Batalla;
import simulador.entrenador.Entrenador;
import simulador.pokemon.*;
import java.util.Random;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        Entrenador entrenador = new Entrenador("Jugador");
        entrenador.agregarPokemon(new Charmander());
        entrenador.agregarPokemon(new Squirtle());
        entrenador.agregarPokemon(new Bulbasaur());
        entrenador.agregarPokemon(new Pikachu());
        entrenador.agregarPokemon(new Abra());
        entrenador.agregarPokemon(new Geodude());
        entrenador.agregarPokemon(new Pidgey());
        entrenador.agregarPokemon(new Jigglypuff());

        Entrenador enemigo = new Entrenador("Enemigo");
        enemigo.agregarPokemon(new Charmander());
        enemigo.agregarPokemon(new Squirtle());
        enemigo.agregarPokemon(new Bulbasaur());
        enemigo.agregarPokemon(new Pikachu());
        enemigo.agregarPokemon(new Abra());
        enemigo.agregarPokemon(new Geodude());
        enemigo.agregarPokemon(new Pidgey());
        enemigo.agregarPokemon(new Jigglypuff());
        int opcion;
        do {
            System.out.println("\n--- Simulador de Batallas Pokemon ---");
            System.out.println("1. Entrenar un Pokemon");
            System.out.println("2. Batalla ");
            System.out.println("3. Salir");
            System.out.print("Elige una opcion: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("\n--- Entrenar Pokemon ---");
                    System.out.println("Elige un Pokemon para entrenar:");
                    for (int i = 0; i < entrenador.getEquipo().size(); i++) {
                        Pokemon p = entrenador.getEquipo().get(i);
                        System.out.println((i + 1) + ". " + p.getNombre() + " (Vida: " + p.getVida() + ", Poder: " + p.getPoder() + ")");
                    }
                    System.out.print("Opcion: ");
                    int opcionEntrenar = sc.nextInt();

                    if (opcionEntrenar > 0 && opcionEntrenar <= entrenador.getEquipo().size()) {
                        Pokemon pokemonAEntrenar = entrenador.getEquipo().get(opcionEntrenar - 1);
                        entrenador.entrenarPokemon(pokemonAEntrenar);
                        System.out.println(pokemonAEntrenar.getNombre() + " ha mejorado sus estadisticas!");
                    } else {
                        System.out.println("Opcion invalida.");
                    }
                    break;

                case 2:
                    System.out.println("\n--- Batalla  ---");
                    System.out.println("Elige un Pokemon para combatir:");
                    for (int i = 0; i < entrenador.getEquipo().size(); i++) {
                        Pokemon p = entrenador.getEquipo().get(i);
                        System.out.println((i + 1) + ". " + p.getNombre() + " (Vida: " + p.getVida() + ", Poder: " + p.getPoder() + ")");
                    }
                    System.out.print("Opcion: ");
                    int opcionCombate = sc.nextInt();

                    if (opcionCombate > 0 && opcionCombate <= entrenador.getEquipo().size()) {
                        Pokemon pokemonJugador = entrenador.getEquipo().get(opcionCombate - 1);
                        Pokemon pokemonEnemigo = enemigo.getEquipo().get(random.nextInt(enemigo.getEquipo().size()));

                        System.out.println("Tu Pokemon: " + pokemonJugador.getNombre() + " (Vida: " + pokemonJugador.getVida() + ")");
                        System.out.println("Pokemon enemigo: " + pokemonEnemigo.getNombre() + " (Vida: " + pokemonEnemigo.getVida() + ")");

                        Batalla batalla = new Batalla();
                        batalla.iniciarBatalla(pokemonJugador, pokemonEnemigo);
                    } else {
                        System.out.println("Opcion invalida.");
                    }
                    break;

                case 3:
                    System.out.println("Gracias por jugar! Hasta la proxima.");
                    break;

                default:
                    System.out.println("Opcion invalida. Intenta de nuevo.");
            }
        } while (opcion != 3);

        sc.close();
    }
}
