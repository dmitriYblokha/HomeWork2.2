package com.gmail.dimablogha;

import java.lang.annotation.*;

@Inherited
@Target(value = ElementType.METHOD)
@Retention(value = RetentionPolicy.RUNTIME)
public @interface Saver {
}
