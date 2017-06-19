package edu.ds.practice.TopCoder;

import edu.ds.practice.Uber.IntersectionAndUnion;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;


/**
 * Created by bchalla on 12/7/15.
 */
public class Inventory {

  class UpdateResponse {
    public int status;
    public UUID ID;

    UpdateResponse(int status, UUID ID) {
      this.status = status;
      this.ID = ID;
    }
  }

  public Map<UUID, Integer> findItems(Set<UUID> itemIds) {
    return new HashMap<UUID, Integer>();
  }

  public UpdateResponse updateInventory(Map<UUID, Integer> orderedItems) {





    return new UpdateResponse(201, UUID.randomUUID());
  }

}
