// Key insight — Amortized O(1):
// Even though transfer looks like O(n), each element is transferred exactly once in its lifetime. So averaged across all operations it's O(1).

// Complexity:
// push → O(1)
// pop/peek → Amortized O(1) — each element is moved at most once from stack1 to stack2
// empty → O(1)
// Space: O(n)



import java.util.*;

class MyQueue {
    Deque <Integer> stack1;
    Deque <Integer> stack2;

    public MyQueue() {
        stack1=new ArrayDeque<>();
        stack2=new ArrayDeque<>();
    }
    
    public void push(int x) {
        stack1.push(x);
    }
    
    public int pop() {
        if(stack2.isEmpty()){
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
            
        }
        return stack2.pop();
        
    }
    
    public int peek() {
        if(stack2.isEmpty()){
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
            
        }
        return stack2.peek();
        
    }
    
    public boolean empty() {
        return (stack1.isEmpty() && stack2.isEmpty());
        }

        
    }


/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */