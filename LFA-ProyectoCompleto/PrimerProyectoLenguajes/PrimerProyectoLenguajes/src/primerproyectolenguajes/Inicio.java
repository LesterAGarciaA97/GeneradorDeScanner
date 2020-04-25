package primerproyectolenguajes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;


public class Inicio extends javax.swing.JFrame {

    // <editor-fold defaultstate="collapsed" desc="Declarar variables">
     public  Set<Integer>[] FollowPos;
    public  NodoArbol Rama;
    public  Set<EstadoAFD> Estados;
    public  Set<String> Input; 
    public  HashMap<Integer, String> Simbolo;
    public Set<Integer> Nombre; 
   public  ArrayList<String> list1 = new ArrayList();

    public  ArrayList<String> list2 = new ArrayList<>();

    public  ArrayList<String> list3 = new ArrayList<>();
    
    public  TreeMap<String,  Set<EstadoAFD> > Transicion = new TreeMap<>();
    
    public  ArrayList<String>list4 = new ArrayList();

    public  ArrayList<String>list5 = new ArrayList();

    public  ArrayList<String>Nodos = new ArrayList();

    public  ArrayList<String>ConjuntoFirst = new ArrayList();

    public  ArrayList<String>ConjuntoLast = new ArrayList();
    public   ArrayList<String>listaTransiciones = new ArrayList();       
     public    ArrayList<String>lista_Transiciones = new ArrayList<>();
      public ArrayList<String> Reemplazar = new ArrayList<String>();
    // </editor-fold>
    
    public Inicio() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_ingresar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Transciones = new javax.swing.JList();
        jScrollPane2 = new javax.swing.JScrollPane();
        follow = new javax.swing.JList();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        Firs = new javax.swing.JList();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        Remplazar1 = new javax.swing.JList();
        jLabel5 = new javax.swing.JLabel();
        btn_ingresar2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btn_ingresar.setText("Ingresar");
        btn_ingresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ingresarActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(Transciones);

        jScrollPane2.setViewportView(follow);

        jLabel2.setText("Follow");

        jLabel3.setText("Transiciones");

        jScrollPane3.setViewportView(Firs);

        jLabel4.setText("SET reemplazados");

        jScrollPane4.setViewportView(Remplazar1);

        jLabel5.setText("First/Last");

