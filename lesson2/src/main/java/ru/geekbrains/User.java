package ru.geekbrains;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class User {
    private String lastName, firstName, patronymic;
    private LocalDate dayOfBirth;
    private List<Long> phone;


    private User(UserBuilder userBuilder){
        lastName = userBuilder.lastName;
        firstName = userBuilder.firstName;
        patronymic = userBuilder.patronymic;
        dayOfBirth = userBuilder.dayOfBirth;
        phone = userBuilder.phone;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public LocalDate getDayOfBirth() {
        return dayOfBirth;
    }

    public List<Long> getPhone() {
        return phone;
    }

    public static class UserBuilder{
        private String lastName, firstName, patronymic;
        private LocalDate dayOfBirth;
        private List<Long> phone;

        public UserBuilder(String lastName, String firstName){
            this.lastName = lastName;
            this.firstName = firstName;
        }

        public UserBuilder setPatronymic(String patronymic) {
            this.patronymic = patronymic;
            return this;
        }

        public UserBuilder setDayOfBirth(LocalDate dayOfBirth) {
            this.dayOfBirth = dayOfBirth;
            return this;
        }

        public UserBuilder setPhone(long phone) {
            if(this.phone == null){
                this.phone = new ArrayList<>();
            }
            this.phone.add(phone);
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}
