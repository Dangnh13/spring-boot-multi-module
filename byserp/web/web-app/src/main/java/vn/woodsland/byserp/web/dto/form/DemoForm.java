package vn.woodsland.byserp.web.dto.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import vn.woodsland.byserp.framework.validation.annotation.RequiredNotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DemoForm {
    @RequiredNotBlank(message = "{javax.validation.constraints.NotBlank.message}", name = "Tac gia")
    private String author;
    private String book;

}
