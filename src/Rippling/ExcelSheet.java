package Rippling;

import java.util.HashMap;
import java.util.Map;

public class ExcelSheet {

    class Cell{

        int value;
        String formula;
        Map<String,Integer> dependent;
        Map<String,Integer> childrens;


        public Cell(){
            dependent = new HashMap<>();
            childrens = new HashMap<>();
        }

        public Cell(int val){
            this.value = val;
        }


    }

    private Cell[][] sheet;

    public ExcelSheet(int height, char width){
        int row = height;
        int col = width-'A'+1;
        sheet = new Cell[row][col];
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

        //update dependencies
        updateDependent(row, col, val);
        int oldValue = cell.value;
        cell.value = val;
        System.out.println(oldValue+" "+ cell.value);
        //update childrens with delta
        updateChildrens(row,col,val-oldValue);

    }

    public int get(int row, char column) {
        row = row-1;
        int col = column-'A';
        Cell cell = sheet[row][col];
        return cell.value;
    }

    //"sum(3, 'C', [\"A1\", \"A1:B2\"]) = "
    public int sum(int row, char column, String[] numbers) {
        row = row-1;
        int col = column-'A';
        Cell cell = sheet[row][col];
        //remove old formula if exists
        if(cell.formula != null && !cell.formula.isEmpty()){
            //System.out.println("removing formula");
            removeFormula(row,col,cell.dependent);
        }
        Map<String, Integer> formula = new HashMap<>();
        createFormula(numbers, formula);
        //System.out.println(formula.size());
        formula.forEach((e,v)->{
            System.out.println(e +" "+ v);
        });
        cell.dependent = formula;
        //for each dependency cell, add this as child
        //recursively updates childrens
        int total=0;
        for(Map.Entry<String,Integer> entry: cell.dependent.entrySet()){
            String dependent = entry.getKey();
            String[] rowCol = dependent.split(",");
            int r = Integer.parseInt(rowCol[0]);
            int c = Integer.parseInt(rowCol[1]);
            Cell child = sheet[r][c];
            total += child.value * entry.getValue();
            addChild(row,col,r,c,entry.getValue());
        }

        int oldValue = cell.value;
        cell.value = total;
        updateChildrens(row,col,total-oldValue);

        return total;
    }

    private void addChild(int row, int col, int r, int c, Integer value) {
        Cell cell = sheet[row][col];
        cell.childrens.put(r+","+c, cell.childrens.getOrDefault(r+","+c,0)+value);
        System.out.println(r+","+c +" "+ cell.childrens.get(r+","+c));
    }

    private static void createFormula(String[] numbers, Map<String, Integer> formula) {
        for(String s: numbers){
            if(s.contains(":")){
                String[] parts = s.split(":");
                String start = parts[0];
                String end = parts[1];
                int startCol = start.charAt(0)-'A';
                int startRow = Integer.parseInt(start.substring(1))-1;
                int endCol = end.charAt(0)-'A';
                int endRow = Integer.parseInt(end.substring(1))-1;

                for(int i=startRow;i<=endRow;i++){
                    for(int j=startCol;j<=endCol;j++){
                        formula.put(i+","+j, formula.getOrDefault(i+","+j,0)+1);
                    }
                }


            }else{
                int r = Integer.parseInt(s.substring(1))-1;
                int c = s.charAt(0)-'A';
                formula.put(r+","+c, formula.getOrDefault(r+","+c,0)+1);
            }
        }
    }

    private void updateChildrens(int row, int col, int delta) {
        Cell cell = sheet[row][col];
        if(cell.childrens ==null || cell.childrens.isEmpty()){
            System.out.println("child is null");
            return;
        }
        //receursively updates childrens
        Map<String,Integer> childrens = cell.childrens;
        for(Map.Entry<String,Integer> entry: childrens.entrySet()){
            String dependent = entry.getKey();
            String[] rowCol = dependent.split(",");
            int r = Integer.parseInt(rowCol[0]);
            int c = Integer.parseInt(rowCol[1]);
            Cell child = sheet[r][c];
            child.value = delta * entry.getValue();
            updateChildrens(r,c,delta* entry.getValue());
        }
    }

    private void updateDependent(int row, int col, int val) {
        Cell cell = sheet[row][col];
        System.out.println(cell.dependent);
        if(cell.dependent!=null && !cell.dependent.isEmpty()){
            removeDependency(row,col,val);
            cell.dependent = null;
        }
    }

    private void removeDependency(int row, int col, int val) {
        Cell cell = sheet[row][col];
        Map<String,Integer> dependents = cell.dependent;
        if(dependents == null || dependents.isEmpty()){
            return;
        }
        //remove dependency from all dependency cells
        removeFormula(row, col, dependents);
        cell.formula = null;
    }

    private void removeFormula(int row, int col, Map<String, Integer> dependents) {
        for(Map.Entry<String,Integer> entry: dependents.entrySet()){
            String dependent = entry.getKey();
            String[] rowCol = dependent.split(",");
            int r = Integer.parseInt(rowCol[0]);
            int c = Integer.parseInt(rowCol[1]);
            Cell dependentCell = sheet[r][c];
            dependentCell.childrens.remove(row +","+ col);
        }
    }


    public static void main(String[] args) {
        ExcelSheet excel = new ExcelSheet(3, 'C');
        excel.set(1, 'A', 2);
        System.out.println("sum(3, 'C', [\"A1\", \"A1:B2\"]) = " +
                excel.sum(3, 'C', new String[]{"A1", "A1:B2"})); // Expected: 8
        excel.set(2, 'B', 2);
        System.out.println("get(3, 'C') = " + excel.get(3, 'C')); // Expected: 6
    }
}
