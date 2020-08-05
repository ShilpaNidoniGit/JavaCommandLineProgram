# JavaCommandLineProgram

1. A java command line program that gives me two options. One to ask a specific question and the other option is to add questions and their answers

Therefore the following restrictions apply:
=> A Question is a String with max 255 chars
=> An Answer is a String with max 255 chars
=> A Question can have multiple answers (like bullet points)
=> If the user asks a question it has to be exactly the same as entered – no "best match".
=> If the user asks a question which is not stored yet the program should print "the answer to life, universe and everything is 42" according to "The hitchhikers guide
to the Galaxy"
=> If the user asks a question whish is  stored the program should print all answers to that question. Every Answer in a separate line
=> Adding a question looks like:
      -> <question>? "<answer1>" "<answer2>" "<answerX>"
      -> Char "?" is the separator between question and answers
      -> Every Question needs to have at least one answer but can have unlimited answers all inside of char "
=> Provide tests for the functionality described in 1)

Note: Since this is command line program, it is not persisting data in cache or database, on every rerun of the program the questions and the answera data stored will be 
erased. The answers stored for the questions can be retrieved only in the one time running instance of that program.
      
      
