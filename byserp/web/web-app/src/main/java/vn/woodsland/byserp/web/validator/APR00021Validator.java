package vn.woodsland.byserp.web.validator;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import vn.woodsland.byserp.web.dto.suggestion.apr00021.form.APR00021Form;

@Component
public class APR00021Validator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return APR00021Form.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        APR00021Form form = (APR00021Form) target;
        if (!form.getData().getPaymentOrderData().getStep().equals(form.getData().getPaymentOrderData().getTotalStep())) {
            if (form.getData().getAssignedUser().equals(SecurityContextHolder.getContext().getAuthentication().getName())) {
                errors.rejectValue("data.assignedUser", "", "Người được chỉ định không hợp lệ!");
            }
        }
    }
}
