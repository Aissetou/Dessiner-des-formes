import java.awt.*;


public class AfficheTriangle implements Affiche{
  private Triangle t;

  public AfficheTriangle(Triangle t){
    this.t=t;
  }
  public void dessiner(Graphics g){
    int[]x= new int[3];
    x[0]= this.t.getX();
    x[1]=this.t.getX2();
    x[2]=this.t.getX3();

    int[]y= new int[3];
    y[0]= this.t.getY();
    y[1]= this.t.getY2();
    y[2]= this.t.getY3();

    if(this.t.getPlein()){
      g.fillPolygon(x,y,3);
    }
    else{
      g.drawPolygon(x,y,3);
    }
    }

  }
