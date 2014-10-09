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
  
  public WolfList addWolf() {
    int side = (int) (4 * Math.random());
    return new WolfList(new Wolf.AcWolf(1, 1));
  }
  
  public WolfList killWolf() {
    return new WolfList(new Wolf.AcWolf(1, 1));
  }
  
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
    return new WolfList(new Wolf.AcWolf(1, 1));
  }
  
  public WolfList mover(int cent) {
    return new WolfList(new Wolf.AcWolf(1, 1));
  }
  
}