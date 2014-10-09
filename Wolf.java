package Game1;

import java.util.Random;

public interface Wolf {
  //int x;
  //int y;
   
    public Wolf makeWolf(int x, int y);
    public Wolf change(int x, int y);
    public Wolf move(int cent);
    public Boolean edgeHuh(int wdith, int height);
    public Boolean staffHuh(int x, int y);
  
  class AcWolf implements Wolf {
    int x;
    int y;
    //int sp;
    
    public AcWolf(int x, int y) {
      this.x = x;
      this.y = y;
    }
       
    public Wolf makeWolf(int x, int y) {
      return new AcWolf(x, y);
    }
    
    public Wolf change(int staffX, int staffY) {
      if (this.staffHuh(staffX, staffY)) {
      return new ScWolf(this.x, this.y);
      }
      else {
        return this;
      }
    }
    
    public Wolf move(int cent) {
   int vertOrHor = (int) (10 * Math.random());
      if (vertOrHor < 5) {
      
      if (this.x > cent) {
      return new ScWolf(this.x++, this.y);
      }
      else  {
        return new ScWolf(this.x--, this.y);
      }}
      
      else {
       if (this.y > cent) {
        return new ScWolf(this.x, this.y++);
      }
      else {
        return new ScWolf(this.x, this.y--);
      }
      
      }
    }
    
    public Boolean edgeHuh(int width, int height) {
      return (this.x <= 0 || this.y <= 0 || this.x >= x || this.y >= y);
    }
    
    public Boolean staffHuh(int staffX, int staffY) {
           //int rangex1 = staffX - 5;
      //int rangex2 = staffX + 5;
      //int rangey1 = staffY - 5;
      //int rangey2 = staffY + 5;
      
     int range = 5;
        
      if (staffX - range < this.x || staffX + range > this.x ||
          staffY - range < this.y || staffY + range > this.y) {
      return true;
    }
      else {
        return false;
      }
    }
  }

  class ScWolf implements Wolf {
    int x;
    int y;
    //int sp;
    
    public ScWolf(int x, int y) {
      this.x = x;
      this.y = y;
    }
    
    public Wolf makeWolf(int x, int y) {
      return new ScWolf(x, y);
    }
    
    public Wolf change(int staffX, int staffY) {
      return new ScWolf(this.x, this.y);
    }
    
    public Wolf move(int cent) {
      int vertOrHor = (int) (10 * Math.random());
      if (vertOrHor < 5) {
      
      if (this.x > cent) {
      return new ScWolf(this.x++, this.y);
      }
      else  {
        return new ScWolf(this.x--, this.y);
      }}
      
      else {
       if (this.y > cent) {
        return new ScWolf(this.x, this.y++);
      }
      else {
        return new ScWolf(this.x, this.y--);
      }
      
      }
    }
    
    public Boolean edgeHuh(int width, int height) {
      return (this.x <= 0 || this.y <= 0 || this.x >= width || this.y >= height);
    }
    
    public Boolean staffHuh(int staffX, int staffY) {
 return false;
  }
    
  }
}
  

