import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.lang.*;

public class Vue extends JFrame{
  private ArrayList<Figure> modele;
  private   JPanelFigure ListFig;
  public static final int CERCLE = 0;
  public static final int RECTANGLE = 1;
  public static final int ELLIPSE = 2;
  public static final int DROITE = 7;
  public static final int TRIANGLE = 8;
  public static final int RESET =9;
  private static int x;
  private static int y;
  private static int x2;
  private static int y2;
  private static int mode = 1;

public Vue (String titre,int w, int h){
super(titre);
this.centreEcran(w,h);
this.initialise();
	this.setVisible(true);
 }
 public void centreEcran(int w, int h) { // permet d'afficher la fenêtre au milieu de l ecran
   Toolkit aTK = Toolkit.getDefaultToolkit();
   Dimension dim = aTK.getScreenSize();
   this.setBounds((dim.width / 2) - (w / 2), (dim.height / 2 ) - (h / 2), w, h);
 }
 public void initialise(){ // initialise la fenêtre
   this.setLayout(new BorderLayout());
   this.add(this.getPanelNorth(),BorderLayout.NORTH);
  this.add(this.getPanelCenter(), BorderLayout.CENTER);

  }
  private JPanel getPanelNorth() { // le panel nord
    JPanel jPan = new JPanel();
// creation des bouton pour les diff figure
    JButton but1 = new JButton("Cercle");
    but1.addActionListener(new GestBoutons(CERCLE));
    jPan.add(but1);
    JButton but2 = new JButton("Rectangle");
    but2.addActionListener(new GestBoutons(RECTANGLE));
    jPan.add(but2);
    JButton but3 = new JButton("Ellipse");
    but3.addActionListener(new GestBoutons(ELLIPSE));
    jPan.add(but3);
    JButton but4 = new JButton("Droite");
    but4.addActionListener(new GestBoutons(DROITE));
    jPan.add(but4);
    JButton but5 = new JButton("Triangle");
    but5.addActionListener(new GestBoutons(TRIANGLE));
    jPan.add(but5);
    JButton but6 = new JButton("Reset"); // creation d'un bouton permettant de tout recommencer
    but6.addActionListener(new GestBoutons(RESET));
    jPan.add(but6);
    return jPan;
  }
  private JTabbedPane getPanelCenter() {
    JTabbedPane jTab = new JTabbedPane();
    this.addMouseListener(new getMouse());
    this.ListFig= new JPanelFigure();
    JPanel text = new JPanel();
    text.add(new JTextArea(100, 100));
    jTab.add(this.ListFig, "Dessin");
    jTab.add(text, "Texte");
    return jTab;
  }

  class getMouse extends MouseAdapter {

  /*public void mousePressed (MouseEvent e ) {
    Vue.x = e.getX();
    Vue.y= e.getY();
    //System.out.println(e.getX());
    ListFig.ListFigure.add(new AfficheRectangle(new Rectangle( Vue.x,Vue.y,120,80,false)));
    Vue.this.repaint();

    }*/

