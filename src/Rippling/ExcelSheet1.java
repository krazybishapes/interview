package Rippling;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ExcelSheet1 {

    /**
     * Cell
     *
     * set
     * remove dependency
     * set value
     * update childrens with delta in recursion
     *
     * get
     * get the cell value
     *
     * sum
     * remove depdendency
     * create new formula
     * create new dependency
     * set value
     * update childrens
     *
     */
    class Cell{
        int value;
        String formula;
        Map<String, Integer> dependencies;

        public Cell(){
            this.dependencies = new HashMap<>();
        }
    }

    Cell[][] sheet;

    public ExcelSheet1(int height, char width){
        int row = height;
        int col =  width-'A'+1;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                sheet[i][j] = new Cell();
            }
        }
    }

    public void set(int row, char column, int val) {
        row = row-1;
        int col = column-'A';

        Cell cell = sheet[row][col];
        cell.dependencies.clear();
        int delta = val-cell.value;
        cell.value = val;
        updateDependencies(row,col,delta);
    }

    public int get(int row, char column) {
        row = row-1;
        int col = column-'A';

        Cell cell = sheet[row][col];
        return cell.value;
    }

    public int sum(int row, char column, String[] numbers) {
        row = row-1;
        int col = column-'A';

        Cell cell = sheet[row][col];
        cell.dependencies.clear();
        for (String number : numbers) {
            if (number.contains(":")) {

                String[] parts = number.split(":");
                int srow = Integer.parseInt(parts[0].substring(1)) - 1;
                int scol = parts[0].charAt(0) - 'A';

                int erow = Integer.parseInt(parts[1].substring(1)) - 1;
                int ecol = parts[1].charAt(0) - 'A';

                for (int i = srow; i <= erow; i++) {
                    for (int j = scol; j <= ecol; j++) {
                        cell.dependencies.put(i + "," + j, cell.dependencies.getOrDefault(i + "," + j, 0) + 1);
                    }
                }

            } else {
                int r = Integer.parseInt(number.substring(1)) - 1;
                int c = number.charAt(0) - 'A';
                cell.dependencies.put(r + "," + c, cell.dependencies.getOrDefault(r + "," + c, 0) + 1);
            }
        }

        int total = calculateSum(cell.dependencies);
        int delta = total-cell.value;
        cell.value= total;
        updateDependencies(row,col,delta);
        return total;

    }

    private int calculateSum(Map<String, Integer> formula) {
        int sum = 0;
        for (Map.Entry<String, Integer> entry : formula.entrySet()) {
            String[] parts = entry.getKey().split(",");
            int r = Integer.parseInt(parts[0]);
            int c = Integer.parseInt(parts[1]);
            sum += sheet[r][c].value * entry.getValue();
        }
        return sum;
    }

    private void updateDependencies(int row, int col, int delta) {
        String key = row+","+col;
        for(int i=0;i< sheet.length;i++){
            for(int j=0;j< sheet[0].length ;j++){
               Cell cell = sheet[i][j];
               if(cell.dependencies.containsKey(key)){
                   int count = cell.dependencies.getOrDefault(key,0);
                   cell.value += delta*count;
                   updateDependencies(i,j,delta*count);
               }
            }
        }
    }






}
