/**
 * For Question 1A
 * Random initial Location and Status. No state.
 */
import java.util.Random;
public class simpleReflex {

    private static String[] isDirty = new String[3];
    private static char init_location;
    private static int score = 0;
    private static double step = 100;
    private static String runVacuum(){

//            if(randomStatus().equals("Dirty")) {
//                score += 10;
//                step--;
//                return "[" +init_location + ", suck] ";
//            }else
              if (init_location == 'A'){
                score -= 3;
                step --;
                init_location = 'B';
                if(isDirty[0].equals("Dirty")){
                    System.out.print("[A , suck] ");
                }
                return "[A , right] ";

            }else if (init_location == 'C'){
                score -= 1;
                step -=2;
                init_location = 'B';
                if(isDirty[2].equals("Dirty")){
                    System.out.print("[C , suck] ");
                }
                return "[C , left] ";

            }else {
                score -= 1;
                step -=2;
                init_location = 'C';
                if(isDirty[1].equals("Dirty")){
                    System.out.print("[B , suck] ");
                }
                return "[B , right] ";
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
    public static String randomStatus(){
        String[] stats = {"Clean","Dirty"};
        return stats[generateRandom(0,1)];
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
    public static String getStatus(char location){
        if (location == 'A'){
            return isDirty[0];
        }else if(location == 'B'){
            return isDirty[1];
        }else {
            return isDirty[2];
        }
    }

    public static void main(String[] args){
        //true is dirty, false is clean
        setStatus(isDirty);
        init_location = randomLocation();
        System.out.println("The initial configuration: ");
        for (int i = 0; i <isDirty.length ; i++) {
            char[] abc = {'A','B','C'};
            System.out.printf("Location: %s Status = %s\n",abc[i],isDirty[i]);
        }
        for (int i = 0; i < 100; i++) {
            if (i%3 == 0){
                System.out.println();
            }else {
                System.out.print(runVacuum());
            }
        }
        System.out.printf("Performance Score: %.2f", score/step);
    }

}
