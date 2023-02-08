package lt.code.academy;

import java.util.Map;
import java.util.Scanner;

public class NewUser {
    private final Map<String, User> users;
    private final LoginWriterReader loginWriterReader;

    public NewUser() {
        loginWriterReader = new LoginWriterReader();
        users = loginWriterReader.getUsers();
    }

    public static void main(String[] args) {
        System.out.println();
        NewUser newUser = new NewUser();
        Scanner sc = new Scanner(System.in);

        String line;
        do {
            newUser.menu();
            line = sc.nextLine();
            newUser.userSelection(sc, line);
        }while(!line.equals("3"));
    }

    private void userSelection(Scanner sc, String action) {
        switch (action) {
            case "1" -> registration(sc);
            case "2" -> System.out.println("this is case 2");
            case "3" -> {
                loginWriterReader.saveUsers(users);
                System.out.println("The program was ended");
            }
            default -> System.out.println("This action does not exist!");
        }
    }

        private void printUsers() {

        }

        private void registration (Scanner scanner) {
            {
                User user;
                int id;
                do {
                    System.out.println("Please write your personal id :");
                    id = Integer.parseInt(scanner.nextLine());
                    user = users.get(id);
                    if (user != null) {
                        System.out.println("User with this id already exist! You need to login.");
                    }
                } while (user != null);

                System.out.println("Please write your name:");
                String name = scanner.nextLine();
                System.out.println("Please write your surname:");
                String surname = scanner.nextLine();
                System.out.println("Please write your personal id once again");
                int personalId = Integer.parseInt(scanner.nextLine());
                System.out.println("Registration ended");
            }
        }
        private void printUser () {


        }


        private void menu () {
            System.out.println("""
                    [1]. User registration
                    [2]. Print all users
                    [3]. Exit from program
                    """);
        }
    }
