/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.Desktop;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.UnknownHostException;
import java.util.Iterator;
import java.util.LinkedList;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.event.TableModelListener;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.TableModel;
import modelo.Adaptador_Red;
import modelo.Guardar_Leer;
import modelo.Host;
import modelo.Inicio;
import modelo.Red;
import modelo.Red_Regla;



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

public final class Pantalla_Reglas extends javax.swing.JFrame {

    /**
     * Creates new form Pantalla_Reglas
     */
    
        @Override
    public Image getIconImage() {
            Image retValue = Toolkit.getDefaultToolkit().
         getImage(ClassLoader.getSystemResource("Imagenes/Icono.png"));
   return retValue;
}
       
       
        
    private String   Adap ,enlace ,Info_1a , Info_1b , Info_1c , Info_1d ,Info_2a , Info_2b ,Info_3a ,Info_3b , Info_4 , Info_5 , Info_6 , Info_7 , Info_8;
        
    private LinkedList<Host> hosts ;
    private LinkedList<Adaptador_Red> enlaces_disponibles ;
    private Inicio in;
    private Red red = null;
    private Red_Regla rr = null;
    private String idioma;
         
    public Pantalla_Reglas(final LinkedList<Host> hosts,LinkedList<Adaptador_Red> enlaces_disponibles, String leng , Inicio ini ) {

        initComponents();
        this.red = new Red();
        in = ini;
        idioma = leng;      
        cambiar_idioma(idioma);
        
        this.setLocationRelativeTo(null);
        jTable_hosts.getTableHeader().setReorderingAllowed(false);  
        this.jTable_hosts.setModel(new ReglasTableModel());
        
          jTable_hosts.addMouseListener(new java.awt.event.MouseAdapter() {
              
                     @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if (in.getAdaptadores().size() > 0 && evt.getClickCount() == 2){
                Mouse2Clicked(evt);}else{  
               if (jTable_hosts.getSelectedRow() != -1){     
                jTable_hosts.setToolTipText(hosts.get(jTable_hosts.getSelectedRow()).toString());}
                }
            }     
          
           @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
              if (jTable_hosts.getSelectedRow() != -1){
                jTable_hosts.setToolTipText(hosts.get(jTable_hosts.getSelectedRow()).toString());}}     
           
           @Override
            public void mousePressed(java.awt.event.MouseEvent evt) {
            if (jTable_hosts.getSelectedRow() != -1){  
                jTable_hosts.setToolTipText(hosts.get(jTable_hosts.getSelectedRow()).toString());}} 
          
          @Override
            public void mouseReleased(java.awt.event.MouseEvent evt) {
             if (jTable_hosts.getSelectedRow() != -1){     
                jTable_hosts.setToolTipText(hosts.get(jTable_hosts.getSelectedRow()).toString());}} 
          
          });

        jRadioButton_Mostrar_Avanzadas.setSelected(false);
        jTextField_Mask.setText("255.255.255.255");
        jTextField_Mask.setEnabled(false);
        jLabel_IMG_Estado.setIcon( new ImageIcon(getClass().getResource( "/Imagenes/Bueno.png")));
        
        
               addWindowListener(new WindowAdapter(){
            @Override
    public void windowClosing(WindowEvent we){   
                setVisible(false);
    }});
               
               
        this.enlaces_disponibles = enlaces_disponibles;
        this.hosts = hosts;
        
        Actualizar_jComboBox();
        
        jComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jTable_hosts.setToolTipText(null);
               jTable_hosts.setModel(new ReglasTableModel());
            }
        });

        

          
 
      jTextField_IP.addKeyListener(new java.awt.event.KeyAdapter() {


            @Override
            public void keyReleased(KeyEvent ke) {
                if (ke.getKeyCode() == 10){
                    jTextField_IP.setEnabled(false);
                    Agregar_host();
                    jTextField_IP.setEnabled(true);   
            }
                 
            } 
        });  
        
      
            jTextField_Nombre.addKeyListener(new java.awt.event.KeyAdapter() {


            @Override
            public void keyReleased(KeyEvent ke) {
                if (ke.getKeyCode() == 10){
                    jTextField_Nombre.setEnabled(false);
                    jButton_obteneripActionPerformed(null);
                    jTextField_Nombre.setEnabled(true);   
            }
                 
            } 
        }); 
            
            
    jTextField_Mask.addKeyListener(new java.awt.event.KeyAdapter() {


            @Override
            public void keyReleased(KeyEvent ke) {
                if (ke.getKeyCode() == 10){
                    jTextField_Mask.setEnabled(false);
                    Agregar_host();
                    jTextField_Mask.setEnabled(true);   
            }
                 
            } 
        });
             
          
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
        jTable_hosts = new javax.swing.JTable();
        jComboBox = new javax.swing.JComboBox();
        jLabel_Host_Activos = new javax.swing.JLabel();
        Btn_Lanzar = new javax.swing.JButton();
        Btn_Eliminar = new javax.swing.JButton();
        jPanel = new javax.swing.JPanel();
        jLabel_IP = new javax.swing.JLabel();
        jLabel_Nom = new javax.swing.JLabel();
        jButton_Agregar = new javax.swing.JButton();
        jTextField_IP = new javax.swing.JTextField();
        jTextField_Nombre = new javax.swing.JTextField();
        jLabel_Mask = new javax.swing.JLabel();
        jTextField_Mask = new javax.swing.JTextField();
        jRadioButton_Mostrar_Avanzadas = new javax.swing.JRadioButton();
        jButton_obtenerip = new javax.swing.JButton();
        Btn_GuardarenArchivo = new javax.swing.JButton();
        jLabel_enlace = new javax.swing.JLabel();
        jLabel_IMG_Estado = new javax.swing.JLabel();
        jButton_Actualizar = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu_Archivo = new javax.swing.JMenu();
        jMenuItem_Anhadir = new javax.swing.JMenuItem();
        jMenuItem_Fin = new javax.swing.JMenuItem();
        jMenu_Ayuda = new javax.swing.JMenu();
        jMenuItem_Tuto = new javax.swing.JMenuItem();
        jMenuItem_Acerca = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Swap");
        setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        setIconImage(getIconImage());
        setResizable(false);

        jTable_hosts.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTable_hosts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Host", "IP", "Adaptador", "Enlazado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable_hosts.setDragEnabled(true);
        jTable_hosts.setEditingColumn(1);
        jTable_hosts.setEditingRow(1);
        jScrollPane1.setViewportView(jTable_hosts);
        jTable_hosts.getColumnModel().getColumn(0).setResizable(false);
        jTable_hosts.getColumnModel().getColumn(1).setResizable(false);
        jTable_hosts.getColumnModel().getColumn(2).setResizable(false);
        jTable_hosts.getColumnModel().getColumn(3).setResizable(false);

        jComboBox.setFont(new java.awt.Font("Segoe UI Semibold", 0, 13)); // NOI18N

        jLabel_Host_Activos.setText("Hosts:");

        Btn_Lanzar.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        Btn_Lanzar.setText("Usar reglas");
        Btn_Lanzar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_LanzarActionPerformed(evt);
            }
        });

        Btn_Eliminar.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        Btn_Eliminar.setText("Eliminar");
        Btn_Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_EliminarActionPerformed(evt);
            }
        });

        jPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Host"));

        jLabel_IP.setText("IP:");

        jLabel_Nom.setText("Nombre:");

        jButton_Agregar.setText("Agregar");
        jButton_Agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_AgregarActionPerformed(evt);
            }
        });

        jLabel_Mask.setText("Mascara de subred:");

        jRadioButton_Mostrar_Avanzadas.setText("Avanzadas");
        jRadioButton_Mostrar_Avanzadas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton_Mostrar_AvanzadasActionPerformed(evt);
            }
        });

        jButton_obtenerip.setText("Obtener IP");
        jButton_obtenerip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_obteneripActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelLayout = new javax.swing.GroupLayout(jPanel);
        jPanel.setLayout(jPanelLayout);
        jPanelLayout.setHorizontalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLayout.createSequentialGroup()
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jRadioButton_Mostrar_Avanzadas))
                    .addGroup(jPanelLayout.createSequentialGroup()
                        .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanelLayout.createSequentialGroup()
                                .addComponent(jLabel_Nom)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField_Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelLayout.createSequentialGroup()
                                .addComponent(jLabel_IP)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField_IP, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelLayout.createSequentialGroup()
                                .addComponent(jLabel_Mask)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField_Mask, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton_obtenerip)
                            .addComponent(jButton_Agregar))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelLayout.setVerticalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jRadioButton_Mostrar_Avanzadas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_Nom)
                    .addComponent(jTextField_Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_obtenerip))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_IP)
                    .addComponent(jTextField_IP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_Mask)
                    .addComponent(jTextField_Mask, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_Agregar))
                .addGap(33, 33, 33))
        );

        Btn_GuardarenArchivo.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        Btn_GuardarenArchivo.setText("Guardar en archivo");
        Btn_GuardarenArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_GuardarenArchivoActionPerformed(evt);
            }
        });

        jLabel_enlace.setText("Adaptador:");

        jButton_Actualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Refresh.png"))); // NOI18N
        jButton_Actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ActualizarActionPerformed(evt);
            }
        });

        jMenuBar1.setBackground(new java.awt.Color(255, 255, 255));

        jMenu_Archivo.setText("Archivo");

        jMenuItem_Anhadir.setText("Añadir hosts desde archivo");
        jMenuItem_Anhadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_AnhadirActionPerformed(evt);
            }
        });
        jMenu_Archivo.add(jMenuItem_Anhadir);

        jMenuItem_Fin.setText("Finalizar");
        jMenuItem_Fin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_FinActionPerformed(evt);
            }
        });
        jMenu_Archivo.add(jMenuItem_Fin);

        jMenuBar1.add(jMenu_Archivo);

        jMenu_Ayuda.setText("Ayuda");

        jMenuItem_Tuto.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        jMenuItem_Tuto.setText("Tutorial");
        jMenuItem_Tuto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_TutoActionPerformed(evt);
            }
        });
        jMenu_Ayuda.add(jMenuItem_Tuto);

        jMenuItem_Acerca.setText("Acerca de...");
        jMenuItem_Acerca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_AcercaActionPerformed(evt);
            }
        });
        jMenu_Ayuda.add(jMenuItem_Acerca);

        jMenuBar1.add(jMenu_Ayuda);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(267, Short.MAX_VALUE)
                .addComponent(Btn_Lanzar)
                .addGap(18, 18, 18)
                .addComponent(Btn_Eliminar)
                .addGap(24, 24, 24))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Btn_GuardarenArchivo))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel_Host_Activos)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(29, 29, 29)
                                    .addComponent(jLabel_IMG_Estado, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel_enlace)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton_Actualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(15, 15, 15))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel_enlace)
                        .addComponent(jComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton_Actualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel_IMG_Estado, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60)
                .addComponent(jPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel_Host_Activos, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Btn_Eliminar)
                    .addComponent(Btn_Lanzar))
                .addGap(12, 12, 12)
                .addComponent(Btn_GuardarenArchivo)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Btn_LanzarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_LanzarActionPerformed
  
   
      Usar_Regla();

      
    }//GEN-LAST:event_Btn_LanzarActionPerformed

    private void Btn_EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_EliminarActionPerformed
    jTable_hosts.setToolTipText(null);
    
     if (jTable_hosts.getSelectedRow() != -1){   
        int i = JOptionPane.showConfirmDialog(rootPane, Info_4+ hosts.get(jTable_hosts.getSelectedRow()).getNombre()+"\"");      
        
        if (i == 0){
        hosts.remove(jTable_hosts.getSelectedRow());}
        
        jTable_hosts.setModel(new ReglasTableModel());}else{
       
       if ("es".equals(idioma)){   
            JOptionPane.showMessageDialog(rootPane, "Selecciona un(1) Host de la tabla para eliminar","Swap",JOptionPane.INFORMATION_MESSAGE);
       }else{
           JOptionPane.showMessageDialog(rootPane, "Select One(1) Host from the table for remove","Swap",JOptionPane.INFORMATION_MESSAGE);
       }
     }
        
    }//GEN-LAST:event_Btn_EliminarActionPerformed

    private void jMenuItem_FinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_FinActionPerformed
       setVisible(false);
    }//GEN-LAST:event_jMenuItem_FinActionPerformed

    private void Btn_GuardarenArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_GuardarenArchivoActionPerformed
     
     int i = JOptionPane.showConfirmDialog(rootPane, Info_5 );      
        
        if (i == 0){ 
        Guardar_Leer gl = new Guardar_Leer();
        gl.Guardar(hosts);
        
        if ("es".equals(idioma)){  
        JOptionPane.showMessageDialog(rootPane, "Listo");
        }else{
        JOptionPane.showMessageDialog(rootPane, "Saved");
        }
        
        gl = null;}
        
    }//GEN-LAST:event_Btn_GuardarenArchivoActionPerformed

    private void jRadioButton_Mostrar_AvanzadasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton_Mostrar_AvanzadasActionPerformed

        if (jRadioButton_Mostrar_Avanzadas.isSelected()){

            jTextField_Mask.setEnabled(true);
        }else{

          jTextField_Mask.setText("255.255.255.255");
          jTextField_Mask.setEnabled(false);
        }


    }//GEN-LAST:event_jRadioButton_Mostrar_AvanzadasActionPerformed

    private void jButton_AgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_AgregarActionPerformed
    
        Agregar_host();

    }//GEN-LAST:event_jButton_AgregarActionPerformed

    private void jMenuItem_AnhadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_AnhadirActionPerformed
     jTable_hosts.setToolTipText(null);
     
        JFileChooser fc = new JFileChooser("./");  
        FileFilter filtro = new FileNameExtensionFilter("Data (.dat)", "dat");
        fc.setFileFilter(filtro);
        int result = fc.showOpenDialog(this);
        
        
        if (result == fc.APPROVE_OPTION) {

        
        Guardar_Leer gl = new Guardar_Leer();
        
         LinkedList<Host> hst = gl.Leer(fc.getSelectedFile().getAbsolutePath());
         int r=0;
         boolean mns = false;   
         
         Iterator<Host> hosts_p_iterator = hosts.iterator();
         
         Host hosts_get;
         
         while (hosts_p_iterator.hasNext()){

             hosts_get = hosts_p_iterator.next();
             
        for (int j=0; j< hst.size(); j++){   
        if (hosts_get.getIPs().getFirst().equals(hst.get(j).getIPs().getFirst())) {
            hst.remove(j);
            r++;
            mns = true;
            break;
            }
           }
        }
        
        if (mns){
            if ("es".equals(idioma)){
            JOptionPane.showMessageDialog(rootPane, "¡¡ Se hallaron "+ r+"/"+(hst.size()+r) +" Hosts repetidos; estos no se agregan a la tabla !!","Swap",1);
            }else{
            JOptionPane.showMessageDialog(rootPane, "¡¡ We found "+ r+"/"+(hst.size()+r) +" Hosts repeated, these are not added to the table !!","Swap",1);            
            }
            
        }
        
        hosts.addAll(hst);
        jTable_hosts.setModel(new ReglasTableModel());
        
        }
         


        
        
    }//GEN-LAST:event_jMenuItem_AnhadirActionPerformed

    private void jMenuItem_TutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_TutoActionPerformed
        try {
            

        Object[] options_;
        String path;
        if ("Ayuda".equals(this.jMenu_Ayuda.getText())){
        path = "/Imagenes/GuiaT_es.png";
        Object[] options = {"  Mas  ","  Salir  "};
        options_ = options;   
        }else{
        path = "/Imagenes/GuiaT_en.png";
        Object[] options = {"  More  ","  Exit  "};
        options_ = options;
        }
            
                int es_op = JOptionPane.showOptionDialog(rootPane, "", "Swap", JOptionPane.YES_NO_OPTION,   JOptionPane.INFORMATION_MESSAGE,    new ImageIcon(getClass().getResource( path ))  ,    options_,    options_[1]);   
        
        if (es_op == 0){    
            
            Desktop.getDesktop().browse(new URI("http://redswap.blogspot.com/p/tutorialreglas.html"));}
        } catch (IOException | URISyntaxException ex) {
            System.out.println("Error en jMenuItem_TutorialActionPerformed : \n"+ex.getMessage());
        }
    }//GEN-LAST:event_jMenuItem_TutoActionPerformed

    private void jMenuItem_AcercaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_AcercaActionPerformed
       JOptionPane.showMessageDialog(rootPane, "Creador : DABELOPER \n\n©©Swap Algunos Derechos Reservados\n\n Soporte : http://redswap.blogspot.com/" ,jMenuItem_Acerca.getText(),-1,  new ImageIcon(getClass().getResource( "/Imagenes/Icono_grande.png")));
    }//GEN-LAST:event_jMenuItem_AcercaActionPerformed

    private void jButton_ActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ActualizarActionPerformed
        Actualizar();
    }//GEN-LAST:event_jButton_ActualizarActionPerformed

    private void jButton_obteneripActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_obteneripActionPerformed
        
        jTextField_Nombre.setText(jTextField_Nombre.getText().trim());
        byte b = 1;
        if (! (jTextField_Nombre.getText().contains("/") || jTextField_Nombre.getText().contains(" ")) ){
           
        jTextField_IP.setText(red.ping(b, jTextField_Nombre.getText()));}
    }//GEN-LAST:event_jButton_obteneripActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btn_Eliminar;
    private javax.swing.JButton Btn_GuardarenArchivo;
    private javax.swing.JButton Btn_Lanzar;
    private javax.swing.JButton jButton_Actualizar;
    private javax.swing.JButton jButton_Agregar;
    private javax.swing.JButton jButton_obtenerip;
    private javax.swing.JComboBox jComboBox;
    private javax.swing.JLabel jLabel_Host_Activos;
    private javax.swing.JLabel jLabel_IMG_Estado;
    private javax.swing.JLabel jLabel_IP;
    private javax.swing.JLabel jLabel_Mask;
    private javax.swing.JLabel jLabel_Nom;
    private javax.swing.JLabel jLabel_enlace;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem_Acerca;
    private javax.swing.JMenuItem jMenuItem_Anhadir;
    private javax.swing.JMenuItem jMenuItem_Fin;
    private javax.swing.JMenuItem jMenuItem_Tuto;
    private javax.swing.JMenu jMenu_Archivo;
    private javax.swing.JMenu jMenu_Ayuda;
    private javax.swing.JPanel jPanel;
    private javax.swing.JRadioButton jRadioButton_Mostrar_Avanzadas;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_hosts;
    private javax.swing.JTextField jTextField_IP;
    private javax.swing.JTextField jTextField_Mask;
    private javax.swing.JTextField jTextField_Nombre;
    // End of variables declaration//GEN-END:variables


    
