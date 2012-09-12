package br.ufes.inf.nemo.refontouml2alloy.mapper;

/**
 *	This class is used as a word counter. 
 *
 */

public class WordCounter {
	
	private String word;
	
	private int counter;
	
	public String getWord() 
	{
		return word;
	}
	
	public void setWord(String word) 
	{
		this.word = word;
	}
	
	public int getCounter() 
	{
		return counter;
	}
	
	public void setCounter(int counter) 
	{
		this.counter = counter;
	}
	
	public WordCounter(String word, int counter) 
	{
		super();
		this.word = word;
		this.counter = counter;
	}
	
}