        btn_ingresar2.setText("Limpiar pantalla");
        btn_ingresar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ingresar2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(320, 320, 320)
                .addComponent(jLabel2)
                .addGap(288, 288, 288)
                .addComponent(jLabel3)
                .addGap(106, 106, 106))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_ingresar, javax.swing.GroupLayout.PREFERRED_SIZE, 662, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_ingresar2, javax.swing.GroupLayout.PREFERRED_SIZE, 639, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_ingresar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_ingresar2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 503, Short.MAX_VALUE)
                        .addComponent(jScrollPane1)
                        .addComponent(jScrollPane3))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 503, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)
                        .addComponent(jLabel4))
                    .addComponent(jLabel3))
                .addGap(10, 10, 10))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_ingresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ingresarActionPerformed
       
        try
        {

        ArrayList<String> input = new ArrayList<String>();
            ArrayList<String> input2 = new ArrayList<String>();
        BufferedReader br = null;
        try {
            JFileChooser chooser = new JFileChooser();
            chooser.showOpenDialog(null);
            File file = chooser.getSelectedFile();
            String ruta = file.getAbsolutePath();
            File archivo = new File(ruta);
            br = new BufferedReader(new FileReader(archivo));
            String st; 
            
            while ((st = br.readLine()) != null)
            {
                input2.add(st.trim());
            }
            for (int i = 0; i < input2.size(); i++) 
            {
              input.add(input2.get(i).replace(" ", ""));
                
            }
        } 
        
        catch (FileNotFoundException ex) {
            Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
        } 
        catch (IOException ex) {
            Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                br.close();
            } catch (IOException ex) {
                Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
            }
                   
        }
          Metodos m = new Metodos();
          ArrayList<String> SET = new ArrayList<String>();
          HashMap<String,ArrayList<String>> SET2 = new HashMap<String,ArrayList<String>>();
          ArrayList<String> TOKEN = new ArrayList<String>();
          ArrayList<String> ACTION = new ArrayList<String>();
          ArrayList<String> Ascii = new ArrayList<String>();
          ArrayList<String> ERROR = new ArrayList<String>();
         
          m.Dividir(input);
          ACTION =m.ACTION;
          SET = m.SETS;
          TOKEN = m.TOKEN;
          ERROR = m.ERROR; 
          SET2 = m.lenguaje;
          
      /*------------------------------------------------------------------------------------------------------------------------------------*/
          
             HashMap<String,String> lenguaje = new HashMap<String,String>();
             lenguaje = m.Lenguaje(SET);
             String ER= m.Token(TOKEN, lenguaje);
             Reemplazar = m.Reemplazar;                        
          //Segundo proyecto
            SegundoProyecto P2 = new SegundoProyecto();
            Ascii= m.Ascii;
            P2.ValidarToken(TOKEN,Ascii,ERROR,ACTION);
            ACTION.remove(0);
            P2.ValidarActions(ACTION);
      
            Imprimir(ER,Reemplazar,lenguaje);
        }
        catch(Exception e)
        {
                JOptionPane.showMessageDialog(null, "Error con lectura de archivo");
        }
                
    }//GEN-LAST:event_btn_ingresarActionPerformed

    private void btn_ingresar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ingresar2ActionPerformed
   
              DefaultListModel agregar1 =  new DefaultListModel();   
              DefaultListModel agregar2 =  new DefaultListModel();
              DefaultListModel agregar3 =  new DefaultListModel();
              DefaultListModel agregar4 =  new DefaultListModel();
              
                          Remplazar1.setModel(agregar4);
                          Transciones.setModel(agregar3);
                                Firs.setModel(agregar1);
             
              
            
              follow.setModel(agregar2);
              
              
              
    }//GEN-LAST:event_btn_ingresar2ActionPerformed

    public void Imprimir(String Automata, ArrayList<String> Reemplazar,HashMap<String,String> lenguaje)
    {              
        Estados = new HashSet<>();
        Input = new HashSet<String>();
     
         //EstadoAFD A = new EstadoAFD(0);
         HashMap<String,EstadoAFD> B = new HashMap<String,EstadoAFD>();  
         

        String nueva ="";
        
        for (int i = 0; i < Automata.length(); i++) 
        {
            String act = Automata.charAt(i) + "";
           
            if("?".equals(act))
            {
                nueva = nueva + "*";
            }
            else
            {
                nueva += Automata.charAt(i)+"";
            }
        }
        nueva = nueva.replace("+", "*");
        
        String ExpresionRegular = Expresion(nueva);
        Simbolo(ExpresionRegular);
      
        Sintaxis st = new Sintaxis(nueva);
        Rama = st.ConseguirRama();
        FollowPos = st.ConseguirFollow();
        EstadoAFD q0 = Automata();

        Set<Integer> setFollows[];
        setFollows = st.ConseguirFollow();
        
        for (int i = 0; i < setFollows.length; i++) 
        {
            if(setFollows[i].size()>0)
            list2.add("Nodo("+(i+1)+"), Follow = "+setFollows[i].toString());
        }    
        for(String item : Input){
            list3.add(item);
        }    
                       
    String[] splitFirsts =  st.First.split("-");
        for (int i = 1; i < splitFirsts.length; i++) {
            list4.add(splitFirsts[i]);
        }

        String[] splitLasts =  st.cLast.split("-");
        for (int i = 1; i < splitFirsts.length; i++) {
            list5.add(splitLasts[i]);
        }
       ArrayList<String>listaValores = new ArrayList();
       listaValores = st.listaValores;
       for(String string : listaValores){
       Nodos.add(string.replace("&", "·"));
       }
       
       
        for (int i = 0; i < list4.size(); i++) {
            ConjuntoFirst.add(Nodos.get(i) + " " + list4.get(i));
        }
            
        for (int i = 0; i < list5.size(); i++) 
        {
            ConjuntoLast.add(Nodos.get(i) + "  " + list5.get(i));
        }
              
              DefaultListModel agregar1 =  new DefaultListModel();   
              DefaultListModel agregar2 =  new DefaultListModel();
              DefaultListModel agregar3 =  new DefaultListModel();
              DefaultListModel agregar4 =  new DefaultListModel();
              ArrayList<String> Añadir = new ArrayList<>();
              int c =1;
              
              Añadir.add("\t                                             First");
              for(String item: ConjuntoFirst)
              {
                Añadir.add("First Nodo("+c+") = ( "+item+"  )");
                c++;
              }
              c=1;
              Añadir.add("");
               Añadir.add("");
                Añadir.add("");
                 Añadir.add("\t                                           Last");
                 for(String item: ConjuntoLast)
              {
                   Añadir.add("Last Nodo("+c+") = ( "+item+"  )");
                c++;
              }
                 for(String item: Añadir)
                 {
                     agregar1.addElement(item);                            
                 }
              Firs.setModel(agregar1);
             
              
              for(String item: list2)
              {
                  agregar2.addElement(item);
              }
              follow.setModel(agregar2);
              
              Metodos m = new Metodos();
              lista_Transiciones = m.ObtenerTransiciones(listaTransiciones);
              TreeMap<String, String> treeMap = new TreeMap<String, String>();
             treeMap.putAll(lenguaje);
               Set<String> keys = treeMap.keySet();
              
                   
                   
                        for (int i = 0; i < lista_Transiciones.size(); i++) 
                        {
                            for (int j = 0; j < lista_Transiciones.get(i).length(); j++) 
                            {
                                String d =  lista_Transiciones.get(i).charAt(j)+"";
                                
                              
                                for(String key: keys)
                                {
                                    if(treeMap.containsValue(d))
                                    {
                                        String rem1 = treeMap.get(key);
                                        if(rem1.equals(d))
                                        {
                                          String rem = lista_Transiciones.get(i).replace(d,key);
                                          rem = rem.replace(" #=F[]", "");  
                                          rem = rem.replace(" #=D[]", ""); 
                                          rem = rem.replace(",,", "");  
                                          lista_Transiciones.set(i, rem);
                                        }
                                 
                                    }
                                }
                             
                                
                              
                            
                           
                        
                            }
                        }                        
                     
                
               for(String item: lista_Transiciones)
              {
                  agregar3.addElement(item);
              }
              Transciones.setModel(agregar3);
              
             
              
                for(String item: Reemplazar)
              {
                  agregar4.addElement(item);
              }
              Remplazar1.setModel(agregar4);

    }
  
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inicio().setVisible(true);
            }
        });
    }
    
    
     private static String Expresion(String in) 
    {
        String regex = in;
        return regex+"#";
    }

    private  void Simbolo(String Expresion) {
    
        Set<Character> op = new HashSet<>();
        Character[] ch = {'(', ')', '*', '|', '&', '.', '\\','+','?'};
        op.addAll(Arrays.asList(ch));

        Input = new HashSet<>();
        Simbolo = new HashMap<>();
        int num = 1;
        for (int i = 0; i < Expresion.length(); i++) {
            char charAt = Expresion.charAt(i);

      
            if (op.contains(charAt)) {
                if (i - 1 >= 0 && Expresion.charAt(i - 1) == '\\') {
                    Input.add("\\" + charAt);
                    Simbolo.put(num++, "\\" + charAt);
                }
            } else {
                Input.add("" + charAt);
                Simbolo.put(num++, "" + charAt);
            }
        }
    }

    public  EstadoAFD Automata() 
    {
        int i = 0;
        String  caracteres[] = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","Ñ","O","P","Q","R","S","T","U","V","W","X","Y","Z",
        "A1","A2","A3","A4","A5","A6","A7","A8","A9","A10","A11","A12","A13","A14","A15","A16","A17","A18","A19","A20","A21","A22","A23","A24","A25","A26","A27"};
        String ID = caracteres[i];
 
        Set<Integer> firstpos_n0 = Rama.getFirst();
      i++;
        EstadoAFD q0 = new EstadoAFD(ID);
         ID = caracteres[i];
        q0.AñadirAllNombre(firstpos_n0);
        if (q0.getNombre().contains(FollowPos.length)) 
        {
            q0.setAceptar();
        }
        Estados.clear();
        Estados.add(q0);
        
        while (true) 
        {
            boolean exit = true;
            EstadoAFD s = null;
            for (EstadoAFD state : Estados) {
                if (!state.getMarcar()) {
                    exit = false;
                    s = state;
                }
            }
            if (exit) {
                break;
            }

            if (s.getMarcar()) {
                continue;
            }
            s.SetMarcar(true); 
            Set<Integer> name = s.getNombre();
            for (String a : Input) {
                Set<Integer> U = new HashSet<>();
                for (int p : name) {
                    if (Simbolo.get(p).equals(a)) {
                        U.addAll(FollowPos[p - 1]);
                    }
                }
                boolean flag = false;
                EstadoAFD tmp = null;
                for (EstadoAFD state : Estados) {
                    if (state.getNombre().equals(U)) {
                        tmp = state;
                        flag = true;
                        break;
                    }
                }
                if (!flag) 
                {
                    i++;
                    EstadoAFD q = new EstadoAFD(ID);
                     ID = caracteres[i];
                    q.AñadirAllNombre(U);
                    if (U.contains(FollowPos.length)) {
                        q.setAceptar();
                    }
                    Estados.add(q);
                    tmp = q;
                }
                s.AñadirMover(a, tmp);
                listaTransiciones.add(s.ID + s.Mover.toString());
                
            }
        }

        
        
             return q0;
    }
  
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList Firs;
    private javax.swing.JList Remplazar1;
    private javax.swing.JList Transciones;
    private javax.swing.JButton btn_ingresar;
    private javax.swing.JButton btn_ingresar2;
    private javax.swing.JList follow;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    // End of variables declaration//GEN-END:variables
}
