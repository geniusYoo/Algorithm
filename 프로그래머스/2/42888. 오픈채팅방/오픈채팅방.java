import java.util.*;

class Message {
    String op;
    String userId;
    public Message(String op, String userId) {
        this.op = op;
        this.userId = userId;
    }
}
class Solution {
    static String[] operation = {"Enter", "Leave", "Change"};
    static String enterMsg = "님이 들어왔습니다.";
    static String leaveMsg = "님이 나갔습니다.";
    
    public String[] solution(String[] record) {
        HashMap<String, String> user = new HashMap<>();
        ArrayDeque<Message> msgQueue = new ArrayDeque<>();
        ArrayList<String> answer = new ArrayList<>();
        for (String msg : record) {
            String[] splited = msg.split(" ");
            String command = splited[0];
            String userId = splited[1];
            
            if (command.equals(operation[0])) { // Enter
                user.put(userId, splited[2]);
                msgQueue.addLast(new Message(command, userId));
            } 
            else if (command.equals(operation[1])) { // Leave
                msgQueue.addLast(new Message(command, userId));
            }
            else { // Change
                user.put(userId, splited[2]);
            }
        }
        
        while (!msgQueue.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            Message msg = msgQueue.pollFirst();
            sb.append(user.get(msg.userId));
            // Enter, Leave
            if (msg.op.equals(operation[0])) sb.append(enterMsg);
            else sb.append(leaveMsg);
            answer.add(sb.toString());
        }
        
        return answer.toArray(new String[answer.size()]);
    }
}