    public void mouseReleased (MouseEvent e) {

      Vue.x2 = e.getX();
      Vue.y2= e.getY();
      //System.out.println(e.getX());
      ListFig.ListFigure.add(new AfficheRectangle(new Rectangle( Vue.x,Vue.y,Vue.x2-Vue.x,Vue.y2-Vue.y,false)));
      Vue.this.repaint();
      //System.out.println("x = "+Vue.x+" y = "+Vue.y+" x2 = "+Vue.x2+" y2 = "+Vue.y2);

        switch (Vue.mode) {
         case CERCLE : {
           int hauteur = Vue.y2-Vue.y;
           int longueur =Vue.x2-Vue.x;

         if (hauteur < 0){
           Vue.y+=hauteur;
           hauteur*=-1;
         }

         if (longueur < 0){
           Vue.x+=longueur;
           longueur*=-1;
         }
           String[] options = {"oui", "non"};

         int a = JOptionPane.showOptionDialog(null, "figure pleine ?",
                 "la boite du dialogue",
                 JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
                 boolean bool;
        if ( a ==0){
          bool = true;
        }
        else {
          bool=false;
        }
          /* Cercle c = new Cercle();
           vue.modele.add(c);*/
           ListFig.ListFigure.add(new AfficheCercle(new Cercle( Vue.x,Vue.y,(int)(Math.sqrt(hauteur*hauteur+longueur*longueur)),bool)));
           Vue.this.repaint();

         }
           break;
         case RECTANGLE :{

            int hauteur = Vue.y2-Vue.y;
            int longueur =Vue.x2-Vue.x;

          if (hauteur < 0){
            Vue.y+=hauteur;
            hauteur*=-1;
          }

          if (longueur < 0){
            Vue.x+=longueur;
            longueur*=-1;
          }
           String[] options = {"oui", "non"};

         int a = JOptionPane.showOptionDialog(null, "figure pleine ?",
                 "la boite du dialogue",
                 JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
                 boolean bool;
        if ( a ==0){
          bool = true;
        }
        else {
          bool=false;
        }

        ListFig.ListFigure.add(new AfficheRectangle(new Rectangle( Vue.x,Vue.y,longueur,hauteur,bool)));
        Vue.this.repaint();

         }
           break;
         case ELLIPSE: {
           int hauteur = Vue.y2-Vue.y;
           int longueur =Vue.x2-Vue.x;

           if (hauteur < 0){
           Vue.y+=hauteur;
           hauteur*=-1;
           }

           if (longueur < 0){
           Vue.x+=longueur;
           longueur*=-1;
           }

           String[] options = {"oui", "non"};

         int a = JOptionPane.showOptionDialog(null, "figure pleine ?",
                 "la boite du dialogue",
                 JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
                 boolean bool;
        if ( a ==0){
          bool = true;
        }
        else {
          bool=false;
        }
        ListFig.ListFigure.add(new AfficheEllipse(new Ellipse(Vue.x,Vue.y,hauteur,longueur,bool)));
        Vue.this.repaint();
      }
      break;
        case TRIANGLE:{

          String[] options = {"oui", "non"};

        int a = JOptionPane.showOptionDialog(null, "figure pleine ?",
                "la boite du dialogue",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
                boolean bool;
       if ( a ==0){
         bool = true;
       }
       else {
         bool=false;
       }
          break;
        }
        case DROITE:{
          boolean bool=true;
          ListFig.ListFigure.add(new AfficheDroite(new Droite(Vue.x,Vue.y,Vue.x2,Vue.y2,bool)));
          Vue.this.repaint();

          break;
        }
    }

  }
}

  class GestBoutons implements ActionListener {

    private int val;

    public GestBoutons (int i) {
      this.val = i;
    }
    public void actionPerformed (ActionEvent e) {
      if (val == 9) {
        ListFig.ListFigure = new ArrayList<Affiche>();
        Vue.this.repaint();
      }
      else {
          Vue.mode = val;
      }


       switch (val) {
       case CERCLE : {
         Vue.mode =val;
         String[] options = {"oui", "non"};

       int a = JOptionPane.showOptionDialog(null, "figure pleine ?",
               "la boite du dialogue",
               JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
               boolean bool;
      if ( a ==0){
        bool = true;
      }
      else {
        bool=false;
      }

         ListFig.ListFigure.add(new AfficheCercle(new Cercle( 4,5,20,bool)));
         Vue.this.repaint();

       }
       break;
       
       case RECTANGLE :{
         Vue.mode = val;
         String[] options = {"oui", "non"};

       int a = JOptionPane.showOptionDialog(null, "figure pleine ?",
               "la boite du dialogue",
               JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
               boolean bool;
      if ( a ==0){
        bool = true;
      }
      else {
        bool=false;
      }
         ListFig.ListFigure.add(new AfficheRectangle(new Rectangle( 30,20,120,80,bool)));
         Vue.this.repaint();

       }
       break;
       
       case ELLIPSE: {
         Vue.mode = val;
         String[] options = {"oui", "non"};

       int a = JOptionPane.showOptionDialog(null, "figure pleine ?",
               "la boite du dialogue",
               JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
               boolean bool;
      if ( a == 0){
        bool = true;
      }
      else {
        bool=false;
      }
      ListFig.ListFigure.add(new AfficheEllipse(new Ellipse( 240,150,80,50,bool)));
      Vue.this.repaint();
    }
    break;
    
    case TRIANGLE:{
        Vue.mode = val;
        String[] options = {"oui", "non"};

      int a = JOptionPane.showOptionDialog(null, "figure pleine ?",
              "la boite du dialogue",
              JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
              boolean bool;
     if ( a ==0){
       bool = true;
     }
     else {
       bool=false;
     }
     ListFig.ListFigure.add(new AfficheTriangle(new Triangle(30,20,120,80,70,90,bool)));
     Vue.this.repaint();
        break;
      }
     case DROITE:{
        break;
      }
     
      case RESET : {
        ListFig.ListFigure = new ArrayList<Affiche>();
        Vue.this.repaint();
      }
}
}
}
class JPanelFigure extends JPanel {
  private ArrayList<Affiche> ListFigure;

  public JPanelFigure(){
    this.ListFigure= new ArrayList();
this.addMouseListener(new getMouse());
  }


  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    for(int i=0; i <this.ListFigure.size();i++){
      this.ListFigure.get(i).dessiner(g);
    }
  }



}
public static void main(String[] args) {
  new Vue("Dessiner des formes", 800, 600);
}


}
