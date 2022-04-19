/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sptech.testeprojeto.trayicon;

/**
 *
 * @author LEONARDO
 */
import java.awt.AWTException;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class JFramePrincipal extends JFrame {
    
    static IconeNoTray trayManager;

    public JFramePrincipal() {

        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        this.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent e) {
                try {
                    trayManager.adicionarATray();
                } catch (AWTException e1) {
                    e1.printStackTrace();
                }
            }
        });
        this.setSize(670, 600);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setResizable(false);
    }

    @SuppressWarnings("empty-statement")
    public static void main(String[] args) {
        JFramePrincipal f = new JFramePrincipal();

        // Aqui eu adiciono funções extras no menu TRAY do programa
        final MenuItem[] itensExtrasMenu = new MenuItem[1];
        itensExtrasMenu[0] = new MenuItem("testeTry");
        itensExtrasMenu[0].addActionListener((ActionEvent e) -> {
            System.out.println("asd");
            ;
        });

        trayManager = new IconeNoTray(f, new ImageIcon("D:/Desenvolvimento/Java/testeTrayIcon/src/imagemok.png"));
        trayManager.setBalaoSistemaTitulo("Registro de Ponto");
        trayManager.setToolTipText("Registro de Ponto");
        trayManager.setBalaoSistemaDescricao("Sistema de Ponto ocultado. Para desocultar, abra o submenu e clique em Restaurar");
        trayManager.criarTrayIcon(itensExtrasMenu);

        try {
            trayManager.adicionarATray();
        } catch (AWTException e1) {
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

    

}
