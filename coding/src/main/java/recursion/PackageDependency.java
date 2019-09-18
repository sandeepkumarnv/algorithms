package recursion;

import java.util.*;
/*
 Topological Sort...
 https://www.youtube.com/watch?v=ddTC4Zovtbc
 */
class Node{
    int data;
    List<Node> adjacencyList = new ArrayList<>();
    boolean isVisited = false;

    public Node(int data){
        this.data=data;
    }

    public void addEdge(Node n){
        if(adjacencyList == null){
            adjacencyList = new ArrayList<>();
        }
        adjacencyList.add(n);
    }
}
public class PackageDependency {




    public static void main(String[] args){
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);
        Node n8 = new Node(8);
        Node n9 = new Node(0);

        n7.addEdge(n8);
        n9.addEdge(n7);
        n6.addEdge(n9);
        n5.addEdge(n6);
        n3.addEdge(n5);
        n4.addEdge(n3);
        n4.addEdge(n7);
        n2.addEdge(n4);
        n1.addEdge(n3);
        n1.addEdge(n2);

        List<Node> nodeList = new ArrayList<Node>();
        nodeList.add(n1);
        nodeList.add(n2);
        nodeList.add(n3);
        nodeList.add(n4);
        nodeList.add(n5);
        nodeList.add(n6);
        nodeList.add(n7);
        nodeList.add(n8);
        nodeList.add(n9);



        List<Integer> result = installPackages(nodeList);
        for(Integer data : result){
            System.out.println(data);
        }
    }

    public static List<Integer> installPackages(List<Node> packages) {

        if(packages == null || packages.isEmpty()) return new LinkedList<>();

        List<Integer> sequence = new LinkedList<>(); //output to return

        Stack<Integer> outputStack = new Stack<>();
        Set<Integer> visitedSet = new HashSet<>();
        for(Node pack: packages) {
            if(visitedSet.contains(pack.data)) continue;
            topologicalSort(pack,visitedSet,outputStack);
        }

        while(!outputStack.isEmpty()) sequence.add(outputStack.pop());

        return sequence;
    }

    private static void topologicalSort( Node pack, Set<Integer> visitedSet , Stack<Integer> outputStack) {
        visitedSet.add(pack.data);
        for(Node child : pack.adjacencyList){
            if(visitedSet.contains(child.data)) continue;
            topologicalSort(child,visitedSet,outputStack);
        }
        outputStack.push(pack.data);

    }
}
