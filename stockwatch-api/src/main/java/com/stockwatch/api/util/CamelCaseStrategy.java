package com.stockwatch.api.util;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.introspect.AnnotatedField;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;

public class CamelCaseStrategy extends PropertyNamingStrategy {
	private static final long serialVersionUID = 1307584000168182810L;

	@Override
	public String nameForField(@SuppressWarnings("rawtypes") MapperConfig config, AnnotatedField field, String defaultName) {
		return convert(defaultName);
	}

	@Override
	public String nameForGetterMethod(@SuppressWarnings("rawtypes") MapperConfig config, AnnotatedMethod method, String defaultName) {
		return convert(defaultName);
	}

	@Override
	public String nameForSetterMethod(@SuppressWarnings("rawtypes") MapperConfig config, AnnotatedMethod method, String defaultName) {
		String a = convert(defaultName);
		return a;
	}

	public String convert(String defaultName) {
		char[] arr = defaultName.toCharArray();
		if (arr.length != 0) {
			if (Character.isLowerCase(arr[0])) {
				char upper = Character.toUpperCase(arr[0]);
				arr[0] = upper;
			}
		}
		return new StringBuilder().append(arr).toString();
	}
}
