/* Name: Ethan Chen
 * PennKey: etc
 * Recitation: 217
 * 
 * Execution: java StampSketch
 * 
 * Generates a different random image based on user interaction
 * 
 */

public class StampSketch {
    public static void main(String[] args) {
        
        // is this the first time through the animation loop?
        boolean firstTime = true;
        
        while (true) {
            
            if (firstTime || PennDraw.hasNextKeyTyped()) {
                
                //Clear Screen
                PennDraw.clear();
            
                //Randomized Background Color Set
                int r1 = (int) (Math.random() * 254);
                int g1 = (int) (Math.random() * 254);
                int b1 = (int) (Math.random() * 254);
            
                //Draw Backgrounnd
                PennDraw.setPenColor(r1, g1, b1);
                PennDraw.filledRectangle(0.5, 406.0 / 512, 0.5, 106.0 / 512);
                PennDraw.setPenColor(g1, b1, r1);
                PennDraw.filledRectangle(0.5, 150.0 / 512, 0.5, 150.0 / 512);
            
                //Horizon Line
                PennDraw.setPenColor();
                PennDraw.line(0, 300.0 / 512, 1, 300.0 / 512);
            
                //Deterimine if Stars should appear
                if (PennDraw.hasNextKeyTyped()) {
                    
                    int keyTyped = PennDraw.nextKeyTyped();
                    double randomI = Math.random() * 10 + 5;
                    double randomY = Math.random() * 1.0;
                    double randomX = Math.random() * 1.0;
                    
                    if (keyTyped >= 110) {
                        
                        if (randomY > 300.0 / 512) {
                            
                            for (double i = randomI; i > 0; i--) {
                                
                                //Draw Stars
                                randomX = Math.random() * 1.0;
                                randomY = Math.random() * 200.0 / 512 + 
                                    350.0 / 512;
                                PennDraw.setPenColor(PennDraw.YELLOW);
                                PennDraw.square(randomX, randomY, 0.01, 0);
                                PennDraw.square(randomX, randomY, 0.01, 45);
                            }
                        }
                    }
                    //Determine if Pool should appear
                    if (keyTyped <= 120) {
                        
                        double randomY2 = Math.random() * 1.0;
                        PennDraw.setPenColor(PennDraw.BLUE);
                        
                        if (randomY2 < 300.0 / 512) {
                            
                            for (int i = 1; i > 0; i--) {
                                
                                //Draw Pool
                                randomX = Math.random() * 1.0;
                                randomY = Math.random() * 200 / 512;
                                PennDraw.filledEllipse(randomX, randomY, 
                                                       randomX / 2, 
                                                       randomY2 / 3);
                            }
                        }
                    }
                }
                //First Face Variables
                double squareX = 75.0 / 512;
                double squareY = 312.0 / 512;
                int eyeAngle = 360;
                double eyeRadi = 0.01;
                
                //Set Eye Coordinates
                double squareEyeX1 = squareX - 30.0 / 512;
                double squareEyeX2 = squareX + 30.0 / 512;
                double squareEyeY = squareY + 20.0 / 512;
            
                //Set EyeColors
                int eyeColorR = (int) (Math.random() * 255);
                int eyeColorB = (int) (Math.random() * 255);
                int eyeColorG = (int) (Math.random() * 255);
            
                //Draw Square
                PennDraw.setPenColor(255, 10, 10);
                PennDraw.filledSquare(squareX, squareY, 0.08);
            
                //Draw Square's Eyes
                PennDraw.setPenColor(eyeColorR, eyeColorG, eyeColorB);
                PennDraw.filledArc(squareEyeX1, squareEyeY, eyeRadi, 
                                   0, eyeAngle);
                PennDraw.filledArc(squareEyeX2, squareEyeY, eyeRadi, 
                                   0, eyeAngle);
                
                //Determine Smile
                double squareSmile = Math.random() * 1.0;
                
                //Draw face expression for square
                if (squareSmile >= 0.75) {
                    PennDraw.arc(squareX, squareY, 0.015, 180, 360);
                }
                else if (squareSmile < 0.25) {
                    PennDraw.arc(squareX, squareY, 0.015, 0, 180);
                }
                else {
                    PennDraw.line(squareX - 8.0 / 512, squareY, 
                                  squareX + 7.0 / 512, squareY);
                }
            }
                firstTime = false;
            
                // if the mouse is clicked
                if (PennDraw.mousePressed()) {
                    
                    // get the coordinates of the mouse cursor
                    double x = PennDraw.mouseX();
                    double y = PennDraw.mouseY(); 
                
                    //print shape depending on mouse cursor
                    //Set Eye Coordinates
                    double squareEyeX1 = x - (30.0 / 512) * y;
                    double squareEyeX2 = x + (30.0 / 512) * y;
                    double squareEyeY = y + (20.0 / 512) * y;
                    
                    //Set Eye Color
                    int eyeColorR = (int) (Math.random() * 255);
                    int eyeColorB = (int) (Math.random() * 255);
                    int eyeColorG = (int) (Math.random() * 255);
                    
                    //Set Eye Expression and Size
                    int eyeAngle = (int) (Math.random() * 400);
                    double eyeRadi = 0.01 * y;
                    
                    //Draw Square
                    PennDraw.setPenColor(255, 10, 10);
                    PennDraw.filledSquare(x, y, 0.1 * y);
                    
                    //Draw Square's Eyes
                    PennDraw.setPenColor(eyeColorR, eyeColorG, eyeColorB);
                    PennDraw.filledArc(squareEyeX1, squareEyeY, eyeRadi, 
                                       0, eyeAngle);
                    PennDraw.filledArc(squareEyeX2, squareEyeY, eyeRadi, 
                                       0, eyeAngle);
                
                    //Determine Smile
                    double squareSmile = Math.random() * 1.0;
                
                    //Draw face expression for square
                    if (squareSmile >= 0.75) {
                        PennDraw.arc(x, y, 0.015 * y, 180, 360);
                    }
                    else if (squareSmile < 0.25) {
                        PennDraw.arc(x, y, 0.015 * y, 0, 180);
                    }
                    else {
                        PennDraw.line(x - (8.0 / 512) * y, y, 
                                  x + (7.0 / 512) * y, y);
                    }
                }
        }
    }
}