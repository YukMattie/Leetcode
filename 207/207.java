class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> courses = new ArrayList<>(numCourses);
        
        // initialize the List, each element is a new list
        for(int i = 0; i < numCourses; i++){
            courses.add(new ArrayList<Integer>());
        }

        // find the element by the course number, fill each element(new list inside) with their prerequsite course
        for(int i = 0; i < prerequisites.length; i++){
            courses.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        int[] visited = new int[numCourses];
        for(int i = 0; i < numCourses; i++){
            if(dfs(i, courses, visited) == false){
                return false;
            }
        }
        return true;
    }

    public boolean dfs(int courseNum, List<List<Integer>> courses, int[] visited){
        // mark the course as begin visiting
        visited[courseNum] = 1;
        List<Integer> thisPrereq = courses.get(courseNum);
        for(int i = 0; i < thisPrereq.size(); i++){
            int thePrereqVal = thisPrereq.get(i).intValue();
            // infinite loop
            if(visited[thePrereqVal] == 1){
                return false;
            }
            // if the pre req course is not visited, recursive this prereq course
            if(visited[thePrereqVal] == 0){
                if(dfs(thePrereqVal, courses, visited) == false){
                    return false;
                }
            }
        }
        visited[courseNum] = 2;
        return true;
    }
}