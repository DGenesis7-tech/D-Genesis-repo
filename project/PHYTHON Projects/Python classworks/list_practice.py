#words = string.split()
#wordslist = words
#print(wordslist)

string = 'i love programming'
wordlist = []
newstring = ""
for word in string:
	if word != " ":
		newstring += word 
	elif newstring:
		wordlist.append(newstring)
		newstring = ""
if newstring:
	wordlist.append(newstring )	
print(wordlist)	