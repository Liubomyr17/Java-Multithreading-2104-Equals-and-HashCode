package com.company;

/*

2104 Equals and HashCode
In the Solution class, fix a couple of equals / hashCode methods according to the rules for implementing these methods (see your favorite search engine for details).
Both the first and the last lines must participate in the comparison using the equals method and the hashcode calculation.
The main method does not participate in testing.

Requirements:
1. Hashes of the same objects must be equal.
2. The equals method should check whether the passed object is equal to the current one (compare ==).
3. The equals method should check that the passed object is an object of the Solution class.
4. The equals method should return true if the first and last fields are equal to the passed object and the current one (remember that they can be null).
5. Proper HashSet behavior with Solution element type must be ensured.

 */

import java.util.HashSet;
import java.util.Set;

    public class Solution {
        private final String first, last;
        public Solution (String first, String last){
            this.first = first;
            this.last = last;
        }
        @Override
        public boolean equals(Object o) {
            if (o == null) return false;
            if(!(o instanceof Solution)) {
                return false;
            }
            if (this == o) return true;
            Solution solution = (Solution) o;
            if (first != null ? !first.equals(solution.first) : solution.first != null) return false;
            if (last != null ? !last.equals(solution.last) : solution.last != null) return false;
            return true;
        }
        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (last != null ? last.hashCode() : 0);
            return result;
        }

        public static void main(String[] args) {
            Set<Solution> s = new HashSet<>();
            s.add(new Solution("Donald", "Duck"));
            System.out.println(s.contains(new Solution("Donald", "Duck")));
        }
    }

