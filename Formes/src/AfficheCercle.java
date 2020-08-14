import java.awt.*;

public class AfficheCercle implements Affiche{
  private Cercle c;

public AfficheCercle(Cercle c){
  this.c=c;
}

public void dessiner(Graphics g){
  if (this.c.getPlein()){ // si plein alors
    g.fillOval(this.c.getX(),this.c.getY(),this.c.getRayon(),this.c.getRayon()); // permet de dessiner le cercle plein
  }
  else { // sinon
    g.drawOval(this.c.getX(),this.c.getY(),this.c.getRayon(),this.c.getRayon()); // juste le contour du cercle
  }
  }
}
