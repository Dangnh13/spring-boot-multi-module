package vn.woodsland.byserp.framework.validation;

import vn.woodsland.byserp.framework.validation.annotation.OrNotBlank;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OrNotBlankValidator implements ConstraintValidator<OrNotBlank, Object> {

	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(OrNotBlankValidator.class);

	private String[] properties;

	@Override
	public void initialize(OrNotBlank constraintAnnotation) {
		properties = constraintAnnotation.value();
		if (properties.length < 2) {
			throw new IllegalArgumentException("at least two properties needed to make a choice");
		}
	}

	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		try {
			BeanInfo info = Introspector.getBeanInfo(value.getClass());
			if (!isValidParams(info)) {
				throw new IllegalArgumentException("Has param not exist in BeanInfo");
			}
			return Stream.of(properties)
					.map(property -> Stream.of(info.getPropertyDescriptors())
							.filter(desr -> desr.getName().equals(property))
							.findAny()
							.orElse(null)
					)
					.map(prop -> getProperty(prop, value))
					.anyMatch(StringUtils::isNotBlank);
		} catch (IntrospectionException noBean) {
			return false;
		}
	}

	private String getProperty(PropertyDescriptor prop, Object bean) {
		try {
			if (Objects.nonNull(prop.getReadMethod())) {
				Object value = prop.getReadMethod().invoke(bean);
				if (Objects.nonNull(value) && StringUtils.isNotBlank(String.valueOf(value))) {
					return String.valueOf(value);
				}
			}
		} catch (ReflectiveOperationException noAccess) {
			logger.info("NoAccess prop {}", prop);
		}
		return null;
	}

	private boolean isValidParams(BeanInfo info) {
		List<String> fieldNameList = Stream.of(info.getPropertyDescriptors()).map(p -> p.getName()).collect(Collectors.toList());
		return CollectionUtils.isNotEmpty(fieldNameList) && fieldNameList.containsAll(Arrays.asList(properties));
	}
}
