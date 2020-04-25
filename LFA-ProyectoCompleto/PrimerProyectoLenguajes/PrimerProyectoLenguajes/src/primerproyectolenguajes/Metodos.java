package primerproyectolenguajes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;
import javax.swing.JOptionPane;


public class Metodos {
    
       public ArrayList<String> SETS = new ArrayList<String>();
       public ArrayList<String> TOKEN = new ArrayList<String>();
       public ArrayList<String> TOKEN2 = new ArrayList<String>();
       public ArrayList<String> ACTION = new ArrayList<String>();
       public ArrayList<String> ERROR = new ArrayList<String>();
       public ArrayList<String> Tempo = new ArrayList<String>();
       public ArrayList<String> Reemplazar =  new ArrayList<String>();
       public HashMap<String,String> Diccionario = new HashMap<String,String> ();   
       public HashMap<String,ArrayList<String>> lenguaje = new HashMap<String,ArrayList<String>>();
       public ArrayList<String> Ascii = new ArrayList<String>();
       

    public void Dividir(ArrayList<String>  archivo)
   {
       boolean condicion =false;
       boolean condicion2 =false;
       boolean condicion3 =false;
       boolean condicion4 =false;
       
       for (int i = 0; i < archivo.size(); i++) 
       {
            if(archivo.get(i).toUpperCase().contains("ERROR"))
           {
              condicion4 = true;
              condicion3 = false;
           }
           if(archivo.get(i).toUpperCase().contains("ACTIONS"))
           {
              condicion3 = true;
              condicion2 = false;
           }
           
           if(archivo.get(i).toUpperCase().contains("SETS"))
           {
               condicion = true;    
           }
            if(archivo.get(i).toUpperCase().contains("TOKENS"))
           {
             condicion = false;
             condicion2 =true;
           }
            
           if(condicion ==true)
           {
               SETS.add(archivo.get(i+1));
           }
           if(condicion2 == true)
           {
              TOKEN.add(archivo.get(i+1));
           }
           if(condicion3 == true)
           {
               int v = i+2;
               
               if(v < archivo.size())
               {
                       ACTION.add(archivo.get(i+1));
               }
               else
               {
                    ACTION.add(archivo.get(i));
               }               
           }
             if(condicion4 == true)
           {
              ERROR.add(archivo.get(i));
           }
  
       } 
       
       // <editor-fold defaultstate="collapsed" desc="Listas archivo">
       Tempo = EliminarVacios(SETS);
       SETS.clear();
       SETS = Tempo;
       SETS.remove(SETS.size()-1);
       Tempo = EliminarVacios(TOKEN);
       TOKEN.clear();
       TOKEN = Tempo;
       TOKEN.remove(TOKEN.size()-1);     
       Tempo = EliminarVacios(ACTION);
       ACTION.clear();
       ACTION = Tempo;
       String g = ERROR.get(0).replace("=", " ");
       ERROR.set(0, g);
     // </editor-fold>
       
   }
    
