/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * CatalogoAlmacenes.java
 *
 * Created on 11/10/2008, 07:56:04 PM
 */

package omoikane.formularios;

import java.util.*;
import java.awt.event.*;
import java.awt.image.*;
import java.awt.*;
import javax.swing.table.*;
import javax.swing.*;
import javax.swing.event.*;
import omoikane.sistema.*;





/**
 *
 * @author Adan
 */
public class CatalogoAlmacenes extends javax.swing.JInternalFrame {

    BufferedImage     fondo;
    TimerBusqueda     timerBusqueda;
    public    int ID;

    class TimerBusqueda extends Thread
    {
        CatalogoAlmacenes ca;
        boolean busquedaActiva = true;

        TimerBusqueda(CatalogoAlmacenes ca) { this.ca = ca; }
        public void run()
        {
            synchronized(this)
            {
                busquedaActiva = true;
                try { this.wait(600); } catch(Exception e) { Dialogos.lanzarDialogoError(null, "Error en el timer de búsqueda automática", Herramientas.getStackTraceString(e)); }
                if(busquedaActiva) { ca.buscar(); }
            }
        }
        void cancelar()
        {
            busquedaActiva = false;
            try { this.notify(); } catch(Exception e) {}
        }
    }

        public void actionPerformed(ActionEvent ae)
    {
        System.out.println("acción");
    }

    /** Creates new form CatalogoAlmacenes */
    public CatalogoAlmacenes() {
        initComponents();

        this.setOpaque(false);
        ((JPanel)this.getContentPane()).setOpaque(false);
        this.getLayeredPane().setOpaque(false);
        this.getRootPane().setOpaque(false);
        this.generarFondo(this);

        this.btnAceptar.setVisible(false);

        Herramientas.centrarVentana(this);

        //Instrucciones para el funcionamiento de las teclas de navegación
        Set newKeys = new HashSet(getFocusTraversalKeys(KeyboardFocusManager.BACKWARD_TRAVERSAL_KEYS));
        newKeys.add(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0));
        setFocusTraversalKeys(KeyboardFocusManager.BACKWARD_TRAVERSAL_KEYS, newKeys);

