package simulador.pokemon;

import java.util.HashMap;
import java.util.Map;

public enum TipoPokemon {
    FUEGO, AGUA, PLANTA, ELECTRICO, NORMAL, HIELO;

    private static final Map<TipoPokemon, TipoPokemon> ventajas = new HashMap<>();

    static {
        ventajas.put(FUEGO, PLANTA);       
        ventajas.put(AGUA, FUEGO);        
        ventajas.put(PLANTA, AGUA);     
        ventajas.put(ELECTRICO, AGUA);   
        ventajas.put(HIELO, PLANTA);    
    }
   public boolean esFuerteContra(TipoPokemon otroTipo) {
        return ventajas.containsKey(this) && ventajas.get(this) == otroTipo;
    }
}

 