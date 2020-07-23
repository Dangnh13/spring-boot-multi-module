package vn.woodsland.byserp.web.controller.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import vn.woodsland.byserp.web.dto.form.DemoForm;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/cmn/cmn0003")
@Slf4j
public class CMN0003Controller {

    // Binding data qua request param, data tu dong gan vao object form
    // http://localhost:8081/cmn/cmn0003/init?author=ngohaidang&book=quyensach
    // 2. Khi su dung @ModelAttribute("demoForm") thi se khong can phai dung model.addAttribute nua
    @GetMapping("/init")
    public String init(Model model, @Valid @ModelAttribute("demoForm") DemoForm demoForm, BindingResult bindingResult) {
        model.addAttribute("ten", "ngo hai dang");
        if(bindingResult.hasErrors()) return "cmn0003_1";
        return "cmn0003_1";
    }

    @GetMapping("/{author}/sach/{book}")
    public String bindingPath(Model model, DemoForm demoForm) {
        log.info("Luc nay cac gia tri cua path se dc binding vao object form: {}", demoForm.toString());
        model.addAttribute("demoForm", demoForm);
        return "cmn0003_1";
    }

    @GetMapping("/init2")
    public String init2(@ModelAttribute(binding = false) DemoForm demoForm) {
        //trước khi set binding data thì demoFOrm lấy giá trị từ hàm setupForm
        demoForm.setBook("sau khi set gia tri");
        // sau khi set gia tri binding mới vào demo form nó sẽ lấy giá trị mới này
        return "cmn0003_1";
    }

    @ModelAttribute
    public DemoForm setUpForm() {
        DemoForm demoForm = new DemoForm();
        demoForm.setAuthor("Demo form author");
        demoForm.setBook("Demo form book");
        return demoForm;
    }
}
