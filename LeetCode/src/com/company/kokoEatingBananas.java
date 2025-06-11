package com.company;

public class kokoEatingBananas {

    public static int minEatingSpeed(int[] piles, int h) {

        int minSpeed = 1;
        int maxSpeed = 0;

        for (int pile : piles) {
            maxSpeed = Math.max(maxSpeed, pile);
        }

        while (minSpeed < maxSpeed) {
            int mid = minSpeed + (maxSpeed - minSpeed) / 2;
            int hours = 0;
            for (int pile : piles) {
                hours += Math.ceil(pile/mid);
            }
            if (hours <= h) {
                minSpeed = Math.min(minSpeed, mid);
                maxSpeed = mid - 1;
            } else {
                minSpeed = mid + 1;
            }
        }

        return minSpeed;

    }

}