        newKeys = new HashSet(getFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS));
        newKeys.add(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0));
        setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, newKeys);
    }



    

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtBusqueda = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaAlmacenes = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        btnAceptar = new javax.swing.JButton();
        btnDetalles = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnImprimir = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();

        setTitle("Catálogo de Almacenes");

        txtBusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBusquedaKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBusquedaKeyTyped(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Buscar [F3]:");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 36));
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Catálogo de Almacenes");

        tablaAlmacenes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Almacen", "Descripcion"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaAlmacenes.setShowHorizontalLines(false);
        jScrollPane1.setViewportView(tablaAlmacenes);

        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnAceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/32x32/accept.png"))); // NOI18N
        btnAceptar.setText("Aceptar [Enter]");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        btnDetalles.setIcon(new javax.swing.ImageIcon(getClass().getResource("/32x32/page_search.png"))); // NOI18N
        btnDetalles.setText("Detalles [F4]");
        btnDetalles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetallesActionPerformed(evt);
            }
        });

        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/32x32/page_add.png"))); // NOI18N
        btnNuevo.setText("Nuevo [F5]");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/32x32/blog_post_edit.png"))); // NOI18N
        btnModificar.setText("Modificar [F6]");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/32x32/page_remove.png"))); // NOI18N
        btnEliminar.setText("Eliminar [Supr]");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/32x32/printer.png"))); // NOI18N
        btnImprimir.setText("Imprimir [F7]");
        btnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirActionPerformed(evt);
            }
        });

        btnCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/back.png"))); // NOI18N
        btnCerrar.setText("Cerrar [Esc]");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 826, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 585, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAceptar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDetalles)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnNuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnModificar, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnImprimir, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 234, Short.MAX_VALUE)
                        .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(11, 11, 11)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAceptar)
                    .addComponent(btnDetalles, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        resetTable();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtBusquedaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBusquedaKeyTyped
        // TODO add your handling code here:
        preBuscar();
    }//GEN-LAST:event_txtBusquedaKeyTyped

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void txtBusquedaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBusquedaKeyPressed
        // TODO add your handling code here:
           if(evt.getKeyCode() == evt.VK_DOWN)
        {
            int sigFila = tablaAlmacenes.getSelectedRow()+1;
            if(sigFila < tablaAlmacenes.getRowCount())
            {
                this.tablaAlmacenes.setRowSelectionInterval(sigFila, sigFila);
                this.tablaAlmacenes.scrollRectToVisible(tablaAlmacenes.getCellRect(sigFila, 1, true));
            }
        }
        if(evt.getKeyCode() == evt.VK_UP)
        {
            int antFila = tablaAlmacenes.getSelectedRow()-1;
            if(antFila >= 0) {
                this.tablaAlmacenes.setRowSelectionInterval(antFila, antFila);
                this.tablaAlmacenes.scrollRectToVisible(tablaAlmacenes.getCellRect(antFila, 1, true));
            }
        }
        if(evt.getKeyCode() == evt.VK_PAGE_DOWN)
        {
            int nFilas  = (int) this.jScrollPane1.getViewportBorderBounds().getHeight() / tablaAlmacenes.getRowHeight();
            int sigFila = tablaAlmacenes.getSelectedRow()+nFilas;
            if(sigFila > tablaAlmacenes.getRowCount()) {
                sigFila = tablaAlmacenes.getRowCount()-1;
            }
            if(sigFila < tablaAlmacenes.getRowCount()) {
                this.tablaAlmacenes.setRowSelectionInterval(sigFila, sigFila);
                this.tablaAlmacenes.scrollRectToVisible(tablaAlmacenes.getCellRect(sigFila, 1, true));
            }
        }
        if(evt.getKeyCode() == evt.VK_PAGE_UP)
        {
            int nFilas  = (int) this.jScrollPane1.getViewportBorderBounds().getHeight() / tablaAlmacenes.getRowHeight();
            int antFila = tablaAlmacenes.getSelectedRow()-nFilas;
            if(antFila < 0) {
                antFila = 0;
            }
            this.tablaAlmacenes.setRowSelectionInterval(antFila, antFila);
            this.tablaAlmacenes.scrollRectToVisible(tablaAlmacenes.getCellRect(antFila, 1, true));
        }
        if(evt.getKeyCode() == evt.VK_DELETE)
        {
            this.btnEliminar.doClick();
        }

    }//GEN-LAST:event_txtBusquedaKeyPressed

    private void btnDetallesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetallesActionPerformed
        // TODO add your handling code here:
        int sel = this.tablaAlmacenes.getSelectedRow();
        int id;
        if(sel == -1) {
            Dialogos.lanzarAlerta("Ninguna fila ha sido seleccionada.");
        } else {
            id = (Integer)this.tablaAlmacenes.getValueAt(sel, 0);
            //Lanzar ventana y agregarle un listener
            omoikane.principal.Almacenes.lanzarDetallesAlmacen(id);
        }
}//GEN-LAST:event_btnDetallesActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        // TODO add your handling code here:
        JInternalFrame wnd = (JInternalFrame) omoikane.principal.Almacenes.lanzarFormNuevoAlmacen();
        wnd.addInternalFrameListener(iframeAdapter);
}//GEN-LAST:event_btnNuevoActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        // TODO add your handling code here:
        int sel = this.tablaAlmacenes.getSelectedRow();
        int id;

        if(sel == -1) {
            Dialogos.lanzarAlerta("Ninguna fila ha sido seleccionada.");
        } else {
            id = (Integer)this.tablaAlmacenes.getValueAt(sel, 0);
            //Lanzar ventana y agregarle un listener
            JInternalFrame wnd = (JInternalFrame) omoikane.principal.Almacenes.lanzarModificarAlmacen(id);
            wnd.addInternalFrameListener(iframeAdapter);
        }
}//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        int sel = this.tablaAlmacenes.getSelectedRow();
        int id;

        if(sel == -1) {
            Dialogos.lanzarAlerta("Ninguna fila ha sido seleccionada.");
        } else {
            id = (Integer)this.tablaAlmacenes.getValueAt(sel, 0);
            String descripcion = String.valueOf(((DefaultTableModel)tablaAlmacenes.getModel()).getValueAt(tablaAlmacenes.getSelectedRow(),1));
            if(JOptionPane.showConfirmDialog(null, "¿Realmente desea eliminar éste Almacen : \""+descripcion+"\"?", "seguro...", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
                omoikane.principal.Almacenes.eliminarAlmacen(id);
                resetTable();
            }
        }
}//GEN-LAST:event_btnEliminarActionPerformed

    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed
        // TODO add your handling code here:
        omoikane.principal.Almacenes.lanzarImprimir();
}//GEN-LAST:event_btnImprimirActionPerformed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        // TODO add your handling code here:
        this.dispose();
}//GEN-LAST:event_btnCerrarActionPerformed



    public void preBuscar()
    {
        if(timerBusqueda != null && timerBusqueda.isAlive()) { timerBusqueda.cancelar(); }
        this.timerBusqueda = new TimerBusqueda(this);
        timerBusqueda.start();

    }

    public void buscar()
    {
       resetTable();
    }



    public JTable getTablaAlmacenes()
    {
        return tablaAlmacenes;
    }

    public void resetTable()
    {
        String[] columnas = {"ID Almacen", "Descripcion"};
        this.tablaAlmacenes.setModel(new DefaultTableModel());
        ((DefaultTableModel)this.tablaAlmacenes.getModel()).setColumnIdentifiers(columnas);
        omoikane.principal.Almacenes.poblarAlmacenes(this.tablaAlmacenes,txtBusqueda.getText());
    }

    public void paintComponent(Graphics g)
    {
      Graphics2D g2d = (Graphics2D) g;
      g2d.drawImage(fondo, 0, 0, null);

    }
    public void generarFondo(Component componente)
    {
      Rectangle areaDibujo = this.getBounds();
      BufferedImage tmp;
      GraphicsConfiguration gc = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration();

      tmp = gc.createCompatibleImage(areaDibujo.width, areaDibujo.height,BufferedImage.TRANSLUCENT);
      Graphics2D g2d = (Graphics2D) tmp.getGraphics();
      g2d.setColor(new Color(55,55,255,165));
      g2d.fillRect(0,0,areaDibujo.width,areaDibujo.height);
      fondo = tmp;

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnDetalles;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnImprimir;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable tablaAlmacenes;
    public javax.swing.JTextField txtBusqueda;
    // End of variables declaration//GEN-END:variables

    public InternalFrameAdapter iframeAdapter = new InternalFrameAdapter()
    {
        public void internalFrameClosed(InternalFrameEvent e) { resetTable(); }

    };
}
