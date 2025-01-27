/*
 *
 * # Released under MIT License
 *
 * Copyright (c) 2016-2021 Jim Earley.
 *
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), 
 * to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, 
 * and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, 
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER 
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS 
 * IN THE SOFTWARE.
 */
package org.ghotibeaun.json.converters.annotation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import org.ghotibeaun.json.converters.valueconverter.ValueConverter;

/**
 * Specifies a {@link ValueConverter} to be applied to a JSONValue before setting the value on the target class.
 * These can be used for situations where underlying Class does not have a default, zero-parameter constructor, for
 * converting a primitive value to a specific class (e.g., a Long JSON value to a LocalDate or LocalDateTime), or 
 * for formatting values from JSON before setting them in the target class (e.g., formatting a double with commas and 
 * decimal places)
 * @author Jim Earley (xml.jim@gmail.com)
 *
 */
@Documented
@Retention(RUNTIME)
@Target({ FIELD, METHOD })
public @interface JSONValueConverter {

    /**
     * Sets the ValueConverter class to be applied to the JSONValue
     * @return
     */
    Class<? extends ValueConverter<?>> converter();

    String[] args() default {};
}
