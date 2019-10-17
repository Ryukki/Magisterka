import json

# outfile = open('data.sql', 'w+')

# with open('quotes.json') as json_file:
#     data = json.load(json_file)
#     for quote in data:
#         quoteText = quote['quoteText'].translate(str.maketrans({"]":  r"\]",
#                                           "\\": r"\\",
#                                           "^":  r"\^",
#                                           "$":  r"\$",
#                                           "*":  r"\*"}))
#         quoteAuthor = quote['quoteAuthor'].translate(str.maketrans({"]":  r"\]",
#                                           "\\": r"\\",
#                                           "^":  r"\^",
#                                           "$":  r"\$",
#                                           "*":  r"\*"}))
#         outfile.write('(\'' + quoteText + '\', \'' + quoteAuthor + '\'),\n')

# outfile.close()

outfile = open('data2.sql', 'w+')

with open('quotes.json') as json_file:
    data = json.load(json_file)
    unique = { each['quoteText'] : each for each in data }.values()
    for quote in data:
        quoteText = quote['quoteText'].translate(str.maketrans({"]":  r"\]",
                                          "\\": r"\\",
                                          "^":  r"\^",
                                          "$":  r"\$",
                                          "*":  r"\*"}))
        quoteAuthor = quote['quoteAuthor'].translate(str.maketrans({"]":  r"\]",
                                          "\\": r"\\",
                                          "^":  r"\^",
                                          "$":  r"\$",
                                          "*":  r"\*"}))
        outfile.write(quoteText +'\n')
        outfile.write(quoteAuthor +'\n')

outfile.close()