package Game1;

import java.util.Random;

public class WolfList {
  Wolf wolf;
  WolfList next;
  
  public WolfList(Wolf wolf) {
    this.wolf = wolf;
    this.next = null;
  }
  
  public WolfList(Wolf wolf, WolfList next) {
    this.wolf = wolf;
    this.next = next;
  }
  
  public WolfList(WolfList wolflist) {
    this.wolf = wolflist.wolf;
    this.next = wolflist.next;
  }
  
  public WolfList addWolf(int cent) {
    int side = (int) (4 * Math.random());
    if (side == 0) {
      return new WolfList(new Wolf.AcWolf((int)
                                          (cent * Math.random() + (cent / 2)),
                                          1), this);
    }
    else if (side == 1) {
      return new WolfList(new Wolf.AcWolf((int)
                                          (cent * Math.random() + (cent / 2)),
                                          ((2 * cent) - 1)), this);
    }
    else if (side == 2) {
      return new WolfList(new Wolf.AcWolf((int)
                                          1,
                                          (int) (cent * Math.random() + (cent / 2))), this);
    }
    else {
      return new WolfList(new Wolf.AcWolf((int)
                                          ((2 * cent) - 1), (int)
                                          (cent * Math.random() + (cent / 2))), this);
    }
    //return new WolfList(new Wolf.AcWolf(1, 1));
  }
  
//  public WolfList killWolf() {
//    return new WolfList(new Wolf.AcWolf(1, 1));
//  }
  
  public WolfList getLast() {
    if (this.next == null) {
      return this;
    }
    else {
      return this.next.getLast();
    }
  }
  
  public WolfList changeWolfs(int x, int y) {
    if (this.next == null) {
      return new WolfList(this.wolf.change(x, y));
      //return this;
    }
    else {
      //return this;
    return new WolfList(this.wolf.change(x, y), this.next.changeWolfs(x, y));
    }
  }
  
  public WolfList killer(int width, int height) {
    if (this.wolf.edgeHuh(width, height)) {
      return new WolfList(this.next).killer(width, height);
    }
    else {
      return new WolfList(this.wolf, this.next.killer(width, height));
    }
  }
  
  public WolfList mover(int cent) {
    int speed = (int) (5 * Math.random());
    if (speed > 2) {
    return new WolfList (this.wolf.move(cent), this.next.mover(cent));
    }
    else {
      return new WolfList (this.wolf, this.next.mover(cent));
    }
  }
  
}