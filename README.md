# Alar-Trie

Alar-Trie is a java library which provides a Dictionary built over an implementation of a trie.


Two kind of dictionaries are available: 
* Dictionary: composed by words(String) only
* MappedDictionary: A Map where each word is associated to a specific generic value


## Example

//Setup the dictionary

MappedDictionary<Long> dictionary = new MappedDictionary<>();

dictionary.addWord(4L,"america");

dictionary.addWord(5L,"available");

dictionary.addWord(7L,"sun");

dictionary.addWord(8L,"run");

dictionary.addWord(9L,"home");

dictionary.addWord(10L,"honey");

dictionary.addWord(11L,"hover");


//Find how many words start with "ho"

dictionary.startsWithSubstring("ho");

## License

This project is licensed under Apache 2.0 license.
