import java.awt.*;

public class AfficheEllipse implements Affiche{
  private Ellipse e;

  public AfficheEllipse(Ellipse e){
    this.e=e;
  }
  public void dessiner(Graphics g){
    if(this.e.getPlein()){
      g.fillOval(this.e.getX(),this.e.getY(),this.e.getLongueur(),this.e.getHauteur());
    }
    else {
      g.drawOval(this.e.getX(),this.e.getY(),this.e.getLongueur(),this.e.getHauteur());
    }
  }
}
