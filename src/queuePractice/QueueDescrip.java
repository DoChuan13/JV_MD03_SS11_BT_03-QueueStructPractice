package queuePractice;

public class QueueDescrip {
    private Node front;
    private Node rear;

    public QueueDescrip() {
        this.front = null;
        this.rear = null;
    }

    //Step 1: enQueue => thêm phần tử vào cuối chuỗi (rear luôn đóng kín với front thành vòng kín)
    public void enQueue(int data) {
        Node newNode = new Node(data);

        if (this.rear == null) {
            //Tạo ra 2 nút front với dữ liệu giống nhau
            this.front = newNode;
            this.rear = newNode;
            //Nối đầu với đuôi và đuôi với đầu để đóng kín vòng
            //(phần tử đầu tiên tự tham chiếu về chính nó, do đó chỉ cần gán 1 lần)
            //front (=>Node0) =>>> front.link(=Node0.link) = rear (=>Node0 =>>>Node0.link = front.link = rear)
            this.front.link = this.rear;
//            this.rear.link = this.front;
            return;
        }
        if (this.front == this.rear) {
            //Trường hợp front = rear => cùng tham chiếu vào một ô nhớ
            //Tách rear tham chiếu vào New Node =>>> rear.link được tái tham chiếu về front
            //front.link tái tham chiếu với rear để khép kín chuỗi
            //front (=>Node0) =>>> front.link = rear (=>newNode) =>rear.link = front....
            this.rear = newNode;
            this.rear.link = this.front;
            this.front.link = this.rear;
            return;
        }
        //Trường hợp còn lại front, rear tham chiếu về các ô nhớ riêng rẽ
        //Biến "temp" tạm giữ tại nút rear (biến temp giữa các link từ front tới rear hiện tại)
        //newRear = newNode
        //temp.link = newRear => newRear được chèn ngay sau chuỗi ban đầu
        //tepm.link.link = newRear.link = front => nối lại đuôi vào đầu để khép kín vòng lặp
        Node temp = this.rear;
        this.rear = newNode;
        temp.link = this.rear;
        temp.link.link = this.front;
       /* //Cách khác (dùng vòng lặp): ===> Biến holderLink để truy xuất sâu vào tầng link, khởi là điểm front
        Node holderLink = this.front;
        while (true) {
            //Xét điều kiện holderLink.link để truy xuất tới tham chiếu tiếp theo của nó
            //Nếu holderLink.link==this.front => holderLink là vị trí rear
            //Biến rear mới được tạo lại, khi chỉ định lại bằng newNode,
            //Link tham chiếu của holderLink.link được cài đè lại bằng rear mới
            //Sau cùng thì link cuối cùng được tham chiếu lại về front để đóng kín chuỗi
            if (holderLink.link == this.front) {
                this.rear = newNode;
                holderLink.link = this.rear;
                holderLink.link.link = this.front;
                break;
            }
            holderLink = holderLink.link;
        }*/
    }

    //Step 2: deQueue => xoá phần tử đầu chuỗi
    public int deQueue() {
        if (this.front == null) {
            //Nếu front null thì báo lỗi Queue Null
//            return null;
            throw new IllegalStateException("Front Queue Null");
        }
        int data = this.front.getData();
        if (this.front == this.rear) {
            //Nếu front == rear => 2 nút tham chiếu cùng một ô nhớ => gán null để xoá bỏ hoàn toàn
            this.front = this.rear = null;
        } else {
            //Front được gán tham chiếu tới phần tử kế tiếp trong chuỗi
            //Rear được tái gắn tham chiếu lại vào ô nhớ Heap mới của front
            this.front = this.front.link;
            this.rear.link = this.front;
        }
        return data;
    }

    //Step 3: displayQueue => in ra thông tin tại từng Node trong chuỗi
    public void displayQueue() {
        Node temp = this.front;
        int index = 0;
        //Biến temp tham chiếu vào front
        //thực thi kiểm tra trạng thái của front => nếu null trả ra thông báo Empty
        //Nếu không null => lần lượt in ra data tại vị trí "temp" và data tại nút kế tiếp
        //"temp" tiếp tục tham chiếu vào link tiếp theo và lại thực hiện lại vòng lặp
        //Vòng lặp chỉ dừng khi "temp" trở về vị trí front trong vòng khép kín
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
