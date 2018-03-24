package net.callirgos.triePractice;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

class TriePracticeTest {
    private void printTrie(TriePractice.MyTrie root, String offset) {
        if(root.getWord()){
            System.out.printf("%s%c\r\n", offset, root.getValue());
        }
        if(root.getValue() != 0) {
            offset += root.getValue();
        }
        for(TriePractice.MyTrie child: root.getChildren()) {
            if(child!=null) {
                printTrie(child, offset);
            }
        }
    }
    private void autoComplete(TriePractice.MyTrie root, String baseWord) {
        if(root.autoComplete(baseWord)!=null) {
            System.out.printf("'%s' will autocomplete to -> \r\n",baseWord);
            printTrie(root.autoComplete((baseWord)),baseWord.substring(0,baseWord.length()-1));
        }

        List<String> possibilities = root.allPossibleContacts(baseWord);
        if(possibilities != null){
            System.out.printf("Given '%s' possible contacts are -> [ ",baseWord);
            for(String possible : possibilities ) {
                System.out.printf("%s ",possible);
            }
            System.out.println("]");
        }
    }
    private void testSuite(TriePractice.MyTrie root) {

        root.add("Antrony");
        root.add("Carlos");
        root.add("Kelly");
        root.add("Karina");
        root.add("Alfredo");
        root.add("Nancy");
        root.add("Karmina");
        root.add("Austin");
        root.add("Carol");
        //printTrie
        printTrie(root, "");
        System.out.printf("something is a word -> %s\r\n", root.isWord("something"));
        String baseWord = "so";
        autoComplete(root, baseWord);
        autoComplete(root, "C");
        autoComplete(root, "K");
        autoComplete(root, "Al");
        autoComplete(root, "Ca");
        autoComplete(root, "Car");
        autoComplete(root, "Carl");
        autoComplete(root, "Al");


    }
    @Test
    void useTrie() {

        TriePractice.TrieNode root1 = new TriePractice.TrieNode();
        TriePractice.Node root2 = new TriePractice.Node();
        System.out.println("Sample Trie");
        testSuite(root1);
        System.out.println("Contacts Trie");
        testSuite(root2);



    }
}