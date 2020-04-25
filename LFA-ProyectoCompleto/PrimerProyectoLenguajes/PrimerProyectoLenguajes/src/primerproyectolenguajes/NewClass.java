package primerproyectolenguajes;
import java.util.ArrayList;

public class NewClass {
    
 public String SegundoProyecto (String Leer)
 {
     String Estado = "";
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
      if(i+1 == Token.size()){


if(Token.get(i) == 13) 
{}
else if( Token.get(i) >= 48 && Token.get(i) <= 57 )
{
String j = Token.get(i)+"";
 String d = (char) Integer.parseInt(j)+"";
Estado +=  d + " = Estado 1\n";
}
else if( Token.get(i) == 61 )
{
String j = Token.get(i)+"";
 String d = (char) Integer.parseInt(j)+"";
Estado +=  d + " = Estado 2\n";
}
else if( Token.get(i) >= 65 && Token.get(i) <= 90 || Token.get(i) >= 97 && Token.get(i) <= 122 || Token.get(i) == 39 || Token.get(i) >=  48 && Token.get(i) <= 57 )
{
String j = Token.get(i)+"";
 String d = (char) Integer.parseInt(j)+"";
Estado +=  d + " = Estado 4\n";
}

else
{
String j = Token.get(i)+"";
 String d = (char) Integer.parseInt(j)+"";
Estado += d + " = ERROR 54";
}
break;
}

else
{
String tempo ="";if(Token.get(i) == 13) 
{
 //probando
 }
else if( Token.get(i) >= 48 && Token.get(i) <= 57 )
{
String j = Token.get(i)+"";
 String d = (char) Integer.parseInt(j)+"";
Estado +=  d + " = Estado 1\n";
}
else if( Token.get(i) == 61 )
{
String j = Token.get(i)+"";
 String d = (char) Integer.parseInt(j)+"";
Estado +=  d + " = Estado 2\n";
}
else if( Token.get(i)  == 58 && Token.get(i+1) == 61 )
{
String j = Token.get(i)+"";
 String d = (char) Integer.parseInt(j)+"";
 String j1 = Token.get(i+1)+"";
 String d1 = (char) Integer.parseInt(j1)+"";
 String agregar = d+d1;
Estado +=  agregar + " = Estado 3 \n";
i++;
}
else if( Token.get(i) >= 65 && Token.get(i) <= 90 || Token.get(i) >= 97 && Token.get(i) <= 122 || Token.get(i) == 39 || Token.get(i) >=  48 && Token.get(i) <= 57 )
{
String j = Token.get(i)+"";
 String d = (char) Integer.parseInt(j)+"";
Estado +=  d + " = Estado 4\n";
}

else
{
String j = Token.get(i)+"";
 String d = (char) Integer.parseInt(j)+"";
Estado += d + "  = ERROR 54";
}
}
     }   
     return Estado;
 }
 
 
 
}