    public ArrayList EliminarVacios(ArrayList<String>  lista)
    {
            ArrayList<String> Nueva = new ArrayList<String>();
            
            for (int i = 0; i < lista.size(); i++) 
            {
               if(lista.get(i).length()>1)
               {
                   Nueva.add(lista.get(i));
               }
            }
            return Nueva;
    }
    
    
    public  String ExpresionRegular(ArrayList<String> token,HashMap<String,String> lenguaje)
    {        
        String ER ="";
        String tempo ="";
        String cadena = "";
        

        for (int i = 0; i < token.size() ; i++) 
        {
            if(!token.get(i).contains("'"))
            {
              if((i+1)<token.size())
              {
                 // <editor-fold defaultstate="collapsed" desc="Si no posee '">
                  for (int j = 0; j < token.get(i).length(); j++) 
                  {
                      if((token.get(i).charAt(j)+"").equals("*")|(token.get(i).charAt(j)+"").equals("?")|(token.get(i).charAt(j)+"").equals("+")|(token.get(i).charAt(j)+"").equals("(")|(token.get(i).charAt(j)+"").equals(")")|(token.get(i).charAt(j)+"").equals("|"))
                      {                         
                      }
                          
                      else
                      {
                    cadena += token.get(i).charAt(j);
                    if(lenguaje.containsKey(cadena)==true)
                    {
                     tempo += cadena +" ";
                     cadena ="";
                    }
                    
                     }
                    
                  }
                  String[] split = tempo.split(" ");
                  if(cadena.length()!=0)
                  {
                      split[split.length-1] = "NO EXISTE";
                  }
                  ValidarToken2(split,lenguaje);
                
                  if(token.get(i).endsWith("|"))
                  {
                       JOptionPane.showMessageDialog(null, ERROR.get(0)+",Token Incorrecto");
                       System.exit(0);   
                  }
                  
                  
                    
                    ER += "("+token.get(i)+")|"; 
                    
                     for(String item: split)
                    {
                        if(lenguaje.containsKey(item))
                        {
                             String g = lenguaje.get(item);
                         ER = ER.replace(item, g);
                        }
                    }  
                  
                 // </editor-fold>
              }
              else
              {
               // <editor-fold defaultstate="collapsed" desc="Si no posee '">
                  for (int j = 0; j < token.get(i).length(); j++) 
                  {
                      if((token.get(i).charAt(j)+"").equals("*")|(token.get(i).charAt(j)+"").equals("?")|(token.get(i).charAt(j)+"").equals("+")|(token.get(i).charAt(j)+"").equals("(")|(token.get(i).charAt(j)+"").equals(")")|(token.get(i).charAt(j)+"").equals("|"))
                      {                          
                      }
                          
                      else
                      {
                    cadena += token.get(i).charAt(j);
                    if(lenguaje.containsKey(cadena)==true)
                    {
                     tempo += cadena +" ";
                     cadena ="";
                    }
                    
                     }
                    
                  }
                  String[] split = tempo.split(" ");
                   if(cadena.length()!=0)
                  {
                      split[split.length-1] = "NO EXISTE";
                  }
                  ValidarToken2(split,lenguaje);
                
                  if(token.get(i).endsWith("|"))
                  {
                           JOptionPane.showMessageDialog(null, ERROR.get(0)+",Token Incorrecto");
                       System.exit(0);   
                  }
                    
                  
                    ER += "("+token.get(i)+")"; 
                        for(String item: split)
                    {
                        if(lenguaje.containsKey(item))
                        {
                             String g = lenguaje.get(item);
                         ER = ER.replace(item, g);
                        }
                    }  
                  
                 // </editor-fold> 
              }
            }
            
            
            else
            {
               if((i+1)<token.size())
            {
            if(!token.get(i).contains("'''"))
                {
                    // <editor-fold defaultstate="collapsed" desc="Replace si solo posee ''">
                    
                    String tempo2 = token.get(i).replace("'", " "); 
                    tempo2 = tempo2.replace(" ", ",");
                    String[] split = tempo2.split(",");                    
                    ValidarToken2(split,lenguaje);
                    tempo2 = tempo2.replace(" ", "");
                    if(tempo2.endsWith("|"))
                    {
                        JOptionPane.showMessageDialog(null, ERROR.get(0)+",Token Incorrecto");
            System.exit(0);
                    }
                    
                    tempo2 = tempo2.replace(",", ""); 
                    
                     if(tempo2.equals("|")|tempo2.equals("+")|tempo.equals("//*")|tempo.equals("?")|tempo2.equals("(")|tempo2.equals(")")|tempo2.equals("[")|tempo2.equals("]")|tempo2.equals(".")|tempo2.equals(","))
                    {
                        tempo2 = tempo2.replace(tempo2, "\\"+tempo2);
                        split[0] ="";
                    }
                     if(tempo2.length() == 1 && tempo2.contains("*"))
                     {
                             tempo2 = tempo2.replace(tempo2, "\\"+tempo2);
                     }
                    
                        ER += "("+tempo2+")|"; 
                            for(String item: split)
                    {
                        if(lenguaje.containsKey(item))
                        {
                             String g = lenguaje.get(item);
                         ER = ER.replace(item, g);
                        }
                    }  
                    // </editor-fold>
                }
                else
                {
                     // <editor-fold defaultstate="collapsed" desc="Validar si posee '''">
                       String tempo2 = token.get(i).replace("'''", "TOKENCAMBIAR"); 
                       tempo2 = tempo2.replace("'", " ");
                       tempo2 = tempo2.replace("TOKENCAMBIAR", " ' ");
                       tempo2 = tempo2.replace(" ", ",");
                       String[] split = tempo2.split(",");
                        ValidarToken2(split,lenguaje);
                        if(tempo2.endsWith("|"))
                    {
                          JOptionPane.showMessageDialog(null, ERROR.get(0)+",Token Incorrecto");
            System.exit(0);
                    } 
                           tempo2 = tempo2.replace(",", ""); 
                          if(tempo2.equals("|")|tempo2.equals("+")|tempo.equals("*")|tempo.equals("?"))
                    {
                        tempo2 = tempo2.replace(tempo2, "\\"+tempo2);
                        split[0] ="";
                    }
                           if(tempo2.length() == 1 && tempo2.contains("*"))
                     {
                             tempo2 = tempo2.replace(tempo2, "\\"+tempo2);
                     }
                      
               ER += "("+tempo2+")|"; 
                   for(String item: split)
                    {
                        if(lenguaje.containsKey(item))
                        {
                             String g = lenguaje.get(item);
                         ER = ER.replace(item, g);
                        }
                    }  
                      // </editor-fold>
                }
            }
            else
            {
                
                if(!token.get(i).contains("'''"))
                {
                    // <editor-fold defaultstate="collapsed" desc="Replace si solo posee ''">
                    
                    String tempo2 = token.get(i).replace("'", " "); 
                    tempo2 = tempo2.replace(" ", ",");
                    String[] split = tempo2.split(",");                    
                    ValidarToken2(split,lenguaje);
                    tempo2 = tempo2.replace(" ", "");
                    if(tempo2.endsWith("|"))
                    {
                            JOptionPane.showMessageDialog(null, ERROR.get(0)+",Token Incorrecto");
            System.exit(0);
                    }
                    
                    tempo2 = tempo2.replace(",", ""); 
                    
                     if(tempo2.equals("|")|tempo2.equals("+")|tempo.equals("*")|tempo.equals("?"))
                    {
                        tempo2 = tempo2.replace(tempo2, "\\"+tempo2);
                        split[0] ="";
                    }
                      if(tempo2.length() == 1 && tempo2.contains("*"))
                     {
                             tempo2 = tempo2.replace(tempo2, "\\"+tempo2);
                     }
                     
                        ER += "("+tempo2+")"; 
                            for(String item: split)
                    {
                        if(lenguaje.containsKey(item))
                        {
                             String g = lenguaje.get(item);
                         ER = ER.replace(item, g);
                        }
                    }  
                    // </editor-fold>
                }
                else
                {
                     // <editor-fold defaultstate="collapsed" desc="Validar si posee '''">
                       String tempo2 = token.get(i).replace("'''", "TOKENCAMBIAR"); 
                       tempo2 = tempo2.replace("'", " ");
                       tempo2 = tempo2.replace("TOKENCAMBIAR", " ' ");
                       tempo2 = tempo2.replace(" ", ",");
                       String[] split = tempo2.split(",");
                        ValidarToken2(split,lenguaje);
                        if(tempo2.endsWith("|"))
                    {
                                JOptionPane.showMessageDialog(null, ERROR.get(0)+",Token Incorrecto");
            System.exit(0);
                    } 
                           tempo2 = tempo2.replace(",", ""); 
                          if(tempo2.equals("|")|tempo2.equals("+")|tempo.equals("*")|tempo.equals("?"))
                    {
                        tempo2 = tempo2.replace(tempo2, "\\"+tempo2);
                        split[0] ="";
                    }
                           if(tempo2.length() == 1 && tempo2.contains("*"))
                     {
                             tempo2 = tempo2.replace(tempo2, "\\"+tempo2);
                     }
                     
                    
                ER += "("+tempo2+")"; 
                    for(String item: split)
                    {
                        if(lenguaje.containsKey(item))
                        {
                             String g = lenguaje.get(item);
                         ER = ER.replace(item, g);
                        }
                    }  
                      // </editor-fold>
                } 
            }
               
            }
            
        }
        
           
         return ER;
    }
   
