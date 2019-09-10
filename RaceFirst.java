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
        boolean pennWins = false;      // has Penn won the race?
        boolean princetonWins = false; // has Princeton won the race?
        
        //the width of 1 pixel in window coordinates,
        //assuming you do NOT call PennDraw.setXscale()
        double ONE_PIXEL = 1.0 / 512;
        
        //TODO - define any variables you need here
        
        
        //TODO - set the pennant locations before the starting line
        double PennX = 75.0/512;
        double PrincetonX = 75.0/512;
        
        
        //enable animation at 10 frames/second
        //TODO - you may change the frame rate to be any speed you like
        PennDraw.enableAnimation(10);
        
        while (!pennWins && !princetonWins) {
            //Clears the screen
            PennDraw.clear();
            //Draw the start line
            PennDraw.line(150.0/512, 511.0/512, 150.0/512, 1.0/512);
            //Draw the finish line
            PennDraw.line (450.0/512, 511.0/512, 450.0/512, 1.0/512);
            //Draw the Penn & Princeton pennants
            PennDraw.picture(PennX, 312.0/512, "penn.png");
            PennDraw.picture(PrincetonX, 212.0/512, "princeton.png");
            //Determine if anyone has wone
            if (PennX == 500.0/512) {
                pennWins = true;
            }
            if (PrincetonX == 500.0/512) {
                princetonWins = true;
            }
            //Determine if Penn Changes
            double PennProbabilityMoves = (double)(Math.random()* 1.0);
            if (PennProbabilityMoves >= 0.49) {
                PennX += ONE_PIXEL;
            }
            //Determine if Princeton Changes
            double PrincetonProbabilityMoves = (double)(Math.random()*1.0);
            if (PrincetonProbabilityMoves >= 0.51) {
                PrincetonX += ONE_PIXEL;
            }
            /* TODO the following
             * 1. clear the screen
             * 2. draw the start line
             * 3. draw the finish line
             * 4. draw the Penn and Princeton pennants
             * 5. based on the current positions, determine if anyone has won
             * 6. determine whether the Penn pennant position changes
             * 7. determine whether the Princeton pennant position changes
             */
            
            PennDraw.advance(); // show this frame and go on to the next one
        }
        
        PennDraw.disableAnimation(); // the race is over so turn off animatiion
        // TODO - draw text containing a victory message in the sketch
        if (pennWins == true) {
            PennDraw.setFontSize(200);
            PennDraw.setFontItalic();
            PennDraw.text(0.5, 0.5, "Penn WINS!");
        }
        else {
            PennDraw.setFontSize(100);
            PennDraw.setFontItalic();
            PennDraw.text(0.5, 0.5, "Princeton wins...");
        }
        
    }
}
        