package com.nematode.unittesting;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import junit.framework.AssertionFailedError;
import junit.framework.TestCase;

public class AssertTestCase extends TestCase {

	public static void assertEquals(final String message, final Object[] expected,
			final Object[] actual) {
		assertNotNull(message + " Expected was null. Huh? Your test is wrong.", expected);
		assertNotNull(message + "Your actual was null. Oops!", actual);
		assertEquals(message + " Arrays were not the same length.", expected.length, actual.length);
		final List<Object> expectedAsList = Arrays.asList(expected);
		final List<Object> actualAsList = Arrays.asList(actual);
		assertEquals(message, expectedAsList, actualAsList);
	}

	public static void assertEquals(final Object[] expected, final Object[] actual) {
		assertEquals(null, expected, actual);
	}

	public static void assertEqualListContents(final List<?> expected, final List<?> actual) {
		assertEqualsCollectionContents(expected, actual);
	}

	public static void assertEqualsCollectionContents(final Collection<?> expectedCollection,
			final Collection<?> actualCollection) {
		assertNotNull("Expected collection was null", expectedCollection);
		assertNotNull("Actual collection was null", actualCollection);
		assertEquals("List was incorrect size.", expectedCollection.size(), actualCollection.size());
		final Iterator<?> actualCollectionIterator = actualCollection.iterator();
		int index = 0;
		for (final Object object : expectedCollection) {
			assertEquals("failed at index " + index, object, actualCollectionIterator.next());
			index++;
		}
	}

	public void assertEquals(final int[] expected, final int[] actual) {
		assertNotNull("Expected was null. Huh? Your test is wrong.", expected);
		assertNotNull("Your actual was null. Oops!", actual);
		assertEquals("Arrays were not the same length.", expected.length, actual.length);
		for (int i = 0; i < expected.length; i++) {
			assertEquals("failed at position: " + i, expected[i], actual[i]);
		}
	}

	public void assertEquals(final long[] expected, final long[] actual) {
		assertNotNull("Expected was null. Huh? Your test is wrong.", expected);
		assertNotNull("Your actual was null. Oops!", actual);
		assertEquals("Arrays were not the same length.", expected.length, actual.length);
		for (int i = 0; i < expected.length; i++) {
			assertEquals("failed at position: " + i, expected[i], actual[i]);
		}
	}

	public void assertEquals(final double[] expected, final double[] actual) {
		assertNotNull("Expected was null. Huh? Your test is wrong.", expected);
		assertNotNull("Your actual was null. Oops!", actual);
		assertEquals("Arrays were not the same length.", expected.length, actual.length);
		for (int i = 0; i < expected.length; i++) {
			assertEquals("failed at position: " + i, expected[i], actual[i]);
		}
	}

	public void assertEquals(final double[] expected, final double[] actual, final double tolerance) {
		assertNotNull("Expected was null. Huh? Your test is wrong.", expected);
		assertNotNull("Your actual was null. Oops!", actual);
		assertEquals("Arrays were not the same length.", expected.length, actual.length);
		for (int i = 0; i < expected.length; i++) {
			assertEquals("failed at position: " + i, expected[i], actual[i], tolerance);
		}
	}

	public void assertEquals(final byte[] expected, final byte[] actual) {
		assertNotNull("Expected byte array was null?", expected);
		assertNotNull("Actual byte array was null", actual);
		assertEquals("Arrays were not the same length.", expected.length, actual.length);
		try {
			assertEquals(ByteBuffer.wrap(expected), ByteBuffer.wrap(actual));
		} catch (final Throwable oops) {
			for (int i = 0; i < expected.length; i++) {
				assertEquals("failed at position " + i + " of the byte buffer: ", expected[i],
						actual[i]);
			}
		}

	}

	public void assertEquals(final String errorMessage, final byte[] expected, final byte[] actual) {
		try {
			this.assertEquals(expected, actual);
		} catch (final Throwable unExpected) {
			fail(errorMessage + unExpected.getMessage());
		}
	}

	public static void assertEqualsCollectionContentsUnordered(final Collection<?> expected,
			final Collection<?> actual) {
		assertNotNull("Expected collection was null", expected);
		assertNotNull("Actual collection was null", actual);
		assertEquals("List was incorrect size.", expected.size(), actual.size());
		for (final Object object : expected) {
			assertTrue("Failed, did not contain " + object, actual.contains(object));
		}
	}

	public static <K, V> void assertEqualMapContents(final Map<K, V> expectedMap,
			final Map<K, V> actualMap) {
		assertNotNull("Expected map was null?", expectedMap);
		assertNotNull("Actual map was null", actualMap);
		assertEquals("Map has incorrect size", expectedMap.size(), actualMap.size());
		for (final Entry<K, V> entry : expectedMap.entrySet()) {
			final K key = entry.getKey();
			final V value1 = entry.getValue();
			final V value2 = actualMap.get(key);
			assertEquals("Failed at key: " + key, value1, value2);
		}
	}

