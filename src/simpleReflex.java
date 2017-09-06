/**
 * Created by Jun Lin on 9/6/2017.
 */

public class simpleReflex {

    public static void main(String[] args){

        System.out.printf("The initial configuration: location = A" +
                " status = Dirty \n" + runVacuum('A',"Dirty") +" Performance Score: %.2f", score/step);
    }



    private static int score = 0;
    private static double step = 100;
    private static String runVacuum(char location, String status){
            if(status.equals("Dirty")) {
                score += 10;
                step--;
                return "[" +location + ", suck] " + runVacuum(location,"Clean");
            }else if (location == 'A'){
                score -= 1;
                step -=2;
                return "[" +location + ", right] ";
            }else if (location == 'C'){
                score -= 1;
                step -=2;
                return "[" +location + ", left] ";
            }else {
                score -= 1;
                step -=2;
                return "[" +location + ", right] ";
            }


    }

}
//    double ranChoice = Math.random();
//                if (ranChoice < 0.5){
//        score -= 1;
//        return "left";
//        }else {
//        score -= 1;
//        return "right";
//        }