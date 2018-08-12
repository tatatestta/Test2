package main.practice;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<Player> players = new LinkedHashSet<>();
        players.add(new Player("user1", "elf", 2345));
        players.add(new Player("user2", "witch", 4567));
        players.add(new Player("user3", "elf", 2345));
        players.add(new Player("user4", "gnom", 87));


        Scanner scan = new Scanner(System.in);
        System.out.println("Enter username of user to be deleted");
        String inputUsername = scan.nextLine();
        Set<Player> playersWithDeletedusers = deletePlayerByUsername(players, inputUsername);
        System.out.println(playersWithDeletedusers);


        System.out.println("Enter username to be found");
        String usernameToBeFound = scan.nextLine();

        Player foundPlayer = foundPlayerByUsername(players, usernameToBeFound);
        scan.close();
    }

    private static Player foundPlayerByUsername(Set<Player> players, String inputUsername) {
        Iterator<Player> playerIterator = players.iterator();
        Player playerToBeFound = null;

        while (playerIterator.hasNext()) {
            Player exactPlayer = playerIterator.next();

            if (exactPlayer.getUsername().equalsIgnoreCase(inputUsername)) {
                System.out.println(exactPlayer);
                playerToBeFound = exactPlayer;
            }
        }

        return playerToBeFound;
    }


    private static Set<Player> deletePlayerByUsername(Set<Player> players, String inputUsername) {
        Iterator<Player> playerIterator = players.iterator();

        while (playerIterator.hasNext()) {
            Player exactPlayer = playerIterator.next();

            if (exactPlayer.getUsername().equalsIgnoreCase(inputUsername)) {
                playerIterator.remove();
            }
        }
        return players;
    }
}
