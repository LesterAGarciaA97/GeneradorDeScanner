
package primerproyectolenguajes;


import java.util.HashSet;
import java.util.Set;

 public class HojaArbol extends NodoArbol {

    public int num;
    public Set<Integer> follow;

    public HojaArbol(String simbolo, int num) {
        super(simbolo);
        this.num = num;
        follow = new HashSet<>();
    }

    public int getNumero() {
        return num;
    }

   
    public void setNumero(int numero) {
        this.num = numero;
    }
    
    public void addFollow(int numero){
        follow.add(numero);
    }

    
    public Set<Integer> getFollow() {
        return follow;
    }

  
    public void setFollow(Set<Integer> Follow) {
        this.follow = Follow;
    }
}
