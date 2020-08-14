public class Droite extends Figure{
  private int x2;
  private int y2;

public Droite (int x,int y, int x2, int y2, boolean b){ // constructeur
  super(x,y,b);
  this.x2= x2;
  this.y2=y2;
}
public int getX2(){ // getter
  return this.x2;
}
public int getY2(){
  return this.y2;
}
public String toString(){
  String k = new String (super.toString() + "Coordonnée du 2eme point : x= "+ this.x2+" y= " +
  this.y2);
  return k;
}
}
