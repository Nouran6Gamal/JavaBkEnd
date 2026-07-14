import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[][] arr = new String[5][4];
        int[] gradeSum = new int[5];
        int[] studentSum = new int[5];
        int[] subjectAvg = new int[5];

        int passed = 0;
        int tempMath = 0;
        int tempChem = 0;
        int tempPhysics = 0;

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 4; j++) {

                System.out.println("enter name then grade for 3 subjects in a conseuctive way: math,physics ,chemsitry");
                arr[i][j] = sc.next();

                if (j != 0) {
                    int grade = Integer.parseInt(arr[i][j]);

                    if (grade < 0 || grade > 100) {
                        System.out.println("Invalid Grade");
                        arr[i][j] = sc.next();
                    }
                }
            }
        }

        System.out.println(
                "========= Grade Management =========\n" +
                "1. Show student names\n" +
                "2. Show all student grades & highest grade in each subject\n" +
                "3. search student by name\n" +
                "4. count passed students , show letter grades , avg for each subject\n" +
                "5. Exit\n" +
                "==================================="
        );

        System.out.println("Enter Option");
        int option = sc.nextInt();

        switch (option) {

            case 1:

                for (int i = 0; i < 5; i++) {
                    System.out.println("student" + i + ":" + arr[i][0]);
                }

                break;

            case 2:

                for (int i = 0; i < 5; i++) {

                    System.out.println(
                            "student " + arr[i][0] +
                            "\nmath = " + arr[i][1] +
                            " physics = " + arr[i][2] +
                            " chemistry = " + arr[i][3]
                    );

                    int currMath = Integer.parseInt(arr[i][1]);
                    int currPhysics = Integer.parseInt(arr[i][2]);
                    int currChem = Integer.parseInt(arr[i][3]);

                    if (tempMath < currMath) {
                        tempMath = currMath;
                    }

                    if (tempPhysics < currPhysics) {
                        tempPhysics = currPhysics;
                    }

                    if (tempChem < currChem) {
                        tempChem = currChem;
                    }
                }

                System.out.println("highest grade for maths " + tempMath);
                System.out.println("highest grade for Physics " + tempPhysics);
                System.out.println("highest grade for chemistry " + tempChem);

                break;

            case 3:

                System.out.println("Enter name you want to search for");
                String name = sc.next();

                for (int i = 0; i < 5; i++) {

                    if (name.equals(arr[i][0])) {
                        System.out.println("student " + i + ": " + arr[i][0]);
                    }
                }

                break;

            case 4:

                for (int i = 0; i < 5; i++) {

                    for (int j = 0; j < 3; j++) {

                        studentSum[i] =
                                Integer.parseInt(arr[i][1]) +
                                Integer.parseInt(arr[i][2]) +
                                Integer.parseInt(arr[i][3]);

                        gradeSum[0] += Integer.parseInt(arr[i][1]);
                        gradeSum[1] += Integer.parseInt(arr[i][2]);
                        gradeSum[2] += Integer.parseInt(arr[i][3]);

                        subjectAvg[i] = studentSum[i] / 3;

                        if (studentSum[i] >= 85) {
                            System.out.println("student " + i + ": A");
                        }
                        else if (studentSum[i] >= 75) {
                            System.out.println("student " + i + ": B");
                        }
                        else if (studentSum[i] >= 65) {
                            System.out.println("student " + i + ": C");
                        }
                        else if (studentSum[i] >= 50) {
                            System.out.println("student " + i + ": D");
                            passed++;
                        }
                        else {
                            System.out.println("student " + i + ": F");
                        }
                    }
                }

                System.out.println("no of passed students " + passed);

                break;

            case 5:
                break;

            default:
                System.out.println("Invalid option");
        }
    }
}