package src.main.java.com.example.demo.designquestions.InventoryManagementSystem;

import java.util.List;

public abstract class WarehouseSelectionStrategy {

    public abstract Warehouse selectWarehouse(List<Warehouse> warehouseList);
}
