import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Card {
    private String palo;
    private String color;
    private String valor;

    public Card(String palo, String color, String valor) {
        this.palo = palo;
        this.color = color;
        this.valor = valor;
    }

    public String getPalo() {
        return palo;
    }

    public String getColor() {
        return color;
    }

    public String getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return palo + "," + color + "," + valor;
    }
}

class Deck {
    private List<Card> cartas;

    public Deck() {
        cartas = new ArrayList<>();
        String[] palos = {"tréboles", "corazones", "picas", "diamantes"};
        String[] colores = {"negro", "rojo"};
        String[] valores = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "A", "J", "Q", "K"};

        for (String palo : palos) {
            for (String valor : valores) {
                if (palo.equals("corazones") || palo.equals("diamantes")) {
                    cartas.add(new Card(palo, "rojo", valor));
                } else {
                    cartas.add(new Card(palo, "negro", valor));
                }
            }
        }
        Collections.shuffle(cartas);
    }

    public void shuffle() {
        Collections.shuffle(cartas);
        System.out.println("Se mezcló el Deck.");
    }

    public void head() {
        if (!cartas.isEmpty()) {
            Card carta = cartas.remove(0);
            System.out.println(carta);
            System.out.println("Quedan " + cartas.size() + " cartas en el deck.");
        } else {
            System.out.println("El deck está vacío.");
        }
    }

    public void pick() {
        if (!cartas.isEmpty()) {
            int indiceAleatorio = (int) (Math.random() * cartas.size());
            Card carta = cartas.remove(indiceAleatorio);
            System.out.println(carta);
            System.out.println("Quedan " + cartas.size() + " cartas en el deck.");
        } else {
            System.out.println("El deck está vacío.");
        }
    }

    public void hand() {
        if (cartas.size() >= 5) {
            for (int i = 0; i < 5; i++) {
                Card carta = cartas.remove(0);
                System.out.println(carta);
            }
            System.out.println("Quedan " + cartas.size() + " cartas en el deck.");
        } else {
            System.out.println("No hay suficientes cartas en el deck para repartir una mano.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Deck deck = new Deck();
        deck.head();
        deck.pick();
        deck.hand();
        deck.shuffle();
    }
}
