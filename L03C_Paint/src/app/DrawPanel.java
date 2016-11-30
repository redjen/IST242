package app;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import settings.DrawBrush;
import settings.DrawShape;

/**
 * The DrawPanel class represents a canvas upon which the user can draw. The
 * controls are provided via separate panels.
 *
 */
public class DrawPanel extends JPanel implements MouseMotionListener, MouseListener {

   private Point startPoint;
   private Color drawColor;
   private DrawShape shape;
   private DrawBrush brush;
   private final int BRUSH_WIDTH = 10; 
   private final Color BORDER_COLOR = new Color(96, 96, 102);
   private final Color BACKGROUND_COLOR = Color.white;

   private ArrayList<SavedShape> savedShapes = new ArrayList<>();

   public DrawPanel() {

      super();

      startPoint = new Point();
      drawColor = Color.black;
      shape = DrawShape.SKETCH;
      brush = DrawBrush.LINE;

      addMouseMotionListener(this);
      addMouseListener(this);
      
      setAppearance();
   }

   /**
    * Sets the color used for drawing.
    *
    * @param drawColor the new color
    */
   public void setColor(Color drawColor) {
      this.drawColor = drawColor;
     
   }

   /**
    * Sets the shape to be drawn.
    *
    * The available shapes are defined in DrawShape.
    *
    * @param shape the new shape
    */
   public void setShape(DrawShape shape) {
      this.shape = shape;
   }

   /**
    * Sets the brush shape.
    *
    * @param brush the new brush shape
    */
   public void setBrush(DrawBrush brush) {
      this.brush = brush;
   }

   @Override
   public void paintComponent(Graphics g) {

      super.paintComponent(g);

      if (!savedShapes.isEmpty()) {
         for (int i = 0; i < savedShapes.size(); i++) {
            SavedShape s = savedShapes.get(i);

            drawShape(s, g);
         }
      }

   }

   /**
    * Resets the start and end points when the user releases the mouse button.
    */
   private void resetPoints() {
      startPoint = null;
   }

   /**
    * Saves a shape.
    *
    */
   private void saveShape(SavedShape s) {
      savedShapes.add(s);
   }

   /**
    * Draws the specified shape.
    * 
    * Creates and uses a new graphics pointer. 
    * 
    * @param s the shape
    */
   private void drawShape(SavedShape s) {
      Graphics gg = getGraphics();
      drawShape(s, gg);
   }
   
   /**
    * Draws the specified shape.
    * 
    * @param s the shape
    * @param gg graphics pointer
    */
   private void drawShape(SavedShape s, Graphics g) {
      
      g.setColor(s.getColor());

      int temp;
      
      int startX = s.getStartPoint().x;
      int startY = s.getStartPoint().y;
      int endX = s.getEndPoint().x;
      int endY = s.getEndPoint().y;
      

      // Correct for the direction in which the user drew shapes
      // other than lines.
      if (!s.getShape().equals(DrawShape.LINE) && !s.getShape().equals(DrawShape.SKETCH)) {
         if (startY > endY) {
            temp = startY;
            startY = endY;
            endY = temp;
         }

         if (startX > endX) {
            temp = startX;
            startX = endX;
            endX = temp;
         }
      }

      switch (s.getShape()) {

         case OVAL:
            g.drawOval(startX, startY, endX - startX, endY - startY);
            break;
         case RECTANGLE:
            g.drawRect(startX, startY, endX - startX, endY - startY);
            break;
         case LINE:
            g.drawLine(startX, startY, endX, endY);
            break;
         case SKETCH:
         default:
            
            switch (s.getBrush()) {
               case OVAL:
                  g.fillOval(endX, endY, BRUSH_WIDTH, BRUSH_WIDTH);
                  break;
               case SQUARE:
                  g.fillRect(endX, endY, BRUSH_WIDTH, BRUSH_WIDTH);
                  break;
               case LINE:
               default:
                  g.drawLine(startX, startY, endX, endY);
            }
            

      }

   }
   
   /**
    * Clears all shapes and resets the drawing panel.
    */
   public void clear() {
      savedShapes.clear();
      repaint();
   }
   
   private void setAppearance() {
      LineBorder border = new LineBorder(BORDER_COLOR, 1, true);
      setBorder(border);
      setBackground(BACKGROUND_COLOR);
      setOpaque(true);
      setVisible(true);
   }

   /*
    * Listeners
    * 
    */
   
   
   @Override
   public void mouseDragged(MouseEvent e) {

      if (shape == DrawShape.SKETCH) {
         SavedShape s = new SavedShape(startPoint, e.getPoint(), drawColor, brush, DrawShape.SKETCH);
         drawShape(s);
         
         // the position of the last point needs to be retained for
         // continuous line drawing.
         startPoint = e.getPoint();
         
         saveShape(s);
      }

   }

   @Override
   public void mousePressed(MouseEvent e) {

      resetPoints();
      startPoint = e.getPoint();
   }

   @Override
   public void mouseReleased(MouseEvent e) {

      if (shape != DrawShape.SKETCH) {
         SavedShape s = new SavedShape(startPoint, e.getPoint(), drawColor, brush, shape);
         drawShape(s);
         saveShape(s);
      }
   }

   /*
    * Unused listeners.
    */
   @Override
   public void mouseMoved(MouseEvent e) {
      // no-op
   }

   @Override
   public void mouseClicked(MouseEvent e) {
      // no-op
   }

   @Override
   public void mouseEntered(MouseEvent e) {
      // no-op
   }

   @Override
   public void mouseExited(MouseEvent e) {
      // no-op 
   }
}
