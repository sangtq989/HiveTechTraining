package miscellaneous;
//[["Hue","covid"],["Dat","Hue"],["Lam","Hue"],["SA", "Dat"],["LA","Lam"]];

import java.util.ArrayList;
import java.util.List;

public class HierachiArray {
    static Object[][] base = {{"Hue", "covid"}, {"xa", "covid"}, {"Dat", "Hue"}, {"Lam", "Dat"}, {"SA", "xa"},{"SA", "xa"},{"BA", "xa"}, {"LA", "Lam"}};
    static List<Node> unflated = new ArrayList<>();
    static List<Node> result = new ArrayList<>();

    public static class Node {
        public String name;
        public String parent;
        public ArrayList<Node> child;

        public Node(String name, String parent, ArrayList<Node> child) {
            this.name = name;
            this.parent = parent;
            this.child = child;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "name='" + name + '\'' +
                    ", parent=" + parent +
                    ", child=" + child +
                    '}';
        }
    }
    public static void main(String[] args) {
        for (int i = 0; i < base.length; i++) {
            unflated.add(new Node((String) base[i][0], (String) base[i][1], new ArrayList<>()));
        }
        for (int i = 0; i < unflated.size(); i++) {
            Node element = unflated.get(i);
            if (!element.parent.equals("covid")) {
                String parentId = element.parent;
                for (Node item: unflated ) {
                    if(parentId.equals(item.name)){
                        item.child.add(element);
                    }
                }
            } else {
                result.add(element);
            }
        }
        System.out.println(result.toString());
    }
}
