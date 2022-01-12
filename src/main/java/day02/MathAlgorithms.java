package day02;


public class MathAlgorithms {
    public int findBiggestDivider(int numberOne, int numberTwo) {
        int limit = numberOne;
        if (numberOne > numberTwo){
            limit = numberTwo;
        }

        int biggestDiv = 1;
        for (int i = 1; i <= limit; i++){
            if (numberOne % i == 0 && numberTwo % i == 0){
                biggestDiv = i;
            }
        }
        return biggestDiv;
    }

    public int findEuclid (int numberOne, int numberTwo){
        if (numberOne % numberTwo == 0){
            return numberTwo;
        } else {
            return findEuclid(numberTwo, numberOne % numberTwo);
        }
    }

    public static void main(String[] args) {
    MathAlgorithms mathAlgorithms = new MathAlgorithms();


    System.out.println(mathAlgorithms.findBiggestDivider(4, 6));
    System.out.println(mathAlgorithms.findBiggestDivider(2, 1));
    System.out.println(mathAlgorithms.findBiggestDivider(4, 16));
    System.out.println(mathAlgorithms.findBiggestDivider(10, 10));
    System.out.println(mathAlgorithms.findBiggestDivider(999, 432));

    System.out.println(mathAlgorithms.findEuclid(4, 6));
    System.out.println(mathAlgorithms.findEuclid(2, 1));
    System.out.println(mathAlgorithms.findEuclid(4, 16));
    System.out.println(mathAlgorithms.findEuclid(10, 10));
    System.out.println(mathAlgorithms.findEuclid(999, 432));
    }
}
