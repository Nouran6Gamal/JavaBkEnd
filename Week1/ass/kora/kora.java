// Online Java Compiler
// Use this editor to write, compile and run your Java code online

import java.util.Arrays;

class Main {

    public static void main(String[] args) {

        System.out.println("Start small. Ship something.");

        /*
         using data for 12 players for simplicity & every skill has a number
         tall =1 , leader=2 , smart=3 , strong=4 , fast=5 , passer=6 ,
         dribbler=7 , 5stars_skill=8 , scoring=9
         the 8 skills will have value for every player if skill=0 (don't have skill)
         strikers : strong , fast , scoring , smart
        */

        int[][] selection = new int[12][2];
        int[][] players = new int[12][];

        players[0] = new int[]{1, 1, 1, 0, 0, 0, 0, 0, 0};
        players[1] = new int[]{0, 0, 1, 1, 1, 0, 0, 0, 0};
        players[2] = new int[]{1, 0, 1, 1, 1, 0, 0, 0, 0};
        players[3] = new int[]{1, 1, 1, 1, 1, 0, 0, 0, 0};
        players[4] = new int[]{0, 0, 1, 1, 1, 0, 0, 0, 0};
        players[5] = new int[]{0, 0, 1, 0, 0, 1, 1, 1, 0};
        players[6] = new int[]{0, 0, 1, 1, 0, 1, 1, 1, 0};
        players[7] = new int[]{0, 0, 1, 0, 0, 1, 1, 1, 0};
        players[8] = new int[]{0, 0, 1, 1, 0, 1, 1, 1, 1};
        players[9] = new int[]{0, 0, 1, 1, 1, 0, 0, 0, 1};
        players[10] = new int[]{0, 0, 1, 1, 1, 0, 0, 1, 1};
        players[11] = new int[]{1, 0, 1, 0, 0, 0, 0, 0, 0};

        boolean[] used = new boolean[12];

        int[][] selection_GK = new int[12][2];
        int[][] selection_DEF = new int[12][2];
        int[][] selection_MID = new int[12][2];
        int[][] selection_STR = new int[12][2];

        int temp_gk = -1;
        int index_gk = -1;

        int temp_def = -1;
        int index_def = -1;

        int temp_mid = -1;
        int index_mid = -1;

        int temp_str = -1;
        int index_str = -1;

        for (int i = 0; i < 12; i++) {

            selection[i][1] = Arrays.stream(players[i]).sum();
            selection[i][0] = i;

            // GK
            if (players[i][0] == 1 && players[i][1] == 1 && players[i][2] == 1) {
                selection_GK[i][0] = i;
                selection_GK[i][1] = selection[i][1];
            }

            // DEF
            if (players[i][2] == 1 && players[i][3] == 1 && players[i][4] == 1) {
                selection_DEF[i][0] = i;
                selection_DEF[i][1] = selection[i][1];
            }

            // MID
            if (players[i][2] == 1 && players[i][5] == 1 && players[i][6] == 1 && players[i][7] == 1) {
                selection_MID[i][0] = i;
                selection_MID[i][1] = selection[i][1];
            }

            // STR
            if (players[i][2] == 1 && players[i][5] == 1 && players[i][6] == 1 && players[i][8] == 1) {
                selection_STR[i][0] = i;
                selection_STR[i][1] = selection[i][1];
            }
        }

        // Choose GK
        for (int k = 0; k < 12; k++) {
            if (selection_GK[k][1] > temp_gk && !used[k]) {
                temp_gk = selection_GK[k][1];
                index_gk = selection_GK[k][0];
            }
        }

        used[index_gk] = true;

        // Choose 4 DEF
        for (int c1 = 0; c1 < 4; c1++) {

            temp_def = -1;
            index_def = -1;

            for (int k1 = 0; k1 < 12; k1++) {
                if (selection_DEF[k1][1] > temp_def && !used[k1]) {
                    temp_def = selection_DEF[k1][1];
                    index_def = selection_DEF[k1][0];
                }
            }

            used[index_def] = true;
            System.out.println("Best DEF: " + index_def + " score = " + temp_def);
        }

        // Choose 4 MID
        for (int c2 = 0; c2 < 4; c2++) {

            temp_mid = -1;
            index_mid = -1;

            for (int k2 = 0; k2 < 12; k2++) {
                if (selection_MID[k2][1] > temp_mid && !used[k2]) {
                    temp_mid = selection_MID[k2][1];
                    index_mid = selection_MID[k2][0];
                }
            }

            used[index_mid] = true;
            System.out.println("Best MID: " + index_mid + " score = " + temp_mid);
        }

        // Choose 2 STR
        for (int c3 = 0; c3 < 2; c3++) {

            temp_str = -1;
            index_str = -1;

            for (int k3 = 0; k3 < 12; k3++) {
                if (selection_STR[k3][1] > temp_str && !used[k3]) {
                    temp_str = selection_STR[k3][1];
                    index_str = selection_STR[k3][0];
                }
            }

            used[index_str] = true;
            System.out.println("Best STR: " + index_str + " score = " + temp_str);
        }

        System.out.println("Best GK : " + index_gk + " score = " + temp_gk);
    }
}