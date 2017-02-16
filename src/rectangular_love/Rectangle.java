package rectangular_love;

/**
 * Created by swu on 16/02/2017.
 */
public class Rectangle {
  // coordinates of bottom left corner
  Integer leftX;
  Integer bottomY;

  // dimensions
  Integer width;
  Integer height;

  public Rectangle(Integer leftX, Integer bottomY, Integer width, Integer height) {
    this.leftX = leftX;
    this.bottomY = bottomY;
    this.width  = width;
    this.height = height;
  }

  public Rectangle() {}

  /**
   *
   * @param p1
   * @param p2
   * @param l1
   * @param l2
   * @return
   */
  private static Integer[] protential_point_length(Integer p1, Integer p2, Integer l1, Integer l2) {
    Integer p, l;
    Integer diff = p2 - p1;
    if (diff < 0) {
      p = p2;
      l = Math.min((l2 - diff), l1);
    } else if (diff > 0) {
      p = p1;
      l = Math.min((l1 - diff), l2);
    } else {
      p = p1;
      l = Math.min(l1, l2);
    }
    Integer[] result = new Integer[2];
    result[0] = p;
    result[1] = l;
    return result;
  }

  public Rectangle rectangle_lover(Rectangle r) {
    Integer[] xw = Rectangle.protential_point_length(this.leftX, r.leftX, this.width, r.width);
    Integer[] yh = Rectangle.protential_point_length(this.bottomY, r.bottomY, this.height, r.height);
    if (xw[1] <= 0 || yh[1] <= 0) return new Rectangle();
    return new Rectangle(xw[0], yh[0], xw[1], yh[1]);
  }

  public 

  public String toString() {
    return String.format("(%d, %d, %d, %d)", leftX, bottomY, width, height);
  }

  public static void main(String[] args) {
    Rectangle r1 = new Rectangle(1, 1, 3, 4);
    System.out.println(r1.rectangle_lover(new Rectangle(-1, -2, 2, 3)));
  }
}




