package grafo;

public class Aresta<T> implements Comparable<Aresta<T>> {
    private Double peso;
    private Vertice<T> entrada;
    private Vertice<T> saida;

    public Aresta(Vertice<T> entrada, Vertice<T> saida, double peso) {
        this.peso = peso;
        this.entrada = entrada;
        this.saida = saida;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public Vertice<T> getEntrada() {
        return entrada;
    }

    public void setEntrada(Vertice<T> entrada) {
        this.entrada = entrada;
    }

    public Vertice<T> getSaida() {
        return saida;
    }

    public void setSaida(Vertice<T> saida) {
        this.saida = saida;
    }

    @Override
    public int compareTo(Aresta<T> o) {
        if (this.peso > o.peso) {
            return 1;
        }
        if (this.peso == o.peso) {
            return 0;
        }
        if (this.peso < o.peso) {
            return -1;
        }
        return 0;
    }
}
