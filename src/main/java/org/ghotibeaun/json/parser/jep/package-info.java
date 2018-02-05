/*
 *
 * Copyright (c) 2017, Jim Earley (xml.jim@gmail.com)
 */
/**
 * @author Jim Earley
 * The JSON Event Parser (JEP) is a push-based event processor that uses some of the same design
 * principles that SAX processors provided for XML.  The main premise is that the processor fires
 * events that an event handler {@linkplain org.ghotibeaun.json.parser.jep.eventhandler.JSONEventHandler}
 * class consumes to either build a JSON instance or to use in another type of process, e.g., ETL.
 *
 *
 * Internally, the processor consumes either from a byte stream or from a character streams.  In either case
 * the processors are designed to optimize performance by minimizing the number of reads from the underlying
 * stream or reader by working with blocks of byte or character data. While this may have minimal impact
 * on small JSON data, the expectation is to improve performance on very large data (e.g, 100MB or larger)
 * where many parsers see degradation due to reading one byte/character at a time.
 *
 * The event model is designed to recognize the various types of JSON entities:
 * <ul>
 *  <li>Objects:  Typically this is an instance of a {@linkplain java.util.Map}, but no assumptions
 *      are made about the underlying implementation other than to indicate that a new object token
 *      was recognized.  There are two events - one for when a start token is recognized, and another
 *      when a corresponding end token is detected.  Internally tokens are mapped to a given key (or null for the document),
 *      to align object boundaries, particularly when JSON data is heavily nested.</li>
 *  <li>Arrays: This might be an instance of a {@linkplain java.util.List}, but no assumptions are
 *      made about the underlying implementation other than to indicate that new array has been
 *      recognized in the JSON data</li>
 *  <li>Strings: Strings will be interpreted as a Java String instance, Object keys will also be
 *      recognized as Strings, but will can be handled through separate events from values</li>
 *  <li>Numbers: Internally numbers will either be interpreted as BigDecimal or BigInteger values, but then can be
 *      processed into the appropriate primitive and Boxed classes. </li>
 *  <li>Booleans: will be interpreted as a boolean primitive type</li>
 *  <li>Null Values: Since various implementations handle null values differently, there is a set of
 *      events that indicate when a null value has been detected.  The implementation can determine
 *      how to reflect the value in the Event Handler.
 * </ul>
 *
 * Typically, there are usually two events for each entity, one when the entity starts, and a corresponding
 * event when the entity ends.
 */
package org.ghotibeaun.json.parser.jep;