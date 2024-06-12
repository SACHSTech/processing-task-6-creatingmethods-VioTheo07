import processing.core.PApplet;

/**
 * Sketch class that extends PApplet to draw multiple objects (stickmen) at various locations in different colors and draws hearts.
 * @author Vio
 */
public class Sketch extends PApplet {

  /**
   * Initializes screen size.
   * This method is called once when the program starts.
   */
  public void settings() {
    size(1125, 525);
  }

  /**
   * Called once at the beginning of execution.
   * Sets the background color of the canvas.
   */
  public void setup() {
    background(144, 238, 144);
  }

  /**
   * Draws a row of stickmen at the given y-coordinate.
   * 
   * @param y the y-coordinate for the row of stickmen
   */
  private void rowOfFigure(int y) {
    for (int x = 0; x <= 1050; x += 75) {
      drawMan(x, y);
    }
  }

  /**
   * Draws a stickman at the given (x, y) coordinates.
   * 
   * @param x the x-coordinate of the stickman
   * @param y the y-coordinate of the stickman
   */
  private void drawMan(int x, int y) {
    int baseX = x + 37; // Centered within the 75-pixel block
    int baseY = y;

    fill(200, 250, 170);
    line(baseX, 45 + baseY, baseX, 60 + baseY); // Body
    ellipse(baseX, 35 + baseY, 17, 17); // Head
    line(baseX, 60 + baseY, baseX + 15, 70 + baseY); // Right leg
    line(baseX, 60 + baseY, baseX - 15, 70 + baseY); // Left leg
    line(baseX, 55 + baseY, baseX + 15, 45 + baseY); // Right arm
    line(baseX, 55 + baseY, baseX - 15, 45 + baseY); // Left arm
  }

  /**
   * Draws a heart at the given (x, y) coordinates.
   * 
   * @param x the x-coordinate of the heart
   * @param y the y-coordinate of the heart
   */
  private void drawHeart(int x, int y) {
    stroke(0);
    fill(255, 0, 0);
    
    beginShape();
    vertex(x, y + 20);
    bezierVertex(x - 15, y + 10, x - 15, y - 10, x, y);
    bezierVertex(x + 15, y - 10, x + 15, y + 10, x, y + 20);
    endShape(CLOSE);
  }

  /**
   * Called repeatedly to draw on the screen.
   * Draws stickmen in rows with different colors and hearts for every other stickman in alternating rows.
   */
  public void draw() {
    // Draw stickmen in rows with different colors
    stroke(230, 8, 7); // Red
    rowOfFigure(0);
    stroke(245, 140, 17); // Orange
    rowOfFigure(75);
    stroke(234, 227, 5); // Yellow
    rowOfFigure(150);
    stroke(64, 178, 50); // Green
    rowOfFigure(225);
    stroke(0, 100, 165); // Blue
    rowOfFigure(300);
    stroke(0, 20, 220); // Indigo
    rowOfFigure(375);
    stroke(140, 0, 220); // Violet
    rowOfFigure(450);

    // Draw hearts for every other stickman in alternating rows
    for (int row = 0; row < 7; row++) {
      int y = row * 75 + 25; // Adjust y position of hearts to align with stickman rows
      for (int col = 75; col <= 975; col += 150) {
        int x = col + ((row % 2 == 0) ? 75 : 0); // Offset every other row
        drawHeart(x, y);
      }
    }
  }
}
