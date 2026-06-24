/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package bioskop.view.user;

import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;
import bioskop.view.auth.LoginFrame;
import bioskop.dao.*;
import bioskop.model.*;

/**
 *
 * @author aryab
 */
public class OrderFrame extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(OrderFrame.class.getName());
    
// 3 Keranjang Belanja Sementara
    private List<OrderTicketDetail> keranjangTiket = new ArrayList<>();
    private List<OrderFoodDetail> keranjangFood = new ArrayList<>();
    private List<OrderPackageDetail> keranjangPackage = new ArrayList<>();
    
    // Variabel untuk menampung seluruh kursi kosong di jadwal tertentu
    private List<Seat> kursiTersediaTemp = new ArrayList<>();
    
    /**
     * Creates new form FoodOrderFrame
     */
    public OrderFrame() {
        initComponents();
        loadDataAwal();
        refreshSemuaTabel();
    }
    
    private void loadDataAwal() {
        // 1. Load Film
        FilmComboBox.removeAllItems();
        FilmDAO filmDAO = new FilmDAO();
        for (Film f : filmDAO.getAllFilms()) {
            FilmComboBox.addItem(f);
        }

        // 2. Load Makanan
        MakananComboBox.removeAllItems();
        FoodDAO foodDAO = new FoodDAO();
        for (Food f : foodDAO.getAllFoods()) {
            MakananComboBox.addItem(f);
        }

        // 3. Load Paket Makanan
        PaketMakananComboBox.removeAllItems();
        FoodPackageDAO packageDAO = new FoodPackageDAO();
        for (FoodPackage p : packageDAO.getAllFoodPackages()) {
            PaketMakananComboBox.addItem(p);
        }
    }

    private void hitungTotalKeseluruhan() {
        double grandTotal = 0;
        
        for (OrderTicketDetail t : keranjangTiket) grandTotal += t.getHarga();
        for (OrderFoodDetail f : keranjangFood) grandTotal += f.getSubtotal();
        for (OrderPackageDetail p : keranjangPackage) grandTotal += p.getSubtotal();
        
        TotalHargaLabel.setText("Rp " + grandTotal);
    }

    private void refreshSemuaTabel() {
        // Refresh Tabel Tiket (Kolom: Judul Film, Jadwal, Kursi, Harga)
        DefaultTableModel modelTiket = (DefaultTableModel) TiketTable.getModel();
        modelTiket.setRowCount(0);
        for (OrderTicketDetail t : keranjangTiket) {
            modelTiket.addRow(new Object[]{
                FilmComboBox.getSelectedItem().toString(), // Ambil judul dari combobox
                JadwalTayangComboBox.getSelectedItem().toString(), // Ambil jam tayang
                t.getNomorKursi(),
                t.getHarga()
            });
        }

        // Refresh Tabel Makanan (Kolom: Tipe, Nama Item, Jumlah, Subtotal)
        DefaultTableModel modelMakanan = (DefaultTableModel) MakananTable.getModel();
        modelMakanan.setRowCount(0);
        
        for (OrderFoodDetail f : keranjangFood) {
            modelMakanan.addRow(new Object[]{"Satuan", f.getNamaFood(), f.getJumlah(), f.getSubtotal()});
        }
        for (OrderPackageDetail p : keranjangPackage) {
            modelMakanan.addRow(new Object[]{"Paket", p.getNamaPaket(), p.getJumlah(), p.getSubtotal()});
        }
        
        hitungTotalKeseluruhan();
    }
    
    private void filterKursiBerdasarkanJenis() {
        KursiComboBox.removeAllItems(); // Kosongkan dulu
        
        // Pastikan jenis kursi sudah dipilih dan data kursi dari database tidak kosong
        if (JenisKursiComboBox.getSelectedItem() != null && !kursiTersediaTemp.isEmpty()) {
            
            // Ambil teks jenis kursi, hilangkan spasi depan/belakang
            String jenisDipilih = JenisKursiComboBox.getSelectedItem().toString().trim(); 
            
            // CEK 1: Cetak ke output NetBeans
            System.out.println("LOG: Jenis kursi yang dicari = '" + jenisDipilih + "'");
            System.out.println("LOG: Total kursi di studio ini = " + kursiTersediaTemp.size());

            int kursiDitemukan = 0;
            
            for (Seat kursi : kursiTersediaTemp) {
                // Ambil jenis kursi dari database, hilangkan spasi
                String jenisDiDB = kursi.getJenisKursi().trim(); 
                
                // Bandingkan tanpa mempedulikan huruf besar/kecil
                if (jenisDiDB.equalsIgnoreCase(jenisDipilih)) {
                    KursiComboBox.addItem(kursi);
                    kursiDitemukan++;
                }
            }
            
            // CEK 2: Cetak hasil filter
            System.out.println("LOG: Kursi yang cocok = " + kursiDitemukan);
            
        } else {
            System.out.println("LOG: Filter diabaikan karena Jenis Kursi null ATAU kursiTersediaTemp kosong.");
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

        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jMenu1 = new javax.swing.JMenu();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jLabel5 = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        FilmComboBox = new javax.swing.JComboBox();
        JadwalTayangComboBox = new javax.swing.JComboBox();
        JenisKursiComboBox = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        TiketTable = new javax.swing.JTable();
        TambahTiketButton = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        KursiComboBox = new javax.swing.JComboBox();
        HapusTiketButton = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        MakananComboBox = new javax.swing.JComboBox();
        jScrollPane3 = new javax.swing.JScrollPane();
        MakananTable = new javax.swing.JTable();
        JumlahMakananSpinner = new javax.swing.JSpinner();
        PaketMakananComboBox = new javax.swing.JComboBox();
        jLabel11 = new javax.swing.JLabel();
        JumlahPaketSpinner = new javax.swing.JSpinner();
        TambahMakananButton = new javax.swing.JButton();
        HapusMakananButton = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel12 = new javax.swing.JLabel();
        TotalHargaLabel = new javax.swing.JLabel();
        BayarButton = new javax.swing.JButton();
        LogoutButton = new javax.swing.JButton();
        MenuUtamaButton = new javax.swing.JButton();

        jLabel2.setText("jLabel2");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.addActionListener(this::jComboBox1ActionPerformed);

        jTabbedPane1.addTab("Makanan & Minuman", jTabbedPane2);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 307, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 101, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("tab2", jPanel1);

        jLabel3.setText("jLabel3");

        jMenu1.setText("jMenu1");

        jScrollPane1.setViewportView(jTextPane1);

        jLabel5.setText("jLabel5");

        jButton2.setText("jButton2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Pemesanan");

        jLabel4.setText("Film");

        jLabel6.setText("Jadwal");

        jLabel7.setText("Jenis Kursi");

        FilmComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        FilmComboBox.setSelectedIndex(-1);
        FilmComboBox.addActionListener(this::FilmComboBoxActionPerformed);

        JadwalTayangComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        JadwalTayangComboBox.setSelectedIndex(-1);
        JadwalTayangComboBox.addActionListener(this::JadwalTayangComboBoxActionPerformed);

        JenisKursiComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Regular", "Couple" }));
        JenisKursiComboBox.setSelectedIndex(-1);
        JenisKursiComboBox.addActionListener(this::JenisKursiComboBoxActionPerformed);

        TiketTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Film", "Jadwal", "Jenis Kursi", "Kursi"
            }
        ));
        jScrollPane2.setViewportView(TiketTable);

        TambahTiketButton.setText("Tambahkan ke Keranjang");
        TambahTiketButton.addActionListener(this::TambahTiketButtonActionPerformed);

        jLabel13.setText("Kursi");

        KursiComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        KursiComboBox.setSelectedIndex(-1);
        KursiComboBox.addActionListener(this::KursiComboBoxActionPerformed);

        HapusTiketButton.setText("Hapus");
        HapusTiketButton.addActionListener(this::HapusTiketButtonActionPerformed);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(FilmComboBox, 0, 190, Short.MAX_VALUE)
                            .addComponent(JenisKursiComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(JadwalTayangComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(KursiComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(TambahTiketButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(HapusTiketButton, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(8, 8, 8)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(FilmComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(JadwalTayangComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(JenisKursiComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(KursiComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TambahTiketButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(HapusTiketButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("Tiket", jPanel2);

        jLabel8.setText("Makanan");

        jLabel9.setText("Jumlah");

        jLabel10.setText("Paket");

        MakananComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        MakananComboBox.setSelectedIndex(-1);

        MakananTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Jenis", "Nama", "Jumlah", "Harga"
            }
        ));
        jScrollPane3.setViewportView(MakananTable);

        PaketMakananComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        PaketMakananComboBox.setSelectedIndex(-1);

        jLabel11.setText("Jumlah Paket");

        TambahMakananButton.setText("Tambah ke Keranjang");
        TambahMakananButton.addActionListener(this::TambahMakananButtonActionPerformed);

        HapusMakananButton.setText("Hapus");
        HapusMakananButton.addActionListener(this::HapusMakananButtonActionPerformed);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11)
                            .addComponent(jLabel9)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(PaketMakananComboBox, 0, 182, Short.MAX_VALUE)
                            .addComponent(MakananComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(JumlahMakananSpinner)
                            .addComponent(JumlahPaketSpinner)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(TambahMakananButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(HapusMakananButton)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(MakananComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(JumlahMakananSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(PaketMakananComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(JumlahPaketSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TambahMakananButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(HapusMakananButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("Makanan & Minuman", jPanel3);

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel12.setText("Total Pembayaran : ");

        TotalHargaLabel.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        TotalHargaLabel.setText("[ - ]");

        BayarButton.setText("Bayar");
        BayarButton.addActionListener(this::BayarButtonActionPerformed);

        LogoutButton.setText("Logout");
        LogoutButton.addActionListener(this::LogoutButtonActionPerformed);

        MenuUtamaButton.setText("Menu Utama");
        MenuUtamaButton.addActionListener(this::MenuUtamaButtonActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jTabbedPane3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(280, 280, 280)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(BayarButton)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TotalHargaLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(MenuUtamaButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(LogoutButton)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTabbedPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(TotalHargaLabel)
                    .addComponent(LogoutButton)
                    .addComponent(MenuUtamaButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BayarButton)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void BayarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BayarButtonActionPerformed
        // TODO add your handling code here:
        if (keranjangTiket.isEmpty() && keranjangFood.isEmpty() && keranjangPackage.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Keranjang kosong! Belum ada tiket atau makanan yang dipilih.", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Hitung ulang total untuk memastikan
        double grandTotal = 0;
        for (OrderTicketDetail t : keranjangTiket) grandTotal += t.getHarga();
        for (OrderFoodDetail f : keranjangFood) grandTotal += f.getSubtotal();
        for (OrderPackageDetail p : keranjangPackage) grandTotal += p.getSubtotal();

        // 1. Buat Nota Utama
        Order notaUtama = new Order();
        notaUtama.setIdUser(1); // NANTI DIGANTI: Ambil dari ID User yang sedang Login
        notaUtama.setTotalHarga(grandTotal);
        notaUtama.setStatusPembayaran("Lunas");
        
        // Cek apakah di transaksi ini ada pembelian tiket
        if (!keranjangTiket.isEmpty()) {
            Showtime jadwal = (Showtime) JadwalTayangComboBox.getSelectedItem();
            notaUtama.setIdJadwal(jadwal.getIdJadwal());
        } else {
            notaUtama.setIdJadwal(null); // Hanya beli makanan
        }

        // 2. Tempelkan semua keranjang ke Nota
        notaUtama.setListTiket(keranjangTiket);
        notaUtama.setListFoodDetails(keranjangFood);
        notaUtama.setListPackageDetails(keranjangPackage);

        // 3. Eksekusi Transaksi Database!
        OrderDAO orderDAO = new OrderDAO();
        if (orderDAO.insertOrderLengkap(notaUtama)) {
            JOptionPane.showMessageDialog(this, "Transaksi Berhasil Disimpan ke Database!\nTotal: Rp " + grandTotal);
            
            // Reset seluruh form (Atau bisa tutup frame lalu buka lagi)
            keranjangTiket.clear();
            keranjangFood.clear();
            keranjangPackage.clear();
            
            // Memaksa trigger load ulang kursi yang tersedia
            if (JadwalTayangComboBox.getSelectedItem() != null) {
                JadwalTayangComboBoxActionPerformed(null); 
            }
            refreshSemuaTabel();
            
        } else {
            JOptionPane.showMessageDialog(this, "Terjadi kesalahan saat memproses pembayaran.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_BayarButtonActionPerformed

    private void TambahTiketButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TambahTiketButtonActionPerformed
        // TODO add your handling code here:
        Showtime jadwalTerpilih = (Showtime) JadwalTayangComboBox.getSelectedItem();
        Seat kursiTerpilih = (Seat) KursiComboBox.getSelectedItem();
        
        if (jadwalTerpilih == null || kursiTerpilih == null) {
            JOptionPane.showMessageDialog(this, "Silakan pilih Jadwal dan Kursi terlebih dahulu!", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Tentukan Harga (Jika Couple Seat, kalikan 2 harga dasar jadwalnya)
        double hargaAkhir = jadwalTerpilih.getHargaTiket();
        if (kursiTerpilih.getJenisKursi().equalsIgnoreCase("Couple")) {
            hargaAkhir = hargaAkhir * 2;
        }

        // Buat objek tiket dan masukkan ke keranjang
        OrderTicketDetail tiketBaru = new OrderTicketDetail(0, 0, kursiTerpilih.getIdKursi(), hargaAkhir);
        tiketBaru.setNomorKursi(kursiTerpilih.getNomorKursi());
        
        keranjangTiket.add(tiketBaru);
        
        // Hapus kursi yang baru saja dipilih dari combobox agar tidak dipilih dua kali
        KursiComboBox.removeItem(kursiTerpilih); 
        
        refreshSemuaTabel();
    }//GEN-LAST:event_TambahTiketButtonActionPerformed

    private void JadwalTayangComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JadwalTayangComboBoxActionPerformed
        // TODO add your handling code here:
        Showtime jadwalTerpilih = (Showtime) JadwalTayangComboBox.getSelectedItem();
        if (jadwalTerpilih != null) {
            TicketDAO dao = new TicketDAO();
            // Ambil SEMUA kursi yang kosong di jadwal & studio tersebut, simpan di memori sementara
            kursiTersediaTemp = dao.getKursiTersedia(jadwalTerpilih.getIdJadwal(), jadwalTerpilih.getIdStudio());
            
            // Panggil filter jenis kursi
            filterKursiBerdasarkanJenis();
        }
    }//GEN-LAST:event_JadwalTayangComboBoxActionPerformed

    private void JenisKursiComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JenisKursiComboBoxActionPerformed
        // TODO add your handling code here:
        filterKursiBerdasarkanJenis();
    }//GEN-LAST:event_JenisKursiComboBoxActionPerformed

    private void TambahMakananButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TambahMakananButtonActionPerformed
        // TODO add your handling code here:
        int jmlMakanan = Integer.parseInt(JumlahMakananSpinner.getValue().toString());
        int jmlPaket = Integer.parseInt(JumlahPaketSpinner.getValue().toString());

        // Proses Jika Beli Makanan Satuan
        if (jmlMakanan > 0) {
            Food foodDipilih = (Food) MakananComboBox.getSelectedItem();
            double subtotal = foodDipilih.getHarga() * jmlMakanan;
            
            OrderFoodDetail detailFood = new OrderFoodDetail(0, 0, foodDipilih.getIdFood(), jmlMakanan, subtotal);
            detailFood.setNamaFood(foodDipilih.getNamaFood());
            keranjangFood.add(detailFood);
        }

        // Proses Jika Beli Paket
        if (jmlPaket > 0) {
            FoodPackage paketDipilih = (FoodPackage) PaketMakananComboBox.getSelectedItem();
            double subtotal = paketDipilih.getHarga() * jmlPaket;
            
            OrderPackageDetail detailPackage = new OrderPackageDetail(0, 0, paketDipilih.getIdPaket(), jmlPaket, subtotal);
            detailPackage.setNamaPaket(paketDipilih.getNamaPaket());
            keranjangPackage.add(detailPackage);
        }

        // Reset Spinner
        JumlahMakananSpinner.setValue(0);
        JumlahPaketSpinner.setValue(0);
        
        refreshSemuaTabel();
    }//GEN-LAST:event_TambahMakananButtonActionPerformed

    private void FilmComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FilmComboBoxActionPerformed
        // TODO add your handling code here:
        Film filmTerpilih = (Film) FilmComboBox.getSelectedItem();
        if (filmTerpilih != null) {
            JadwalTayangComboBox.removeAllItems();
            ShowtimeDAO dao = new ShowtimeDAO();
            
            // Catatan: Pastikan kamu sudah membuat method getJadwalByFilm(idFilm) di ShowtimeDAO
            // yang isinya SELECT * FROM showtimes WHERE id_film = ?
            for (Showtime s : dao.getJadwalByFilm(filmTerpilih.getIdFilm())) {
                JadwalTayangComboBox.addItem(s);
            }
        }
    }//GEN-LAST:event_FilmComboBoxActionPerformed

    private void KursiComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KursiComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_KursiComboBoxActionPerformed

    private void HapusTiketButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HapusTiketButtonActionPerformed
        // TODO add your handling code here:
        int barisTerpilih = TiketTable.getSelectedRow();
        
        // Validasi apakah kasir sudah mengklik salah satu baris di tabel
        if (barisTerpilih == -1) {
            JOptionPane.showMessageDialog(this, "Pilih tiket yang ingin dihapus dari tabel terlebih dahulu!", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Hapus tiket dari keranjang (List) berdasarkan urutan barisnya
        keranjangTiket.remove(barisTerpilih);
        
        // Refresh tabel dan total harga
        refreshSemuaTabel();
        
        // Panggil method ini agar kursi yang dibatalkan kembali muncul di ComboBox
        filterKursiBerdasarkanJenis();
    }//GEN-LAST:event_HapusTiketButtonActionPerformed

    private void HapusMakananButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HapusMakananButtonActionPerformed
        // TODO add your handling code here:
        int barisTerpilih = MakananTable.getSelectedRow();
        
        if (barisTerpilih == -1) {
            JOptionPane.showMessageDialog(this, "Pilih makanan atau paket yang ingin dihapus dari tabel!", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Ambil tulisan di kolom pertama (index 0) untuk melihat tipenya
        String tipeItem = MakananTable.getValueAt(barisTerpilih, 0).toString();
        
        if (tipeItem.equals("Satuan")) {
            // Karena Makanan Satuan dimasukkan pertama kali ke tabel, 
            // nomor barisnya sama persis dengan urutan index di List keranjangFood
            keranjangFood.remove(barisTerpilih);
            
        } else if (tipeItem.equals("Paket")) {
            // Karena Paket dimasukkan ke tabel SETELAH Makanan Satuan,
            // nomor urut aslinya di List keranjangPackage harus dikurangi jumlah Makanan Satuan
            int indexPaketAsli = barisTerpilih - keranjangFood.size();
            keranjangPackage.remove(indexPaketAsli);
        }

        // Refresh tabel dan total harga
        refreshSemuaTabel();
    }//GEN-LAST:event_HapusMakananButtonActionPerformed

    private void LogoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutButtonActionPerformed
        // TODO add your handling code here:
        int konfirmasi = JOptionPane.showConfirmDialog(this, "Apakah Anda yakin ingin log out?", "Konfirmasi Log Out", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
    
        if (konfirmasi == JOptionPane.YES_OPTION) {
            this.dispose();

            new LoginFrame().setVisible(true);
        }
    }//GEN-LAST:event_LogoutButtonActionPerformed

    private void MenuUtamaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuUtamaButtonActionPerformed
        // TODO add your handling code here:
        this.dispose();

        new MainMenuFrame().setVisible(true);
    }//GEN-LAST:event_MenuUtamaButtonActionPerformed

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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new OrderFrame().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BayarButton;
    private javax.swing.JComboBox FilmComboBox;
    private javax.swing.JButton HapusMakananButton;
    private javax.swing.JButton HapusTiketButton;
    private javax.swing.JComboBox JadwalTayangComboBox;
    private javax.swing.JComboBox<String> JenisKursiComboBox;
    private javax.swing.JSpinner JumlahMakananSpinner;
    private javax.swing.JSpinner JumlahPaketSpinner;
    private javax.swing.JComboBox KursiComboBox;
    private javax.swing.JButton LogoutButton;
    private javax.swing.JComboBox MakananComboBox;
    private javax.swing.JTable MakananTable;
    private javax.swing.JButton MenuUtamaButton;
    private javax.swing.JComboBox PaketMakananComboBox;
    private javax.swing.JButton TambahMakananButton;
    private javax.swing.JButton TambahTiketButton;
    private javax.swing.JTable TiketTable;
    private javax.swing.JLabel TotalHargaLabel;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTextPane jTextPane1;
    // End of variables declaration//GEN-END:variables
}
