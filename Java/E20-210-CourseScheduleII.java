class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] map=new int[numCourses];
        for(int i=0;i<prerequisites.length;i++){
            map[prerequisites[i][0]]++;
        }
        Queue<Integer> queue=new LinkedList<>();
        for(int i=0;i<map.length;i++){
            if(map[i]==0)
                queue.add(i);
        }
        List<Integer> res =new ArrayList<>();
        int count =queue.size();
        while(!queue.isEmpty()){
            int temp=queue.poll();
            res.add(temp);
            for(int i=0;i<prerequisites.length;i++)
            {
                if(temp==prerequisites[i][1]){
                    int t=prerequisites[i][0];
                    map[t]--;
                    if(map[t]==0){
                        queue.add(t);
                        count++;
                    }
                }
            }
        }
        if(count!=numCourses){
            int[] a=new int[0];
            return a;
        }
        else{
            int[] a=new int[res.size()];
            for(int i=res.size()-1;i>=0;i--){
                a[i]=res.get(i);
            }
            return a;
        }
    }
}