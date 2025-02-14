import java.util.*;
class Truck {
    int weight;
    int location;
    public Truck (int weight) {
        this.weight = weight;
        this.location = 1;
    }
    public void move() {
        this.location += 1;
    }
}
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        ArrayDeque<Truck> waitQ = new ArrayDeque<>();
        ArrayDeque<Truck> moveQ = new ArrayDeque<>();
        
        for (int t : truck_weights) waitQ.addLast(new Truck(t));
        
        int curWeight = 0;
        int answer = 1;
        
        while (!waitQ.isEmpty() || !moveQ.isEmpty()) {
            answer++;
            
            // 다리가 비어있으면 트럭 올리기
            if (!waitQ.isEmpty() && moveQ.isEmpty()) {
                Truck curT = waitQ.pollFirst();
                moveQ.addLast(curT);
                curWeight += curT.weight;
            }
            
            // 한칸씩 이동시키기
            for (Truck t : moveQ) t.move();
            
            // 이동시켰을 때, 다리를 건넌 트럭은 다리에서 내리기
            if (!moveQ.isEmpty() && moveQ.peek().location > bridge_length) {
                Truck curT = moveQ.pollFirst();
                curWeight -= curT.weight;
            }
            
            // 다리에서 내린 후에 올릴 수 있는 트럭이 있다면 다리로 올리기
            if (!waitQ.isEmpty() && curWeight + waitQ.peek().weight <= weight) {
                Truck curT = waitQ.pollFirst();
                moveQ.addLast(curT);
                curWeight += curT.weight;
            }
        }
        return answer;
    }
}