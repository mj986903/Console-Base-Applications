import java.util.*;

public class Itenary_Of_Tickets {
    public static void main(String[] args) {
        HashMap<String, String> tickets = new HashMap<>();
        tickets.put("DEL", "HYD");
        tickets.put("HYD", "KOL");
        tickets.put("LUK", "HYD");
        tickets.put("BLR", "LUK");
        tickets.put("KSD", "HYD");
        tickets.put("KOL", "KSD");

        List<String> itenaryList = findItenary(tickets);
        System.out.println("Itenary List : " + itenaryList);
    }

    private static List<String> findItenary(HashMap<String, String> tickets) {
        HashSet<String> visited = new HashSet<>();
        List<String> itenaryList = new ArrayList<>();

        String startPoint = "DEL";
        findItenaryRecursive(tickets, visited, startPoint, itenaryList);
        return itenaryList;
    }

    private static void findItenaryRecursive(HashMap<String, String> tickets, HashSet<String> visited, String source,
            List<String> itenaryList) {
        if (tickets.containsKey(source)) {
            if (!visited.contains(source)) {
                visited.add(source);
                itenaryList.add(source);
                findItenaryRecursive(tickets, visited, tickets.get(source), itenaryList);
            }
        }
    }
}
