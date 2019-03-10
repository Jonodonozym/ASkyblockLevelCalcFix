
package jdz.sbLevelFix;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class FieldChanger {
	public static void setFinalStatic(Field field, Object newValue) throws ReflectiveOperationException {
		field.setAccessible(true);

		Field modifiersField = Field.class.getDeclaredField("modifiers");
		modifiersField.setAccessible(true);
		modifiersField.setInt(field, field.getModifiers() & ~Modifier.FINAL);

		field.set(null, newValue);
	}
}