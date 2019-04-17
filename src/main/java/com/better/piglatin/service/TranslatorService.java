package com.better.piglatin.service;

import org.springframework.stereotype.Service;

@Service
public class TranslatorService {


	public String translate(String input) {

		char[] characters=input.toCharArray();
		
		String result="";
		int index=0;
		
		//Iterate over all characters
		while(index<characters.length) 
		{
			//Loop for words
			int startIndex=index;
			while(index<characters.length) 
			{
				if(isAlphabet(characters[index]))
				{
					index++;
				}
				else
					break;
			}
			int stopIndex = index;
			//Word is contained between startIndex & endIndex
			result = result + wordTranslate(input.substring(startIndex, stopIndex));
			
			
			
			//Loop for punctuations/white spaces
			while(index<characters.length)  
			{
				if(!isAlphabet(characters[index]))
				{
					result=result+characters[index];     //append the punctuation or white space
					index++;
				}
				else
					break;
			}
		}

		
		
		return result;


	}
	public String wordTranslate(String word) {

		if(word==null||word.length()<1)
			return "";
		//Initialize variables
		
		String response="";
		
		boolean found=false;
		boolean[] characterCase=new boolean[word.length()];

		
		//loop to store capitalization information
		for(int i=0;i<word.length();i++)
		{
			if(Character.isUpperCase(word.charAt(i)))
			{
				characterCase[i]=true;
			}
			else
				characterCase[i]=false;
		}
		
		word=word.toLowerCase();
		char firstChar = word.charAt(0);
		//Check if the first alphabet of input word is a vowel and handle it
		if(firstChar!='y'&&isVowel(firstChar)) {
			response=word;
			found=true;
		}

		//if first alphabet is not a vowel translate it
		if(!found) {
			int i=1;
			response="";
			String temp="";
			temp=word.substring(0);
			while(i<word.length()) {
				if(isVowel(word.charAt(i)))
				{
					response=word.substring(i);
					break;
				}
				else
				{
					temp=temp+word.charAt(i);
				}
				i++;
			}
			response=response+temp;
			
		}

		
		//rebuild result based on capitalization
		String piglatin="";
		for(int i=0;i<word.length();i++)
		{
			if(characterCase[i])
			{
				piglatin=piglatin+Character.toUpperCase(response.charAt(i));
			}
			else
				piglatin=piglatin+response.charAt(i);
		}
		
		
		piglatin=piglatin+"ay";
		
		
		
		return piglatin;


	}

	// utility function for checking if character is an alphabet or punctation/white space. Access:private
	private  boolean isAlphabet(char character) {
		return ( (character >='A' && character <='Z') || (character >='a' && character <='z') );
	}
	
	private boolean isVowel(char character) {
		final char[] vowels = {'a', 'e', 'i', 'o', 'u','y'};
		boolean result=false;
		for (char letter: vowels) {
			if (Character.toLowerCase(character)== letter) {
				result=true;
			}
		}
		return result;
		
	}
	
}
