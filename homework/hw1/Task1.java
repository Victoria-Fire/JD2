package homework.hw1;

import java.io.*;
import java.util.*;

public class Task1 {
    public static void main(String[] args) throws IOException {
        File dir = new File("homework/hw1");
        File fileStart = new File(dir,"in.txt");
        File fileResult = new File(dir,"out.txt");

        if(!dir.exists()) {
            dir.mkdirs();
        }
        if(!fileResult.exists()) {
            fileResult.createNewFile();
        }

        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileStart));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileResult));

        ArrayList<ArrayList<String>> array = new ArrayList<>();
        int count = 0;
        while(bufferedReader.ready()) {
            String text = bufferedReader.readLine();
            ArrayList<String> row = new ArrayList<>(Arrays.asList(text.split("\\t+")));
            array.add(new ArrayList<>());

            for (int j = 0; j < row.size(); j++) {
                array.get(count).add(row.get(j));
            }
            count++;
        }

        Collections.sort(array, new LineComparator());

        for (int i = 0; i < array.size(); i++) {
            for (int j = 0; j < array.get(i).size(); j++) {
                bufferedWriter.write(array.get(i).get(j) + " ");
            }
            bufferedWriter.write("\n");
        }

        bufferedReader.close();
        bufferedWriter.close();
    }

    private static class LineComparator implements Comparator<ArrayList<String>> {

        @Override
        public int compare(ArrayList<String> first, ArrayList<String> second) {
            for(int i = 0; i < first.size(); i++) {
                Integer firstLineInt = parseInt(first.get(i));
                Integer secondLineInt = parseInt(second.get(i));

                if (firstLineInt != null && secondLineInt != null) {
                    int numberComparisionResult = firstLineInt.compareTo(secondLineInt);
                    if (numberComparisionResult != 0) {
                        return numberComparisionResult;
                    }
                }
                else if (firstLineInt != null) {
                    return -1;
                }
                else if (secondLineInt != null) {
                    return 1;
                }
                else {
                    int stringComparisionResult = first.get(i).compareTo(second.get(i));
                    if (stringComparisionResult != 0) {
                        return stringComparisionResult;
                    }
                }
            }
            return 0;
        }
    }

    private static Integer parseInt(String value) {
        try {
            return Integer.parseInt(value);
        }
        catch (Throwable e) {
            return null;
        }
    }
}
