package edu.ds.practice.TopCoder;

import java.util.List;
import java.util.Map;
import java.util.UUID;


/**
 * Created by bchalla on 12/7/15.
 */
public class Item {
  class CreateResponse {
    public int status;
    public long ID;
  }

  Map<UUID, Item> items = null;

  public UUID orderId;
  public String name;
  public String description;
  public double price;

  public Item get(UUID itemID) {
    return items.get(itemID);
  }

}
