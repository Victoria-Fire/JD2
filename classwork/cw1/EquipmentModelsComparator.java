package classwork.cw1;

import java.util.Comparator;
import java.util.regex.Pattern;

public class EquipmentModelsComparator implements Comparator<Equipment> {
    private static final Pattern PATTERN = Pattern.compile("-?\\d+(\\.\\d+)?");

    @Override
    public int compare(Equipment e1, Equipment e2) {
        int result = 0;
        int length = Math.min(e1.getModel().length, e2.getModel().length);
        for(int i = 0; i < length; i++) {
            result  = compareStrings(e1.getModel()[i], e2.getModel()[i]);
                    if(result !=0) {
                        return result;
                    }
        }
        if (e1.getModel().length > e2.getModel().length) {
            return 1;
        }
        if (e1.getModel().length < e2.getModel().length) {
            return -1;
        }
        return result;
    }

    private int compareStrings(String s1, String s2) {
        if (isNumeric(s1) && isNumeric(s2)) {
            return Double.valueOf(s1).compareTo(Double.valueOf(s2));
        } else if (isNumeric(s1)) {
            return -1;
        } else if (isNumeric(s2)) {
            return 1;
        } else {
            return s1.compareToIgnoreCase(s2);
        }
    }

    private boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        return PATTERN.matcher(strNum).matches();
    }
}
