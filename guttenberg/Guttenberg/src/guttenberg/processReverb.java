package guttenberg;

import java.io.IOException;

import edu.washington.cs.knowitall.nlp.ChunkedSentence;
import edu.washington.cs.knowitall.nlp.OpenNlpSentenceChunker;

public class processReverb {
	
	OpenNlpSentenceChunker chunker;
    ChunkedSentence sent;
	public processReverb(String sentStr) {
	    try {
			chunker = new OpenNlpSentenceChunker();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	
	ChunkedSentence tuple(String sentStr)
	{
		sent = chunker.chunkSentence(sentStr);
        for (int i = 0; i < sent.getLength(); i++) {
            String token = sent.getToken(i);
            String posTag = sent.getPosTag(i);
            String chunkTag = sent.getChunkTag(i);
            System.out.println(token + " " + posTag + " " + chunkTag);
        }
        return sent;
	}
	
}
