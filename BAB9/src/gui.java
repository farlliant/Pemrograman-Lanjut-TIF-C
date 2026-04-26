import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.table.*;
import java.util.*;

public class gui extends JFrame {
    JMenuBar mb = new JMenuBar();
    JMenu file = new JMenu("File");
    JMenu edit = new JMenu("Edit");
    JMenu help = new JMenu("Help");
    JMenuItem open = new JMenuItem("Open");
    JMenuItem close = new JMenuItem("Close");
    JMenuItem quit = new JMenuItem("Quit");
    JMenuItem about = new JMenuItem("About");
    JMenuItem copy = new JMenuItem("Copy");
    JMenuItem paste = new JMenuItem("Paste");
    JMenuItem cut = new JMenuItem("Cut");
    JLabel lblnama = new JLabel("Nama");
    JTextField txnama = new JTextField(30);
    JLabel lblnim = new JLabel("NIM");
    JTextField txnim = new JTextField(7);
    JLabel lblkelamin = new JLabel("Jenis Kelamin");
    JRadioButton pria = new JRadioButton("Pria");
    JRadioButton wanita = new JRadioButton("Wanita");
    ButtonGroup kelompok = new ButtonGroup();
    JLabel lblhobi = new JLabel("Hobi");
    JCheckBox baca = new JCheckBox("shoping");
    JCheckBox mancing = new JCheckBox("Futsal");
    JCheckBox jalan = new JCheckBox("musik");
    JLabel label1 = new JLabel("Nilai UTS");
    JTextField tx1 = new JTextField(20);
    JLabel label2 = new JLabel("Nilai UAS");
    JTextField tx1 = new JTextField(20);
    JButton cetak = new JButton("Cetak");
    JTextArea hasil = new JTextArea();

    gui() {
        setTitle("DATA MAHASISWA");
        setLocation(300, 100);
        setSize(300, 420);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    void KomponenVisual() {
        setJMenuBar(mb);
        mb.add(file);
        mb.add(edit);
        mb.add(help);
        file.add(open);
        file.add(close);
        edit.add(copy);
        edit.add(paste);
        edit.add(cut);
        close.setEnabled(false);
        file.add(quit);
        help.add(about);
        setVisible(true);
        getContentPane().setLayout(null);
        getContentPane().add(lblnama);
        lblnama.setBounds(10, 10, 80, 20);
        getContentPane().add(txnama);
        txnama.setBounds(105, 10, 175, 20);
        getContentPane().add(lblnim);
        lblnim.setBounds(10, 33, 80, 20);
        getContentPane().add(txnim);
        txnim.setBounds(105, 33, 70, 20);
        getContentPane().add(lblkelamin);
        lblkelamin.setBounds(10, 56, 80, 20);
        kelompok.add(pria);
        kelompok.add(wanita);
        getContentPane().add(pria);
        pria.setBounds(105, 56, 50, 20);
        getContentPane().add(wanita);
        wanita.setBounds(160, 56, 70, 20);
        getContentPane().add(lblhobi);
        lblhobi.setBounds(10, 80, 70, 20);
        getContentPane().add(baca);
        baca.setBounds(105, 80, 100, 20);
        getContentPane().add(mancing);
        mancing.setBounds(105, 103, 100, 20);
        getContentPane().add(jalan);
        jalan.setBounds(105, 126, 100, 20);
        getContentPane().add(label1);
        label1.setBounds(10, 146, 80, 20);
        getContentPane().add(tx1);
        tx1.setBounds(105, 146, 175, 20);
        getContentPane().add(label2);
        label2.setBounds(10, 169, 80, 20);
        getContentPane().add(tx2);
        tx2.setBounds(105, 169, 175, 20);
        getContentPane().add(cetak);
        cetak.setBounds(10, 191, 270, 20);
        getContentPane().add(hasil);
        hasil.setBounds(10, 214, 270, 140);
        setVisible(true);
    }

    void AksiReaksi() {
        cetak.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                hasil.append(lblnama.getText() + " : " +
                txnama.getText() + "\n");
                hasil.append(lblnim.getText()
                + " : " + txnim.getText() + "\n");
                if (pria.isSelected() == true) {
                    hasil.append(lblkelamin.getText() + " : " +
                    pria.getText() + "\n");
                } else {
                    hasil.append(lblkelamin.getText() + ": " +
                    wanita.getText() + "\n");
                }
                if (baca.isSelected() == true) {
                    hasil.append(lblhobi.getText() + " : " +
                    baca.getText() + "\n");
                }
                if (mancing.isSelected() == true) {
                    hasil.append(lblhobi.getText() + " : " +
                    mancing.getText() + "\n");
                }
                if (jalan.isSelected() == true) {
                    hasil.append(lblhobi.getText() + " : " +
                    jalan.getText() + "\n");
                }
                hasil.append(label1.getText() + " : " +
                tx1.getText() + "\n");
                hasil.append(label2.getText() + " : " +
                tx2.getText() + "\n");
                double a = 0.0, b = 0.0, c = 0.0;
                try {
                    a = Double.parseDouble(tx1.getText());
                    b = Double.parseDouble(tx2.getText());
                } catch (NumberFormatException nfe) {
                    nfe.printStackTrace();
                }
                JButton btn = (JButton) event.getSource();
                if (btn == cetak) {
                    c = ((a + b) / 2);
                }
                hasil.append(new String().valueOf("NIlai Akhir " + c));
            }
        });
    }

    public static void main(String args[]) {
        graphic e5 = new graphic();
        e5.KomponenVisual();
        e5.AksiReaksi();
    }
}