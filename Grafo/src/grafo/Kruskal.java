package grafo;

import java.util.ArrayList;
import java.util.Collections;

import grafo.Aresta;
import grafo.Grafo;
import grafo.Vertice;

public class Kruskal {
    public static <T> void kruskal(Grafo<T> g) {
        Grafo<T> arvGer = new Grafo<>();
        iniciarArv(g, arvGer);

        ArrayList<Aresta<T>> listaArestas = new ArrayList<>();
        listaArestas.addAll(g.getArestas());
        Collections.sort(listaArestas);

        int numVer = g.getVertices().size();

        ArrayList<ArrayList<Vertice<T>>> matriz = new ArrayList<>();

        while (arvGer.getArestas().size() != numVer - 1) {
            Aresta<T> aresta = null;
            Vertice<T> vertEntrada = null, vertSaida = null;
            boolean arestaInvalida = false;

            ArrayList<Vertice<T>> arrayDoVertEntrada = null, arrayDoVertSaida = null;

            do{
                aresta = listaArestas.remove(0);
                vertEntrada = aresta.getEntrada();
                vertSaida = aresta.getSaida();

                for (ArrayList<Vertice<T>> array : matriz) {
                    if (array.contains(vertEntrada) && array.contains(vertSaida)) {
                        arestaInvalida = true;
                        continue;
                    }
                    arestaInvalida = false;

                    if (array.contains(vertEntrada)) arrayDoVertEntrada = array;
                    if (array.contains(vertSaida)) arrayDoVertSaida = array;
                }
            }while(arestaInvalida);

            if(arrayDoVertEntrada == null && arrayDoVertSaida == null){
                ArrayList<Vertice<T>> arr = new ArrayList<>();
                arr.add(vertEntrada);
                arr.add(vertSaida); 
                matriz.add(arr);
            }else{
                if (arrayDoVertEntrada != null  && arrayDoVertSaida != null) {
                    for (Vertice<T> vertice : arrayDoVertSaida) 
                        arrayDoVertEntrada.add(vertice);
                    matriz.remove(arrayDoVertSaida);
                }

                if(arrayDoVertEntrada != null && arrayDoVertSaida == null) arrayDoVertEntrada.add(vertSaida);
                if(arrayDoVertEntrada == null && arrayDoVertSaida != null) arrayDoVertSaida.add(vertEntrada);
            }

            arvGer.adicionarAresta(vertEntrada.getDados(), vertSaida.getData(), aresta.getPeso());
        }

        for(Aresta<T> aresta : arvGer.getArestas()){
            System.out.println(aresta.getEntrada().getDados() + " -- " + aresta.getSaida().getData());
        }
    }

    private static <T> void iniciarArv(Grafo<T> grafo, Grafo<T> arvGer) {
        for (Vertice<T> v : grafo.getVertices()) {
            arvGer.adicionarVertice(v.getDados());
        }
    }
}
