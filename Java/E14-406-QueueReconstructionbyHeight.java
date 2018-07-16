class Solution {
    private void swap(int[][] people,int a,int b){
        int t1=people[a][0],t2=people[a][1];
        people[a][0] = people[b][0];
        people[a][1] = people[b][1];
        people[b][0] = t1;
        people[b][1] = t2;

    }
    public int[][] reconstructQueue(int[][] people) {
        int n = people.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(people[i][0] < people[j][0])
                    swap(people,i,j);
                else if(people[i][0] == people[j][0] && people[i][1] > people[j][1])
                    swap(people,i,j);
            }
        }
        //按照顺序插入
        List<Integer> la = new ArrayList<Integer>();
        List<Integer> lb = new ArrayList<Integer>();
        for(int i=0;i<n;i++){
            la.add(people[i][1],people[i][0]);
            lb.add(people[i][1],people[i][1]);
        }
        for(int i=0;i<n;i++){
            people[i][0]=la.get(i);
            people[i][1]=lb.get(i);
        }
        return people;

    }
}