     public  void ValidarToken2(String[] cadenas,HashMap<String,String> lenguaje)
    {
        int c = cadenas.length,c2=0,c3 =0,c4=0;
        boolean condicion = false,condicion2=false;
        ArrayList<String> validar = new ArrayList<String>();
        
        for(String item:cadenas)
        {
          if(item.length()<2)
          {
              c3++;
          }
          else
          {
              validar.add(item);
          }
          if(item.length()==0)
          {
              condicion = true;
          }
        }  
         for(String item:validar)
        {
            if(item.length()>1)
            {                
                if(lenguaje.containsKey(item))
                {
                 c4++;   
                }
            }
        }
         
         if(c4!=validar.size())
         {
           JOptionPane.showMessageDialog(null, ERROR.get(0)+",Token Incorrecto");
            System.exit(0);
         }
        
        if(c3 ==c)
        {
            condicion2 = true;
        }
        if(condicion == false&&condicion2 == false)
        {
        for(String item:cadenas)
        {
            if(item.length()>1)
            {                
                if(lenguaje.containsKey(item))
                {
                 c2++;   
                }
            }
        }
        if(c2!=c || c2==0 && c ==0)
        {
            String a = ERROR.get(0)+",Token Incorrecto"; 
            JOptionPane.showMessageDialog(null, a);
            System.exit(0);
        }  
        }
        
            
        
    }
 
