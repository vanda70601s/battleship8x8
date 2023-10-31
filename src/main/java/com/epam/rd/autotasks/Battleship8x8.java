package com.epam.rd.autotasks;

import java.util.Arrays;

public class Battleship8x8 {
    private final long ships;
    private long shots = 0L;


    public Battleship8x8(final long ships) {
        this.ships = ships;
    }

    public boolean shoot(String shot) {
        char[] ch = new char[shot.length()];
        for (int i = 0; i < shot.length(); i++) {
            ch[i] = shot.charAt(i);
        }
        int column = 0;
        switch (ch[0]) {
            case 'A':
                column = 1;
                break;
            case 'B':
                column = 2;
                break;
            case 'C':
                column = 3;
                break;
            case 'D':
                column = 4;
                break;
            case 'E':
                column = 5;
                break;
            case 'F':
                column = 6;
                break;
            case 'G':
                column = 7;
                break;
            case 'H':
                column = 8;
                break;
        }
        int toChange = column + (8 * (Integer.parseInt(String.valueOf(ch[1])) - 1));
        int n = 64 - toChange;
        long currentShot = 1L;
        currentShot = currentShot << n;
        shots = shots | currentShot;
        return (ships & currentShot) != 0;
    }

    public String state() {
        char empty = '.';
        char miss = '×';
        char ship = '☐';
        char hit = '☒';

        char[] binaryBattleMap = Long.toBinaryString(ships).toCharArray();

        if (binaryBattleMap.length < 64) {
            char[] tmp = new char[64];
            Arrays.fill(tmp, '0');
            System.arraycopy(binaryBattleMap, 0, tmp, 1, tmp.length - 1);
            binaryBattleMap = tmp;
        }

        char[] binaryShots = Long.toBinaryString(shots).toCharArray();

        if (binaryShots.length < 64) {
            char[] tmp = new char[64];
            Arrays.fill(tmp, '0');
            System.arraycopy(binaryShots, 64 - binaryShots.length - (64 - binaryShots.length), tmp, 64 - binaryShots.length, tmp.length - (64 - binaryShots.length));
            binaryShots = tmp;
        }

        char[] battleMap = new char[64];
        //comparing currently map and array of shots
        for (int i = 0; i <= binaryBattleMap.length - 1; i++) {
            if (binaryBattleMap[i] == '1' && binaryShots[i] == '1') {
                battleMap[i] = hit;
            } else if (binaryBattleMap[i] == '1' && binaryShots[i] == '0') {
                battleMap[i] = ship;
            } else if (binaryBattleMap[i] == '0' && binaryShots[i] == '1') {
                battleMap[i] = miss;
            } else if (binaryBattleMap[i] == '0' && binaryShots[i] == '0') {
                battleMap[i] = empty;
            }
        }

        String str = String.valueOf(battleMap);
        for (int i = 8; i < battleMap.length; i = i + 8 + 1) {
            str = str.substring(0, i) + '\n' + str.substring(i);
        }
        return str;
    }
}