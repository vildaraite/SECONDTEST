package lt.code.academy;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class LoginWriterReader {
    private static final String FILE_NAME = "users.json";

    Map<String, User> getUsers() {
        Map<String, User> users = new HashMap<>();
        try (ObjectInput oi = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            while (true) {
                User user = (User) oi.readObject();
                users.put(user.name(), user);
            }
        } catch (EOFException e) {
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return users;
    }

    void saveUsers(Map<String, User> users) {
        try (ObjectOutput ob = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            for (User user : users.values()) {
                ob.writeObject(user);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}