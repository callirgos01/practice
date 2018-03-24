package net.callirgos.triePractice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TriePractice {

    public static class TrieNode implements MyTrie{
        char value;
        TrieNode[] children;
        boolean word;
        public TrieNode() {
            this.value = 0;
            this.children = new TrieNode[100];
            this.word = false;
        }
        public void add(String s) {
            // Base case
            if(s.isEmpty()) {
                this.word = true;
                return;
            }
            char letter = s.charAt(0);
            int index = letter - 'A';
            if(this.children[index] == null) {
                this.children[index] = new TrieNode();
                this.children[index].value = letter;
            }
            this.children[index].add(s.substring(1));
        }
        public boolean isWord(String s) {

            if(s.isEmpty()) {
                return this.word;
            }
            if(children[s.charAt(0)-'a']==null) {
                return false;
            }
            return children[s.charAt(0)-'a'].isWord(s.substring(1));
        }

        @Override
        public boolean getWord() {
            return this.word;
        }

        @Override
        public char getValue() {
            return this.value;
        }

        @Override
        public MyTrie[] getChildren() {
            return this.children;
        }

        public TrieNode autoComplete(String s) {

            if(s.isEmpty()) {
                return this;
            }
            if(children[s.charAt(0)-'A']==null) {
                return null;
            }
            return children[s.charAt(0)-'A'].autoComplete(s.substring(1));
        }
        public List<String> allPossibleContacts(String name) {
            List<String> toReturn = new ArrayList<>();
            return toReturn;
        }
    }
    public interface MyTrie {
        void add(String name);

        boolean isWord(String name);

        boolean getWord();

        char getValue();

        MyTrie[] getChildren();

        MyTrie autoComplete(String word);

        List<String> allPossibleContacts(String name);
    }
    public static class Node implements MyTrie {
        boolean word;
        char value;
        Node[] children;
        public Node() {
            this.word = false;
            this.value = 0;
            this.children = new Node[100];
        }
        public Node(char value) {
            this.word = false;
            this.value = value;
            this.children = new Node[100];
        }
        public void add(String name) {
            if(name.isEmpty()) {
                this.word = true;
                return;
            }
            if(children[name.charAt(0)-'A'] == null) {
                children[name.charAt(0)-'A'] = new Node(name.charAt(0));
            }
            this.children[name.charAt(0)-'A'].add(name.substring(1));
        }
        public boolean isWord(String name) {
            if(name.isEmpty()) {
                return this.word;
            }
            if(this.children[name.charAt(0)-'A'] == null) {
                return false;
            }
            return this.children[name.charAt(0)-'A'].isWord(name.substring(1));
        }
        public boolean getWord() {
            return this.word;
        }

        @Override
        public char getValue() {
            return this.value;
        }

        @Override
        public MyTrie[] getChildren() {
            return this.children;
        }

        @Override
        public MyTrie autoComplete(String word) {
        //given part of a contact
        // what other contants will be available
            if(word.isEmpty()) {
                return this;
            }
            if(this.children[word.charAt(0)-'A'] == null) {
                return null;
            }

            return this.children[word.charAt(0)-'A'].autoComplete(word.substring(1));
        }
        private void gatherPossibilites(Node root, String prefix, List<String> possibilities) {
            if(root.getWord()){
                //System.out.printf();
                possibilities.add(String.format("%s%c", prefix, root.getValue()));
            }
            if(root.getValue() != 0) {
                prefix += root.getValue();
            }
            for(Node child: root.children) {
                if(child!=null) {
                    gatherPossibilites(child, prefix, possibilities);
                }
            }
        }
        private List<String> getPosibilities(Node root, String prefix) {
            List<String> posibilities = new ArrayList<>();

            //System.out.printf("'%s' will autocomplete to -> \r\n",baseWord);

            gatherPossibilites(root, prefix.substring(0,prefix.length()-1), posibilities);

            return posibilities;
        }
        public List<String> allPossibleContacts(String name) {

            StringBuilder sb = new StringBuilder();
            sb.insert(0, "1");
            sb.insert(0, "2");
            sb.insert(0, "3");
            sb.insert(0, "4");
            sb.insert(0, "5");
            sb.insert(0, "6");
            System.out.println(sb.toString());
            
            Node root = (Node)this.autoComplete(name);
            if(root == null){
                return null;
            }
            return getPosibilities(root, name);
        }

    }

    public void useTrie(TrieNode root) {

    }
}
