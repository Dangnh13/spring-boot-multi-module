package vn.woodsland.byserp.domain.modal.common;

import lombok.Data;
import vn.woodsland.byserp.domain.entity.generator.RequestType;

@Data
public class FindRequestTypeModal extends RequestType {
    private String branchName;
}