package pl.wipb.ztp.ps2;

import javax.swing.*;
import java.awt.event.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Program3 {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
            Logger.getLogger(Program3.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        final JFrame frame = new JFrame("Baza danych");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        final Database database = new Database();
        
        JTable table = new JTable(database);
        JMenuBar bar = new JMenuBar();
        
        JButton row = new JButton("Dodaj Wiersz");
        JButton col = new JButton("Dodaj Kolumnę");
        
        bar.add(row);
        bar.add(col);
        
        frame.add(new JScrollPane(table));
        frame.setJMenuBar(bar);
        
        frame.pack();
        frame.setVisible(true);
        
        row.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ev)
            {
                database.addRow();
            }
        });
        col.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ev)
            {
                Object option = JOptionPane.showInputDialog(
                    frame,
                    "Podaj typ kolumny",
                    "Dodaj Kolumnę",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    new TableHeader[] { // Tworzenie obiektów konkretnego typu
                        new TableHeaderInt(),
                        new TableHeaderDouble(),
                        new TableHeaderChar(),
                        new TableHeaderBoolean(),
                    }, null);
                if(option == null)
                    return;
                database.addCol((TableHeader)option);
            }
        });
    }
}