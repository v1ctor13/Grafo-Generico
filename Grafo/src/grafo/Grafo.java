package grafo;

import java.util.ArrayList;

public class Grafo<T> {

    private ArrayList<Vertice<T>> vertices;
    private ArrayList<Aresta<T>> arestas;

    public Grafo() {
        this.vertices = new ArrayList<>();
        this.arestas = new ArrayList<>();
    }

    public int adicionarVertice(T dado) {
        Vertice<T> novo = new Vertice<>(dado);
        this.vertices.add(novo);
        return 1;
    }

    public int adicionarAresta(T dado1, T dado2, double peso) {
        try {
            Vertice<T> v1 = this.getVertice(dado1);
            Vertice<T> v2 = this.getVertice(dado2);
            Aresta<T> aresta = new Aresta<>(v1, v2, peso);

            v1.adicionarArestaSaindo(aresta);
            v2.adicionarArestaEntrando(aresta);

            v1.getAdjs().add(v2);
            v2.getAdjs().add(v1);

            this.arestas.add(aresta);
            return 1;
        } catch (Exception e) {
            System.err.println("ERRO: não foi possivel adicionar uma aresta ponderada - " + e);
            return 0;
        }
    }

    public Vertice<T> getVertice(T dado) {
        for (Vertice<T> i : this.vertices) {
            if (i.getData().equals(dado)) {
                return i;
            }
        }
        return null;
    }

    public ArrayList<Vertice<T>> getVertices() {
        return vertices;
    }

    public void setVertices(ArrayList<Vertice<T>> vertices) {
        this.vertices = vertices;
    }

    public ArrayList<Aresta<T>> getArestas() {
        return arestas;
    }

    public void setArestas(ArrayList<Aresta<T>> arestas) {
        this.arestas = arestas;
    }

    public int buscarIndex(Vertice<T> v) {
        return this.getVertices().indexOf(v);
    }
}
