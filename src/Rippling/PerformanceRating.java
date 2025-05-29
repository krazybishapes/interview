package Rippling;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class PerformanceRating {

    class Employee{
        int id;
        String name;
        double performanceRating;
        String position;
        int managerId;
        List<Employee> reportees;

        public Employee(int id, String name, double performanceRating, int manager) {
            this.id = id;
            this.name = name;
            this.performanceRating = performanceRating;
            this.managerId = manager;
            this.reportees = new ArrayList<>();
        }

        public boolean isManager(){
            return reportees!=null && reportees.isEmpty();
        }

    }

    class Team{

        int id;
        String name;
        List<Employee> employees;

        public Team(int id, String name){
            this.id = id;
            this.name = name;
            this.employees = new ArrayList<>();
        }
    }

    class TeamPerformance{
        Team team;
        double avgPerformanceRating;
        
        public TeamPerformance(Team team, double avgPerformanceRating){
            this.team = team;
            this.avgPerformanceRating = avgPerformanceRating;
        }
    }

    //Max heap keeping high performance team at the top
    static PriorityQueue<TeamPerformance> teamPerformances;

    public PerformanceRating(){
        //containing team id and average rating
        teamPerformances = new PriorityQueue<>((a,b)->Double.compare(b.avgPerformanceRating, a.avgPerformanceRating));
    }

    public void calculateTeamPerformance(List<Team> teams){

        if(teams == null || teams.isEmpty()){
            return;
        }
        int totalEmployee = 0;
        double avgPerformanceRating = 0;
        double totalPerformanceRaing = 0;
        for(Team team: teams){

            for(Employee reportee: team.employees){
                totalEmployee++;
                totalPerformanceRaing += reportee.performanceRating;
            }
            if(totalEmployee>0){
                avgPerformanceRating = totalPerformanceRaing/totalEmployee;
                teamPerformances.offer(new TeamPerformance(team, avgPerformanceRating));
            }

        }
    }

    public List<Team> findBestPerformingteam(int k){
        List<Team> bestPerformingTeams = new ArrayList<>();
        for(int i=teamPerformances.size()-1;i>=0;i--){
            if(bestPerformingTeams.size()==k){
                return bestPerformingTeams;
            }
            bestPerformingTeams.add(teamPerformances.peek().team);
        }
        return null;
    }

    public static void main(String[] args) {
        PerformanceRating pr = new PerformanceRating();

        // Create employees
        Employee manager1 = pr.new Employee(1, "Alice", 4.8, 0);
        Employee emp1 = pr.new Employee(2, "Bob", 4.2, 1);
        Employee emp2 = pr.new Employee(3, "Charlie", 3.9, 2);

        Employee manager2 = pr.new Employee(4, "David", 4.5, 0);
        Employee emp3 = pr.new Employee(5, "Eve", 4.7, 4);
        Employee emp4 = pr.new Employee(6, "Frank", 4.9, 4);

        // Assign reportees (optional)
        manager1.reportees.add(emp1);
        manager1.reportees.add(emp2);
        manager2.reportees.add(emp3);
        manager2.reportees.add(emp4);

        // Create teams
        Team teamA = pr.new Team(1, "TeamA");
        teamA.employees.add(manager1); // include manager
        teamA.employees.add(emp1);
        teamA.employees.add(emp2);

        Team teamB = pr.new Team(2, "TeamB");
        teamB.employees.add(manager2);
        teamB.employees.add(emp3);
        teamB.employees.add(emp4);

        // Add teams to list
        List<Team> teams = Arrays.asList(teamA, teamB);

        // Get sorted teams
        pr.calculateTeamPerformance(teams);

        // Print top team
        List<Team> bestperformingTeams = pr.findBestPerformingteam(1);

        // Optional: Print all teams in descending order
        System.out.println("\nAll Teams by Avg Rating:");
        for(Team team: bestperformingTeams){
            System.out.println(team.name);
        }
    }

}