  public String[] Separacion(String cadena)
    {
        String nueva = "";
        ArrayList<String> Lista = new ArrayList<String>();
        
        for (int i = 0; i < cadena.length(); i++) 
        {
            String charset = cadena.charAt(i) +"";
           
            if(!charset.equals("+"))            
            {
             
                    nueva += charset;
            }
            else
            {
                nueva += ",";
            }

        }
        
        String[] split = nueva.split(",");
        
        return split;
    }

    public String Token(ArrayList<String> token, HashMap<String,String>  lenguaje)
    {
        boolean condicion =false;
        ArrayList<String> l = new ArrayList<String>();
        ArrayList<String> value = new ArrayList<String>();
         ArrayList<String> value2 = new ArrayList<String>();

        for(String item: token)
        {

            int j = item.indexOf("=");
            String v = item.substring(0,j).toUpperCase();
             if(!v.contains("TOKEN"))
            {
            JOptionPane.showMessageDialog(null, ERROR.get(0)+",Token Incorrecto");
            System.exit(0);  break;            
            }
             
            l.add(item.substring(0,j));
            value.add(item.substring(j+1,item.length()));             
        }
        value2 = EliminarVacios(value);
        condicion = ValidarToken(l);
        TOKEN2 = value2;
        String ExpresionRegular=  ExpresionRegular(value2,lenguaje);

        return ExpresionRegular;
    }
            
      public  int validarSet(String set)
    {
        
        int contador =0;
          for (int i = 0; i < set.length(); i++) 
        {
            String charset = set.charAt(i) +"";
           
            if(charset.equals("'"))            
            {
                
                contador++;
            }

        }
         
          return contador;
    }
   
