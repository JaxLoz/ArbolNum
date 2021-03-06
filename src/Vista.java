
import javax.swing.JOptionPane;
import javax.swing.tree.DefaultTreeModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author javier
 */
public class Vista extends javax.swing.JFrame {

    /**
     * Creates new form Vista
     */
    private DefaultTreeModel tree;
    ItipoRecorrido arbol;

    public Vista() {
        initComponents();
        tree = (DefaultTreeModel) Tree.getModel();
        tree.setRoot(null);
    }

    private void verMensaje(String texto) {
        JOptionPane.showMessageDialog(null, texto);
    }

    private Nodo getRaiz() {
        if (tree.getRoot() != null) {
            return (Nodo) tree.getRoot();
        } else {
            return null;
        }
    }

    private Nodo seleccionado() {
        if (Tree.getSelectionPath() != null) {
            return (Nodo) Tree.getLastSelectedPathComponent();
        } else {
            return null;
        }
    }

    private void actualizar() {
        tree.reload();
        txtNodo.setText("");
        txtNodo.grabFocus();
    }

    private boolean agregarRaiz() {
        try {
            Integer.parseInt(txtNodo.getText());
            if (getRaiz() == null) {
                tree.setRoot(new Nodo(txtNodo.getText()));
                actualizar();
                return true;
            } else {
                return false;
            }
        } catch (NumberFormatException e) {
        }
        return false;
    }

    //par
    private void preOrden(Nodo nodo) {
        if (nodo != null) {
            if ((Integer.parseInt(nodo.getIndicador().trim()) % 2) == 0) {
                mostrar(nodo);
            }
            preOrden(nodo.HijoNizquierdo());
            preOrden(nodo.HijoNderecho());
        }
    }

    //impar
    private void inOrden(Nodo nodo) {
        if (nodo != null) {
            inOrden(nodo.HijoNizquierdo());
            if ((Integer.parseInt(nodo.getIndicador().trim()) % 2) != 0) {
                mostrar(nodo);
            }
            inOrden(nodo.HijoNderecho());
        }
    }

    //impar y m??ltiplo de 3
    private void postOrden(Nodo nodo) {
        if (nodo != null) {
            int indicador = Integer.parseInt(nodo.getIndicador().trim());
            postOrden(nodo.HijoNizquierdo());
            postOrden(nodo.HijoNderecho());
            if ((indicador % 3) == 0)
            mostrar(nodo);
        }
    }

    private void mostrar(Nodo nodo) {
        jTextArea1.setText(jTextArea1.getText() + " " + nodo.getIndicador());
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
        Tree = new javax.swing.JTree();
        lbl1 = new javax.swing.JLabel();
        txtNodo = new javax.swing.JTextField();
        Btde = new javax.swing.JButton();
        btEl = new javax.swing.JButton();
        btLi = new javax.swing.JButton();
        btiz = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        cb1 = new javax.swing.JComboBox<>();
        btEs = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane1.setViewportView(Tree);

        lbl1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lbl1.setText("Ingresar valor del nodo:");

        Btde.setText("Derecha");
        Btde.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtdeActionPerformed(evt);
            }
        });

        btEl.setText("Eliminar");
        btEl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btElActionPerformed(evt);
            }
        });

        btLi.setText("Limpiar");
        btLi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLiActionPerformed(evt);
            }
        });

        btiz.setText("Izquierda");
        btiz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btizActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setText("Opciones del arbol");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setText("Opciones de resultados");

        cb1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PreOrden", "InOrden", "PostOrden" }));

        btEs.setText("Establecer");
        btEs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEsActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setText("Resultados");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btiz)
                        .addGap(18, 18, 18)
                        .addComponent(Btde)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                        .addComponent(btEl)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btLi)
                        .addGap(67, 67, 67))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lbl1)
                        .addGap(18, 18, 18)
                        .addComponent(txtNodo, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(95, 95, 95))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator2))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(58, 58, 58)
                                .addComponent(cb1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(btEs))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jSeparator3))
                            .addComponent(jScrollPane2))
                        .addGap(40, 40, 40))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 458, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNodo, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl1))
                        .addGap(60, 60, 60)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btiz)
                            .addComponent(btEl)
                            .addComponent(btLi)
                            .addComponent(Btde))
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cb1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btEs))
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void BtdeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtdeActionPerformed
        // TODO add your handling code here:
        Nodo padre;
        if (!agregarRaiz()) {
            try {
                padre = seleccionado();
                int nodo = Integer.parseInt(txtNodo.getText());
                if (padre == null) {
                    verMensaje("Seleccione nodo padre");
                } else if (padre.A??adirNder(new Nodo(nodo + ""))) {
                    actualizar();
                } else {
                    verMensaje("El padre ya tiene hijo izquierdo");
                }
            } catch (NumberFormatException e) {
                verMensaje("por favor ingrese un n??mero!!");
            }
        }
    }//GEN-LAST:event_BtdeActionPerformed

    private void btizActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btizActionPerformed
        // TODO add your handling code here:
        Nodo padre;
        if (!agregarRaiz()) {
            try {
                padre = seleccionado();
                int nodo = Integer.parseInt(txtNodo.getText());
                if (padre == null) {
                    verMensaje("Seleccione nodo padre");
                } else if (padre.A??adirNIz(new Nodo(nodo + ""))) {
                    actualizar();
                } else {
                    verMensaje("El padre ya tiene hijo izquierdo");
                }
            } catch (NumberFormatException e) {
                verMensaje("por favor ingrese un n??mero!!");
            }
        }
    }//GEN-LAST:event_btizActionPerformed

    private void btElActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btElActionPerformed
        // TODO add your handling code here:
        Nodo nodo;
        nodo = seleccionado();
        if (nodo != null) {
            if (nodo != getRaiz()) {
                tree.removeNodeFromParent(nodo);
            }
        } else {
            verMensaje("seleccione nodo a eliminar");
        }
    }//GEN-LAST:event_btElActionPerformed

    private void btLiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLiActionPerformed
        // TODO add your handling code here:
        tree.setRoot(null);
        actualizar();
    }//GEN-LAST:event_btLiActionPerformed

    private void btEsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEsActionPerformed
        // TODO add your handling code here:
        Nodo raiz;
        raiz = getRaiz();
        if (raiz != null) {
            jTextArea1.setText("");
            switch (cb1.getSelectedIndex()) {
                case 0:

                    arbol = (nodo) -> preOrden(nodo);
                    arbol.Recorrido(raiz);
                    break;
                case 1:
                    arbol = (nodo) -> inOrden(nodo);
                    arbol.Recorrido(raiz);
                    break;
                case 2:
                    arbol = (nodo) -> postOrden(nodo);
                    arbol.Recorrido(raiz);
                    break;
            }
        } else {
            verMensaje("arbol vac??o");
        }
    }//GEN-LAST:event_btEsActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Vista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btde;
    private javax.swing.JTree Tree;
    private javax.swing.JButton btEl;
    private javax.swing.JButton btEs;
    private javax.swing.JButton btLi;
    private javax.swing.JButton btiz;
    private javax.swing.JComboBox<String> cb1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel lbl1;
    private javax.swing.JTextField txtNodo;
    // End of variables declaration//GEN-END:variables
}
