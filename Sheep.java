package Game1;

import java.util.Random;

public interface Sheep {
  
  Sheep makeSheep(int x, int y);
    Sheep change(int x, int y);
    Sheep move(String direct);
    Boolean edgeHuh(int wdith, int height);
    Boolean staffHuh(int x, int y);
  
  class AcSheep implements Sheep {
    int x;
    int y;
    //int sp;
    
    public AcSheep(int x, int y) {
      this.x = x;
      this.y = y;
    }
       
    public Sheep makeSheep(int x, int y) {
      return new AcSheep(x, y);
    }
    
    public Sheep change(int x, int y) {
      if (this.staffHuh(x, y)) {
        return new ScSheep(x, y);
      }
      else {
        return this;
      }
    }
    
    public Sheep move(String direct) {
      if (direct == "right") {
      return new AcSheep(this.x++, this.y);
      }
      else if (direct == "left") {
        return new AcSheep(this.x--, this.y);
      }
      
      else if (direct == "up") {
        return new AcSheep(this.x, this.y++);
      }
      else if (direct == "down") {
        return new AcSheep(this.x, this.y--);
      }
      else {
        return new AcSheep(this.x, this.y);
      }
    }
    
    public Boolean edgeHuh(int width, int height) {
      return (this.x <= 0 || this.y <= 0 || this.x >= x || this.y >= y);
    }
    
    public Boolean staffHuh(int x, int y) {
      return true;
    }
  }
  
  class ScSheep implements Sheep {
    int x;
    int y;
    //int sp;
    
    public ScSheep(int x, int y) {
      this.x = x;
      this.y = y;
    }
    
    public Sheep makeSheep(int x, int y) {
      return new ScSheep(x, y);
    }
    
    public Sheep change(int x, int y) {
      return new ScSheep(this.x, this.y);
    }
    
    public Sheep move(String direct) {
      if (direct == "right") {
      return new ScSheep(this.x++, this.y);
      }
      else if (direct == "left") {
        return new ScSheep(this.x--, this.y);
      }
      
      else if (direct == "up") {
        return new ScSheep(this.x, this.y++);
      }
      else if (direct == "down") {
        return new ScSheep(this.x, this.y--);
      }
      else {
        return new ScSheep(this.x, this.y);
      }
    }
    
    public Boolean edgeHuh(int width, int height) {
      return (this.x <= 0 || this.y <= 0 || this.x >= width || this.y >= height);
    }
    
    public Boolean staffHuh(int x, int y) {
      return true;
    }
  }
    
  }
  


