package primerproyectolenguajes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import javax.swing.JOptionPane;

public class SegundoProyecto 
{
    TreeMap<String,String[]> DiccionarioEstado = new TreeMap<String,String[]>();
    ArrayList<String> Lista = new ArrayList<String>();    
    
    public void ValidarToken(ArrayList<String> tokens,ArrayList<String> Ascii,ArrayList<String> Error,ArrayList<String> Action)
    {     
        ArrayList<String> NoToken = new ArrayList<>();
        ArrayList<String> ValidarToken = new ArrayList<>();
        
        for(String tempo: tokens)
        {
            tempo = tempo.trim();
            int j = tempo.indexOf("=");
            NoToken.add(tempo.substring(0, j));
            tempo = tempo.substring(j+1,tempo.length()); 

            if(tempo.contains("'*'"))
            {
             tempo = tempo.replace("'*'", "cam1");
            }
             if(tempo.contains("'?'"))
            {
                tempo = tempo.replace("'?'", "cam2");
            }
              if(tempo.contains("'+'"))
            {
                tempo = tempo.replace("'+'", "cam3");
            }
              
            tempo = tempo.replace("'", "");
            tempo = tempo.replace("(", "");
            tempo = tempo.replace(")", "");
            tempo = tempo.replace("|", "");
          
            tempo = tempo.replace("*", "");
            tempo = tempo.replace("?", "");
            tempo = tempo.replace("+", "");
            tempo = tempo.replace("cam1", "*");
            tempo = tempo.replace("cam2", "?");
            tempo = tempo.replace("cam3", "+");
            tempo = tempo.replace("{reservadas()}", "");
            ValidarToken.add(tempo);                               
        }
        
        AsignarEstado(NoToken,ValidarToken,Ascii,Error,Action);
        }
    
    public void ValidarActions(ArrayList<String> actions)
    {
        int c = 0;
        int j = 0;
        boolean condicion = false;
        for(String tempo: actions)
        {
            for (int i = 0; i < tempo.length(); i++) 
            {
                String d = tempo.charAt(i)+"";
                if(d.equals("'"))
                {
                    c++;
                }
                if(d.equals("="))
                {
                    j++;
                }
            }
            if(c%2 !=0||!tempo.substring(tempo.length()-1, tempo.length()).equals("'"))
            {
                String error = tempo.substring(0, tempo.indexOf("="));
                error = error.trim();
                JOptionPane.showMessageDialog(null, "Error en action (" + error + ")");
                condicion  =true;
            } 
             if(j!= 1)
            {
                 JOptionPane.showMessageDialog(null, "Error en action");
                 condicion  =true;
            }
            j=0;
            c =0;   
        }
        
        

        if(condicion == true)
        {
            System.exit(0);
        }
        
        
        
    }
        
