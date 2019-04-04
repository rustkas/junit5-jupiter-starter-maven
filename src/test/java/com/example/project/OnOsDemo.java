package com.example.project;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnJre;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnOs;
import static org.junit.jupiter.api.condition.OS.MAC;
import static org.junit.jupiter.api.condition.OS.LINUX;
import static org.junit.jupiter.api.condition.OS.WINDOWS;
import static org.junit.jupiter.api.condition.JRE.JAVA_8;
import static org.junit.jupiter.api.condition.JRE.JAVA_9;
import static org.junit.jupiter.api.condition.JRE.JAVA_10;

public class OnOsDemo {
//private static final String MAC = "MAC";

	@Test
	@EnabledOnOs(MAC)
	void onlyOnMacOs() {
	    // ...
	}

	@TestOnMac
	void testOnMac() {
	    // ...
	}

	@Test
	@EnabledOnOs({ LINUX, MAC })
	void onLinuxOrMac() {
	    // ...
	}

	@Test
	@DisabledOnOs(WINDOWS)
	void notOnWindows() {
	    // ...
	}

	@Target(ElementType.METHOD)
	@Retention(RetentionPolicy.RUNTIME)
	@Test
	@EnabledOnOs(MAC)
	@interface TestOnMac {
	}
	
	@Test
	@EnabledOnJre(JAVA_8)
	void onlyOnJava8() {
	    // ...
	}

	@Test
	@EnabledOnJre({ JAVA_9, JAVA_10 })
	void onJava9Or10() {
	    // ...
	}

	@Test
	@DisabledOnJre(JAVA_9)
	void notOnJava9() {
	    // ...
	}
	
}
