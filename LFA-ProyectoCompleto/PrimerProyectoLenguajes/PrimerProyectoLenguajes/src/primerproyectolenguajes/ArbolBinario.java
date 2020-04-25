package primerproyectolenguajes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class ArbolBinario 

{

    private int IDNodoHoja = 0;
    
    public Stack<NodoArbol> PilaNodo = new Stack<>();
    public Stack<Character> Operador = new Stack<Character>();
  
   
    public Set<Character> Entrada = new HashSet<Character>();
    public ArrayList<Character> op = new ArrayList<>();

    public NodoArbol GenerarArbol(String regular) 
    {

        Character[] ops = {'*','|', '&','?','+'};
        op.addAll(Arrays.asList(ops));
        Character ch[] = new Character[26 + 26];
        for (int i = 65; i <= 90; i++) {
            ch[i - 65] = (char) i;
            ch[i - 65 + 26] = (char) (i + 32);
        }
        Character integer[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        Character others[] = new Character[256];
          for (int j = 0; j < others.length; j++) 
                  {
                 others[j] =(char)j;
                   }
        Entrada.addAll(Arrays.asList(ch));
        Entrada.addAll(Arrays.asList(integer));
        Entrada.addAll(Arrays.asList(others));

        regular = Concatenar(regular);
        
        
        PilaNodo.clear();
        Operador.clear();

        boolean Simbolo = false;

        for (int i = 0; i < regular.length(); i++) {

            if (regular.charAt(i) == '\\') 
            {
                Simbolo = true;
                continue;
            }
            if (Simbolo || CaracterEntrada(regular.charAt(i))) 
            {
                if (Simbolo) 
                {
                   
                    pushStack("\\"+Character.toString(regular.charAt(i)));
                }
                else{
                    pushStack(Character.toString(regular.charAt(i)));
                }
                Simbolo = false;
            }
            else if (Operador.isEmpty()) 
            {
                Operador.push(regular.charAt(i));

            } else if (regular.charAt(i) == '(') 
            {
                Operador.push(regular.charAt(i));

            } else if (regular.charAt(i) == ')') 
            {
                while (Operador.get(Operador.size() - 1) != '(') 
                {
                    Operar();
                }

               
                Operador.pop();

            } else {
                while (!Operador.isEmpty()
                        && Prioridad(regular.charAt(i), Operador.get(Operador.size() - 1))) {
                    Operar();
                }
                Operador.push(regular.charAt(i));
            }
        }

        while (!Operador.isEmpty()) {
            Operar();
        }

        NodoArbol completeTree = PilaNodo.pop();
        return completeTree;
    }

    public boolean Prioridad(char Primero, Character Segundo) 
    {
        if (Primero == Segundo) {
            return true;
        }
        if (Primero == '*') {
            return false;
        }
        if (Segundo == '*') {
            return true;
        }
        
          if (Primero == '?') {
            return false;
        }
        if (Segundo == '?') {
            return true;
        }
        if (Primero == '&') {
            return false;
        }
        if (Segundo == '&') {
            return true;
        }
        if (Primero == '|') {
            return false;
        }
           if (Primero == '+') {
            return false;
        }
        if (Segundo == '+') {
            return true;
        }
        return true;
    }

    public void Operar() 
    {
        if (this.Operador.size() > 0) {
            char charAt = Operador.pop();

            switch (charAt) {
                case ('|'):
                    union();
                    break;

                case ('&'):
                    Concatenacion();
                    break;

                case ('*'):
                    Inicio();
                    break;
                    
                    case ('?'):
                    Inicio2();
                    break;
                                           
            }
        }
    }


    public void Inicio() 
    {
        NodoArbol node = PilaNodo.pop();
        NodoArbol root = new NodoArbol("*");
        root.EstablecerNodoIzquierdo(node);
        root.EstablecerNodoDerecho(null);
        node.setParent(root);
        PilaNodo.push(root);
    }
    
     public void Inicio2() 
    {
        NodoArbol node = PilaNodo.pop();
        NodoArbol root = new NodoArbol("?");
        root.EstablecerNodoIzquierdo(node);
        root.EstablecerNodoDerecho(null);
        node.setParent(root);
        PilaNodo.push(root);
    }
  


    private void Concatenacion() 
    {
      
        NodoArbol node2 = PilaNodo.pop();
        NodoArbol node1 = PilaNodo.pop();

        NodoArbol root = new NodoArbol("&");
        root.EstablecerNodoIzquierdo(node1);
        root.EstablecerNodoDerecho(node2);
        node1.setParent(root);
        node2.setParent(root);
        PilaNodo.push(root);
    }

    private void union() 
    {
        NodoArbol node2 = PilaNodo.pop();
        NodoArbol node1 = PilaNodo.pop();

        NodoArbol root = new NodoArbol("|");
        root.EstablecerNodoIzquierdo(node1);
        root.EstablecerNodoDerecho(node2);
        node1.setParent(root);
        node2.setParent(root);

        PilaNodo.push(root);
    }

    
    private void pushStack(String Simbolo) 
    {
        NodoArbol node = new HojaArbol(Simbolo, ++IDNodoHoja);
        node.EstablecerNodoIzquierdo(null);
        node.EstablecerNodoDerecho(null);
        PilaNodo.push(node);
    }

    private String Concatenar(String regular) {
        String newRegular = new String("");

        for (int i = 0; i < regular.length() - 1; i++) {
           
            if (regular.charAt(i) == '\\' && CaracterEntrada(regular.charAt(i + 1))) {
                newRegular += regular.charAt(i);
            } else if (regular.charAt(i) == '\\' && regular.charAt(i + 1) == '(') {
                newRegular += regular.charAt(i);
            } else if ((CaracterEntrada(regular.charAt(i)) || (regular.charAt(i) == '(' && i > 0 && regular.charAt(i - 1) == '\\')) && CaracterEntrada(regular.charAt(i + 1))) {
                newRegular += regular.charAt(i) + "&";

            } else if ((CaracterEntrada(regular.charAt(i)) || (regular.charAt(i) == '(' && i > 0 && regular.charAt(i - 1) == '\\')) && regular.charAt(i + 1) == '(') {
                newRegular += regular.charAt(i) + "&";

            } else if (regular.charAt(i) == ')' && CaracterEntrada(regular.charAt(i + 1))) {
                newRegular += regular.charAt(i) + "&";

            } else if (regular.charAt(i) == '*' && CaracterEntrada(regular.charAt(i + 1))) {
                newRegular += regular.charAt(i) + "&";

            } else if (regular.charAt(i) == '*' && regular.charAt(i + 1) == '(') {
                newRegular += regular.charAt(i) + "&";

            } else if (regular.charAt(i) == ')' && regular.charAt(i + 1) == '(') {
                newRegular += regular.charAt(i) + "&";

            } else {
                newRegular += regular.charAt(i);
            }

        }
        newRegular += regular.charAt(regular.length() - 1);
        return newRegular;
    }

  
    private boolean CaracterEntrada(char charAt) 
    {

        if (op.contains(charAt)) {
            return false;
        }
        for (Character c : Entrada) {
            if ((char) c == charAt && charAt != '(' && charAt != ')') {
                return true;
            }
        }
        return false;
    }
    
    public void Inorder(NodoArbol Nodo) 
    {
        if (Nodo == null) {
            return;
        }

        Inorder(Nodo.ConseguirNodoIzquierdo());
        System.out.print(Nodo.ConseguirSimbolo() + " ");
        Inorder(Nodo.ConseguirNodoDerecho());
    }
    
    public int ConseguirNumeroHojas()
    {
        return IDNodoHoja;
    }

}
