import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class CommandLineProgram {

	@SuppressWarnings("resource")
	public static void main(String[] args) {

		Map<String, List<String>> questionnaireMap = new HashMap<String, List<String>>();
		String limitedString;
		boolean repeat = true;

		while (repeat) {
			System.out.println("\nPlease input number '1' if you want to ask a question");
			System.out.println("Please input number '2' if you want to add questions and their answers");
			String option = args.length != 0 ? args[0] : new Scanner(System.in).nextLine();

			switch (option) {
			case "1":
				System.out.println("Please ask your question: ");
				String questionAsked = args.length == 0 ? new Scanner(System.in).nextLine().trim() : args[1].trim();

				limitedString = getLimitedString(questionAsked);
				if (!questionnaireMap.isEmpty()) {
					List<String> storedAnswers = questionnaireMap.get(limitedString.replace("?", "").toLowerCase());
					if (storedAnswers != null && !storedAnswers.isEmpty()) {
						System.out.println("* Answer will be");
						storedAnswers.forEach(answer -> {
							System.out.println("  * " + getLimitedString(answer));
						});
					} else {
						System.out.println("the answer to life, universe and everything is 42");
					}
				} else {
					System.out.println("the answer to life, universe and everything is 42");
				}
				if(args.length != 0) {
					repeat = false;
				}
				break;

			case "2":
				System.out.println(
						"Please add question and answers with maximun 255 length for each questions and an answer, else it will be truncated: ");
				String qtnAndAns = args.length == 2 ? args[1].trim() : new Scanner(System.in).nextLine().trim();

				if (!qtnAndAns.isEmpty()) {
					while (!validateMinAnswer(qtnAndAns)) {
						System.out.println(
								"Please enter atleast one answer to the question (Char \"?\" is the separator between question and answers): ");
						qtnAndAns = new Scanner(System.in).nextLine();
					}
					String question = getLimitedString(qtnAndAns.split("\\?")[0].toLowerCase());
					String[] answersArr = qtnAndAns.split("\\?")[1].replace("“", "").replace("”", "\"").trim()
							.split("\"");
					List<String> enteredAnswers = new ArrayList<>(Arrays.asList(answersArr));
					questionnaireMap.put(question, enteredAnswers);
				}
				if(args.length != 0) {
					repeat = false;
				}
				break;
			default:
				System.out.println("Please enter either option number 1 or 2 by rerunning the program.");
				repeat = false;
			}
		}
	}

	private static String getLimitedString(String value) {
		final int LIMIT = 255;
		if (!value.isEmpty() && value.length() > LIMIT) {
			value = value.substring(0, LIMIT);
		}
		return value;
	}

	private static boolean validateMinAnswer(String enteredString) {
		if (!enteredString.isEmpty() && enteredString.split("\\?").length == 1) {
			return false;
		}
		return true;
	}
}
