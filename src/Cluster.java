import java.util.HashMap;

public class Cluster {
    // public ArrayList<User> users;
    public HashMap<Integer, String> users;

    public Cluster() {
        users = new HashMap<Integer, String>();
    }

    public String print() {
        String str = "";
        for (int k : users.keySet())
            str += "(" + k + " " + users.get(k) + ") ";
        return str;
    }
}
