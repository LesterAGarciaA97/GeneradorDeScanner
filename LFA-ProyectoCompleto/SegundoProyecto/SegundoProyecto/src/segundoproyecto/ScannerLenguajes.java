package segundoproyecto;
import java.util.ArrayList;

public class ScannerLenguajes {
 ArrayList<String> ACTIONS = new ArrayList<String>();   

public String Estado;
public String SegundoProyecto (String Leer)
 {

String cadena ="";
     ArrayList<Integer> Token=  new ArrayList<Integer>();
         
     cadena = Leer.replace(" ", "");
     
     for(int i =0;i<cadena.length();i++) 
     {
         char n = cadena.charAt(i); 
         int a = (int)n; 
         Token.add(a);
     }
     
     
     for(int i =0;i< Token.get(i);i++)
     {

if(i+2 == Token.size()) 
{
if(Token.get(i) == 13) 
{}
else if( Token.get(i) >= 48 && Token.get(i) <= 52 )
{
String j = Token.get(i)+"";
 String d = "("+ (char) Integer.parseInt(j)+")";
Estado +=  d + " = Estado 1 ESPACIO";
}
else if( Token.get(i) == 61 )
{
String j = Token.get(i)+"";
 String d = "("+ (char) Integer.parseInt(j)+")";
Estado +=  d + " = Estado 2 ESPACIO";
}
else if( Token.get(i)  == 58 && Token.get(i+1) == 61 )
{
String j = Token.get(i)+"";
 String d = (char) Integer.parseInt(j)+"";
 String j1 = Token.get(i+1)+"";
 String d1 = (char) Integer.parseInt(j1)+"";
 String agregar = "("+d+d1+")";
Estado +=  agregar + " = Estado 3 ESPACIO";
i++;
}
else if( Token.get(i) >= 65 && Token.get(i) <= 90 || Token.get(i) >= 97 && Token.get(i) <= 122 || Token.get(i) == 39 || Token.get(i) >=  48 && Token.get(i) <= 52 )
{
String j = Token.get(i)+"";
 String d = "("+ (char) Integer.parseInt(j)+")";
Estado +=  d + " = Estado 4 ESPACIO";
}

else
{
String j = Token.get(i)+"";
 String d = "("+(char) Integer.parseInt(j)+")";
Estado += d + " = ERROR 54 ESPACIO";
}
}
if(i+1 == Token.size()) 
{
if(Token.get(i) == 13) 
{}
else if( Token.get(i) >= 48 && Token.get(i) <= 52 )
{
String j = Token.get(i)+"";
 String d = "("+ (char) Integer.parseInt(j)+")";
Estado +=  d + " = Estado 1 ESPACIO";
}
else if( Token.get(i) == 61 )
{
String j = Token.get(i)+"";
 String d = "("+ (char) Integer.parseInt(j)+")";
Estado +=  d + " = Estado 2 ESPACIO";
}
else if( Token.get(i) >= 65 && Token.get(i) <= 90 || Token.get(i) >= 97 && Token.get(i) <= 122 || Token.get(i) == 39 || Token.get(i) >=  48 && Token.get(i) <= 52 )
{
String j = Token.get(i)+"";
 String d = "("+ (char) Integer.parseInt(j)+")";
Estado +=  d + " = Estado 4 ESPACIO";
}

else
{
String j = Token.get(i)+"";
 String d = "("+(char) Integer.parseInt(j)+")";
Estado += d + " = ERROR 54 ESPACIO";
}
break;
}

else
{
String tempo ="";if(Token.get(i) == 13) 
{
 //probando
 }

else if( Token.get(i) >= 48 && Token.get(i) <= 52 )
{
String j = Token.get(i)+"";
 String d ="(" + (char) Integer.parseInt(j)+")";
Estado +=  d + " = Estado 1 ESPACIO";
}
else if( Token.get(i) == 61 )
{
String j = Token.get(i)+"";
 String d ="(" + (char) Integer.parseInt(j)+")";
Estado +=  d + " = Estado 2 ESPACIO";
}
else if( Token.get(i)  == 58 && Token.get(i+1) == 61 )
{
String j = Token.get(i)+"";
 String d = (char) Integer.parseInt(j)+"";
 String j1 = Token.get(i+1)+"";
 String d1 = (char) Integer.parseInt(j1)+"";
 String agregar = "("+d+d1+")";
Estado +=  agregar + " = Estado 3 ESPACIO";
i++;
}
else if( Token.get(i) >= 65 && Token.get(i) <= 90 || Token.get(i) >= 97 && Token.get(i) <= 122 || Token.get(i) == 39 || Token.get(i) >=  48 && Token.get(i) <= 52 )
{
String j = Token.get(i)+"";
 String d ="(" + (char) Integer.parseInt(j)+")";
Estado +=  d + " = Estado 4 ESPACIO";
}

else
{
String j = Token.get(i)+"";
 String d = "("+(char) Integer.parseInt(j)+")";
Estado += d + "  = ERROR 54 ESPACIO";
}
}
     }   
     return Estado;
 }


public ScannerLenguajes()
{
  ACTIONS.add("18='PROGRAM'".toLowerCase());
  ACTIONS.add("19='INCLUDE'".toLowerCase());
  ACTIONS.add("20='CONST'".toLowerCase());
  ACTIONS.add("21='TYPE'".toLowerCase());
  ACTIONS.add("22='VAR'".toLowerCase());

Estado ="";

}

public ArrayList<String> ACTION(ArrayList<String> Leer)
{
  ArrayList<String> Cadenas = new ArrayList<String>();
  for(String item: Leer)
  {
      String tempo ="";
      String[] Split = item.split(" ");
      for(String tempo1: Split)      
      {
          for (int i = 0; i < ACTIONS.size(); i++) 
          {
              String validar = ACTIONS.get(i).replace("'","");
              int f = validar.indexOf("=");
              validar = validar.substring(f+1,validar.length()).trim();
               if(validar.equals(tempo1.toLowerCase()))
          {         
              String split = ACTIONS.get(i).replace(tempo1, "").replace("'", "");
              int j = split.indexOf("=");
              Estado += "(" + tempo1 + ") = Estado " + split.substring(0,j) + "ESPACIO";
              item = item.replace(tempo1, "");  
              break;
          }               
               
          }        
      }    
        Cadenas.add(item);
  }  
     return Cadenas;

}


}
