package com.amd.clase1;

import com.orm.SugarRecord;

public class Usuario extends SugarRecord<com.amd.clase1.Usuario> {

        private String name;
        private String user;
        private String email;
        private String password;

        public Usuario() {

        }

        public Usuario(String name, String user, String email, String password) {
            this.name = name;
            this.user = user;
            this.email = email;
            this.password = password;
        }


        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUser() {
            return user;
        }

        public void setUser(String user) {
            this.user = user;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }


}


