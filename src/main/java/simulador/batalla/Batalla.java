package simulador.batalla;

import simulador.pokemon.Pokemon;
import java.util.Scanner;

public class Batalla {
    public void iniciarBatalla(Pokemon pokemon1, Pokemon pokemon2) {
        System.out.println("Comienza la batalla entre " + pokemon1.getNombre() + " y " + pokemon2.getNombre() + "!");

        Scanner sc = new Scanner(System.in);

        while (pokemon1.getVida() > 0 && pokemon2.getVida() > 0) {
            System.out.println("\nTurno de " + pokemon1.getNombre());
            System.out.print("Elige un movimiento (Z: Golpe, X: Super Poder): ");
            char tecla = sc.next().toUpperCase().charAt(0);
            pokemon1.atacar(pokemon2, tecla);
            System.out.println(pokemon2.getNombre() + " tiene " + pokemon2.getVida() + " puntos de vida restantes.");

            if (pokemon2.getVida() <= 0) {
                System.out.println("\n" + pokemon2.getNombre() + " ha sido derrotado.");
                System.out.println(pokemon1.getNombre() + " es el ganador.");
                break;
            }

            System.out.println("\nTurno de " + pokemon2.getNombre());
            pokemon2.atacar(pokemon1, 'Z');
            System.out.println(pokemon1.getNombre() + " tiene " + pokemon1.getVida() + " puntos de vida restantes.");

            if (pokemon1.getVida() <= 0) {
                System.out.println("\n" + pokemon1.getNombre() + " ha sido derrotado.");
                System.out.println(pokemon2.getNombre() + " es el ganador.");
                break;
            }
        }
    }
}
