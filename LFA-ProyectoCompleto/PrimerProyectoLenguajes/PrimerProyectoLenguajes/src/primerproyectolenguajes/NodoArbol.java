
package primerproyectolenguajes;

import java.util.HashSet;
import java.util.Set;

public class NodoArbol {

    public String simbolo;
    public NodoArbol NodoPadre;
    public NodoArbol NodoIzquierda;
    public NodoArbol Nododerecha;

    public Set<Integer> First;
    public Set<Integer> Last;
    public boolean Nullable;

    public NodoArbol(String simbolo) 
    {
        this.simbolo = simbolo;
        NodoPadre = null;
        NodoIzquierda = null;
        Nododerecha = null;

        First = new HashSet<>();
        Last = new HashSet<>();
        Nullable = false;
    }

    public String ConseguirSimbolo() 
    {
        return simbolo;
    }

    public void EstablecerSimbolo(String Simbolo) 
    {
        this.simbolo = Simbolo;
    }


    public NodoArbol ConseguiNodoPadre() 
    {
        return NodoPadre;
    }
    
    public void setParent(NodoArbol Padre)
    {
        this.NodoPadre = Padre;
    }

    
    public NodoArbol ConseguirNodoIzquierdo() 
    {
        return NodoIzquierda;
    }

 
    public void EstablecerNodoIzquierdo(NodoArbol NodoIzquierdo1) 
    {
        this.NodoIzquierda = NodoIzquierdo1;
    }

   
    public NodoArbol ConseguirNodoDerecho() 
    {
        return Nododerecha;
    }

   
    public void EstablecerNodoDerecho(NodoArbol NodoDerecho) 
    {
        this.Nododerecha = NodoDerecho;
    }

    public void AñadirFirst(int Posicion) 
    {
        First.add(Posicion);
    }
    
    public void AñadirAllFirst(Set set) 
    {
        First.addAll(set);
    }

    public void addLast(int number) 
    {
        Last.add(number);
    }
    public void addAllLast(Set set) 
    {
        Last.addAll(set);
    }

    public Set<Integer> getFirst() 
    {
        return First;
    }

  
    public Set<Integer> getLast() 
    {
        return Last;
    }

    public boolean EsNullable() 
    {
        return Nullable;
    }

  
    public void setNullable(boolean nullable) 
    {
        this.Nullable = nullable;
    }
}
