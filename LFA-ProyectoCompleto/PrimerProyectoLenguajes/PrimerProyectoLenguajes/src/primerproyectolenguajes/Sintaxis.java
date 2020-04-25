package primerproyectolenguajes;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Sintaxis {

    public String ER;
    public ArbolBinario Arbol;
    public NodoArbol Rama;
    public int NumeroHojas;
    public Set<Integer>[] Follow;
    public  Set<Integer> in;
     public  Set<Integer> setFirst;
    public  String First="";   
    public  Set<Integer> setLast;
    public  String cLast="";
    public  int c = 0;
    public  String Valor="";
    
    public  ArrayList<String>listaValores = new ArrayList<>();

    public Sintaxis(String ExpresionRegular) 
    {
        this.ER = ExpresionRegular;
        Arbol = new ArbolBinario();
        
        Rama = Arbol.GenerarArbol(ExpresionRegular);
        NumeroHojas = Arbol.ConseguirNumeroHojas();
        Follow = new Set[NumeroHojas];
        
        for (int i = 0; i < NumeroHojas; i++) 
        {
            Follow[i] = new HashSet<>();
        }
        
        GenerarNullable(Rama);
        GenerarFirstYLast(Rama);
        GenerarFollow(Rama);
    }

    public void GenerarNullable(NodoArbol Nodo) 
    {
        if (Nodo == null) {
            return;
        }
        if (!(Nodo instanceof HojaArbol)) {
            NodoArbol left = Nodo.ConseguirNodoIzquierdo();
            NodoArbol right = Nodo.ConseguirNodoDerecho();
            GenerarNullable(left);
            GenerarNullable(right);
            switch (Nodo.ConseguirSimbolo()) {
                case "|":
                    Nodo.setNullable(left.EsNullable() | right.EsNullable());
                    break;
                case "&":
                    Nodo.setNullable(left.EsNullable() & right.EsNullable());
                    break;
                case "*":
                    Nodo.setNullable(true);
                    break;
                     case "?":
                    Nodo.setNullable(true);
                    break;
                    case "+":
                        try
                        {
                            if(left.EsNullable()==true)
                            {
                                  Nodo.setNullable(true);
                            }
                            else
                            {
                                  Nodo.setNullable(false);
                                    break;
                            }
                        }
                        catch(Exception e)
                        {
                                 Nodo.setNullable(false);
                                 break;
                        }
                        
                        try
                        {
                            if(right.EsNullable()==true)
                            {
                                  Nodo.setNullable(true);
                                    break;
                            }
                            else
                            {
                                  Nodo.setNullable(false);
                                    break;
                            }
                        }
                        catch(Exception e)
                        {
                                 Nodo.setNullable(false);
                                   break;
                        }
                  
                
            }
        }
    }

    public void GenerarFirstYLast(NodoArbol Nodo) 
    {
            if(c==0){
        if (Nodo == null) {
            return;
        }
        if (Nodo instanceof HojaArbol) {
            HojaArbol lnode = (HojaArbol) Nodo;
            Nodo.AñadirFirst(lnode.getNumero());
            Nodo.addLast(lnode.getNumero());
        } else {
            NodoArbol left = Nodo.ConseguirNodoIzquierdo();
            NodoArbol right = Nodo.ConseguirNodoDerecho();
            GenerarFirstYLast(left);
            GenerarFirstYLast(right);
            switch (Nodo.ConseguirSimbolo()) {
                case "|":
                    Nodo.AñadirAllFirst(left.getFirst());
                    Nodo.AñadirAllFirst(right.getFirst());
                    Nodo.addAllLast(left.getLast());
                    Nodo.addAllLast(right.getLast());                  
                    break;
                case "&":
                    if (left.EsNullable()) {
                        Nodo.AñadirAllFirst(left.getFirst());
                        Nodo.AñadirAllFirst(right.getFirst());
                    } else {
                        Nodo.AñadirAllFirst(left.getFirst());
                    }
                    if (right.EsNullable()) {
                        Nodo.addAllLast(left.getLast());
                        Nodo.addAllLast(right.getLast());
                    } else {
                        Nodo.addAllLast(right.getLast());
                    }
                    break;
                case "*":
                    Nodo.AñadirAllFirst(left.getFirst());
                    Nodo.addAllLast(left.getLast());
                    break;
                case "?":
                    Nodo.AñadirAllFirst(left.getFirst());
                    Nodo.addAllLast(left.getLast());
                    break;
                case "+":
                    Nodo.AñadirAllFirst(left.getFirst());
                    Nodo.addAllLast(left.getLast());
                    break;
            }
        }
         listaValores.add(Nodo.ConseguirSimbolo());
         
        setFirst = (Nodo.getFirst()); 
        First += "-" + setFirst.toString();
        
        setLast = (Nodo.getLast()); 
        cLast += "-" + setLast.toString();
    }
        else {
            if (Nodo == null) {
            return;
        }
        if (Nodo instanceof HojaArbol) {
            HojaArbol lnode = (HojaArbol) Nodo;
            Nodo.AñadirFirst(lnode.getNumero());
            Nodo.AñadirFirst(lnode.getNumero());
        } else {
            NodoArbol left = Nodo.ConseguirNodoIzquierdo();
            NodoArbol right = Nodo.ConseguirNodoDerecho();
            GenerarFirstYLast(left);
            GenerarFirstYLast(right);
            switch (Nodo.ConseguirSimbolo()) {
                case "|":
                    Nodo.AñadirAllFirst(left.getFirst());
                    Nodo.AñadirAllFirst(right.getFirst());
                    Nodo.addAllLast(left.getLast());
                    Nodo.addAllLast(right.getLast());                  
                    break;
                case "&":
                    if (left.EsNullable()) {
                        Nodo.AñadirAllFirst(left.getFirst());
                        Nodo.AñadirAllFirst(right.getFirst());
                    } else {
                        Nodo.AñadirAllFirst(left.getFirst());
                    }
                    if (right.EsNullable()) {
                        Nodo.addAllLast(left.getLast());
                        Nodo.addAllLast(right.getLast());
                    } else {
                        Nodo.addAllLast(right.getLast());
                    }
                    break;
                case "*":
                    Nodo.AñadirAllFirst(left.getFirst());
                    Nodo.addAllLast(left.getLast());
                    break;
                case "?":
                    Nodo.AñadirAllFirst(left.getFirst());
                    Nodo.addAllLast(left.getLast());
                    break;
                case "+":
                    Nodo.AñadirAllFirst(left.getFirst());
                    Nodo.addAllLast(left.getLast());
                    break;
            }
        }
    }
       
        
    }

    public void GenerarFollow(NodoArbol Nodo) 
    {
       c++;
        if (Nodo == null) 
        {
            return;
        }
        NodoArbol Izquierdo = Nodo.ConseguirNodoIzquierdo();
        NodoArbol Derecho = Nodo.ConseguirNodoDerecho();
        switch (Nodo.ConseguirSimbolo()) 
        {
            case "&":
                Object lastpos_c1[] = Izquierdo.getLast().toArray();
                Set<Integer> firstpos_c2 = Derecho.getFirst();
                for (int i = 0; i < lastpos_c1.length; i++) 
                {
                    Follow[(Integer) lastpos_c1[i] - 1].addAll(firstpos_c2);
                }
                break;
            case "*":
                Object lastpos_n[] = Nodo.getLast().toArray();
                Set<Integer> firstpos_n = Nodo.getFirst();
                for (int i = 0; i < lastpos_n.length; i++) 
                {
                    Follow[(Integer) lastpos_n[i] - 1].addAll(firstpos_n);
                }
                break;
                
                case "?":
                Object lastpos_n2[] = Nodo.getLast().toArray();
                Set<Integer> firstpos_n2 = Nodo.getFirst();
                for (int i = 0; i < lastpos_n2.length; i++) 
                {
                    Follow[(Integer) lastpos_n2[i] - 1].addAll(firstpos_n2);
                }
                break;
                    
                case "+":
                Object lastpos_n3[] = Nodo.getLast().toArray();
                Set<Integer> firstpos_n3 = Nodo.getFirst();
                for (int i = 0; i < lastpos_n3.length; i++) 
                {
                    Follow[(Integer) lastpos_n3[i] - 1].addAll(firstpos_n3);
                }
                break;
                    
        }
        GenerarFollow(Nodo.ConseguirNodoIzquierdo());
        GenerarFollow(Nodo.ConseguirNodoDerecho());

    }

    public void Mostrar(NodoArbol Nodo) 
    {
        if (Nodo == null) 
        {
            return;
        }
        Mostrar(Nodo.ConseguirNodoIzquierdo());
        Object s[] = Nodo.getLast().toArray();

        Mostrar(Nodo.ConseguirNodoDerecho());
    }

    public void MostrarFollow() 
    {
        for (int i = 0; i < Follow.length; i++) 
        {
            Object s[] = Follow[i].toArray();
        }
    }

    public Set<Integer>[] ConseguirFollow() 
    {
        return Follow;
    }

    public NodoArbol ConseguirRama() 
    {
        return this.Rama;
        
    }
    
   
}
