/* Name: Ethan Chen
 * PennKey: etc
 * Recitation: 217
 * 
 * Execution: java Race
 * 
 * Races a pennant of Penn and Princeton, with Penn having a marginally
 * greater chance of winning
 */

public class Race {
    public static void main(String[] args) {
        //Square or Circle won?
        boolean squareWins = false;
        boolean circleWins = false;
        
        //the width of 1 pixel in window coordinates,
        //assuming you do NOT call PennDraw.setXscale()
        double ONE_PIXEL = 1.0 / 512;

        //Set Pictures at Start Line and Angles and sizes
        double squareX = 75.0 / 512;
        double squareY = 312.0 / 512;
        double circleX = 75.0 / 512;
        double circleY = 212.0 / 512;
        int eyeAngle = 360;
        double eyeRadi = 0.01;
        
        //enable animation at 10 frames/second
        //TODO - you may change the frame rate to be any speed you like
        PennDraw.enableAnimation(10);
        
        while (!squareWins && !circleWins) {
            //Clears the screen
            PennDraw.clear();
            
            //Draw the start line
            PennDraw.line(150.0 / 512, 511.0 / 512, 150.0 / 512, 1.0 / 512);
            
            //Draw the finish line
            PennDraw.line(450.0 / 512, 511.0 / 512, 450.0 / 512, 1.0 / 512);
            
            //Set Eye Coordinates
            double squareEyeX1 = squareX - 30.0 / 512;
            double squareEyeX2 = squareX + 30.0 / 512;
            double circleEyeX1 = circleX - 30.0 / 512;
            double circleEyeX2 = circleX + 30.0 / 512;
            double squareEyeY = squareY + 20.0 / 512;
            double circleEyeY = circleY + 20.0 / 512;
            
            //Set EyeColors
            int eyeColorR = (int) (Math.random() * 255);
            int eyeColorB = (int) (Math.random() * 255);
            int eyeColorG = (int) (Math.random() * 255);
            int eyeColorGG = eyeColorR;
            int eyeColorBB = eyeColorG;
            int eyeColorRR = eyeColorB;
            
            //Draw Square
            PennDraw.setPenColor(255, 10, 10);
            PennDraw.filledSquare(squareX, squareY, 0.08);
            
            //Draw Square's Eyes
            PennDraw.setPenColor(eyeColorR, eyeColorG, eyeColorB);
            PennDraw.filledArc(squareEyeX1, squareEyeY, eyeRadi, 0, eyeAngle);
            PennDraw.filledArc(squareEyeX2, squareEyeY, eyeRadi, 0, eyeAngle);
            
            //Draw Cirlce
            PennDraw.setPenColor(10, 10, 255);
            PennDraw.filledCircle(circleX, circleY, 0.08);
            
            //Draw Circle's Eyes
            PennDraw.setPenColor(eyeColorRR, eyeColorGG, eyeColorBB);
            PennDraw.filledArc(circleEyeX1, circleEyeY, eyeRadi, 0, eyeAngle); 
            PennDraw.filledArc(circleEyeX2, circleEyeY, eyeRadi, 0, eyeAngle);
            
            //Determine Smile
            double squareSmile = Math.random() * 1.0;
            double circleSmile = Math.random() * 1.0;
                           
            //Determine if anyone has won
            if (squareX >= 450.0 / 512) {
                squareWins = true;
            }
            if (circleX >= 450.0 / 512) {
                circleWins = true;
            }
            
            //Determine if Square Changes
            double squareProbabilityMoves = (double) (Math.random() * 1.0);
            if (squareProbabilityMoves >= 0.49) {
                squareX += ONE_PIXEL;
                eyeAngle = (int) (Math.random() * 400);
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
            
            //Determine if Circle Changes
            double circleProbabilityMoves = (double) (Math.random() * 1.0);
            if (circleProbabilityMoves >= 0.51) {
                circleX += ONE_PIXEL;
                 if (circleSmile >= 0.75) {
                    PennDraw.arc(circleX, circleY, 0.015, 180, 360);
                }
                else if (circleSmile < 0.25) {
                    PennDraw.arc(circleX, circleY, 0.015, 0, 180);
                }
                else {
                    PennDraw.line(circleX - 8.0 / 512, circleY, 
                                  circleX + 8.0 / 512, circleY);
                }
            }
            
            // show this frame and go on to the next one
            PennDraw.advance();
        }
        
        // the race is over so turn off animatiion
        PennDraw.disableAnimation();
        
        //Win message
        if (squareWins == true) {
            PennDraw.setFontSize(75);
            PennDraw.setFontItalic();
            PennDraw.text(0.5, 0.5, "Square WINS!");
        }
        else {
            PennDraw.setFontSize(25);
            PennDraw.setFontItalic();
            PennDraw.text(0.5, 0.5, "Circle wins...");
        }
        
    }
}
        