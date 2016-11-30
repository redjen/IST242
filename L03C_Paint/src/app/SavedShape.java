package app;

import java.awt.Color;
import java.awt.Point;
import settings.DrawBrush;
import settings.DrawShape;

/**
 * The SavedShape class represents a shape that has been drawn.
 * 
 * The purpose of this class is to save drawings that should be redrawn when
 * the drawing panel is resized. Since the purpose is to save the state of the
 * drawing exactly as it was when created its attributes must be immutable.
 * 
 * The shape DrawShape.CONTINUOUS should not be used here as its segments are 
 * drawn as lines. Use DrawShape.LINE instead.
 * 
 */
public class SavedShape {

   private final Point startPoint;
   private final Point endPoint;
   private final Color color;
   private final DrawBrush brush;
   private final DrawShape shape;

   /**
    * Instantiates a SavedShape that is to be drawn/redrawn.
    * 
    * @param startPoint the start point
    * @param endPoint the end point
    * @param color the brush color
    * @param brush the brush shape
    * @param shape the shape to be drawn
    */
   public SavedShape(Point startPoint, Point endPoint, Color color, DrawBrush brush, DrawShape shape) {
      this.startPoint = startPoint;
      this.endPoint = endPoint;
      this.color = color;
      this.brush = brush;
      this.shape = shape;
   }

   /**
    * Returns the point at which the the shape began.
    * 
    * @return the start point
    */
   public Point getStartPoint() {
      return startPoint;
   }

   /**
    * Returns the point at which the shape ended.
    * 
    * @return the end point
    */
   public Point getEndPoint() {
      return endPoint;
   }

   /** 
    * Returns the shape's color.
    * @return the shape's color
    */
   public Color getColor() {
      return color;
   }

   /**
    * Returns the brush type.
    * 
    * See DrawBrush for valid brushes.
    * 
    * @return the brush type.
    */
   public DrawBrush getBrush() {
      return brush;
   }

   /**
    * Returns the shape type.
    * 
    * See DrawShape for valid shapes.
    * 
    * @return the shape type.
    */
   public DrawShape getShape() {
      return shape;
   }
   
   
   
}
