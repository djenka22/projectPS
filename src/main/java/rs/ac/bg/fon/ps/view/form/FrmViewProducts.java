/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package rs.ac.bg.fon.ps.view.form;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import rs.ac.bg.fon.ps.controller.Controller;
import rs.ac.bg.fon.ps.domain.Product;

/**
 *
 * @author Rusimovic
 */
public class FrmViewProducts extends javax.swing.JDialog {

    /**
     * Creates new form FrmAllProducts
     */
    public FrmViewProducts(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        try {
            prepareView();
        } catch (Exception ex) {

            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error in view initialization: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
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
        tblProducts = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tblProducts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Price", "Measurement Unit", "Manufacturer", "Saved By"
            }
        ));
        jScrollPane1.setViewportView(tblProducts);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 461, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 37, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblProducts;
    // End of variables declaration//GEN-END:variables

    private void prepareView() throws Exception {
       fillTblProducts();
    }

    private void fillTblProducts() throws Exception {
        List <Product> products = Controller.getInstance().getAllProducts();
        
        DefaultTableModel model = (DefaultTableModel) tblProducts.getModel();
        for(Product product : products){
            Object row[] = new Object[] { product.getID(), product.getName(), product.getPrice(), product.getMeasurementUnit(), product.getManufacturer(), product.getSavedByUser()};
            model.addRow(row);
        }
    }
}
