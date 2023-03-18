package queuePractice;

public class Queue {
    private Node front;
    private Node rear;

    public Queue() {
        this.front = null;
        this.rear = null;
    }

    //Step 1: enQueue => thêm phần tử vào cuối chuỗi (rear luôn đóng kín với front thành vòng kín)
    public void enQueue(int data) {
        Node newNode = new Node(data);

        if (this.rear == null) {
            this.front = newNode;
            this.rear = newNode;
            this.front.link = this.rear;
            return;
        }
        if (this.front == this.rear) {
            this.rear = newNode;
            this.rear.link = this.front;
            this.front.link = this.rear;
            return;
        }
        Node temp = this.rear;
        this.rear = newNode;
        temp.link = this.rear;
        temp.link.link = this.front;
    }

    //Step 2: deQueue => xoá phần tử đầu chuỗi
    public int deQueue() {
        if (this.front == null) {
            throw new IllegalStateException("Front Queue Null");
        }
        int data = this.front.getData();
        if (this.front == this.rear) {
            this.front = this.rear = null;
        } else {
            this.front = this.front.link;
            this.rear.link = this.front;
        }
        return data;
    }

    //Step 3: displayQueue => in ra thông tin tại từng Node trong chuỗi
    public void displayQueue() {
        Node temp = this.front;
        int index = 0;
        do {
            if (this.front == null) {
                System.err.println("This queue is Empty");
                break;
            }
            System.out.print("Node data at index " + (index++) + "=>> " + temp.getData() +
                    "\t, Next Node data=>> " + temp.link.getData());
            System.out.println();
            temp = temp.link;
        } while (temp != this.front);
    }
}
