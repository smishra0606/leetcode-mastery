class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> q=new LinkedList<>();
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<students.length;i++){
            q.add(students[i]);
        }
        for(int i=sandwiches.length-1;i>=0;i--){
            st.push(sandwiches[i]);
        }
        int i=0;
        while(!st.isEmpty() && i<q.size()){
            if(q.peek()==st.peek()){
                q.poll();
                st.pop();
                i=0;
            }
            else{
                q.add(q.poll());
                i++;
            }
        }
        return q.size();
    }
}