    public void  AsignarEstado(ArrayList<String> Notoken,ArrayList<String> Token,ArrayList<String> Ascii,ArrayList<String> Error,ArrayList<String> Action)
    {
        //
        String tempo = "";
        ArrayList<String> anterior2 = new ArrayList<String>();    
             
            for(int j = 0; j < Token.size(); j++)
            {      
                 boolean condicion = false;
                 String cadena = "";
                
            for(String No:Ascii)
            {   
             String[] Set = No.split("SET");             
                            
                for (int i = 0; i < Token.get(j).length(); i++) 
                {                   
                    tempo += Token.get(j).charAt(i) + "";
                    if(tempo.equals(Set[1]))
                    {   
                        anterior2.add(Set[1]);
                        if(Token.get(j).contains(tempo))
                        {
                        if(!cadena.contains(Set[0]))
                        {
                        cadena += (Set[0]) + "+ SPLIT";
                        condicion = true;
                        tempo ="";                        
                        }
                        else
                        {
                            tempo =""; 
                        }
                        }                        
                    }   
                    else
                    {
                        for (String string: anterior2) 
                        {
                           if (string.equals(tempo))
                           {
                               tempo = "";
                           }
                        }
                      
                    }
                }      
                    tempo ="";
            }     
             if(condicion == true)
                {                                            
                        String[] Split = cadena.split("SPLIT");
                        String cadena2 = "";
                        for(String tempo2: Split)
                        {
                            cadena2 += tempo2;
                        }
                        String[] Split2 = cadena2.split("\\+");
                        String estado = Notoken.get(j).replace("TOKEN", "Estado ");
                        Lista.add(Notoken.get(j));
                        DiccionarioEstado.put(estado, Split2);
                }
                condicion = false;            
        }
        
   
                for(int j = 0; j < Notoken.size(); j++)
            {
             
                if(!Lista.contains(Notoken.get(j)))
                {
                    
                for (int i = 0; i < Token.get(j).length(); i++) 
                {
                     tempo += Token.get(j).charAt(i) + "";
                }
                 String estado = Notoken.get(j).replace("TOKEN", "Estado ");
                 
                   
                    if(tempo.length()==1)
                    {                     
                        char ascii = tempo.charAt(0);
                        int NoAscii = (int)ascii;  
                        String[] value = new String[1];
                        value[0] =  NoAscii +"";
                     DiccionarioEstado.put(estado,value);                                         
                    }
                    else
                    {
                        if(tempo.length() == 2 || tempo.length()==1)
                        {
                     String[] value = new String[1];
                     char ascii = tempo.charAt(0);
                     int NoAscii = (int)ascii;  
                     char ascii2 = tempo.charAt(1);
                     int NoAscii2 = (int)ascii2;                       
                     value[0] = NoAscii +","+NoAscii2+"CAMBIAR";
                     DiccionarioEstado.put(estado,value);     
                        }
                        else
                        {
                     String[] value = new String[1];
                     char ascii = tempo.charAt(0);
                     int NoAscii = (int)ascii;  
                     char ascii2 = tempo.charAt(1);
                     int NoAscii2 = (int)ascii2;    
                     char ascii3 = tempo.charAt(2);
                     int NoAscii3 = (int)ascii3;  
                     value[0] = NoAscii +","+NoAscii2+","+NoAscii3+"CAMBIAR";
                     DiccionarioEstado.put(estado,value); 
                        }
                    }
                 tempo = "";
                }
            }          
        GenerarCodigo(DiccionarioEstado,Error,Action);
    }
    
    public void GenerarCodigo(TreeMap<String,String[]> DiccionarioEstado,ArrayList<String> Error,ArrayList<String> Action)
    {
        ArrayList<String> Codigo = new ArrayList<String>();
        boolean Condicion =false,Condicion2 =false;
        String IfsTempo ="if(Token.get(i) == 13) " +"\n{" + "}"  +"\nelse if(";
        String IfsTempo2 = "if(Token.get(i) == 13) " +"\n{" + "}"  +"\nelse if(";
        String prioridad = "\nelse if(";
        int Ntempo =0;
        String ifs = "\nelse if(";  
       
        for (Entry<String, String[]> entry : DiccionarioEstado.entrySet())             
        {           
             String[] value = entry.getValue();              
             
             for(String Value:value)
             {
                 if(!Value.contains("CAMBIAR"))
                 {
                 String[] Split = Value.split(",");
                                                      
                 if(Split.length == 2)
                 {
                     ifs += " Token.get(i) >= "+Split[0] +" && Token.get(i) <= "+Split[1] + " ||";
                     IfsTempo += " Token.get(i) >= "+Split[0] +" && Token.get(i) <= "+Split[1] + " ||";     
                     IfsTempo2 += " Token.get(i) >= "+Split[0] +" && Token.get(i) <= "+Split[1] + " ||";    
                 }
                 if(Split.length ==1)
                 {
                     if(!Split[0].equals(" "))
                     {
                        ifs += " Token.get(i) == " + Split[0] +" ||";
                        IfsTempo += " Token.get(i) == " + Split[0] +" ||";
                        IfsTempo2 += " Token.get(i) == " + Split[0] +" ||";
                     }                     
                 }
                 }
                 else
                 {                     
                     Value = Value.replace("CAMBIAR", "");
                     String[] Split = Value.split(",");
                     if(Split.length == 2)
                     {
                     ifs += " Token.get(i)  == "+Split[0] +" && Token.get(i+1) == "+Split[1] + " ||";  
                     IfsTempo2 += " Token.get(i)  == "+Split[0] +" && Token.get(i+1) == "+Split[1] + " ||"; 
                     Ntempo = Split.length;
                     Condicion = true;
                     }
                     if(Split.length == 3)
                     {                        
                         Condicion = true;
                         Ntempo = Split.length;
                         prioridad += " Token.get(i)  == "+Split[0] +" && Token.get(i+1) == "+Split[1] +" && Token.get(i+2) == "+Split[2] +" ||";        
                     }
                 }
             
             }                                 
             if(ifs.endsWith("||"))
             {
                 ifs = ifs.substring(0, ifs.length()-2) + ")" ;
             }
              if(IfsTempo.endsWith("||"))
             {
                 IfsTempo = IfsTempo.substring(0, IfsTempo.length()-2) + ")" ;
             }
               if(IfsTempo2.endsWith("||"))
             {
                 IfsTempo2 = IfsTempo2.substring(0, IfsTempo2.length()-2) + ")" ;
             }
               if(prioridad.endsWith("||"))
             {
                 prioridad = prioridad.substring(0, prioridad.length()-2) + ")" ;
             }
             
             String key = entry.getKey();
             
             if(Condicion == true)
             {
                 if(Ntempo == 1 || Ntempo ==2)
                 {
             ifs += "\n{"+"\nString j = Token.get(i)+\"\";\n" +" String d = (char) Integer.parseInt(j)+\"\";\n" +" String j1 = Token.get(i+1)+\"\";\n" +" String d1 = (char) Integer.parseInt(j1)+\"\";"+"\n String agregar = \"(\"+d+d1+\")\";" + "\nEstado +=  agregar + \" = " + key + " ESPACIO\";"+"\ni++;"+"\n}" + "\nelse if(";                         
             IfsTempo2 += "\n{"+"\nString j = Token.get(i)+\"\";\n" +" String d = (char) Integer.parseInt(j)+\"\";\n" +" String j1 = Token.get(i+1)+\"\";\n" +" String d1 = (char) Integer.parseInt(j1)+\"\";"+"\n String agregar = \"(\"+d+d1+\")\";" + "\nEstado +=  agregar + \" = " + key + " ESPACIO\";"+"\ni++;"+"\n}" + "\nelse if(";                         
            
                 }
                 else
                 {                     
                      prioridad += "\n{"+"\nString j = Token.get(i)+\"\";\n" +" String d = (char) Integer.parseInt(j)+\"\";\n" +" String j1 = Token.get(i+1)+\"\";\n" +" String d1 = (char) Integer.parseInt(j1)+\"\";"+"String j2 = Token.get(i+2)+\"\";\n" +" String d2 = (char) Integer.parseInt(j2)+\"\";"+"\n String agregar = \"(\"+d+d1+d2+\")\";" + "\nEstado +=  agregar + \" = " + key + " ESPACIO\";"+"\nif(i+3 == Token.size())\n" +"{ \n" +"    break;\n" +"}\n" +"else\n" +"{\n" +"i++;i++;\n" +"}"+"\n}" + "\nelse if(";                         
                 }
             }
             else
             {
                  ifs += "\n{"+"\nString j = Token.get(i)+\"\";\n" +" String d =\"(\" + (char) Integer.parseInt(j)+\")\";" + "\nEstado +=  d + \" = " + key + " ESPACIO\";"+"\n}" + "\nelse if(";
                  IfsTempo += "\n{"+"\nString j = Token.get(i)+\"\";\n" +" String d = \"(\"+ (char) Integer.parseInt(j)+\")\";" + "\nEstado +=  d + \" = " + key + " ESPACIO\";"+"\n}" + "\nelse if(";
                  IfsTempo2 += "\n{"+"\nString j = Token.get(i)+\"\";\n" +" String d = \"(\"+ (char) Integer.parseInt(j)+\")\";" + "\nEstado +=  d + \" = " + key + " ESPACIO\";"+"\n}" + "\nelse if(";
             }
             Condicion = false;
             Ntempo =0;
        }
          if(ifs.endsWith("else if("))
             {
                 ifs = ifs.substring(0,ifs.length()-8);
             }
          if(IfsTempo.endsWith("else if("))
             {
                 IfsTempo = IfsTempo.substring(0,IfsTempo.length()-8);
             }
          if(IfsTempo2.endsWith("else if("))
             {
                 IfsTempo2 = IfsTempo2.substring(0,IfsTempo2.length()-8);
             }
          if(prioridad.endsWith("else if("))
             {
                 prioridad = prioridad.substring(0,prioridad.length()-8);
             }
        ifs += "\nelse"+ "\n{"+"\nString j = Token.get(i)+\"\";\n" +" String d = \"(\"+(char) Integer.parseInt(j)+\")\";" + "\nEstado += d + \"  = "+Error.get(0)+" ESPACIO\";"+ "\n}";
        IfsTempo += "\nelse"+ "\n{"+"\nString j = Token.get(i)+\"\";\n" +" String d = \"(\"+(char) Integer.parseInt(j)+\")\";" + "\nEstado += d + \" = "+Error.get(0)+" ESPACIO\";"+ "\n}";
        IfsTempo2 += "\nelse"+ "\n{"+"\nString j = Token.get(i)+\"\";\n" +" String d = \"(\"+(char) Integer.parseInt(j)+\")\";" + "\nEstado += d + \" = "+Error.get(0)+" ESPACIO\";"+ "\n}";
        Codigo.add("package segundoproyecto;\n" +"import java.util.ArrayList;\n" +"\n" +"public class ScannerLenguajes {\n" +" ArrayList<String> ACTIONS = new ArrayList<String>();   \n" +"\npublic String Estado;"+"\npublic String SegundoProyecto (String Leer)\n" +" {\n" +"\nString cadena =\"\";\n" +"     ArrayList<Integer> Token=  new ArrayList<Integer>();\n" +"         \n" +"     cadena = Leer.replace(\" \", \"\");\n" +"     \n" +"     for(int i =0;i<cadena.length();i++) \n" +"     {\n" +"         char n = cadena.charAt(i); \n" +"         int a = (int)n; \n" +"         Token.add(a);\n" +"     }\n" +"     \n" +"     \n" +"     for(int i =0;i< Token.get(i);i++)\n" +"     {\n");
        Codigo.add("if(i+2 == Token.size()) \n{" + "\n"+IfsTempo2 +"\n}");        
        Codigo.add("if(i+1 == Token.size()) \n{" + "\n"+IfsTempo +"\nbreak;"+"\n}");        
        Codigo.add("\nelse"+"\n{"+"\nString tempo =\"\";"+"if(Token.get(i) == 13) " +"\n{" + "\n //probando" + "\n }"+ prioridad +ifs+"\n}");
        Codigo.add("     }   \n"  +"     return Estado;\n" +" }\n");
        Codigo.add("\n" + "public ScannerLenguajes()" +"\n{");
        Action.remove(0);
        for(String agregar:Action)
        {
            Codigo.add("  ACTIONS.add(\""+agregar +"\".toLowerCase());");
        }          
        Codigo.add("\nEstado =\"\";");
        Codigo.add("\n}"+"\n");                
        Codigo.add("public ArrayList<String> ACTION(ArrayList<String> Leer)\n" +"{\n" +"  ArrayList<String> Cadenas = new ArrayList<String>();\n" +"  for(String item: Leer)\n" +"  {\n" +"      String tempo =\"\";\n" +"      String[] Split = item.split(\" \");\n" +"      for(String tempo1: Split)      \n" +"      {\n" +"          for (int i = 0; i < ACTIONS.size(); i++) \n" +"          {\n" +"              String validar = ACTIONS.get(i).replace(\"'\",\"\");\n" +"              int f = validar.indexOf(\"=\");\n" +"              validar = validar.substring(f+1,validar.length()).trim();\n" +"               if(validar.equals(tempo1.toLowerCase()))\n" +"          {         \n" +"              String split = ACTIONS.get(i).replace(tempo1, \"\").replace(\"'\", \"\");\n" +"              int j = split.indexOf(\"=\");\n" +"              Estado += \"(\" + tempo1 + \") = Estado \" + split.substring(0,j) + \"ESPACIO\";\n" +"              item = item.replace(tempo1, \"\");  \n" +"              break;\n" +"          }               \n" +"               \n" +"          }        \n" +"      }    \n" +"        Cadenas.add(item);\n" +"  }  \n" +"     return Cadenas;\n" +"\n" +"}\n" +"");
         Codigo.add("\n}" );
        
        Escribir(Codigo);
    }
    
    public static void Escribir (ArrayList<String> Codigo)
    {
        FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter("C:\\Users\\leste\\Desktop\\LFA-ProyectoCompleto\\SegundoProyecto\\SegundoProyecto\\src\\segundoproyecto\\ScannerLenguajes.java");
            pw = new PrintWriter(fichero);

            for (int i = 0; i < Codigo.size(); i++)
            {
                pw.println(Codigo.get(i));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
           // Nuevamente aprovechamos el finally para 
           // asegurarnos que se cierra el fichero.
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }
      }          
    
}