	public static <T> T assertIsOfTypeAndGet(final Class<T> expectedType, final Object actual) {
		return assertIsOfTypeAndGet("", expectedType, actual);
	}

	@SuppressWarnings("unchecked")
	public static <T> T assertIsOfTypeAndGet(final String errorMessage,
			final Class<T> expectedType, final Object actual) {
		assertNotNull(
				errorMessage + " Object was null instead of type " + expectedType.getSimpleName(),
				actual);
		assertEquals(
				errorMessage + " Object " + actual + " was not of type "
						+ expectedType.getSimpleName(), expectedType, actual.getClass());
		return (T) actual;
	}

	public static void assertEqualCollectionContentsRegardlessOfOrder(final Collection<?> expected,
			final Collection<?> actual) {
		assertEquals(expected.size(), actual.size());
		for (final Object object : expected) {
			assertTrue("Object in 1st list not found in 2nd. " + object.toString(),
					actual.contains(object));
		}
	}

	public void assertEqualSetContents(final Set<?> expectedSet, final Set<?> actualSet) {
		assertEquals(expectedSet.size(), actualSet.size());
		for (final Object object : expectedSet) {
			assertTrue("Object in 1st list not found in 2nd. " + object.toString(),
					actualSet.contains(object));
		}
	}

	public static void assertClassImplementsInterfaces(final Class<?> classUnderTest,
			final Class<?>... expectedInterfaces) {
		final Class<?>[] interfaces = classUnderTest.getInterfaces();
		assertEquals("Wrong Number of Interfaces.", expectedInterfaces.length, interfaces.length);
		assertEquals("Wrong interfaces.", expectedInterfaces, interfaces);
	}

	public static void assertImplementsInterface(final Class<?> expectedInterface,
			final Class<?> theClass) {

		assertEquals(theClass.getSimpleName() + " does not implement exactly 1 interface. ", 1,
				theClass.getInterfaces().length);
		assertEquals(expectedInterface, theClass.getInterfaces()[0]);
	}

	public static void assertImplementsInterfaces(final Class<?> theClass,
			final Class<?>... expectedInterfaces) {
		assertEquals(expectedInterfaces.length, theClass.getInterfaces().length);
		for (final Class<?> expectedInterface : expectedInterfaces) {

			assertTrue("Missing " + expectedInterface.getSimpleName(),
					Arrays.asList(theClass.getInterfaces()).contains(expectedInterface));
		}
	}

	public static void assertExtends(final Class<?> expectedSuperClass,
			final Class<?> classUnderTest) {
		final Class<?> superclass = classUnderTest.getSuperclass();
		assertEquals(expectedSuperClass, superclass);
	}

	public static <T> void assertHasOneInstanceOfThisType(final Class<T> classy,
			final Object[] array) {
		int numberFound = 0;
		String classesFound = "";
		for (final Object object : array) {
			if (object.getClass().equals(classy)) {
				numberFound++;
			} else {
				classesFound += object.getClass().getName() + ", ";
			}
		}
		assertEquals("Did not find an instance of " + classy.getName() + " but did find < "
				+ classesFound, 1, numberFound);
	}

	public static <T> int getFirstIndexOfThisType(final Class<T> classy, final Object[] array) {
		int index = 0;
		boolean found = false;
		for (final Object object : array) {
			if (object.getClass().equals(classy)) {
				found = true;
				break;
			}
			index++;
		}
		if (found) {
			return index;
		} else {
			return -1;
		}
	}

	public AssertTestCase() {
		super();
	}

	public AssertTestCase(final String name) {
		super(name);
	}

	public void assertConstructorIsPackageProtected(final Class<?> class1) {
		final Constructor<?>[] declaredConstructors = class1.getDeclaredConstructors();
		try {
			assertEquals(1, declaredConstructors.length);
			final String msg = class1.getSimpleName()
					+ " should have a single protected constructor.";
			assertEquals(msg, 0, declaredConstructors[0].getModifiers());
		} catch (final AssertionFailedError e) {
			assertEquals(1, declaredConstructors.length);
			final String msg = class1.getSimpleName()
					+ " should have a single protected constructor.";
			assertTrue(msg, Modifier.isProtected(declaredConstructors[0].getModifiers()));
		}
	}

	public void assertConstructorIsPrivate(final Class<?> class1) {
		final Constructor<?>[] declaredConstructors = class1.getDeclaredConstructors();
		assertEquals(1, declaredConstructors.length);
		final String msg = class1.getSimpleName() + " should have a single private constructor.";
		assertTrue(msg, Modifier.isPrivate(declaredConstructors[0].getModifiers()));
	}
}
