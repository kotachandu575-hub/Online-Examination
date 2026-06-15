import java.util.Scanner;

public class OnlineExaminationSystem {

    static String username = "admin";
    static String password = "admin123";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("===== ONLINE EXAMINATION SYSTEM =====");

        System.out.print("Enter Username: ");
        String user = sc.nextLine();

        System.out.print("Enter Password: ");
        String pass = sc.nextLine();

        if (!user.equals(username) || !pass.equals(password)) {
            System.out.println("Invalid Login Credentials!");
            return;
        }

        System.out.println("\nLogin Successful!");

        while (true) {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Start Exam");
            System.out.println("2. Update Profile");
            System.out.println("3. Change Password");
            System.out.println("4. Logout");

            System.out.print("Enter Choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    startExam(sc);
                    break;

                case 2:
                    System.out.print("Enter New Username: ");
                    username = sc.nextLine();
                    System.out.println("Profile Updated Successfully!");
                    break;

                case 3:
                    System.out.print("Enter New Password: ");
                    password = sc.nextLine();
                    System.out.println("Password Changed Successfully!");
                    break;

                case 4:
                    System.out.println("Logged Out Successfully!");
                    System.out.println("Thank You!");
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }

    public static void startExam(Scanner sc) {

        String[] questions = {
                "1. Java is a?",
                "2. Which company developed Java?",
                "3. Java is ____ language?",
                "4. JVM stands for?",
                "5. Which keyword is used for inheritance?"
        };

        String[][] options = {
                {"A. Programming Language", "B. Browser", "C. OS", "D. Database"},
                {"A. Google", "B. Microsoft", "C. Sun Microsystems", "D. Apple"},
                {"A. Low Level", "B. High Level", "C. Machine", "D. Assembly"},
                {"A. Java Virtual Machine", "B. Java Variable Method", "C. Joint VM", "D. None"},
                {"A. extends", "B. implement", "C. inherit", "D. super"}
        };

        char[] answers = {'A', 'C', 'B', 'A', 'A'};

        int score = 0;

        long startTime = System.currentTimeMillis();
        long examDuration = 60000; // 60 seconds

        System.out.println("\nExam Started!");
        System.out.println("You have 60 seconds.\n");

        for (int i = 0; i < questions.length; i++) {

            long currentTime = System.currentTimeMillis();

            if (currentTime - startTime > examDuration) {
                System.out.println("\nTime Up!");
                System.out.println("Exam Auto Submitted.");
                break;
            }

            System.out.println(questions[i]);

            for (String option : options[i]) {
                System.out.println(option);
            }

            System.out.print("Answer: ");
            char userAnswer = Character.toUpperCase(sc.next().charAt(0));

            if (userAnswer == answers[i]) {
                score++;
            }

            System.out.println();
        }

        System.out.println("===== RESULT =====");
        System.out.println("Total Questions: " + questions.length);
        System.out.println("Correct Answers: " + score);
        System.out.println("Score: " + score + "/" + questions.length);
    }
}