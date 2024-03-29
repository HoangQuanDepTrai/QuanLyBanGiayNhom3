/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.raven.component;

import com.raven.Model.Menu_Model;
import com.raven.event.EventMenuSelected;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import javax.swing.Icon;
import javax.swing.ImageIcon;
/**
 *
 * @author Lê Minh Khôi
 */
public class Menu extends javax.swing.JPanel {

    private EventMenuSelected event;

    public void addEventMenuSelected(EventMenuSelected event) {
        this.event = event;
        listMenu1.addEventMenuSelected(event);
    }

    public Menu() {
        initComponents();
        setOpaque(false);
        penMoving.setOpaque(false);
        listMenu1.setOpaque(false);
        init();
    }

    private void init() {
        listMenu1.addItem(new Menu_Model("", "Hệ thống", Menu_Model.MenuType.TITLE));
        listMenu1.addItem(new Menu_Model("login", "Đổi Mật Khẩu", Menu_Model.MenuType.MENU));
        listMenu1.addItem(new Menu_Model("logout", "Đăng Xuất", Menu_Model.MenuType.MENU));
        listMenu1.addItem(new Menu_Model("ketthuc", "Kết Thúc", Menu_Model.MenuType.MENU));
        listMenu1.addItem(new Menu_Model("", "", Menu_Model.MenuType.EMPTY));
        listMenu1.addItem(new Menu_Model("", "Quản Lý", Menu_Model.MenuType.TITLE));
        listMenu1.addItem(new Menu_Model("sanpham", "Sản Phẩm", Menu_Model.MenuType.MENU));
        listMenu1.addItem(new Menu_Model("NhanVien", "Nhân Viên", Menu_Model.MenuType.MENU));
        listMenu1.addItem(new Menu_Model("giaodich", "Giao Dịch", Menu_Model.MenuType.MENU));
        listMenu1.addItem(new Menu_Model("Trahang", "Trả Hàng", Menu_Model.MenuType.MENU));
        listMenu1.addItem(new Menu_Model("thongke", "Thống Kê", Menu_Model.MenuType.MENU));
    }

    @Override
    protected void paintChildren(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        //chỉnh màu
        GradientPaint gdp = new GradientPaint(0, 0, Color.decode("#434343"), 0, getHeight(), Color.decode("#000000"));
        g2.setPaint(gdp);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
        g2.fillRect(getWidth() - 20, 0, getWidth(), getHeight());
        super.paintChildren(g);
    }

    private int x;
    private int y;
//di chuyển Fame
    public void iniMoving(JFrame fr) {
        penMoving.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                x = e.getX();
                y = e.getY();
            }

        });
        penMoving.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                fr.setLocation(e.getXOnScreen() - x, e.getYOnScreen() - y);
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

        penMoving = new javax.swing.JPanel();
        lblShop = new javax.swing.JLabel();
        listMenu1 = new com.raven.Swing.ListMenu<>();

        penMoving.setBackground(getBackground());

        lblShop.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblShop.setForeground(new java.awt.Color(0, 255, 255));
        lblShop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/Icon/RavenXanh.png"))); // NOI18N
        lblShop.setText("SHOP BCCDM");

        javax.swing.GroupLayout penMovingLayout = new javax.swing.GroupLayout(penMoving);
        penMoving.setLayout(penMovingLayout);
        penMovingLayout.setHorizontalGroup(
            penMovingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblShop, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
        );
        penMovingLayout.setVerticalGroup(
            penMovingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, penMovingLayout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(lblShop, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        listMenu1.setOpaque(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(penMoving, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(listMenu1, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(penMoving, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(508, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(0, 97, Short.MAX_VALUE)
                    .addComponent(listMenu1, javax.swing.GroupLayout.PREFERRED_SIZE, 506, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblShop;
    private com.raven.Swing.ListMenu<String> listMenu1;
    private javax.swing.JPanel penMoving;
    // End of variables declaration//GEN-END:variables
}
