package Page;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.InputStream;

import java.net.URL;
import java.net.URLConnection;

public class Page implements ActionListener {
    JFrame fenetre;
    JLabel Adresse;
    JTextField adr;
    JButton Envoyer;
    JButton Effacer;
    JEditorPane monpanel;
    public Page(){
        fenetre=new JFrame("Page");
        Adresse=new JLabel("Adresse");
        Adresse.setBounds(20,10,300,30);
        Adresse.setBorder(new LineBorder(Color.black));
        adr=new JTextField();
        adr.setBounds(80,10,300,30);
        adr.setBorder(new LineBorder(Color.black));
        adr.setFont(new Font(Font.MONOSPACED,Font.ITALIC,15));
        Envoyer=new JButton("Envoyer");
        Envoyer.setBounds(390,10,100,30);
        Envoyer.setBorder(new LineBorder(Color.BLUE));
        Envoyer.addActionListener(this);
        Effacer=new JButton("Effacer");
        Effacer.setBounds(500,10,100,30);
        Effacer.addActionListener(this);
        monpanel=new JEditorPane();
        monpanel.setContentType("text/html");
        monpanel.setText("Contenu de la page");
        monpanel.setBounds(20,70,600,500);
        monpanel.setBorder(new LineBorder(Color.black));
        fenetre.add(Adresse);
        fenetre.add(adr);
        fenetre.add(Envoyer);
        fenetre.add(Effacer);
        fenetre.add(monpanel);
        fenetre.setLayout(null);
        fenetre.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        fenetre.setSize(700,700);
        fenetre.setVisible(true);

    }

    public static void main(String[] args) {
        new Page();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src=e.getSource();
        if(src.equals(Envoyer)){
           String hostname= adr.getText();

            try{
                URL url=new URL(hostname);
                URLConnection con=url.openConnection();
                InputStream stream=con.getInputStream();
                int ent=0;
                String txt="";
                while((ent=stream.read())!=-1){

                    txt+=(char)ent;
                }

                monpanel.setText(txt);


            } catch(Exception exception){
                JOptionPane.showConfirmDialog(null,exception.getMessage(),"Erreur",JOptionPane.YES_OPTION,JOptionPane.ERROR_MESSAGE);
            }
        }
        else if(src.equals(Effacer)){
            adr.setText("http://");
            monpanel.setText("Aucune page");
        }

    }
}
