package com.sand.java.hackathon;

import java.util.*;

// Write your Checker class here

class Player{
    String name;
    int score;

    Player(String name, int score){
        this.name = name;
        this.score = score;
    }

    public int getScore() {
        return score;
    }
}

class Checker implements Comparator<Player> {

    public int compare(Player firstPlayer, Player secondPlayer) {
        int scoreResult = Integer.compare(firstPlayer.score, secondPlayer.score);
        if (scoreResult != 0) {
            return scoreResult;
        }
        return firstPlayer.name.compareTo(secondPlayer.name);
    }
}

class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        Player[] player = new Player[n];
        Checker checker = new Checker();

        for(int i = 0; i < n; i++){
            player[i] = new Player(scan.next(), scan.nextInt());
        }
        scan.close();

        Arrays.sort(player, checker);
        for(int i = 0; i < player.length; i++){
            System.out.printf("%s %s\n", player[i].name, player[i].score);
        }
    }
}