/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;
import java.awt.AWTException;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import static java.awt.Frame.ICONIFIED;
import static java.awt.Frame.NORMAL;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.concurrent.Worker;
import javafx.embed.swing.JFXPanel;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebEvent;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
*/
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import modelo.Adaptador_Red;
import modelo.Guardar_Leer;
import modelo.Host;
import modelo.Inicio;
import modelo.Red;
import modelo.Return;


/**
 *
 * @author DABELOPER
 * 
 * 
 * @Licence Swap se encuentra bajo una Licencia Creative Commons Atribución-NoComercial-SinDerivadas 3.0 Unported.
 *
 * 
 *
 */



public class Pantalla_Principal extends javax.swing.JFrame {

    /**
     * Creates new form Pantalla_Principal
     */
    
    @Override
    public Image getIconImage() {
            Image retValue = Toolkit.getDefaultToolkit().
         getImage(ClassLoader.getSystemResource("Imagenes/Icono.png"));
   return retValue;
}


    static double version = 4; 
    private Inicio in;
    private  Red seleccionar_red = null;
    protected  Adaptador_Red adaptador_utilizado = null;
    protected Adaptador_Red principal ;
    
    private Bucle_Actualizar actualizacion_automatica ;
    
    
     private String ToolTip_Lbl_Estado_Ok,ToolTip_Lbl_Estado_Malo,ToolTip_Usar_Temporal,Text_Button_Usar_Temporal,
                    Text_Button_Usar_Des,Mensaje_Info_Perm , mensaje_salir,Mensaje_Info_1,Mensaje_Info_1b,
                    Mensaje_Info_1c,Mensaje_Info_2,Mensaje_Info_3,Mensaje_Info_3b,Mensaje_Info_3c,Mensaje_Info_4,
                    Mensaje_Info_5,Mensaje_Info_6,nombre;
     
     private Pantalla_Reglas pr = null;
     private WindowStateListener wsl = new java.awt.event.WindowStateListener() {
            @Override
            public void windowStateChanged(java.awt.event.WindowEvent evt) {
                FORMWindowStateChanged(evt);}
        };
     
     private final TrayIcon iconoSystemTray = new TrayIcon(Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("Imagenes/Icono_Tray.png")), "Swap");
     
     //ADS
     String Tl_ocultar,Tl_mostrar;
     private boolean ocultar_auto=false;
    private int ocultar=0,temp_perm=0; 
