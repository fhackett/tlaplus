/*******************************************************************************
 * Copyright (c) 2024 Microsoft Research. All rights reserved.
 *
 * The MIT License (MIT)
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies
 * of the Software, and to permit persons to whom the Software is furnished to do
 * so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
 * FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN
 * AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 *
 * Contributors:
 *   Federico Ponzi - initial API and implementation
 ******************************************************************************/
package tlc2.tool;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Test;

import tlc2.output.EC;
import tlc2.tool.liveness.ModelCheckerTestCase;

public class Github866Test extends ModelCheckerTestCase {

	public Github866Test() {
		super("Github866", new String[] { "-config", "Github866.tla" }, EC.ExitStatus.SUCCESS);
	}

	@Override
	protected int getNumberOfThreads() {
		// Test requires more than one worker, and 2 seemed like a good number.
		return 2;
	}

	@Test
	public void testSpec() throws IOException {
		assertTrue(recorder.recorded(EC.TLC_FINISHED));
		assertFalse(recorder.recorded(EC.GENERAL));

		// Assert POSTCONDITION.
		assertFalse(recorder.recorded(EC.TLC_ASSUMPTION_FALSE));
		assertFalse(recorder.recorded(EC.TLC_ASSUMPTION_EVALUATION_ERROR));
	}
	
	@Override
	protected boolean doCoverage() {
		return false;
	}
	
	// overrides below are nice-to-have but not relevant for the test.

	@Override
	protected boolean runWithDebugger() {
		return false;
	}

	protected boolean doDump() {
		return false;
	}

	protected boolean doDumpTrace() {
		return false;
	}

	protected boolean noGenerateSpec() {
		return true;
	}
}