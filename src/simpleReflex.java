/**
 * For Question 1A
 * Random initial Location and Status. No state.
 */
import java.util.ArrayList;
import java.util.Random;
public class simpleReflex {

    private static String[] isDirty = new String[3];
    private static char current_location;
    private static int score = 0;
    private static double step = 100;
    private static String[] state;
    public static String run1aVacuum(){
            if (current_location == 'A'){
                score -= 3;
                step --;
                current_location = 'B';
                if(isDirty[0].equals("Dirty")){
                    System.out.print("[A , suck] ");
                }
                return "[A , right] ";

            }else if (current_location == 'C'){
                score -= 1;
                step -=2;
                current_location = 'B';
                if(isDirty[2].equals("Dirty")){
                    System.out.print("[C , suck] ");
                }
                return "[C , left] ";

            }else {
                score -= 1;
                step -=2;
                current_location = 'C';
                if(isDirty[1].equals("Dirty")){
                    System.out.print("[B , suck] ");
                }
                return "[B , right] ";
            }
    }
    public static void run1bVacuum(){
        state = isDirty;
        ArrayList output = new ArrayList();
        for (int i = 0; i < 100; i++) {
            if(state[0].equals("Clean") && state[0].equals(state[1]) && state[1].equals(state[2]) && state[2].equals(state[0])){
                System.out.print("[NoOp] ");
                break;
            }else if (current_location == 'A'){
                score -= 3;
                step --;

                if(state[0].equals("Dirty")){
                    score += 10;
                    state[0] = "Clean";
                    output.add("[A , suck] ");
                }
                System.out.print("[A , right] ");
                current_location = 'B';

            }else if (current_location == 'C'){
                score -= 3;
                step --;
                current_location = 'B';
                if(state[2].equals("Dirty")){
                    score += 10;
                    state[2] = "Clean";
                    System.out.print("[C , suck] ");
                }
                System.out.print("[C , left] ");

            }else {
                score -= 3;
                step --;
                if(state[1].equals("Dirty")){
                    score += 10;
                    state[1] = "Clean";
                    System.out.print("[B , suck] ");
                }
                if(state[0].equals("Clean")){
                    current_location = 'C';
                    System.out.print("[B , right] ");
                }else {
                    current_location = 'A';
                    System.out.print("[B , left] ");
                }

            }
        }
    }

    private static int generateRandom(int min, int max) {
        Random rand = new Random();
        // max - min + 1 will create a number in the range of min and max, including max. If you don´t want to include it, just delete the +1.
        // adding min to it will finally create the number in the range between min and max
        return rand.nextInt(max-min+1) + min;
    }

    public static char randomLocation(){
        char[] config = {'A','B','C'};
        return  config[generateRandom(0,2)];
    }


    //50 50 chance to be dirty(true) and clean(false)
    public static void setStatus(String[] isDirty){
        for (int i = 0; i < isDirty.length; i++) {
            double chance = Math.random();
            if(chance <= 0.5){
                isDirty[i] = "Dirty";
            }else {
                isDirty[i] = "Clean";
            }
        }
    }


    public static void main(String[] args){
        //true is dirty, false is clean
        setStatus(isDirty);
        current_location = randomLocation();
        System.out.println("The initial configuration: ");
        for (int i = 0; i <isDirty.length ; i++) {
            char[] abc = {'A','B','C'};
            System.out.printf("Location: %s Status = %s\n",abc[i],isDirty[i]);
        }
        for (int i = 0; i < 100; i++) {
            if (i%3 == 0){
                System.out.println();
            }else {
                System.out.print(run1aVacuum());

            }
        }
        System.out.printf("Performance Score: %.2f\n", score/step);
        System.out.println();
        for (int i = 0; i <isDirty.length ; i++) {
            char[] abc = {'A','B','C'};
            System.out.printf("Location: %s Status = %s\n",abc[i],isDirty[i]);
        }
        run1bVacuum();
        System.out.println();
        System.out.printf("Performance Score: %.2f\n", score/step);
    }

}
