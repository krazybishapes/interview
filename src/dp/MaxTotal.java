package dp;

import java.util.*;

public class MaxTotal {

    public static void main(String[] args) {

        Map<String, Integer> cityValMap = new HashMap<>();
        cityValMap.put("NY", 10000);
        cityValMap.put("SF", 1000);
        cityValMap.put("LA", 20000);
        cityValMap.put("CI", 3000);
        cityValMap.put("SJ", 900);

        Map<String, List<String>> cityFlightMap = new HashMap<>();
        cityFlightMap.put("NY", List.of("SF", "LA"));
        cityFlightMap.put("SF", List.of("NY", "SJ"));
        cityFlightMap.put("LA", List.of("NY", "CI"));
        cityFlightMap.put("CI", List.of("LA"));
        cityFlightMap.put("SJ", List.of("SF"));

        Set<String> cities = cityValMap.keySet();

        System.out.println("Max Value: " + findMaxValue(cities, cityValMap, cityFlightMap));
    }

    private static int findMaxValue(Set<String> cities, Map<String, Integer> cityValMap, Map<String, List<String>> cityFlightMap) {
        int maxValue = Integer.MIN_VALUE;

        for (String city : cities) {
            Set<String> visited = new HashSet<>();
            int val = dfs(city, cityValMap, cityFlightMap, visited, 0, 0);
            maxValue = Math.max(maxValue, val);
        }

        return maxValue;
    }

    private static int dfs(String city, Map<String, Integer> cityValMap, Map<String, List<String>> cityFlightMap,
                           Set<String> visited, int currentSum, int depth) {

        if (depth == 4 || visited.contains(city)) {
            return currentSum;
        }

        visited.add(city);
        currentSum += cityValMap.getOrDefault(city, 0);

        int maxSum = currentSum;

        for (String neighbor : cityFlightMap.getOrDefault(city, Collections.emptyList())) {
            maxSum = Math.max(maxSum, dfs(neighbor, cityValMap, cityFlightMap, new HashSet<>(visited), currentSum, depth + 1));
        }

        return maxSum;
    }
}