   public  boolean ValidarToken(ArrayList<String> TokenKey)
   {
       boolean condicion = false;
       int contador =0;
       for (int i = 0; i < TokenKey.size(); i++) 
       {
           for (int j = 0; j < TokenKey.size(); j++) 
           {
               if(TokenKey.get(i).equals(TokenKey.get(j)))
               {
                contador++;   
               }
               if(contador>TokenKey.size())
               {
                   condicion = true;
                   
                   JOptionPane.showMessageDialog(null, ERROR.get(0)+",Token Incorrecto");
            System.exit(0);  break;
               }
           }  
       }
       

       return condicion;
   }
   
   
    public  HashMap Lenguaje(ArrayList<String> lista)
    {
        String Abecedario2 = "abcdefghijklmnñopqrstuvwxyz";
        String Abecedario = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
        String Numeros = "0123456789";
        ArrayList<String> Remplazar = new ArrayList<String>();
           String tempo ="";
           
        Metodos m =  new Metodos();
  
            HashMap<String,String> lenguaje2 = new HashMap<String,String>();
            int contador =128;
        for(String cadena: lista)
        {
            ArrayList<String> Value = new ArrayList<String>();   
        String[] split = cadena.split("=");
      
        if(!split[1].toUpperCase().contains("CHR"))
        {

       String[] prueba = m.Separacion(split[1]);
       
       
        for(String item:prueba)
        {
          
        int prueba2 = m.validarSet(item);
       if(prueba2 == 2)
       {
           Value.add(item.replace("'", ""));
           char char1 = item.charAt(0);
            int asciiNo = (int) char1;            
            tempo += asciiNo +",";
            
            
       }
       else if(prueba2 ==4)
       {
           if(item.contains(".."))
           {
           item = item.replace("'..'",",");
           item = item.replace("'", "");
           String[] Split = item.split(",");
            boolean condicion = false;
            
             // <editor-fold defaultstate="collapsed" desc="Ciclos">
          
           for (int i = 0; i < Abecedario.length(); i++) 
           {
            if(Split[0].equals(Abecedario.charAt(i)+""))
            {
                condicion = true;
                
            }
               if (condicion ==true) 
               {
                 Value.add(Abecedario.charAt(i)+""); 
                
               }
               
            if(Split[1].equals(Abecedario.charAt(i)+""))
            {
                condicion = false;
                break;
            }
               
           }
           
          
              
            for (int i = 0; i < Abecedario2.length(); i++) 
           {
            if(Split[0].equals(Abecedario2.charAt(i)+""))
            {
                condicion = true;
            }
               if (condicion ==true) 
               {
                 Value.add(Abecedario2.charAt(i)+"");  
                 
               }
               
            if(Split[1].equals(Abecedario2.charAt(i)+""))
            {
                condicion = false;
                break;
            }
               
           }
               tempo += "-";
             for (int i = 0; i < Numeros.length(); i++) 
           {
            if(Split[0].equals(Numeros.charAt(i)+""))
            {
                condicion = true;
            }
               if (condicion ==true) 
               {
                 Value.add(Numeros.charAt(i)+"");  
                    
               }
               
            if(Split[1].equals(Numeros.charAt(i)+""))
            {
                condicion = false;
                break;
            }
            
           }
             int s = 0;
             
                int cont =0;
            for(String item2: Split)
                {
                 char char1 = item2.charAt(0);
                 int asciiNo = (int) char1;
                 cont++;
                 if(cont!=Split.length)
                 {
                 tempo += asciiNo +",";
                 }
                 else
                 {
                     tempo += asciiNo;
                 }
                }
                
                tempo += "+";
                // </editor-fold>
    
           }
           else
           {
               
               JOptionPane.showMessageDialog(null,  ERROR.get(0)+", Set invalido, rango incorrecto");
                System.exit(0);
           }
       }
       else
       {
             JOptionPane.showMessageDialog(null,  ERROR.get(0)+", Set invalido, rango incorrecto");
            System.exit(0);
       }
            
       }

        lenguaje.put(split[0], Value);
        if(tempo.substring(tempo.length()-1, tempo.length()).equals(","))
        {
            tempo = tempo.substring(0, tempo.length()-1);
        }
                tempo = tempo.replace("-", "");

                tempo =tempo+"SET"+split[0];
                tempo = tempo.replace("+SET", "SET");
                
        Ascii.add(tempo);
        
         tempo ="";
             lenguaje.put(split[0], Value);
             Reemplazar.add("SET  (" +split[0] + "), ha sido remplazado por el numero del caracter del ascii (" +contador+")");
             lenguaje2.put(split[0],(char)contador +"");
             contador++;

        }
        
        else
        {
            boolean condicion = false;
            String[] charset = m.Separacion(split[1]);
            
                for (String item: charset) 
                {                          
                    int v =0,d=0;
                      String f = ""; 
                    for (int i = 0; i < item.length(); i++) 
                    {
                       String c = item.charAt(i) + "";
                      f += c;
                       if(c.equals("."))
                       {
                           v++;
                       }     
                 
                    }
                  if(v != 2 && v != 0)
                  {
                       JOptionPane.showMessageDialog(null,  ERROR.get(0)+", Set invalido");
                         System.exit(0);
                  }
                  
                 if(item.subSequence(item.length()-1, item.length()).equals("+"))
                  {
                       JOptionPane.showMessageDialog(null,  ERROR.get(0)+", Set invalido");
                         System.exit(0);
                  }           
               
                    item = item.toUpperCase();
                    String prueba3 = item;
                    item = item.replace("CHR(", "");                    
                    item = item.replace(")", "");
                    item = item.replace("..",",");
                    item.toUpperCase();
                             
                   for (int i = 0; i < item.length(); i++) 
                    {
                        String so = item.charAt(i)+ "";
                        for (int j = 0; j < Abecedario.length(); j++) 
                        {
                             String so1 = Abecedario.charAt(j)+ "";
                           if(so.equals(so1)) 
                           {
                              JOptionPane.showMessageDialog(null,  ERROR.get(0)+", Set invalido");
                         System.exit(0);
                           }
                        }
                    }
            
                    String[] Split = item.split(",");
                    int prueba = validarCHAR(prueba3);  
                    int cont =0;
                     for(String item2: Split)
                {
                 char char1 = item2.charAt(0);
                 int asciiNo = (int) char1;
                 cont++;
                 if(cont!=Split.length)
                 {
                 tempo += asciiNo +",";
                 }
                 else
                 {
                     tempo += asciiNo;
                 }
                }                                     
                tempo += "+";
                    if(prueba == 2)
                    {
                  for (int j = 0; j < 256; j++) 
                 {
                  
                     if(Integer.parseInt(Split[0])>Integer.parseInt(Split[1]))
                     {
                          JOptionPane.showMessageDialog(null,  ERROR.get(0)+", Set invalido, rango invalido");
                         System.exit(0);
                     }
                  
                     
                  if(Split[0].equals(j+""))
                  {
                    condicion =true;
                  } 
                  if(condicion == true)
                  {
                      Value.add((char)j +"");   
                      
                  }
                   if(Split[1].equals(j+""))
                   {
                       condicion = false;
                   }                                   
                    
                 }
                    }
                    else
                    {
                  for (int j = 0; j < 256; j++) 
                  {
                  if(Split[0].equals(j+""))
                  {
                      Value.add((char)j +"");
                  } 
                  
                   }
                  
                   }
 
                }

        lenguaje.put(split[0], Value);
        lenguaje2.put(split[0],(char)contador +"");
        if(tempo.substring(tempo.length()-1, tempo.length()).equals(",")||tempo.substring(tempo.length()-1, tempo.length()).equals("+"))
        {
            tempo = tempo.substring(0, tempo.length()-1);
        }
          tempo =tempo+"SET"+split[0];
                tempo = tempo.replace("+SET", "SET");
                
        Ascii.add(tempo);                
        tempo ="";
  Reemplazar.add("SET  (" +split[0] + "), ha sido remplazado por el numero del caracter del ascii (" +contador+")");
        contador++;

        }
 
        }
        
        return lenguaje2;
    }

     public int validarCHAR(String set)
    {
        int contador =0;
          for (int i = 0; i < set.length(); i++) 
        {
            String charset = set.charAt(i) +"";
           
            if(charset.equals("."))            
            {
                
                contador++;
            }

        }
         
          return contador;
    }
     
     public  ArrayList<String> ObtenerTransiciones(ArrayList<String> transicion)
    {
          ArrayList<String> NuevasTransiciones = new ArrayList<String>(); 
          boolean condicion = false;
          
        for (int i = 0; i < transicion.size(); i++) 
        {
            if((i+1)<transicion.size())
            {
                String a = transicion.get(i).substring(0,1);
                String b = transicion.get(i+1).substring(0,1);
                if(!a.equals(b))
                {
                    
                        NuevasTransiciones.add(transicion.get(i));
                    
                }
                
            }
        }
          NuevasTransiciones.add(transicion.get(transicion.size()-1));
          return NuevasTransiciones;
    }

}
