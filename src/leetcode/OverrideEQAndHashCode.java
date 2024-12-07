package leetcode;

import java.util.Objects;

public class OverrideEQAndHashCode {

    class Employee{
        private int id;
        private String name;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public boolean equals(Object object) {
            if(this == object) return true;
            if(object == null || getClass() != object.getClass()) return false;

            Employee e = (Employee) object;
            return this.id == e.id && this.name.equals(e.name);

        }

        @Override
        public int hashCode() {
            return Objects.hash(id, name);
        }
    }
    public static void main(String[] args) {

    }
}
