package classwork.cw1;

import java.util.List;

public class SortTextUtil {
    public static void sortData(List<Equipment> equipmentDetails) {
        equipmentDetails.sort(new EquipmentModelsComparator());
    }
}
