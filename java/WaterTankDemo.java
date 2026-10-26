// stack and constructors previous discussion
class WaterTank {
    // data abstraction - important to hide elements. 
    private String name; // name sa tank
    private int[] buckets;
    private int top;

    public WaterTank(){
        this.name = "Standard Tank";
        this.buckets = new int[5];
        this.top = -1;
        System.out.println(name + " created (no-argument constructor)");
    }
    public WaterTank(String name, int capacity){
        this.name = name;
        this.buckets = new int[capacity];
        this.top = -1;
        System.out.println(name +  "Holds " + capacity + "buckets");
    }
    // PUSH
    public void pour(int liters){
        if(top == buckets.length - 1){
            System.out.println("OVERFLOW!" + name + " is full." + liters + " L spilled on the floor!");
            return;
        }
        top++;
        buckets[top] = liters;
        System.out.println("poured " + liters + "L into " + name);
    }
    // POP
    public int drain(){
        if(isEmpty()){
            System.out.println("UNDERFLOW " + name + " is empty.");
            return 0;
        }
        int liters = buckets[top];
        top--;
        System.out.println("Drained " + liters + " L from" + name);
        return liters;
    }
    // PEEK
    public int checkTop(){
        if(isEmpty()){
            System.out.println(name + " is empty.");
            return 0;
        }
        return buckets[top];
    }
    public boolean isEmpty(){
        return top == -1;
    }

    public int bucketCount(){
        return top + 1;
    }

    public int totalLiters(){
        int total = 0;
        for (int i = 0; i <= top; i++){
            total += buckets[i];
        }
        return total;
    }
}

public class WaterTankDemo{
    public static void main(String[] args) {
            // no argument constructor
            WaterTank tank1 = new WaterTank();
            System.out.println("----------------------------------------");
            tank1.pour(10);
            tank1.pour(20);
            tank1.pour(30);
            System.out.println("----------------------------------------");
            System.out.println("Top bucket: " + tank1.checkTop() + " L");
            tank1.drain();
            System.out.println("Buckets left: " + tank1.bucketCount() + " | Total water: "
            + tank1.totalLiters());

            // parameterized constructor
            WaterTank tank2 = new WaterTank("Mini Tank", 3);
            System.out.println("----------------------------------------");
            tank2.pour(5);
            tank2.pour(10);
            tank2.pour(15);
            tank2.pour(20); // should trigger overflow
            System.out.println("----------------------------------------");
            System.out.println("Top bucket: " + tank2.checkTop() + " L");
            tank2.drain();
            tank2.drain();
            tank2.drain();
            tank2.drain(); // should trigger underflow
            System.out.println("----------------------------------------");
            System.out.println("Is the tank empty? " + tank2.isEmpty());
            System.out.println("========================================\n");
    }
    
}
