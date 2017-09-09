///**
// * For Question 1A
// * Random initial Location and Status. No state.
// */
//import java.util.Random;
//public class modelReflex {
//
//    public static void main(String[] args){
//        //true is dirty, false is clean
//        boolean[] isDirty = new boolean[3];
//        setStatus(isDirty);
//        init_Status = randomStatus();
//        init_location = randomLocation();
//        for (int i = 0; i <isDirty.length ; i++) {
//            System.out.println(isDirty[i]);
//        }
//        System.out.println("The initial configuration: location = " +init_location +
//                " status = " +init_Status);
//        for (int i = 1; i <= 100; i++) {
//            if (i%4 == 0){
//                System.out.println();
//            }else {
//                System.out.print(runVacuum(isDirty));
//            }
//        }
//        System.out.printf(" Performance Score: %.2f", score/step);
//    }
//    private static char init_location;
//    private static String init_Status;
//    private static int score = 0;
//    private static double step = 100;
//    private static String runVacuum(boolean[] isDirty){
//        setStatus(isDirty);
//
//        if(randomStatus().equals("Dirty")) {
//            score += 10;
//            step--;
//            return "[" +init_location + ", suck] ";
//        }else if (init_location == 'A'){
//            score -= 3;
//            step --;
//            init_location = 'B';
//            return "[A , right] ";
//        }else if (init_location == 'C'){
//            score -= 1;
//            step -=2;
//            init_location = 'B';
//            return "[C , left] ";
//        }else {
//            score -= 1;
//            step -=2;
//            init_location = 'C';
//            return "[B , right] ";
//        }
//    }
//
//    private static int generateRandom(int min, int max) {
//        Random rand = new Random();
//        // max - min + 1 will create a number in the range of min and max, including max. If you don´t want to include it, just delete the +1.
//        // adding min to it will finally create the number in the range between min and max
//        return rand.nextInt(max-min+1) + min;
//    }
//
//    public static char randomLocation(){
//        char[] config = {'A','B','c'};
//        return  config[generateRandom(0,2)];
//    }
//    public static String randomStatus(){
//        String[] stats = {"Clean","Dirty"};
//        return stats[generateRandom(0,1)];
//    }
//
//    //50 50 chance to be dirty(true) and clean(false)
//    public static void setStatus(boolean[] isDirty){
//        for (int i = 0; i < isDirty.length; i++) {
//            double chance = Math.random();
//            if(chance <= 0.5){
//                isDirty[i] = true;
//            }else {
//                isDirty[i] = false;
//            }
//        }
//    }
//
//}
