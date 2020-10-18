package org.example.pattern.observer.code0031.annotation;

import com.google.common.annotations.Beta;

import java.lang.annotation.*;

/**
 * todo @Beta是什么意思还不太懂
 */
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Target(ElementType.METHOD)
@Beta
public @interface Subscribe {
}
