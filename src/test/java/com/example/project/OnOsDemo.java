package com.example.project;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.EnabledOnOs;
import static org.junit.jupiter.api.condition.OS.MAC;
import static org.junit.jupiter.api.condition.OS.LINUX;
import static org.junit.jupiter.api.condition.OS.WINDOWS;;

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
	
}
