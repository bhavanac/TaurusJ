package edu.ds.practice.TopCoder;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;


public class Order {
  class CreateResponse {
    public int status;
    public UUID ID;

    CreateResponse(int status, UUID ID) {
      this.status = status;
      this.ID = ID;
    }
  }

  List<Order> orders = null;
  Item item = null;
  Inventory inventory = null;

  public UUID orderId;
  public Map<UUID, Integer> orderItems;

  public Order() {
    orders = new ArrayList<Order>();
    item = new Item();
  }

  public CreateResponse create(Order order) throws Exception{
    // Torrent ID generator/ UUID
    UUID uuid = UUID.randomUUID();

    order.orderId = uuid;

    // Business rules
    // GET on itemID
    Iterator<UUID> iterator = orderItems.keySet().iterator();
    Map<UUID, Integer> inventoryItems = inventory.findItems(order.orderItems.keySet());


    // Just to chekc if i can fulfill the order
    while(iterator.hasNext()) {
      UUID itemID = iterator.next();

      if (null != item.get(itemID)) {

        // Task 1 - Check in the inventory and throw an excepiton
        if (!(inventoryItems.containsKey(itemID) && inventoryItems.get(itemID) > orderItems.get(itemID))) {
          throw new Exception("Item " + itemID + " is not available. So cancelling the order");
        }
      } else {
        throw new Exception("Item is invalid");
      }
    }

    // Fulfill the order
    if (201 != inventory.updateInventory(order.orderItems).status) {
      throw new Exception("Problem in fulfilling the order");
    }
    return new CreateResponse(201, uuid);
  }


}
