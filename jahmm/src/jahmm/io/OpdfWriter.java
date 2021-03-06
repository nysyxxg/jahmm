/*
 * Copyright (c) 2004-2009, Jean-Marc François. All Rights Reserved.
 * Licensed under the New BSD license.  See the LICENSE file.
 */
package jahmm.io;

import jahmm.observables.Opdf;
import java.io.IOException;
import java.io.StreamTokenizer;
import java.io.Writer;
import java.text.DecimalFormat;

/**
 * Writes an observation distribution textual description.
 *
 * @param <O>
 */
public abstract class OpdfWriter<O extends Opdf<?>> {

    /**
     * Writes a textual description of a given
     * {@link be.ac.ulg.montefiore.run.jahmm.Opdf Opdf} compatible with the
     * corresponding {@link OpdfReader}.
     *
     * @param writer The writer where the description is output.
     * @param opdf An observation distribution.
     * @throws java.io.IOException
     */
    public abstract void write(Writer writer, O opdf)
            throws IOException;

    /**
     * Writes a sequence of numbers. This method is compatible with
     * {@link OpdfReader#read(StreamTokenizer, int)}.
     *
     * @param writer Where to read the sequence to.
     * @param array The array to write.
     * @throws java.io.IOException
     */
    protected void write(Writer writer, double... array) throws IOException {
        DecimalFormat formatter = new DecimalFormat("#0.#####");

        writer.write("[");

        for (int i = 0; i < array.length; i++) {
            writer.write(" " + formatter.format(array[i]));
        }

        writer.write(" ]");
    }
}
