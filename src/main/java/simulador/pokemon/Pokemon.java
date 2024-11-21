package simulador.pokemon;

public class Pokemon {
    private String nombre;
    private TipoPokemon tipo;
    private int vida;
    private int poder;
    public Pokemon(String nombre, TipoPokemon tipo, int vida, int poder) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.vida = vida;
        this.poder = poder;
    }
    public String getNombre() {
        return nombre;
    }

    public TipoPokemon getTipo() {
        return tipo;
    }

    public int getVida() {
        return vida;
    }

    public int getPoder() {
        return poder;
    }

    public void mejorarEstadisticas(int porcentaje) {
        this.vida += (this.vida * porcentaje) / 100;
        this.poder += (this.poder * porcentaje) / 100;
    }

    public void atacar(Pokemon oponente, char tecla) {
        switch (tecla) {
            case 'Z':
                golpe(oponente);
                break;
            case 'X':
                superPoder(oponente);
                break;
            default:
                System.out.println("Accion no reconocida.");
        }
    }

    private void golpe(Pokemon oponente) {
        int daño = calcularDano(oponente);
        oponente.recibirDano(daño);
        System.out.println(nombre + " usa Golpe contra " + oponente.getNombre() + " causando " + daño + " de dano.");
    }

    private void superPoder(Pokemon oponente) {
        int dano = calcularDano(oponente) * 4; 
        oponente.recibirDano(dano);
        System.out.println(nombre + " usa Super Poder contra " + oponente.getNombre() + " causando " + dano + " de dano.");
    }

    public void recibirDano(int dano) {
        this.vida -= dano;
        if (this.vida < 0) this.vida = 0;
    }

    private int calcularDano(Pokemon oponente) {
        if (this.tipo.esFuerteContra(oponente.getTipo())) {
            return this.poder * 2; 
        }
        return this.poder;
    }
}
