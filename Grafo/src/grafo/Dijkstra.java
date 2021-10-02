package grafo;

import java.util.ArrayList;

public class Dijkstra<T> {
    public void dijkstra(Grafo<T> grafo, T inicio, T fim) {
        grafo.getVertice(inicio).setDist(0);
        ArrayList<Vertice<T>> abertos = new ArrayList<>();
        preencherAbertos(grafo, abertos);

        while (abertos.size() > 0) {
            Vertice<T> atual = menorDist(abertos);

            atual.setAberto(false);
            abertos.remove(atual);

            for (Aresta<T> aresta : atual.getArestasSaindo()) {
                if (aresta.getSaida().isAberto()) {
                    relaxar(atual, aresta.getSaida(), aresta.getPeso());
                }
            }
        }

        ArrayList<Vertice<T>> caminho = new ArrayList<>();
        Vertice<T> atual = grafo.getVertice(fim);
        double menorDist = atual.getDist();

        caminho.add(0, atual);

        while (atual.getPred() != null) {
            caminho.add(0, atual.getPred());
            atual = atual.getPred();
        }

        if(menorDist >= 50){
            for (Vertice<T> vert : caminho) {
                System.out.println("Vertice -> " + vert.getDados() + ", Distância atual: (" + vert.getDist() + ")");
            }
        }else{
            System.out.println("Caminho menor que 50");
        }
    }

    private Vertice<T> menorDist(ArrayList<Vertice<T>> abertos) {
        Vertice<T> menor = null;

        for (int i = 0; i < abertos.size(); i++) {
            Vertice<T> atual = abertos.get(i);

            if (i == 0 || atual.getDist() < menor.getDist()) {
                menor = atual;
            }
        }

        return menor;
    }

    private void preencherAbertos(Grafo<T> grafo, ArrayList<Vertice<T>> abertos) {
        abertos.addAll(grafo.getVertices());
    }

    private void relaxar(Vertice<T> inicio, Vertice<T> fim, double peso) {
        double novaDist = inicio.getDist() + peso;

        if(novaDist < fim.getDist()) {
            fim.setPred(inicio);
            fim.setDist(novaDist);
        }
    }
}
