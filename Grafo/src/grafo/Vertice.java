package grafo;

import java.util.ArrayList;

public class Vertice<T> {
    private T dados;
    private ArrayList<Aresta<T>> arestasEntrando;
    private ArrayList<Aresta<T>> arestasSaindo;
    private ArrayList<Vertice<T>> adjs;

    private Vertice<T> pred;
    private double dist;
    private boolean aberto;

    public Vertice(T dado) {
        this.dados = dado;
        this.arestasEntrando = new ArrayList<>();
        this.arestasSaindo = new ArrayList<>();
        this.adjs = new ArrayList<>();

        this.pred = null;
        this.dist = Double.MAX_VALUE / 2;
        this.aberto = true;
    }

    public T getDados() {
        return dados;
    }

    public void setDados(T dados) {
        this.dados = dados;
    }

    public ArrayList<Vertice<T>> getAdjs() {
        return adjs;
    }

    public void adicionarArestaEntrando(Aresta<T> aresta) {
        this.arestasEntrando.add(aresta);
    }

    public void adicionarArestaSaindo(Aresta<T> aresta) {
        this.arestasSaindo.add(aresta);
    }

    public T getData() {
        return dados;
    }

    public void setData(T dado) {
        this.dados = dado;
    }

    public ArrayList<Aresta<T>> getArestasEntrando() {
        return arestasEntrando;
    }

    public void setArestasEntrando(ArrayList<Aresta<T>> arestasEntrando) {
        this.arestasEntrando = arestasEntrando;
    }

    public ArrayList<Aresta<T>> getArestasSaindo() {
        return arestasSaindo;
    }

    public void setArestasSaindo(ArrayList<Aresta<T>> arestasSaindo) {
        this.arestasSaindo = arestasSaindo;
    }

    public Vertice<T> getPred() {
        return pred;
    }

    public void setPred(Vertice<T> pred) {
        this.pred = pred;
    }

    public double getDist() {
        return dist;
    }

    public void setDist(double dist) {
        this.dist = dist;
    }

    public boolean isAberto() {
        return aberto;
    }

    public void setAberto(boolean aberto) {
        this.aberto = aberto;
    }

    
}
