/* Mulithreading Solution...! */
class Bus implements Runnable
{
    int available=1,passenger;
    Bus(int passenger)
    {
        this.passenger=passenger;   // passenger=1
    }
    public synchronized void run() // t1 or t2 or t3
    {
        String name=Thread.currentThread().getName();
        if(available>=passenger)  // 1>=1
        {
            System.out.println(name+" Reserved Seat..!");
            available=available-passenger; // 1-1=0
        }
        else
        {
            System.out.println("Sorry seat not available..!");
        }
    }
}
class Customer
{
    public static void main(String[] args) {

        Bus r=new Bus(1);

        Thread t1=new Thread(r);
        Thread t2=new Thread(r);
        Thread t3=new Thread(r);

        t1.setName("Ram");
        t2.setName("Shyam");
        t3.setName("Raja");
        
        t1.start(); t2.start(); t3.start();
    }
}
