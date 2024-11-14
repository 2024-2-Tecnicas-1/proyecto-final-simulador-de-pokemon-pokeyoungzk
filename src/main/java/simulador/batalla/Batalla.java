package simulador.batalla;

public class Batalla {
    private final String name;
    private int health = 400; // 400
    private final int attackPower;  // El poder de ataque del pokemon
    private final String type;

    public Batalla (String name, String type, int attackPower) {
        this.name = name;
        this.type = type;
        this.attackPower = attackPower;
    }

    // Metodo lanza
    public int rangedAttack() {
        int damage = (int) (attackPower * 0.9); // El ataque a distancia hace 10% menos de dano
        System.out.println(name + " lanza un ataque de " + type + " a distancia y causa " + damage + " puntos de dano!");
        return damage;
    }

    // Metodo PUNÑO
    public int normalAttack() {
        System.out.println(name + " lanza un ataque normal y causa " + attackPower + " puntos de dano!");
        return attackPower;
    }

    // Metodo ESCUDO
    public double activateShield() {
        System.out.println(name + " activa un escudo y recibira 15% menos de dano!");
        return 0.85; // El escudo reduce el dano recibido en un 15%
    }

    // Metodo Danio
    public void receiveDamage(int damage, boolean shieldActive) {
        if (shieldActive) {
            damage = (int) (damage * 0.85); // Escudo
        }
        health -= damage;
        if (health < 0) health = 0;
        System.out.println(name + " ahora tiene " + health + " puntos de vida.");
    }

    // Muere Pokemon
    public boolean isKO() {
        return health <= 0;
    }

    public String getName() {
        return name;
    }
}

