import static org.junit.Assert.assertNotNull;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

class CommandLineProgramTest {

	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final PrintStream originalOut = System.out;

	@Before
	public void setUpStreams() {
		System.setOut(new PrintStream(outContent));
	}

	@After
	public void restoreStreams() {
		System.setOut(originalOut);
	}

	@Test
	public void testCaseOption1() {
		CommandLineProgram.main(new String[] { "1", "What is your favourire sport?" });
		assertNotNull(outContent.toString());
	}

	@Test
	public void testCaseOption2() {
		CommandLineProgram.main(new String[] { "2", "What is your favourire sport? Cricket Football" });
		assertNotNull(outContent.toString());
	}

	@Test
	public void testCaseInvalidOption() {
		CommandLineProgram.main(new String[] { "3" });
		assertNotNull(outContent.toString());
	}

}
