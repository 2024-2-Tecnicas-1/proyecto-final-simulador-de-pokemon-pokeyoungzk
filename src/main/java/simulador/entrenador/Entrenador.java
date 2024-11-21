package simulador.entrenador;

import java.util.ArrayList;
import simulador.pokemon.Pokemon;


public class Entrenador {
    private String nombre;
    private ArrayList<Pokemon> equipo;

    public Entrenador(String nombre) {
        this.nombre = nombre;
        this.equipo = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void agregarPokemon(Pokemon pokemon) {
        equipo.add(pokemon);
        System.out.println(pokemon.getNombre() + " ha sido agregado al equipo de " + nombre);
    }

    public void entrenarPokemon(Pokemon pokemon) {
        pokemon.mejorarEstadisticas(15);
        System.out.println(pokemon.getNombre() + " ha mejorado sus estadísticas un 15%.");
    }

    public ArrayList<Pokemon> getEquipo() {
        return equipo;
    }

    public String Nombre() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
}

