package leetcode;

import leetcode.struct.ListNode;

import java.util.Arrays;

public class demo950 {

    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        int len = deck.length;

        ListNode head = new ListNode(0);

        for (int i = deck.length - 1; i >= 0; i--) {

        }

        //todo 2,3,5,7,11,13,17
        //17
        //17
        //13 17
        //17 13
        //11 17 13
        //13 11 17
        //7 13 11 17
        //17 7 13 11
        //todo

        return null;
    }

}
