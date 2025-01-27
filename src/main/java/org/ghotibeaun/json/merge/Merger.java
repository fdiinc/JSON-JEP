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
package org.ghotibeaun.json.merge;

import org.ghotibeaun.json.merge.strategies.ConflictStrategy;

/**
 * Interface for all JSONNode merge operations
 * @author Jim Earley (jim.earley@fdiinc.com)
 *
 * @param <T> The JSONNode type
 * @param <G> The type for the get* accessor
 */
interface Merger<T, G> {

    /**
     * Return the ConflictStrategy that will be used for this merge
     * @return
     */
    ConflictStrategy<T, G> getConflictStrategy();

    /**
     * Return a reference to the MergeProcess that invoked this class
     * @return
     */
    MergeProcess getMergeProcessor();

    /**
     * Run the merge
     * @param primary the primary JSONNode 
     * @param secondary the secondary JSONNode
     * @return a merged JSONNode instance
     */
    T merge(T primary, T secondary);
}
