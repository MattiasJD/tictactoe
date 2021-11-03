package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Start();
    }

    private static void Start() {
        String[] mes = {"X's turn:", "O's turn:"};
        if(round%2==0){
            System.out.println(mes[0]);
        }
        else{
            System.out.println(mes[1]);
        }
        Turn();
    }

    private static void End() {
        if (round % 2 == 0) {
            System.out.println("Player O wins!");
        } else {
            System.out.println("Player X wins!");
        }
    }

    private static char[] parcel = {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-'};
    private static int round = 0;
    private static int[][] winCom = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 4, 8}, {2, 4, 6}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}};

    private static void show() {
        System.out.println(parcel[0] + " | " + parcel[1] + " | " + parcel[2]);
        System.out.println(parcel[3] + " | " + parcel[4] + " | " + parcel[5]);
        System.out.println(parcel[6] + " | " + parcel[7] + " | " + parcel[8]);
    }

    private static void Turn() {
        int playersPlay = 0;
        int[] pb = new int[9];
        Scanner scan = new Scanner(System.in);
        int sel = 0;
        int checkClear = 0;
        show();
        do {
            System.out.print("Please select position:");
            sel = scan.nextInt();
            int arrayIdChoose = sel;
            if (Arrays.stream(pb).anyMatch(i -> i == arrayIdChoose)) {
                System.out.println("Wrong number");
            } else {
                checkClear++;
            }
        } while (checkClear == 0);
        if (round % 2 == 0) {
            parcel[sel] = 'X';
        } else {
            parcel[sel] = 'O';
        }
        pb[playersPlay] = sel;
        playersPlay++;
        round++;
        Check();
    }

    private static void Check() {
        if (round < 8) {
            for (int i = 0; i < winCom.length; i++) {
                if (parcel[winCom[i][0]] == 'X' && parcel[winCom[i - 1][1]] == 'X' && parcel[winCom[i][2]] == 'X') {
                    End();
                    return;
                } if (parcel[winCom[i][0]] == 'O' && parcel[winCom[i][1]] == 'O' && parcel[winCom[i][2]] == 'O') {
                    End();
                    return;
                }
            }
            Start();
        } else {
            System.out.println("Draw!");
        }
    }
}