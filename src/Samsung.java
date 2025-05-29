import java.util.PriorityQueue;

public class Samsung {

    public static void main(String[] args) {

        int[][] input = {
                {1, 1, 10},
                {1, 1, 10},
                {1, 1, 10},
                {1, 1, 10},
                {1, 1, 10}
        };
        int capacity = 5;

        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b)-> Integer.compare(a[1],b[1]));

        for(int[] pass: input){
            int numPass = pass[0];
            int from= pass[1];
            int to = pass[2];
            queue.offer(new int[]{numPass,from,to});
        }


        int start = 0;
        int end = Integer.MAX_VALUE;
        int currentCapacity = 0;

        while(!queue.isEmpty()){
            int[] passanger = queue.poll();
            int numPass = passanger[0];
            int from= passanger[1];
            int to = passanger[2];

            //decrement passangers once reached the to location
            if(from >= end){
                currentCapacity -= numPass;
            }


            currentCapacity += numPass;

            System.out.println(currentCapacity);

            end = to;
            if(currentCapacity > capacity) {
                System.out.println("Impossible");
            }


        }

        System.out.println("possible");




    }
}
