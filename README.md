# Alar-Trie

Alar-Trie is a java library which provides a Dictionary built over an implementation of a trie.


Two kind of dictionaries are available: 
* Dictionary: composed by words(Set<String>) only
* MappedDictionary: A map(Map<T,String>) where each word is paired to a specific value


## Example

Here's an example of finding all the words (and their values) starting with a chosen substring

```
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
```

## License

This project is licensed under Apache 2.0 license.
