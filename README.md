# Alar-Trie

Alar-Trie is a java library which provides a Dictionary built over an implementation of a trie.


Two kind of dictionaries are available: 
* Dictionary: composed by words(Set<String>) only
* MappedDictionary: A map(Map<T,String>) where each word is paired to a specific id

Dictionaries can be defined case-sensitive.


## Example

Below an example of finding all the words starting with a chosen substring

```
//Setup the dictionary (case insensitive)
Dictionary dictionary = new Dictionary();
dictionary.addWord("alessandro");
dictionary.addWord("run");
dictionary.addWord("home");
dictionary.addWord("honey");
dictionary.addWord("hover");

//Will return a Collection of all the words starting with "ho" {"home", "honey", "hover"}
Collection<String> foundWords = dictionary.startsWithSubstring("ho");
```


While here's an example of finding all the words (and their ids) starting with a chosen substring

```
//Setup the dictionary (case insensitive)
MappedDictionary<Long> dictionary = new MappedDictionary<>();
dictionary.addWord(4L,"america");
dictionary.addWord(5L,"available");
dictionary.addWord(7L,"sun");
dictionary.addWord(8L,"run");
dictionary.addWord(9L,"home");
dictionary.addWord(10L,"honey");
dictionary.addWord(11L,"hover");

//Will return a map with all the words starting with "ho" {"home", "honey", "hover"} and their ids
Map<Long, String> map = dictionary.startsWithSubstring("ho");
```

## License

This project is licensed under Apache 2.0 license.
