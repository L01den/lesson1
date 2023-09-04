package ru.geekbrains;

import java.time.LocalDate;

public class Program {
    public static void main(String[] args) {
        User user1 = new User.UserBuilder("Ray", "Guce")
                                        .setDayOfBirth(LocalDate.of(1969, 12, 05))
                                        .build();
        User user2 = new User.UserBuilder("Nataxa", "Taxa")
                                        .setPhone(89990009900l).build();
        User user3 = new User.UserBuilder("Daxa", "---").build();
    }
}
