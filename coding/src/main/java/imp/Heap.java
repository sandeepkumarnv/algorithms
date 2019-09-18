package imp;

class Heap{

    class Node{
        String data;
        int weight;
        public Node(String data, int weight){
            this.data = data;
            this.weight = weight;
        }
    }

    Node[] nodeArray = new Node[10];
    int size = 0;

    private int getParentIndex(int childIndex) {return (childIndex-1)/2;}
    private int getLeftChildIndex(int parentIndex) {return 2* parentIndex +1;}
    private int getRightChildIndex(int parentIndex) {return 2* parentIndex +2;}

    private boolean hasParent(int childIndex) {
        if(getParentIndex(childIndex) < 0) return false;
        else return true;

    }

    private boolean hasLeftChild(int parentIndex) {
        if(getLeftChildIndex(parentIndex) >= nodeArray.length) return false;
        else return true;

    }

    private boolean hasRightChild(int parentIndex) {
        if(getRightChildIndex(parentIndex) >= nodeArray.length) return false;
        else return true;
    }

    private void swap(int i, int j){
        Node temp = nodeArray[i];
        nodeArray[i] = nodeArray[j];
        nodeArray[j]=temp;
    }

    public void add(String data, int weight){
        Node n= new Node(data,weight);

        nodeArray[size] =  n;
        heapifyUp();
        size++;
    }

    public Node peek(){
        return nodeArray[0];
    }

    public Node poll(){
        Node node = nodeArray[0];
        nodeArray[0] = nodeArray[size];
        heapifyDown();
        size--;
        return node;
    }


    private void heapifyUp(){
        int index = size;
        while(hasParent(index) && nodeArray[index].weight < nodeArray[getParentIndex(index)].weight){
            swap(index,getParentIndex(index));
            index = getParentIndex(index);
        }
    }

    private void heapifyDown(){
        int index = 0;
        while(hasLeftChild(index)){
            int smallNodeIndex =  getLeftChildIndex(index);
            if(nodeArray[smallNodeIndex].weight < nodeArray[getRightChildIndex(index)].weight){
                smallNodeIndex = getRightChildIndex(index);
            }
            if(nodeArray[index].weight > nodeArray[smallNodeIndex].weight){
                swap(index,smallNodeIndex);
            }
            index = smallNodeIndex;
        }
    }

}