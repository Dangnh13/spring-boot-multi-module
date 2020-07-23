package vn.woodsland.byserp.dto.inventory.response;

import lombok.Data;
import vn.woodsland.byserp.dto.base.response.RESPONSE;

import java.util.List;

@Data
public class UserResponse extends RESPONSE {

    private List<ItemUser> rows;

    private long total;
    @Data
    public static class ItemUser {
        private String username;
        private String password;
        private Boolean enabled;
    }
}
