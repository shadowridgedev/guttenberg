package guttenberg;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.commons.lang3.tuple.Triple;

import edu.washington.cs.knowitall.extractor.ReVerbExtractor;
import edu.washington.cs.knowitall.extractor.conf.ConfidenceFunction;
import edu.washington.cs.knowitall.extractor.conf.ConfidenceFunctionException;
import edu.washington.cs.knowitall.extractor.conf.ReVerbOpenNlpConfFunction;
import edu.washington.cs.knowitall.nlp.ChunkedSentence;
import edu.washington.cs.knowitall.nlp.OpenNlpSentenceChunker;
import edu.washington.cs.knowitall.nlp.extraction.ChunkedBinaryExtraction;
/* String -> ChunkedSentence */
import edu.washington.cs.knowitall.nlp.OpenNlpSentenceChunker;

/* The class that is responsible for extraction. */
import edu.washington.cs.knowitall.extractor.ReVerbExtractor;

/* The class that is responsible for assigning a confidence score to an
 * extraction.
 */
import edu.washington.cs.knowitall.extractor.conf.ConfidenceFunction;
import edu.washington.cs.knowitall.extractor.conf.ReVerbOpenNlpConfFunction;

/* A class for holding a (arg1, rel, arg2) triple. */
import edu.washington.cs.knowitall.nlp.extraction.ChunkedBinaryExtraction;

public class processReverb {

	OpenNlpSentenceChunker chunker;
	ChunkedSentence sent;

	public processReverb() {
		try {
			chunker = new OpenNlpSentenceChunker();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	ArrayList<Triple<String, String, String>> tuple(String sentStr, ArrayList<Triple<String, String, String>> result) throws ConfidenceFunctionException, IOException {
		sent = chunker.chunkSentence(sentStr);
		for (int i = 0; i < sent.getLength(); i++) {
			String token = sent.getToken(i);
			String posTag = sent.getPosTag(i);
			String chunkTag = sent.getChunkTag(i);
			System.out.println(token + " " + posTag + " " + chunkTag);
			result.add(Triple.of(token, posTag, chunkTag));
		}


		ReVerbExtractor reverb = new ReVerbExtractor();
		ConfidenceFunction confFunc = new ReVerbOpenNlpConfFunction();
		for (ChunkedBinaryExtraction extr : reverb.extract(sent)) {
			double conf = confFunc.getConf(extr);
			System.out.println("Arg1=" + extr.getArgument1());
			System.out.println("Rel=" + extr.getRelation());
			System.out.println("Arg2=" + extr.getArgument2());
			System.out.println("Conf=" + conf);
		}
		
		return result;	
	}
}