//    private Stage stage;  
//    private WebView browser;  
//    private JFXPanel jfxPanel; 
//    private WebEngine webEngine;    
   
     
    public Pantalla_Principal(Inicio ini) { 
        
        initComponents();
           
        this.resize(520, 400);
        this.setResizable(false);
        
        TablaP.getTableHeader().setReorderingAllowed(false); 
        TablaP.getTableHeader().setResizingAllowed(false);
        
        jCheckBoxMenuItem_TrayActionPerformed(null);
        JCMenuItem_ModoOpt.setSelected(false);
        jCheckBoxMenuItem_Tray.setSelected(true);
        jCheckBoxMenuItem_Reglas.setSelected(false);
       
        
        
        jMenuBar1.setBackground(Color.white);
        Button_Usar_Permanente.setBackground(Color.LIGHT_GRAY);
        Button_Usar_Temporal.setBackground(Color.lightGray);
        
        this.setLocationRelativeTo(null);
        //this.Btn_Ocultar_Ads.setEnabled(false);
        
        
        addWindowListener(new WindowAdapter(){
            @Override
    public void windowClosing(WindowEvent we){
            Salir();
            }});
        
        
        Pantalla_Principal.this.setVisible(true);
        this.in = ini;
         Return r = new Return();
         r.deleteFile(in.getPath(), ".jar");
        principal = in.getAdaptador_principal();
        idioma();
        //Btn_Ocultar_Ads.setToolTipText(Tl_ocultar);
        Verificar_Estador_Principal();
        
         
         TModel();
         this.TablaP.updateUI();
         
         
         
         this.Button_Usar_Temporal.addActionListener(new Btn_Usar_Temporal());
         this.Button_Usar_Permanente.addActionListener(new Btn_Usar_Permanente());
         
          
      TablaP.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if (evt.getClickCount() == 2){
                Mouse2Clicked(evt);}
            }
        });
         
        Ads(0);
        actualizacion_automatica = new Bucle_Actualizar();
        actualizacion_automatica.run();   
    }
          
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TablaP = new javax.swing.JTable();
        L_Activos = new javax.swing.JLabel();
        Button_Usar_Temporal = new javax.swing.JButton();
        Lbl_Estado = new javax.swing.JLabel();
        Button_Actualizar = new javax.swing.JButton();
        jLabel_Adaptador_Online = new javax.swing.JLabel();
        Button_Usar_Permanente = new javax.swing.JButton();
        Lbl_Ads = new javax.swing.JLabel();
        Lbl_Update = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu_Archivo = new javax.swing.JMenu();
        jMenuItem_Salir = new javax.swing.JMenuItem();
        jMenu_Configuraciones = new javax.swing.JMenu();
        jCheckBoxMenuItem_Reglas = new javax.swing.JCheckBoxMenuItem();
        jMenuItem_Restaurar_Todo = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        JCMenuItem_ModoOpt = new javax.swing.JCheckBoxMenuItem();
        jCheckBoxMenuItem_Tray = new javax.swing.JCheckBoxMenuItem();
        jMenuItem_Idioma = new javax.swing.JMenuItem();
        jMenu_Ayuda = new javax.swing.JMenu();
        jMenuItem_Tutorial = new javax.swing.JMenuItem();
        jMenuItem_Licencia = new javax.swing.JMenuItem();
        jMenuItem_Acerca_De = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Swap 4.0");
        setFont(new java.awt.Font("Microsoft Sans Serif", 0, 12)); // NOI18N
        setIconImage(getIconImage());
        setMaximumSize(new java.awt.Dimension(520, 430));
        setMinimumSize(new java.awt.Dimension(520, 430));
        setName("principal"); // NOI18N
        setPreferredSize(new java.awt.Dimension(520, 430));
        getContentPane().setLayout(null);

        jScrollPane1.setEnabled(false);

        TablaP.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        TablaP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        TablaP.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        TablaP.setRequestFocusEnabled(false);
        jScrollPane1.setViewportView(TablaP);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(25, 153, 452, 99);

        L_Activos.setFont(new java.awt.Font("Segoe UI Symbol", 0, 12)); // NOI18N
        L_Activos.setText("Adaptadores Activos:");
        L_Activos.setToolTipText("Adaptadores con conexion activa");
        getContentPane().add(L_Activos);
        L_Activos.setBounds(25, 119, 210, 16);

        Button_Usar_Temporal.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        Button_Usar_Temporal.setText("Utilizar Temporalmente");
        getContentPane().add(Button_Usar_Temporal);
        Button_Usar_Temporal.setBounds(296, 295, 181, 25);
        getContentPane().add(Lbl_Estado);
        Lbl_Estado.setBounds(25, 32, 72, 30);

        Button_Actualizar.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        Button_Actualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Refresh.png"))); // NOI18N
        Button_Actualizar.setText("Actualizar");
        Button_Actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_ActualizarActionPerformed(evt);
            }
        });
        getContentPane().add(Button_Actualizar);
        Button_Actualizar.setBounds(360, 81, 117, 25);

        jLabel_Adaptador_Online.setFont(new java.awt.Font("Segoe UI Semibold", 0, 13)); // NOI18N
        getContentPane().add(jLabel_Adaptador_Online);
        jLabel_Adaptador_Online.setBounds(103, 25, 299, 45);

        Button_Usar_Permanente.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        Button_Usar_Permanente.setText("Predeterminar");
        getContentPane().add(Button_Usar_Permanente);
        Button_Usar_Permanente.setBounds(25, 295, 181, 25);

        Lbl_Ads.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Lbl_Ads.setForeground(new java.awt.Color(0, 0, 255));
        Lbl_Ads.setToolTipText("");
        Lbl_Ads.setAutoscrolls(true);
        getContentPane().add(Lbl_Ads);
        Lbl_Ads.setBounds(10, 350, 260, 30);

        Lbl_Update.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Lbl_Update.setForeground(new java.awt.Color(255, 0, 0));
        getContentPane().add(Lbl_Update);
        Lbl_Update.setBounds(360, 350, 170, 20);

        jMenu_Archivo.setText("Archivo");

        jMenuItem_Salir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem_Salir.setText("Salir");
        jMenuItem_Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_SalirActionPerformed(evt);
            }
        });
        jMenu_Archivo.add(jMenuItem_Salir);

        jMenuBar1.add(jMenu_Archivo);

        jMenu_Configuraciones.setText("Herramientas");
        jMenu_Configuraciones.addMenuListener(new javax.swing.event.MenuListener() {
            public void menuCanceled(javax.swing.event.MenuEvent evt) {
            }
            public void menuDeselected(javax.swing.event.MenuEvent evt) {
            }
            public void menuSelected(javax.swing.event.MenuEvent evt) {
                jMenu_ConfiguracionesMenuSelected(evt);
            }
        });

        jCheckBoxMenuItem_Reglas.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        jCheckBoxMenuItem_Reglas.setSelected(true);
        jCheckBoxMenuItem_Reglas.setText("Reglas");
        jCheckBoxMenuItem_Reglas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxMenuItem_ReglasActionPerformed(evt);
            }
        });
        jMenu_Configuraciones.add(jCheckBoxMenuItem_Reglas);

        jMenuItem_Restaurar_Todo.setText("Restaurar todos los adaptadores");
        jMenuItem_Restaurar_Todo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_Restaurar_TodoActionPerformed(evt);
            }
        });
        jMenu_Configuraciones.add(jMenuItem_Restaurar_Todo);
        jMenu_Configuraciones.add(jSeparator3);

        JCMenuItem_ModoOpt.setSelected(true);
        JCMenuItem_ModoOpt.setText("Modo optimo (Procesos tardan mas)");
        jMenu_Configuraciones.add(JCMenuItem_ModoOpt);

        jCheckBoxMenuItem_Tray.setSelected(true);
        jCheckBoxMenuItem_Tray.setText("Ocultar al minimizar");
        jCheckBoxMenuItem_Tray.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxMenuItem_TrayActionPerformed(evt);
            }
        });
        jMenu_Configuraciones.add(jCheckBoxMenuItem_Tray);

        jMenuItem_Idioma.setText("Cambiar Idioma");
        jMenuItem_Idioma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_IdiomaActionPerformed(evt);
            }
        });
        jMenu_Configuraciones.add(jMenuItem_Idioma);

        jMenuBar1.add(jMenu_Configuraciones);

        jMenu_Ayuda.setText("Ayuda");

        jMenuItem_Tutorial.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        jMenuItem_Tutorial.setText("Tutorial");
        jMenuItem_Tutorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_TutorialActionPerformed(evt);
            }
        });
        jMenu_Ayuda.add(jMenuItem_Tutorial);

        jMenuItem_Licencia.setText("Licencia");
        jMenuItem_Licencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_LicenciaActionPerformed(evt);
            }
        });
        jMenu_Ayuda.add(jMenuItem_Licencia);

        jMenuItem_Acerca_De.setText("Acerca de...");
        jMenuItem_Acerca_De.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_Acerca_DeActionPerformed(evt);
            }
        });
        jMenu_Ayuda.add(jMenuItem_Acerca_De);

        jMenuBar1.add(jMenu_Ayuda);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents
 
    
    private void jMenuItem_IdiomaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_IdiomaActionPerformed
        
      String lng;
      
        if (jMenu_Ayuda.getText().equals("Help")){
            Español();
            lng = "es";
        }else{
            Ingles();
            lng = "en";
        }
        
        if (pr != null){
            pr.cambiar_idioma(lng);
        }
        
    }//GEN-LAST:event_jMenuItem_IdiomaActionPerformed

    private void Button_ActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_ActualizarActionPerformed
       Actualizar();
    }//GEN-LAST:event_Button_ActualizarActionPerformed

    private void jMenuItem_SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_SalirActionPerformed
        Salir();
    }//GEN-LAST:event_jMenuItem_SalirActionPerformed

    private void jMenuItem_Acerca_DeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_Acerca_DeActionPerformed
        JOptionPane.showMessageDialog(rootPane, "Creador : DABELOPER \n\n©©Swap Algunos Derechos Reservados\n\n Soporte : http://redswap.blogspot.com/" ,jMenuItem_Acerca_De.getText(),-1,  new ImageIcon(getClass().getResource( "/Imagenes/Icono_grande.png")));
    }//GEN-LAST:event_jMenuItem_Acerca_DeActionPerformed

    private void jMenuItem_Restaurar_TodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_Restaurar_TodoActionPerformed
       int opcion = JOptionPane.showConfirmDialog(rootPane, Mensaje_Info_6, "Swap" , JOptionPane.YES_NO_CANCEL_OPTION);
 
       if (opcion == 0){
 
           if (seleccionar_red == null){
            seleccionar_red = new Red(principal, in.getSO());}
           
            Lbl_Estado.setIcon( new ImageIcon(getClass().getResource( "/Imagenes/cargando.gif")));
            JOptionPane.showMessageDialog(rootPane, Mensaje_Info_3,"Swap",3); 
            seleccionar_red.Restaurar(JCMenuItem_ModoOpt.isSelected());
            Lbl_Estado.setIcon( new ImageIcon(getClass().getResource( "/Imagenes/Bueno.png")));
            seleccionar_red = null;
       }else{
           
            seleccionar_red = null;
            adaptador_utilizado = null;
            principal = in.getAdaptador_principal();}
       
    }//GEN-LAST:event_jMenuItem_Restaurar_TodoActionPerformed

    private void jMenuItem_TutorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_TutorialActionPerformed
        try {
            

        Object[] options_;
        String path;
        if ("Ayuda".equals(this.jMenu_Ayuda.getText())){
        path = "/Imagenes/GuiaS_es.png";
        Object[] options = {"  Mas  ","  Salir  "};
        options_ = options;   
        }else{
        path = "/Imagenes/GuiaS_en.png";
        Object[] options = {"  More  ","  Exit  "};
        options_ = options;
        }
            
                int es_op = JOptionPane.showOptionDialog(rootPane, "", "Swap", JOptionPane.YES_NO_OPTION,   JOptionPane.INFORMATION_MESSAGE,    new ImageIcon(getClass().getResource( path ))  ,    options_,    options_[1]);   
        
        if (es_op == 0){    
            
            Desktop.getDesktop().browse(new URI("http://redswap.blogspot.com/p/tutorialswap.html"));}
        } catch (IOException | URISyntaxException ex) {
            System.out.println("Error en jMenuItem_TutorialActionPerformed : \n"+ex.getMessage());
        }

    }//GEN-LAST:event_jMenuItem_TutorialActionPerformed

    private void jMenuItem_LicenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_LicenciaActionPerformed
        JTextArea Licen = new JTextArea("");
        Object[] options_;
        Licen.setEditable(false);
        if ("Ayuda".equals(this.jMenu_Ayuda.getText())){
        Object[] options = {"  Conocer mas  ","  Salir  "};
        options_ = options;
        Licen.setText("Usted puede:\n\n \tCompartir - copiar, distribuir, ejecutar y comunicar públicamente la obra.\n\n\nBajo las condiciones:\n\n\t Atribución — Debe reconocer los créditos de la obra...\n\t No Comercial — No puede utilizar esta obra para fines comerciales.\n\t Sin Obras Derivadas — No se puede alterar, transformar o generar una obra derivada a partir de esta obra. \n\n\nEl creador de Swap NO se hace responsable por cualquier daño o mal uso que ocasione el programa.");
        }else{
        Object[] options = {"Learn more","Exit"};
        options_ = options;
        Licen.setText("You can:\n\n \tShare - to copy, distribute and transmit the work.\n\n\nUnder the conditions: \n\n\t Atribución - You must attribute the work ... \n\t No Commercial - You can not use this work for commercial purposes. \n\t Without derivative Works - you may not alter, transform, or build a derivative work from this work. \n\n\nThe creator of Swap NOT responsible for any damage or misuse that causes the software.");

        }
        

        
        int es_op = JOptionPane.showOptionDialog(rootPane, Licen, "Swap", JOptionPane.YES_NO_OPTION,   JOptionPane.QUESTION_MESSAGE,    null,    options_,    options_[1]);   
        
        if (es_op == 0){
        try {
            Desktop.getDesktop().browse(new URI("http://creativecommons.org/licenses/by-nc-nd/2.5/co/"));
        } catch (IOException | URISyntaxException ex) {
            System.out.println("Error en jMenuItem_CodigosActionPerformed : \n"+ex.getMessage());
        }}
    }//GEN-LAST:event_jMenuItem_LicenciaActionPerformed

    private void jMenu_ConfiguracionesMenuSelected(javax.swing.event.MenuEvent evt) {//GEN-FIRST:event_jMenu_ConfiguracionesMenuSelected
      if (pr != null){
       
        if (pr.isVisible()){
            
     if (!jCheckBoxMenuItem_Reglas.isSelected()){jCheckBoxMenuItem_Reglas.setSelected(true);}
         
        }else{
        jCheckBoxMenuItem_Reglas.setSelected(false);
      
        }
      }
    }//GEN-LAST:event_jMenu_ConfiguracionesMenuSelected

    
    private void FORMWindowStateChanged(java.awt.event.WindowEvent evt){
    
              if ( evt.getNewState() == ICONIFIED) {
            this.setState(NORMAL);
            this.setVisible(false); 
        
       
        final PopupMenu popup = new PopupMenu();
        
        if (SystemTray.isSupported()) {
            this.setVisible(false);
            
            final SystemTray tray = SystemTray.getSystemTray();
      
            
            iconoSystemTray.setPopupMenu(popup);
                     

            MenuItem item_salir = new MenuItem(jMenuItem_Salir.getText());
            item_salir.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                Salir();}});
            
            String irs;
            if (jMenu_Ayuda.getText().equals("Help")){
                irs = "Open window";
                        }else{
                irs = "Abrir ventana";}
            
            MenuItem item_restaurar = new MenuItem(irs);
            item_restaurar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                      
                    setVisible(true);
                    toFront();
                    tray.remove(iconoSystemTray);  
                }
            });
            
            MenuItem item_reglas = new MenuItem(jCheckBoxMenuItem_Reglas.getText());
            item_reglas.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                       jCheckBoxMenuItem_Reglas.setSelected(!jCheckBoxMenuItem_Reglas.isSelected());
                       Reglas();
                       
             }});
            
            
            popup.add(item_restaurar);
            popup.add(item_reglas);
            popup.addSeparator();
            popup.add(item_salir);
            this.add(popup);

            
            ActionListener restaurar = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setVisible(true);
                    toFront();
                    tray.remove(iconoSystemTray);
                }
            };
            
            if (seleccionar_red != null){
                
                iconoSystemTray.displayMessage("Recuerda que se esta utlizando temporalmente un adaptador", "Swap", TrayIcon.MessageType.INFO);
            }
            
            iconoSystemTray.setImageAutoSize(true);
            iconoSystemTray.addActionListener(restaurar);
            
            
            
            try {
                tray.add(iconoSystemTray);
                if (seleccionar_red != null){
                 iconoSystemTray.displayMessage("Swap",Mensaje_Info_3b, TrayIcon.MessageType.INFO);}
           
            } catch (AWTException e) {
                System.err.println("No es posible agregar el icono al System Tray");
            }
        }
        else
            System.err.println("Tu sistema no soporta el System Tray :(");
      }
        
    }
    
    private void jCheckBoxMenuItem_ReglasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxMenuItem_ReglasActionPerformed
       Reglas();
    }//GEN-LAST:event_jCheckBoxMenuItem_ReglasActionPerformed

    private void jCheckBoxMenuItem_TrayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxMenuItem_TrayActionPerformed
         
    if (jCheckBoxMenuItem_Tray.isSelected()){  
        addWindowStateListener(wsl);
        jCheckBoxMenuItem_Tray.setSelected(true);

        }else{    
        removeWindowStateListener(wsl);
        jCheckBoxMenuItem_Tray.setIcon(null);
        }
    }//GEN-LAST:event_jCheckBoxMenuItem_TrayActionPerformed

    
    private void Salir(){
        if (seleccionar_red == null && pr == null){
            Return r = new Return();
            r.deleteFile(in.getPath(), ".jar");

            System.exit(0);
        }
        
        int opcion = JOptionPane.showConfirmDialog(rootPane, mensaje_salir, "Swap", JOptionPane.YES_NO_OPTION,3);    
       
        if (opcion == 0){
          if (seleccionar_red != null){
          Deshacer();}

          if (pr != null){
              pr.Deshacer_Reglas();
          }  

         Return r = new Return();
         r.deleteFile(in.getPath(), ".jar");

          System.exit(0);
        }
    }
    
    private void Reglas(){
           if(pr == null){
             Guardar_Leer l = new Guardar_Leer();
             l.Leer();
              LinkedList<Host> hosts = l.getHosts();
         
              
              if (jMenu_Ayuda.getText().equals("Ayuda")){
              pr = new Pantalla_Reglas(hosts,in.getAdaptadores(),"es",in);}else{
              pr = new Pantalla_Reglas(hosts,in.getAdaptadores(),"en",in);
              }
           }
        
           if (pr.isVisible()){
               pr.setVisible(false);
               
                }else{
                   pr.Actualizar_jComboBox();
                   pr.setVisible(true);
                   jCheckBoxMenuItem_Reglas.setSelected(true);
                  
                 }
        }

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Button_Actualizar;
    private javax.swing.JButton Button_Usar_Permanente;
    private javax.swing.JButton Button_Usar_Temporal;
    private javax.swing.JCheckBoxMenuItem JCMenuItem_ModoOpt;
    private javax.swing.JLabel L_Activos;
    private javax.swing.JLabel Lbl_Ads;
    private javax.swing.JLabel Lbl_Estado;
    private javax.swing.JLabel Lbl_Update;
    private javax.swing.JTable TablaP;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem_Reglas;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem_Tray;
    private javax.swing.JLabel jLabel_Adaptador_Online;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem_Acerca_De;
    private javax.swing.JMenuItem jMenuItem_Idioma;
    private javax.swing.JMenuItem jMenuItem_Licencia;
    private javax.swing.JMenuItem jMenuItem_Restaurar_Todo;
    private javax.swing.JMenuItem jMenuItem_Salir;
    private javax.swing.JMenuItem jMenuItem_Tutorial;
    private javax.swing.JMenu jMenu_Archivo;
    private javax.swing.JMenu jMenu_Ayuda;
    private javax.swing.JMenu jMenu_Configuraciones;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    // End of variables declaration//GEN-END:variables

    
    private class Bucle_Actualizar implements Runnable{

        @Override
        public void run() {
            //System.out.println(Pantalla_Principal.this.getBackground());
        try {if(seleccionar_red != null ){
             if (temp_perm >= 1200){
                 JOptionPane.showMessageDialog(rootPane, Mensaje_Info_3c,"Swap",JOptionPane.INFORMATION_MESSAGE); 
       principal = adaptador_utilizado;          
       Button_Usar_Permanente.setEnabled(true);
       jMenu_Configuraciones.setEnabled(true);
       Button_Usar_Temporal.setText(Text_Button_Usar_Temporal);
       TablaP.setEnabled(true);
       jLabel_Adaptador_Online.setText(principal.getNombre());
       Lbl_Estado.setIcon(new ImageIcon(getClass().getResource( "/Imagenes/Bueno.png" )));
       
                 seleccionar_red = null;
                 adaptador_utilizado = null;
                 temp_perm = 0;
             }
                temp_perm += 10;
                Actualizar();}else{temp_perm = 0;}
                
                Thread.sleep(10000);

                
//               if(Btn_Ocultar_Ads.getText().equals("<<") && Btn_Ocultar_Ads.isEnabled() && ocultar_auto){
//                  Btn_Ocultar_AdsActionPerformed(null);        
//              }
//                
//              if (!Btn_Ocultar_Ads.isEnabled()&& principal != null){
//                if (browser == null ){fx_Ads();}
//                if (ocultar >= 60 ){
//                    Btn_Ocultar_Ads.setEnabled(true);    
//                }else{
//                    if (isFocused()){ocultar += 10;}}}
                
            
              
              
            } catch (InterruptedException ex) {
                System.out.println("Error en Bucle_Actualizar "+ex.getMessage());
                Actualizar();
            }actualizacion_automatica.run();
        }
        

    }
    
    
    private void Actualizar() {
   try {
       
       int size_antes = in.getAdaptadores().size(); 
       in.Reiniciar();
       
       if( (in.getAdaptadores() != null) && (in.getAdaptadores().size() > 0) ){
       
              
       Adaptador_Red principal_temporal = in.getAdaptador_principal();    
       TablaP.updateUI();

       if (("??????????".equals(jLabel_Adaptador_Online.getText()) || principal == null) && seleccionar_red != null){
           
           principal = principal_temporal;
           if (principal != null){
           Verificar_Estador_Principal();
           TModel();}
           return ;
       }

      if (size_antes != in.getAdaptadores().size() || !in.BuscarAdaptador(principal.getMAC())){
           principal = principal_temporal;
           Verificar_Estador_Principal();
           TModel();
           return ;
       }
       

       if(seleccionar_red != null || principal != null){
       
       if (!principal.getIndice_metrica().equals(principal_temporal.getIndice_metrica()) && principal != null){
       principal = principal_temporal;
       jLabel_Adaptador_Online.setText(principal.getNombre());
       }

       if (seleccionar_red != null){          
                if(!(in.BuscarAdaptador(adaptador_utilizado.getMAC())) || ( !in.BuscarAdaptador(seleccionar_red.getAdaptador_utilizado().getMAC()) ) ){                  
                     JOptionPane.showMessageDialog(rootPane,Mensaje_Info_4+adaptador_utilizado.getNombre(),"Swap",0);
                     Deshacer();
                }}
       return ;
       }
       TModel();
       return ;
       }else{
           jLabel_Adaptador_Online.setText("??????????");
           this.Lbl_Estado.setIcon( new ImageIcon(getClass().getResource( "/Imagenes/Malo.png")));
           this.Lbl_Estado.setToolTipText(ToolTip_Lbl_Estado_Malo);
           this.jLabel_Adaptador_Online.setToolTipText(ToolTip_Lbl_Estado_Malo);
           principal = null;
           seleccionar_red = null;
           TModel();
       }
       
       
       } catch (java.lang.NullPointerException ex) {
                Verificar_Estador_Principal();
                System.out.println( "Error Actualizando :\n"+ex.getMessage()+ " Loc = " +ex.getCause());}
       return ;
            
    }
   
    private class Btn_Usar_Permanente implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

            if (TablaP.getSelectedRow() == -1 || TablaP.getSelectedRowCount() >= 2 ){               
                JOptionPane.showMessageDialog(rootPane,Mensaje_Info_2,"Swap",0);
                
            }else{      
            
            if (seleccionar_red == null){
                Actualizar();
                Utilizar_Permanente();
            }
        }
       }}
   
        private class Btn_Usar_Temporal implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

            
            if (seleccionar_red == null && (TablaP.getSelectedRow() == -1 || TablaP.getSelectedRowCount() >= 2) ){
                JOptionPane.showMessageDialog(rootPane,Mensaje_Info_2,"Swap",0);
                
            }else{                
                
            if (seleccionar_red == null){
                Actualizar();
                Utilizar_Temporal();
            }else {    
            int opcion = JOptionPane.showConfirmDialog(rootPane, Mensaje_Info_1b+adaptador_utilizado.getNombre()+"   ?", "Swap" , JOptionPane.YES_NO_CANCEL_OPTION,3);
 
        if (opcion == 0){  
               Deshacer();}
            }}
        }
       }
        
  private void Utilizar_Permanente(){
        
 if (TablaP.getSelectedRow() == -1){
       JOptionPane.showMessageDialog(rootPane,Mensaje_Info_2,"Swap",0);
       return ;
   }
           
           adaptador_utilizado = in.getAdaptadores().get(TablaP.getSelectedRow());
   
        if (adaptador_utilizado.isPrincipal() || adaptador_utilizado == principal){
            JOptionPane.showMessageDialog(rootPane, adaptador_utilizado.getNombre()+Mensaje_Info_5,"Swap",0);
            Lbl_Estado.setIcon( new ImageIcon(getClass().getResource( "/Imagenes/Bueno.png")));
            adaptador_utilizado = null;
            return ;
        }else{
        Lbl_Estado.setIcon( new ImageIcon(getClass().getResource( "/Imagenes/cargando.gif")));
        int opcion = JOptionPane.showConfirmDialog(rootPane, Mensaje_Info_1c+adaptador_utilizado.getNombre()+"   ?", "Swap" , JOptionPane.YES_NO_CANCEL_OPTION,3);
        
        if (opcion == 0){
               
        seleccionar_red = new Red(principal,in.getSO());
        
        if (adaptador_utilizado.getIndice_metrica() == null){
        in.Reiniciar();}
        
        seleccionar_red.Escoger(adaptador_utilizado,in.getAdaptadores(),JCMenuItem_ModoOpt.isSelected());
        Verificar_Estado_Balanceo();
        jLabel_Adaptador_Online.setText(adaptador_utilizado.getNombre());  
        principal = adaptador_utilizado;
        
        seleccionar_red = null;
        adaptador_utilizado = null;
        
        JOptionPane.showMessageDialog(rootPane, Mensaje_Info_Perm, "Swap" , 3);
        
        }else{
        Lbl_Estado.setIcon( new ImageIcon(getClass().getResource( "/Imagenes/Bueno.png")));
        }
        
        return ;
        }
        

    }     
        
    private void Utilizar_Temporal(){
   
   if (TablaP.getSelectedRow() == -1 ){
       JOptionPane.showMessageDialog(rootPane,Mensaje_Info_2,"Swap",0);
       return ;
   }
        
   if (seleccionar_red == null ){
   
        adaptador_utilizado = in.getAdaptadores().get(TablaP.getSelectedRow());
    
        if (adaptador_utilizado.isPrincipal() || adaptador_utilizado == principal){
            JOptionPane.showMessageDialog(rootPane, adaptador_utilizado.getNombre()+Mensaje_Info_5,"Swap",0);
         
            adaptador_utilizado = null;
            return ;
        }else{
        
        Lbl_Estado.setIcon( new ImageIcon(getClass().getResource( "/Imagenes/cargando.gif")));
        
        int opcion = JOptionPane.showConfirmDialog(rootPane, Mensaje_Info_1+adaptador_utilizado.getNombre()+"   ?", "Swap" , JOptionPane.YES_NO_CANCEL_OPTION,3);
        
        if (opcion == 0){
               
        seleccionar_red = new Red(principal,in.getSO());
        
        if (adaptador_utilizado.getIndice_metrica() == null){
        in.Reiniciar();}
        
        
        jMenu_Configuraciones.setEnabled(false);
        seleccionar_red.Escoger(adaptador_utilizado,in.getAdaptadores(),JCMenuItem_ModoOpt.isSelected());
        Button_Usar_Temporal.setText(Text_Button_Usar_Des);
        Button_Usar_Permanente.setEnabled(false);
        TablaP.setEnabled(false);
        Verificar_Estado_Balanceo();
        jLabel_Adaptador_Online.setText(adaptador_utilizado.getNombre());

        }else{
        adaptador_utilizado = null;
        Lbl_Estado.setIcon( new ImageIcon(getClass().getResource( "/Imagenes/Bueno.png")));
        }
        return ;
        }
    }
   else{
     int opcion = JOptionPane.showConfirmDialog(rootPane, Mensaje_Info_1b+adaptador_utilizado.getNombre()+"   ?", "Swap" , JOptionPane.YES_NO_CANCEL_OPTION,3);
 
        if (opcion == 0){  
               Deshacer();
                return ;}
   
   }
   
   return ;
    }
    
    
   private void Deshacer(){
    
    try{   
       Button_Usar_Permanente.setEnabled(true);
       jMenu_Configuraciones.setEnabled(true);
       Lbl_Estado.setIcon( new ImageIcon(getClass().getResource( "/Imagenes/cargando.gif")));
       seleccionar_red.Deshacer(JCMenuItem_ModoOpt.isSelected());
       Button_Usar_Temporal.setText(Text_Button_Usar_Temporal);
       TablaP.setEnabled(true);
       jLabel_Adaptador_Online.setText(principal.getNombre());
       this.Lbl_Estado.setIcon(new ImageIcon(getClass().getResource( "/Imagenes/Bueno.png" )));

       
       adaptador_utilizado = null;
       seleccionar_red = null;
       
       Verificar_Estador_Principal();
       Actualizar();
    }catch(Exception | StackOverflowError ex){
        System.exit(-1);
    }
   }
      
    private void TModel(){
        
           TablaP.setModel(new AdaptadorTableModel());
           Tamaño();
    }
   
   
      private void Deshacer_(){
       Button_Usar_Permanente.setEnabled(true);
       jMenu_Configuraciones.setEnabled(true);
       Button_Usar_Temporal.setText(Text_Button_Usar_Temporal);
       TablaP.setEnabled(true);
         jLabel_Adaptador_Online.setText("??????????");
         this.Lbl_Estado.setIcon( new ImageIcon(getClass().getResource( "/Imagenes/Malo.png")));
         this.Lbl_Estado.setToolTipText(ToolTip_Lbl_Estado_Malo);
         
       adaptador_utilizado = null;
       seleccionar_red = null;   
       principal = null;
       
       Actualizar();
   }
        

  
    private void Mouse2Clicked(java.awt.event.MouseEvent evt) { 
        Utilizar_Temporal();
    }
    

 
 private class AdaptadorTableModel implements TableModel {

        private String[] columnNames = {nombre,"IP"};
        private Class[] columnClass = {String.class,String.class};
        
        @Override
        public int getRowCount() {
           return in.getAdaptadores().size();
        }

        @Override
        public int getColumnCount() {
            return 2;
        }

        @Override
        public String getColumnName(int columnIndex) {
            return this.columnNames[columnIndex];
        }

        @Override
        public Class<?> getColumnClass(int columnIndex) {
            return this.columnClass[columnIndex];
        }

        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return false;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
         Object value = null;
      try{      
           Adaptador_Red ar = in.getAdaptadores().get(rowIndex);

           
            switch (columnIndex) {
                case 0:    
                    value = ar.getNombre();
                    break;
                case 1:
                    value = ar.getIP();
                    break;    
            }   
            }
                catch (java.lang.IndexOutOfBoundsException ex){
                    System.out.println("Error en Table Model : \n"+ex.getMessage());
                    }
        return value; }

        @Override
        public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        }

        @Override
        public void addTableModelListener(TableModelListener l) {
        }

        @Override
        public void removeTableModelListener(TableModelListener l) {
        }
    }
 
 


 
 
    private void Verificar_Estado_Balanceo(){

     if(!seleccionar_red.getEstado()){
     this.Lbl_Estado.setIcon( new ImageIcon(getClass().getResource( "/Imagenes/Malo.png")));
     this.Lbl_Estado.setToolTipText(ToolTip_Lbl_Estado_Malo);     
     this.jLabel_Adaptador_Online.setToolTipText(ToolTip_Lbl_Estado_Malo);
     }else{
        Lbl_Estado.setIcon( new ImageIcon(getClass().getResource( "/Imagenes/Bueno.png")));
       Lbl_Estado.setToolTipText(ToolTip_Lbl_Estado_Ok+adaptador_utilizado.getNombre());
     }
     
 }

    private void Verificar_Estador_Principal(){
     
     if (in.getAdaptadores().size() > 0){
        
       if (principal == null && seleccionar_red == null){
         jLabel_Adaptador_Online.setText("??????????");
         this.Lbl_Estado.setIcon( new ImageIcon(getClass().getResource( "/Imagenes/Malo.png")));
         this.Lbl_Estado.setToolTipText(ToolTip_Lbl_Estado_Malo);
         this.jLabel_Adaptador_Online.setToolTipText(ToolTip_Lbl_Estado_Malo);
         }else{
           if (seleccionar_red == null && principal != null){
         jLabel_Adaptador_Online.setText(principal.getNombre());
         this.Lbl_Estado.setIcon(new ImageIcon(getClass().getResource( "/Imagenes/Bueno.png" )));
         this.Lbl_Estado.setToolTipText(ToolTip_Lbl_Estado_Ok+principal.getNombre());
           }
              }   }else{
         Deshacer_();      
        }  
    
    }
 
 private void idioma(){
 
     if (in.getLeng().equals("en")){         
         Ingles();        
     }else{
         Español();
     }
     
 }

 
 
 
 private void Ingles(){
     
        nombre = "Adapter Name";
        TModel();
         jMenu_Archivo.setText("File");
         jMenu_Configuraciones.setText("Tools");
         jMenu_Ayuda.setText("Help");
         
         jMenuItem_Salir.setText("Exit");
         
         jMenuItem_Idioma.setText("Cambiar idioma a Español");
         jCheckBoxMenuItem_Reglas.setText("Rules");
         jCheckBoxMenuItem_Tray.setText("Hide when minimized");
         
         jMenuItem_Tutorial.setText("Manual");
         jMenuItem_Acerca_De.setText("About");
         jMenuItem_Restaurar_Todo.setText("Restore conexion for all adapters");
         jMenuItem_Licencia.setText("Licence");
         JCMenuItem_ModoOpt.setText("Secure mode (slow processes)");
         
         L_Activos.setText("Active Adapters:");

         
         Tl_ocultar = "Hide advertising";
         Tl_mostrar = "Show advertising";
         
         L_Activos.setToolTipText("Adapters with active Connection");
         Button_Actualizar.setToolTipText("Refresh Table of Adapters");
         
         ToolTip_Lbl_Estado_Ok = "Every Ok,\n Adapter in use: ";
         ToolTip_Lbl_Estado_Malo = "Adapter not is in Use; If this icon does not turn green Restart and Run as Administrator";

         
         mensaje_salir = "¿Sure you want close the application?";
         
         Text_Button_Usar_Temporal = "Utilize Temporally";
         Text_Button_Usar_Des = "Undo";
//         if (Btn_Ocultar_Ads.getText().equals("<<")){
//             Btn_Ocultar_Ads.setToolTipText(Tl_ocultar);
//         }else{Btn_Ocultar_Ads.setToolTipText(Tl_mostrar);}
         
         if (seleccionar_red == null){
             Button_Usar_Temporal.setText(Text_Button_Usar_Temporal);
             ToolTip_Usar_Temporal = "Utilize bandwidth temporally the Selected Adapter";
         }else{
             Button_Usar_Temporal.setText(Text_Button_Usar_Des);
             ToolTip_Usar_Temporal = "Undo utilize bandwidth temporally the Selected Adapter";
             Verificar_Estado_Balanceo();
         }
         
         Mensaje_Info_1 = "¿Sure you want to use temporally the connection the adapter :\n";
         Mensaje_Info_1b = "¿Sure you want to disable the conexion of the adapter :\n";
         Mensaje_Info_1c = "¿Are you sure you want to predetermine the use of the connecting the adapter: \n";
         Mensaje_Info_2 = "You must select a ONLY Network Adapter from the Table";
         Mensaje_Info_3b = "Remember that you are using an adapter temporarily";  
         Mensaje_Info_3c = "The temporary adapter has been slow to use, has been chosen as permanent";
         Mensaje_Info_3 = "Restoring Adapters...";
         Mensaje_Info_5 = " Is in use actually";
         Mensaje_Info_4 = "The selected adapter is disconnected:\n";
         Mensaje_Info_6 = "¿Sure you want Restore the conexion of all adapters? \n(Lose the connection of all adapters for several seconds)";
         Mensaje_Info_Perm = "This \"Adapter predetermine\" only endure if not done any modification more";
         

         this.Button_Usar_Temporal.setToolTipText(ToolTip_Usar_Temporal);
         this.Button_Actualizar.setText("Refresh");
         this.Button_Usar_Permanente.setText("Predetermine");
         this.Button_Usar_Permanente.setToolTipText("Predetermine the use Bandwidth the Selected Adapter");
         Verificar_Estador_Principal();
 }
 
 private void Español(){
 
            nombre = "Nombre Adaptador";
            TModel();
         jMenu_Archivo.setText("Archivo");
         jMenu_Configuraciones.setText("Herramientas");
         jMenu_Ayuda.setText("Ayuda"); 
         
         jMenuItem_Salir.setText("Salir");
         
         jMenuItem_Idioma.setText("Change language to English");
         jCheckBoxMenuItem_Reglas.setText("Reglas");
         jCheckBoxMenuItem_Tray.setText("Ocultar al minimizar");
         
         jMenuItem_Tutorial.setText("Tutorial");
         jMenuItem_Acerca_De.setText("Acerca de...");
         jMenuItem_Restaurar_Todo.setText("Restaurar la conexion para todos los adaptadores");
         jMenuItem_Licencia.setText("Licencia");
         JCMenuItem_ModoOpt.setText("Modo seguro (Procesos tardan mas)");
                 
         L_Activos.setText("Adaptadores Activos:");

         
         Tl_ocultar = "Ocultar publicidad";
         Tl_mostrar = "Mostrar publicidad";
//                  if (Btn_Ocultar_Ads.getText().equals("<<")){
//             Btn_Ocultar_Ads.setToolTipText(Tl_ocultar);
//         }else{Btn_Ocultar_Ads.setToolTipText(Tl_mostrar);}
         
         Button_Actualizar.setToolTipText("Actualiza la Tabla de Adaptadores");
         L_Activos.setToolTipText("Adaptadores con conexion activa");
         
          ToolTip_Lbl_Estado_Ok = "Todo en orden,\n Adaptador en uso: ";
          ToolTip_Lbl_Estado_Malo = "El Adaptador no se pudo usar; Si este icono no cambia a verde Reiniciar el Programa y Ejecutar como Administrador";
      
          mensaje_salir = "¿Seguro deseas Salir?";
                  
          Text_Button_Usar_Temporal = "Utilizar Temporalmente";
          Text_Button_Usar_Des = "Deshacer";
          
          if (seleccionar_red == null){
             Button_Usar_Temporal.setText(Text_Button_Usar_Temporal);
             ToolTip_Usar_Temporal = "Utilizar temporalmente ancho de banda";
         }else{
              Button_Usar_Temporal.setText(Text_Button_Usar_Des);
              ToolTip_Usar_Temporal = "Deshacer el utilizar temporalmente ancho de banda";
              Verificar_Estado_Balanceo();
          }
          
          Mensaje_Info_1 = "¿Seguro deseas utilizar temporalmente la conexion del adaptador :\n";
          Mensaje_Info_1b = "¿Seguro deseas desutilizar la conexion del adaptador :\n";
          Mensaje_Info_1c = "¿Seguro deseas predeterminar la conexion del adaptador :\n";
          Mensaje_Info_2 = "Debes seleccionar un UNICO Adaptador Red de la Tabla";
          Mensaje_Info_3 = "Restableciendo Adaptadores...";
          Mensaje_Info_3b = "Recuerda que se esta utilizando temporalmente un adaptador"; 
          Mensaje_Info_3c = "El Adaptador temporal ha tardado demasiado en su uso, se ha  elegido como permanente";
          Mensaje_Info_5 = " Esta en uso actualmente";
          Mensaje_Info_4 = "El Adaptador seleccionado se ha desconectado:\n";
          Mensaje_Info_6 = "¿Seguro que deseas restaurar la conexion de todos los adaptadores? \n(Perderas la conexion de todos los adaptadores por varios segundos)";
          Mensaje_Info_Perm = "Este \"Adaptador predeterminado\" Solo perdurara si no se hace ninguna modificacion mas";
        

         this.Button_Usar_Temporal.setToolTipText(ToolTip_Usar_Temporal);
         this.Button_Actualizar.setText("Actualizar");
         this.Button_Usar_Permanente.setText("Predeterminar");
         this.Button_Usar_Permanente.setToolTipText("Predeterminar el uso de Ancho de Banda del Adaptador seleccionado");
         Verificar_Estador_Principal();
 }
 
 
 
 private void Tamaño(){

         this.TablaP.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
         TableColumn rip = this.TablaP.getColumn("IP");
         rip.setPreferredWidth(150);
         TableColumn tc = this.TablaP.getColumn(nombre);
         tc.setPreferredWidth(300);
 
         rip= null;
         tc = null;
         System.gc();
 }

    private void Ads(int rec){
       //int width=0; int height = this.Lbl_Ads.getHeight();
        if( rec > 2 ){ return; }
        try {
                int Time = (int) (System.currentTimeMillis()/1000);
                int randomInt = Time%10;
                int index = 0;
                
                boolean mostrar = ((System.currentTimeMillis()/1000)%2)==0;
                    URL url = new URL("http://redswap.blogspot.com/p/ads_6.html");
			
			// read text returned by server
		    BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
		    
		    String line;
		    while ((line = in.readLine()) != null) {
                        if( line.length() < 6 ){ continue; }
                        line = line.trim();
                    try {
                        
		    	if( line.contains("<swap>") && line.contains("</swap>") ){
                            //System.out.println(line); 
                            line = line.replace("<swap>", "");
                            double vac = Double.parseDouble( line.replace("</swap>", "").trim() );
                            if( version < vac ){
                                this.Lbl_Update.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                                this.Lbl_Update.setText("Disponible Swap "+vac);
                                final URI nv = new URI("http://redswap.blogspot.com/");
                                this.Lbl_Update.addMouseListener(new java.awt.event.MouseAdapter() {
                                    @Override
                                    public void mouseClicked(java.awt.event.MouseEvent evt) {
                                        try {
                                            Desktop.getDesktop().browse(nv);
                                        } catch (IOException ex) {
                                            Logger.getLogger(Pantalla_Principal.class.getName()).log(Level.SEVERE, null, ex);
                                        }
                                    }
                                    
                                    @Override
                                    public void mouseEntered(java.awt.event.MouseEvent e) {
                                        Lbl_Update.setText( "<HTML><U>"+Lbl_Update.getText()+"</U></HTML>" );
                                    }
                                    
                                    @Override
                                    public void mouseExited(java.awt.event.MouseEvent e) {
                                        String txt = Lbl_Update.getText().replace("<HTML><U>","");
                                        Lbl_Update.setText( txt.replace("</U></HTML>","") );
                                    }
                                });
                            }
                        }
                        
                        if( mostrar && line.contains("<ads>") && line.contains("</ads>") ){
                            if( randomInt >= index ){ index++; continue; }
                            if( randomInt < index ){ break; }
                            
                            line = line.replace("<ads>", "");
                            line = line.replace("</ads>", "");
                            //System.out.println(line); 
                            
                           
                            if( line.contains("<a>") ){
                            String link = line.substring(line.indexOf("<a>")+3, line.indexOf("</a>"));
                            this.Lbl_Ads.setText("<HTML>"+line.replace("<a>"+link+"</a>", "")+"</HTML>");
                            final URI nv = new URI(link);
                            this.Lbl_Ads.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                            this.Lbl_Ads.addMouseListener(new java.awt.event.MouseAdapter() {
                                    @Override
                                    public void mouseClicked(java.awt.event.MouseEvent evt) {
                                        try {
                                            Desktop.getDesktop().browse(nv);
                                        } catch (IOException ex) {
                                            Logger.getLogger(Pantalla_Principal.class.getName()).log(Level.SEVERE, null, ex);
                                        }
                                    }
                                    
                                    @Override
                                    public void mouseEntered(java.awt.event.MouseEvent e) {
                                        String link = Lbl_Ads.getText().replace("<HTML>","");
                                        Lbl_Ads.setText( "<HTML><U>"+link.replace("</HTML>","")+"</U></HTML>" );
                                    }
                                    
                                    @Override
                                    public void mouseExited(java.awt.event.MouseEvent e) {
                                        String txt = Lbl_Ads.getText().replace("<U>","");
                                        Lbl_Ads.setText( txt.replace("</U>","") );
                                    }
                                });
                            }else{
                                 this.Lbl_Ads.setText("<HTML>"+line+"</HTML>");
                            }
                            this.resize(520, 440);
                        }
                    
                    }catch (NumberFormatException | URISyntaxException e) { System.out.println(e.getClass().toString()+" : " + e.getMessage()); }
                    
                    
		    }
		    in.close();
		    
		}
		catch (MalformedURLException e) {
			System.out.println("Malformed URL: " + e.getMessage());
		}
		catch (IOException e) {
			System.out.println("I/O Error: " + e.getMessage());
                        Ads(++rec);
		}
        
        //this.Lbl_Ads.setMinimumSize(width, height);
        //this.Lbl_Ads.setPreferedSize(width, height);
        //this.Lbl_Ads.setMaximumSize(width, height);
        //this.Lbl_Ads.setSize(width, height);
        
    }
 
}
