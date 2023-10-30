package com.epam.rd.autotasks;

public class Battleship8x8 {
    private final long ships;
    private long shots = 0L;

    public Battleship8x8(final long ships) {

        this.ships = ships;
    }

    public boolean shoot(String shot) {
        char [] chars = new char[shot.length()];
        for (int i=0; i<shot.length(); i++) {
            chars [i] =shot.charAt(i);
        }
int col = 0;
        switch (chars [0]) {

        }
    }

    public String state() {

        throw new UnsupportedOperationException();
    }
}
