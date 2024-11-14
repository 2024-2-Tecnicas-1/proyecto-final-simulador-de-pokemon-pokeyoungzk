package simulador.entrenador;

import java.util.ArrayList;
import simulador.pokemon.Pokemon;

public class Entrenador {
 private String nombre;
    private ArrayList<Pokemon> equipo;

    public Entrenador(String nombre, String pokemons){
        this.nombre=nombre;
        this.equipo=new ArrayList<>();
    }
     public String getNombre(){
        return nombre;
    }
    public void agregarPokemon(Pokemon pokemon){
        equipo.add(pokemon);
        System.out.println(pokemon.getName()+" ha sido agregado al equipo "+ this.nombre);
}
    public void entrenarPokemon(){
        
    }
    public void mostraPokemons(){
        
    }
    public void prepararBatallas(){
        
    }
}

