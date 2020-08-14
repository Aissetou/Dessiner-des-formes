public abstract class Figure{
  private int x; // coordonnee x
  private int y; // coordonnee y
  private boolean plein; // pour savoir si la figure est pleine ou pas*/

public Figure(int x, int y,boolean b){ // constructeur membre à membre
  this.x= x;
  this.y=y;
  this.plein=b;
}

 public int getX(){ // getter
   return this.x;
 }
 public int getY(){
   return this.y;
 }
public boolean getPlein(){
  return this.plein;
}

public String toString(){
  String k=new String("Coordonnée du point 1: x= "+ this.x+" y= " +
  this.y + "Figure pleine? " + this.plein);
  return k;

}
}
