package vn.woodsland.byserp.framework.validation;

import org.apache.commons.lang3.StringUtils;
import vn.woodsland.byserp.framework.validation.annotation.Date;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Date validity check
 */
public class DateValidator implements ConstraintValidator<Date, String> {

    public void initialize(Date parameters) {
        validateParameters();
    }

    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        if (StringUtils.isBlank(value)) {
            return true;
        }

        String regex = "^[0-9]{1,2}(/|-)[0-9]{1,2}(/|-)[0-9]{4}$";
        Pattern p = Pattern.compile(regex);

        Matcher m = p.matcher(value);

        if (m.find()) {

            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            sdf.setLenient(false);
            try {
                sdf.parse(value.toString());
            } catch (ParseException e) {
                return false;
            }

            return true;

        } else {
            return false;
        }

    }

    private void validateParameters() {
    }
}
