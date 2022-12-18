package org.example;

public class User {

    private String userName;
    private String phone;
    private String gender;

    private User(Builder builder) {
        this.userName = builder.userName;
        this.phone = builder.phone;
        this.gender = builder.gender;
    }

    public static class Builder implements UserName, Phone, Gender, Apply {

        private String userName;
        private String phone;
        private String gender;

        @Override
        public Phone userName(String userName) {
            if (userName == null) {
                 throw new IllegalArgumentException("UserName can't be a null.");
            }
            this.userName = userName;
            return this;
        }

        @Override
        public Gender phone(String phone) {
            if (phone == null){
                throw new IllegalArgumentException("Phone can't be a null.");
            }
            this.phone = phone;
            return this;
        }

        @Override
        public Apply gender(String gender) {
            if (gender == null){
                throw new IllegalArgumentException("Gender can't be a null.");
            }
            this.gender = gender;
            return this;
        }

        @Override
        public User build() {
            return new User(this);
        }
    }

    interface UserName {
        Phone userName(String userName);
    }

    interface Phone {
        Gender phone(String phone);
    }

    interface Gender {
        Apply gender(String gender);
    }

    interface Apply {
        User build();
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", phone='" + phone + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}