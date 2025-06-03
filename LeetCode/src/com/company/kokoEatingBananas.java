package com.company;

public class kokoEatingBananas {

    public int minEatingSpeed(int[] piles, int h) {

        int result = 0;
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
                result = Math.min(result, mid);
                maxSpeed = mid - 1;
            } else {
                minSpeed = mid + 1;
            }
        }

        return result;

    }

}
