import java.awt.*;

public class AfficheDroite implements Affiche{
  private Droite d;

  public AfficheDroite(Droite d){
    this.d=d;
  }
  public void dessiner(Graphics g){ // permet de tracer le trait 
    g.drawLine(this.d.getX(),this.d.getY(),this.d.getX2(),this.d.getY2());

  }

}
