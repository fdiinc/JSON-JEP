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
package org.ghotibeaun.json.factory;

import org.ghotibeaun.json.JSONValueType;

class JSONNumberValueImpl extends AbstractJSONValue<Number> {

    /**
     *
     */
    private static final long serialVersionUID = 6941765393356792258L;

    public JSONNumberValueImpl() {
        // TODO Auto-generated constructor stub
    }

    public JSONNumberValueImpl(Number val) {
        super(val);
    }

    @Override
    public JSONValueType getType() {
        final String typeName = getValue().getClass().getTypeName();

        if (typeName.toUpperCase().contains("INT")) {
            return JSONValueType.INTEGER;
        } else if (typeName.toUpperCase().contains("LONG")) {
            return JSONValueType.LONG;
        } else if (typeName.toUpperCase().contains("DOUBLE")) {
            return JSONValueType.DOUBLE;
        } else if (typeName.toUpperCase().contains("FLOAT")) {
            return JSONValueType.FLOAT;
        } else {
            return JSONValueType.NUMBER;
        }
    }

    @Override
    public boolean isPrimitive() {
        return true;
    }

    @Override
    public boolean isArray() {
        return false;
    }

    @Override
    public String toString() {

        return getValue().toString();
    }

    @Override
    public String prettyPrint() {
        return toString();
    }

    @Override
    public String prettyPrint(int indent) {
        return toString();
    }

}
