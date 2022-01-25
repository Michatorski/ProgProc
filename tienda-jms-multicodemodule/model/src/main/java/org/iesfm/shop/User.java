package org.iesfm.shop;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class User {

        private String username;
        private int phoneNumber;
        private String email;

        @JsonCreator
        public User(
                @JsonProperty("username") String username,
                @JsonProperty("phoneNumber") int phoneNumber,
                @JsonProperty("email") String email) {
            this.username = username;
            this.phoneNumber = phoneNumber;
            this.email = email;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public int getPhoneNumber() {
            return phoneNumber;
        }

        public void setPhoneNumber(int phoneNumber) {
            this.phoneNumber = phoneNumber;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            User user = (User) o;
            return phoneNumber == user.phoneNumber &&
                    Objects.equals(username, user.username) &&
                    Objects.equals(email, user.email);
        }

        @Override
        public int hashCode() {
            return Objects.hash(username, phoneNumber, email);
        }

        @Override
        public String toString() {
            return "User{" +
                    "username='" + username + '\'' +
                    ", phoneNumber=" + phoneNumber +
                    ", email='" + email + '\'' +
                    '}';
        }
    }