public void Deshacer_Reglas (){
    Red_Regla rr = new Red_Regla();
    
    if(!jPanel.isEnabled()){
    rr.Eliminar(hosts);}

}    
    

 private void Agregar_host(){
 try {      
  
            String p = jTextField_IP.getText().trim();
                int j=0;
            
        
                
           if (p.length() > 15 || p.length() < 7 ){  
              
               JOptionPane.showMessageDialog(rootPane, Info_1a+jTextField_IP.getText().trim()+Info_1b,"Swap",JOptionPane.ERROR_MESSAGE);
               
               return ;
           }else{
               
                for (int i=0 ; i<p.length();i++){
                    
                    
                   if( Character.isLetter(p.charAt(i)) ){
                       j=0;
                       break;
                   }
                    
                    if (p.charAt(i) == '.'){
                       ++j;}
                
                }
            
             if ( j == 3 ){

                InetAddress.getByName(jTextField_IP.getText().trim());
                
                String Ip = jTextField_IP.getText().trim();
                String No = jTextField_Nombre.getText().trim();
                
                if (No.indexOf("[m]") != -1){ 
                    No = No.replace("[m]", " ");
                }
                
             if (No.isEmpty()){  
                No =jTextField_IP.getText().trim(); 
                }

               
              if(!contenido_host_ip(Ip) ){ 
                
                  
                if (jRadioButton_Mostrar_Avanzadas.isSelected()){

              String  m = jTextField_Mask.getText().trim();
            
              if (m.length() > 15 || m.length() < 9){
                  JOptionPane.showMessageDialog(rootPane, Info_2a+m+Info_2b,"Swap",JOptionPane.ERROR_MESSAGE);
                  jTextField_Mask.setText("");
                  return ;
              }else{
              
                 if ( !comprobar_mask(m)){
                      JOptionPane.showMessageDialog(rootPane, Info_2a+m+Info_2b,"Swap",JOptionPane.ERROR_MESSAGE); 
                     jTextField_Mask.setText("");
                     return ;
                 }
              }
                 
                No ="[m] "+ No; 
                
              
                hosts.add(new Host(No,Ip,m));
                }else{
                        
                hosts.add(new Host(No,Ip));}
              }
                
                Ip=null;
                No= null;
                jTable_hosts.setModel(new ReglasTableModel());
                jTable_hosts.setToolTipText(null);
                jTextField_Nombre.setText("");
                jTextField_IP.setText("");
                jTextField_Mask.setText("255.255.255.255");
                }else{
                 JOptionPane.showMessageDialog(rootPane, Info_1a+jTextField_IP.getText().trim()+Info_1b,"Swap",JOptionPane.ERROR_MESSAGE);
                 return ;
             }
             return ;
             
           }
           

                
            } catch (UnknownHostException ex) {
                JOptionPane.showMessageDialog(rootPane, Info_1a+jTextField_IP.getText().trim()+Info_1b,"Swap",JOptionPane.ERROR_MESSAGE);
            }return ;
 
 
 }   
    
 
 
 private boolean comprobar_mask(String mask_probar){
 
 
     String[] mask_validas = {"255.255.255.255","255.255.255.254","255.255.255.252","255.255.255.240","255.255.255.224","255.255.255.192","255.255.255.128","255.255.255.0","255.255.254.0","255.255.252.0","255.255.252.0","255.255.248.0","255.255.240.0","255.255.224.0","255.255.192.0","255.255.128.0","255.255.0.0","255.254.0.0","255.252.0.0","255.248.0.0","255.240.0.0","255.224.0.0","255.192.0.0","255.128.0.0","255.0.0.0"};
 
     
     for (int i=0; i < mask_validas.length ; i++){
         
         if (mask_probar.equals(mask_validas[i])){
             return true;
         }
     }
     
     return false;
 }
 
 
    
 private class ReglasTableModel implements TableModel{
         private String[] columnNames = {"Host","IP",Adap,enlace};
        private Class[] columnClass = {String.class,String.class,String.class,Boolean.class};
        

        @Override
        public int getRowCount() {
           return hosts.size();
        }

        @Override
        public int getColumnCount() {
            return 4;
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
            
          if (in.getAdaptadores().size() > 0 && columnIndex == 3){
            return true;}else{
            return false;}
               
        }

        
        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
         Object value = null;
      try{      
           Host hs = hosts.get(rowIndex);
           
           
            switch (columnIndex) {
                case 0:    
                    value = hs.getNombre();
                    break;
                case 1:
                    if (hs.getIPs().size() > 1){
                    value = "***.***.***.***";
                    }else{value = hs.getIPs().getFirst();}
                    break;     
                case 2:
                    value = hs.getEnlace();
                    break;  
                case 3:
                    value = hs.getEstado();
                    break;     
            }   
            }
                catch (java.lang.IndexOutOfBoundsException ex){
                    System.out.println("Error en Table Model : \n"+ex.getMessage());
                    }
        return value; }

        @Override
        public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
            Host hs = hosts.get(rowIndex);
            switch(columnIndex){ 
            case 0: break;
            case 1: break;
            case 2: break;
            case 3:
                escoger_host(hs);
                break;    
        }
                }

        @Override
        public void addTableModelListener(TableModelListener l) {
        }

        @Override
        public void removeTableModelListener(TableModelListener l) {
        }
 }

  private void Mouse2Clicked(java.awt.event.MouseEvent evt) { 
      if (jTable_hosts.getSelectedRow() != -1 && jComboBox.getSelectedIndex() != -1){
        escoger_host(hosts.get(jTable_hosts.getSelectedRow()));}
    }
 
  
  
  public void escoger_host(Host hs){
      jTable_hosts.setToolTipText(null);
      Actualizar();
      
      
      if (in.getAdaptadores().size() > 0 && jComboBox.getSelectedIndex() != -1){
              if(hs.getEnlace() == null || (hs.getEnlace().getMAC().equals(enlaces_disponibles.get(jComboBox.getSelectedIndex()).getMAC())) ){
                hs.setEstado(!hs.getEstado());
                
                if (!hs.getEstado()){
                    hs.setEnlace(null);
                }else
                {hs.setEnlace(enlaces_disponibles.get(jComboBox.getSelectedIndex()));}
                
                }else{
                int i = JOptionPane.showConfirmDialog(rootPane, Info_3a+hs.getNombre()+Info_3b+hs.getEnlace()+"\"");
                   if (i == 0){
                    hs.setEstado(false);
                    hs.setEnlace(null);
                   }
                }         
      }else{
      JOptionPane.showMessageDialog(rootPane, Info_8,"Swap",JOptionPane.INFORMATION_MESSAGE);
      }
      jTable_hosts.setModel(new ReglasTableModel());
  }
  
  
  
  public boolean contenido_host_ip (String ip){
  String eqs = ip.substring(0, ip.indexOf('.'));
    if (( "0".equals(eqs)) || "127".equals(eqs)){
   JOptionPane.showMessageDialog(rootPane, Info_1a+jTextField_IP.getText().trim()+Info_1c,"Swap",JOptionPane.ERROR_MESSAGE);       
    return true;}
  
    if ( ('0' == eqs.charAt(0)) || eqs.length() > 3){
    JOptionPane.showMessageDialog(rootPane, Info_1a+ip+Info_1b,"Swap",JOptionPane.ERROR_MESSAGE);       
    return true;        
    }
    
  try {  
      
         Iterator<Host> hosts_p_iterator = hosts.iterator();
         Iterator<String> ips_iterator;
         
         Host hosts_get;
         String ips_get;
         
    while (hosts_p_iterator.hasNext()){
        
        hosts_get = hosts_p_iterator.next();

      if (hosts_get.getIPs().size() > 1){
      
          ips_iterator = hosts_get.getIPs().iterator();
          
      while (ips_iterator.hasNext()){
          
          ips_get = ips_iterator.next();
          
        if( ips_get.equals(ip)){
             JOptionPane.showMessageDialog(rootPane, Info_1a+jTextField_IP.getText().trim()+Info_1d,"Swap",JOptionPane.ERROR_MESSAGE);       
              return true;
        }
       }}else{
      
                  if( hosts_get.getIPs().getFirst().equals(ip)){
             JOptionPane.showMessageDialog(rootPane, Info_1a+jTextField_IP.getText().trim()+Info_1d,"Swap",JOptionPane.ERROR_MESSAGE);       
              return true;
        }
      }
      
      }
  }catch(java.lang.IndexOutOfBoundsException ex){
      System.out.println("Error en contenido_host_ip : "+ex.getMessage());
  } return false;
  }
  
  
  
  private void Leng_es(){
  
      Adap = "Adaptador";
      enlace = "Enlace";
      
      Info_1a = "La IP ingresada : \"";
      Info_1b = "\"\n No es una IPv4 valida";
      Info_1c = "\"\n Es una IP del sistema";
      Info_1d = "\"\n ya existe";
      
      Info_2a = "La mascara ingresada : \"";
      Info_2b = "\"\n No es una mascara valida";
      
      Info_3a = "Seguro deseas quitar el enlace de \"";
      Info_3b = "\" con \"";
      
      Info_4 = "Seguro deseas eliminar el host : \n\"";
      Info_5 = "Si guardas, sobreescribiras todos los hosts existentes. \n ¿Seguro deseas hacerlo?";
      Info_6 = "¿Seguro deseas usar la Regla? [Verifica los Hosts enlazados]";
      Info_7 = "¿Seguro deseas eliminar la Regla en uso? ";
      Info_8 = "Primero escoge un adaptador de la lista desplegable";
      
      // *************************************** //
      
      jRadioButton_Mostrar_Avanzadas.setText("Avanzadas");
      jMenu_Archivo.setText("Archivo");
      jMenu_Ayuda.setText("Ayuda");
      jMenuItem_Acerca.setText("Acerca de...");
      jMenuItem_Anhadir.setText("Añadir hosts desde archivo");
      jMenuItem_Fin.setText("Finalizar");
      jMenuItem_Tuto.setText("Tutorial");
      jLabel_Mask.setText("Mascara de subred:");
      jLabel_Nom.setText("Nombre:");
      jLabel_enlace.setText("Adaptador: ");
      
      
      // **************************************** //
      
      jButton_Agregar.setText("Agregar");
      
      if (rr == null){
      Btn_Lanzar.setText("Usar reglas");}else{
            Btn_Lanzar.setText("Deshacer Reglas");
      }
      
      Btn_Eliminar.setText("Eliminar");
      Btn_GuardarenArchivo.setText("Guardar en archivo");
      Btn_GuardarenArchivo.setToolTipText("Guarda los Hosts de la tabla en el archivo \"Swap_hosts.dat\" ");
      
     jTable_hosts.setToolTipText(null); 
     jTable_hosts.setModel(new ReglasTableModel());
  }
  
  private void Leng_en(){
      
      Adap = "Adapter";
      enlace = "Link";
      
      Info_1a = "The IP entered : \"";
      Info_1b = "\"\n is not a valid IPv4";
      Info_1c = "\"\n is a IP system";
      Info_1d = "\"\n exists";
      
      Info_2a = "The mask entered : \"";
      Info_2b = "\"\n is not a valid mask";
      
      Info_3a = "Sure you want to remove the link  \"";
      Info_3b = "\" with \"";
      
      Info_4 = "Sure you want to delete the host : \n\"";
      Info_5 = "If you save, you'll overwrite all existing hosts. \n Are you sure you want to?";
      Info_6 = "Sure you want use the Rule? [verify the Hosts linked]";
      Info_7 = "Sure you want remove the Rule in use? ";
      Info_8 = "First choose an adapter from the dropdown list";
            // *************************************** //
      
      jRadioButton_Mostrar_Avanzadas.setText("Advanced");
      jMenu_Archivo.setText("File");
      jMenu_Ayuda.setText("Help");
      jMenuItem_Acerca.setText("About ...");
      jMenuItem_Anhadir.setText("Add hosts from file");
      jMenuItem_Fin.setText("Finalize");
      jMenuItem_Tuto.setText("Manual");
      jLabel_Mask.setText("Subnet Mask:");
      jLabel_Nom.setText("Name:");
      jLabel_enlace.setText("Adapter: ");
      
      
      // **************************************** //
      
      jButton_Agregar.setText("Add");
      
      if (rr == null){
      Btn_Lanzar.setText("Use rules");}else{
      Btn_Lanzar.setText("Undo Rules");
      }
      Btn_Eliminar.setText("Remove");
      Btn_GuardarenArchivo.setText("Save to File");
      Btn_GuardarenArchivo.setToolTipText("Saves the Hosts from table in the file \"Swap_hosts.dat\" ");
      
      jTable_hosts.setToolTipText(null);
      jTable_hosts.setModel(new ReglasTableModel());
  }
    
    
  
  public void cambiar_idioma(String lng){
  
      if ("es".equals(lng)){
            Leng_es();
            idioma = "es";
        }else{
            Leng_en();
            idioma = "en";
        }
      
      
  }
  
  
  private void Usar_Regla(){

       
    short j = 0;
         Iterator<Host> hosts_p_iterator = hosts.iterator();        
         Host hosts_get;

         
    while (hosts_p_iterator.hasNext()){
    
      hosts_get = hosts_p_iterator.next();
       
       if (hosts_get.getEstado()){     
         j++;
         break;
       }
     }
   
      
     if (j == 0 ){
      if ("es".equals(idioma)){ 
          JOptionPane.showMessageDialog(rootPane, "Debe primero \"Enlazar\" como minimo un(1) Host con un(1) Adaptador");
          }else{
          JOptionPane.showMessageDialog(rootPane, "You must first \"Link\" minimum of one (1) Host with one (1) Adapter");    
          }
                   return ;
     }
    
      
    if (jPanel.isEnabled()){
        
   int i = JOptionPane.showConfirmDialog(rootPane, Info_6, "Swap",1);      
        
    if (i == 0){ 
         Actualizar();
        rr = new Red_Regla();
      if (hosts.size() > 0 ){
        
         if (rr.verificar_adm() || (in.getSO().equals("Windows XP"))){
   
        rr.Crear(hosts);
     
    if ("es".equals(idioma)){ 
      Btn_Lanzar.setText("Deshacer Reglas");
      }else{
      Btn_Lanzar.setText("Undo Rules");
      }
        
        
      if ("es".equals(idioma)){    
        JOptionPane.showMessageDialog(rootPane, "Reglas en uso","Swap",JOptionPane.INFORMATION_MESSAGE);
      }else{
      JOptionPane.showMessageDialog(rootPane, "Rules in use","Swap",JOptionPane.INFORMATION_MESSAGE);}
      
     
      jMenuItem_Anhadir.setEnabled(false);
      jComboBox.setEnabled(false);
      jPanel.setEnabled(false);
      jTable_hosts.setEnabled(false);
      jRadioButton_Mostrar_Avanzadas.setEnabled(false);
      jButton_Agregar.setEnabled(false);
      Btn_Eliminar.setEnabled(false);
      Btn_GuardarenArchivo.setEnabled(false);
      jTextField_Nombre.setEnabled(false);
      jTextField_IP.setEnabled(false);
      jTextField_Mask.setEnabled(false);
      
      

      
      }}}
    }else{
        
           int i = JOptionPane.showConfirmDialog(rootPane, Info_7, "Swap",1);      
        
    if (i == 0){
           if (hosts.size() > 0){
      
               eliminar_regla_conj();
      
           }   
        
           rr = null;
           Actualizar();}
    }
    
    return ;
  }
  
  
  private void eliminar_regla_conj (){
     rr.Eliminar(hosts);
        
    if ("es".equals(idioma)){ 
      Btn_Lanzar.setText("Usar Reglas");
      }else{
      Btn_Lanzar.setText("Use Rules");
      }
        
        if ("es".equals(idioma)){ 
        JOptionPane.showMessageDialog(rootPane, "Regla Eliminada","Swap",JOptionPane.INFORMATION_MESSAGE);
        }else{
        JOptionPane.showMessageDialog(rootPane, "Rule remove","Swap",JOptionPane.INFORMATION_MESSAGE);
        }
        
      jMenuItem_Anhadir.setEnabled(true);  
      jComboBox.setEnabled(true);   
      jPanel.setEnabled(true);
      jTable_hosts.setEnabled(true);
      jRadioButton_Mostrar_Avanzadas.setEnabled(true);
      jButton_Agregar.setEnabled(true);
      Btn_Eliminar.setEnabled(true);
      Btn_GuardarenArchivo.setEnabled(true);
      jTextField_Nombre.setEnabled(true);
      jTextField_IP.setEnabled(true);
      
      jRadioButton_Mostrar_Avanzadas.setSelected(false);
      jRadioButton_Mostrar_AvanzadasActionPerformed(null);
  
  }
  
  
  public void Actualizar_jComboBox(){
    int e = jComboBox.getSelectedIndex();
    jComboBox.removeAllItems();
    
         Iterator<Adaptador_Red> enlaces_disp_iterator = enlaces_disponibles.iterator();        
         Adaptador_Red enlace_get;

         
    while (enlaces_disp_iterator.hasNext()){
    
      enlace_get = enlaces_disp_iterator.next(); 
      jComboBox.addItem(enlace_get.getNombre());
   }
      
      jComboBox.setSelectedIndex(e);
      jTable_hosts.setToolTipText(null);
      jTable_hosts.setModel(new ReglasTableModel());
      
  }
  
  
   public boolean BuscarAdaptador(String mac){
       
         Iterator<Adaptador_Red> enlaces_disp_iterator = enlaces_disponibles.iterator();        
         Adaptador_Red enlace_get;

         
    while (enlaces_disp_iterator.hasNext()){
    
      enlace_get = enlaces_disp_iterator.next();    
               if (enlace_get.getMAC().equals(mac)){
               return true;} 
           }

      return false;  
    }
      
  private void Actualizar(){
  
      this.enlaces_disponibles = in.getAdaptadores();
      
         Iterator<Host> hosts_iterator = hosts.iterator();        
         Host host_get;

         
    while (hosts_iterator.hasNext()){
    
      host_get = hosts_iterator.next(); 
          
          if (host_get.getEstado() && ! BuscarAdaptador(host_get.getEnlace().getMAC())){
                      host_get.setEstado(false);
                      host_get.setEnlace(null);
                      
              if (rr != null){
                  eliminar_regla_conj();
                  rr = null;
              }
                      
          }
      
      }
      
      
      Actualizar_jComboBox();
  }


  
  
  
}
