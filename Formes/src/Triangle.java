public class Triangle extends Figure{
  private int x2;
  private int y2;
  private int x3;
  private int y3;

 public Triangle (int x,int y, int x2, int y2, int x3, int y3, boolean b){ // constructeur
   super(x,y, b);
   this.x2= x2;
   this.y2=y2;
   this.x3=x3;
   this.y3=y3;

 }

 public int getX2(){ // getter
   return this.x2;
 }
 public int getY2(){
   return this.y2;
 }
  public int getX3(){
    return this.x3;
  }
  public int getY3(){
    return this.y3;
  }
  public String toString(){
    String k = new String (super.toString() + "Coordonnée du 2eme point : x= "+ this.x2+" y= " +
    this.y2 + "Coordonnée du 3eme point : x= "+ this.x3+" y= " +
    this.y3);
    return k;
  }
}
