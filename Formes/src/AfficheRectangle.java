import java.awt.*;


public class AfficheRectangle implements Affiche{
  private Rectangle r;

  public AfficheRectangle(Rectangle r){
    this.r=r;
  }
  public void dessiner(Graphics g){
    if (r.getPlein()){
      g.fillRect(this.r.getX(),this.r.getY(),this.r.getLongueur(),this.r.getLargeur());
    }
    else{
      g.drawRect(this.r.getX(),this.r.getY(),this.r.getLongueur(),this.r.getLargeur());
    }
    }
  }
