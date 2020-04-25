
package primerproyectolenguajes;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class EstadoAFD {
    
    public String ID;
    public Set<Integer> Nombre;
    public HashMap<String, EstadoAFD> Mover;
    
    public boolean Aceptar;
    public boolean Marcar;
    
    public EstadoAFD(String ID){
        this.ID = ID;
        Mover = new HashMap<>();
        Nombre = new HashSet<>();
        Aceptar = false;
        Marcar = false;
    }
    
    public void AñadirMover(String Simbolo, EstadoAFD s)
    {
        Mover.put(Simbolo, s);
    }
    
    public void AñadirNombre(int Numero)
    {
        Nombre.add(Numero);
    }
    
    public void AñadirAllNombre(Set<Integer> Numero)
    {
        Nombre.addAll(Numero);
    }
    
    public void SetMarcar(boolean bool){
        Marcar = bool;
    }
    
    public boolean getMarcar(){
        return Marcar;
    }
    
    public Set<Integer> getNombre(){
        return Nombre;
    }

    public void setAceptar() {
        Aceptar = true;
    }
    
    public boolean getAceptar(){
        return  Aceptar;
    }
    
    public EstadoAFD getSiguienteSimbolo(String str){
        return this.Mover.get(str);
    }
    
    public HashMap<String, EstadoAFD> getAllMovimientos()
    {
        return Mover;
    }
     public String toString (){  
        String cadena ="";
        cadena += ID;
        cadena += Nombre.toString();
        return cadena;
    }
    
}
