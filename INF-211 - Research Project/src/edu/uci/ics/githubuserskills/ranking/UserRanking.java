package edu.uci.ics.githubuserskills.ranking;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import edu.uci.ics.githubuserskills.lucene.LuceneUtils;

public class UserRanking {

	private static final String EXPORT_TXT = "export.txt";

	private String author;

	private List<TermFrequencyPair> terms;

	public UserRanking() {
		this.terms = new LinkedList<TermFrequencyPair>();
	}

	public void addEntry(TermFrequencyPair frequencyPair) {
		this.terms.add(frequencyPair);
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public List<TermFrequencyPair> getTerms() {
		return new ArrayList<TermFrequencyPair>(this.terms);
	}

	public void setTerms(List<TermFrequencyPair> terms) {
		this.terms = terms;
	}

	public void exportTextFile() throws IOException {
		FileWriter writer = new FileWriter(LuceneUtils.getFileDirectoryForUser(this.author) + File.separator + EXPORT_TXT);
		for (TermFrequencyPair termFreq : this.terms) {
			writer.write(String.format("%s: %s\n", termFreq.getTerm(), termFreq.getFrequency()));
		}
		writer.close();
	}
}