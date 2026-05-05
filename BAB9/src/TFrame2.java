import java.awt.*;
import java.awt.event.*;

public class TFrame2 extends Frame {
    Label lbJudul, lbTugas, lbKuis, lbUTS, lbUAS, lbRata, lbHasil;
    TextField txtTugas, txtKuis, txtUTS, txtUAS, txtRata, txtHasil;
    CheckboxGroup cbg;
    Checkbox cbNilaiAngka, cbNilaiHuruf;

    public TFrame2() {
        setLayout(null);

        lbJudul = new Label("Hitung Nilai Akhir");
        lbJudul.setFont(new Font("Arial", Font.BOLD, 14));
        add(lbJudul);
        lbJudul.setBounds(110, 30, 170, 20);

        lbTugas = new Label("Tugas : ");
        add(lbTugas);
        lbTugas.setBounds(100, 60, 80, 20);

        lbKuis = new Label("Kuis : ");
        add(lbKuis);
        lbKuis.setBounds(100, 90, 80, 20);

        lbUTS = new Label("UTS : ");
        add(lbUTS);
        lbUTS.setBounds(100, 120, 80, 20);

        lbUAS = new Label("UAS : ");
        add(lbUAS);
        lbUAS.setBounds(100, 150, 80, 20);

        lbRata = new Label("Rata-rata : ");
        add(lbRata);
        lbRata.setBounds(100, 180, 80, 20);

        lbHasil = new Label("Hasil : ");
        add(lbHasil);
        lbHasil.setBounds(100, 210, 80, 20);

        txtTugas = new TextField("0");
        add(txtTugas);
        txtTugas.setBounds(200, 60, 80, 20);

        txtKuis = new TextField("0");
        add(txtKuis);
        txtKuis.setBounds(200, 90, 80, 20);

        txtUTS = new TextField("0");
        add(txtUTS);
        txtUTS.setBounds(200, 120, 80, 20);

        txtUAS = new TextField("0");
        add(txtUAS);
        txtUAS.setBounds(200, 150, 80, 20);

        txtRata = new TextField("0");
        add(txtRata);
        txtRata.setBounds(200, 180, 80, 20);

        txtHasil = new TextField("0");
        add(txtHasil);
        txtHasil.setBounds(200, 210, 80, 20);

        cbg = new CheckboxGroup();

        cbNilaiHuruf = new Checkbox("Nilai Huruf", cbg, false);
        add(cbNilaiHuruf);
        cbNilaiHuruf.setBounds(100, 250, 90, 20);

        cbNilaiAngka = new Checkbox("Nilai Angka", cbg, false);
        add(cbNilaiAngka);
        cbNilaiAngka.setBounds(200, 250, 90, 20);

        cbNilaiHuruf.addItemListener(new mainAction());
        cbNilaiAngka.addItemListener(new mainAction());

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
    }

    class mainAction implements ItemListener {
        public void itemStateChanged(ItemEvent e) {
            int tugas = Integer.parseInt(txtTugas.getText().trim());
            int kuis = Integer.parseInt(txtKuis.getText().trim());
            int UTS = Integer.parseInt(txtUTS.getText().trim());
            int UAS = Integer.parseInt(txtUAS.getText().trim());

            double rata = (UTS + UAS) / 2.0;
            double nilaiAkhir = (tugas + kuis + UTS + UAS) / 4.0;

            txtRata.setText(String.valueOf(rata));

            Object source = e.getItemSelectable();

            if (source == cbNilaiAngka) {
                txtHasil.setText(String.valueOf(nilaiAkhir));
            } else if (source == cbNilaiHuruf) {
                txtHasil.setText(konversiHuruf(nilaiAkhir));
            }
        }
    }

    String konversiHuruf(double nilai) {
        if (nilai >= 80 && nilai <= 100) {
            return "A";
        } else if (nilai >= 75) {
            return "B+";
        } else if (nilai >= 65) {
            return "B";
        } else if (nilai >= 60) {
            return "C+";
        } else if (nilai >= 50) {
            return "C";
        } else if (nilai >= 45) {
            return "D+";
        } else if (nilai >= 35) {
            return "D";
        } else {
            return "E";
        }
    }
}